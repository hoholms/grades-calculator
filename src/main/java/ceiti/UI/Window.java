package ceiti.UI;

import ceiti.model.Subject;
import ceiti.parser.http.HTMLParser;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Class Window creates a new window and sets the content in it.
 */
public class Window extends JFrame {
    /**
     * List of all subjects.
     */
    List<Subject> subjects = new ArrayList<>();

    /**
     * The Global grade label.
     */
    JLabel globalGradeLabel;

    /**
     * Instantiates a new Window.
     */
    Window(Document document) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //App app = new App();
        //Document document = app.handleWebPage();

        subjects = HTMLParser.parseSubjects(document, -1);

        setTitle("Grades accounting");
        ImageIcon logo = new ImageIcon("img/logo.png");
        setIconImage(logo.getImage());
        setSize(new Dimension(1000, 600));
        setMinimumSize(new Dimension(640, 480));
        setResizable(true);
        setComponents();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Save changes?", "Exit Program Message Box",
                        JOptionPane.YES_NO_CANCEL_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    writeData();
                    dispose();
                } else if (confirmed == JOptionPane.NO_OPTION)
                    dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setComponents() {
        JPanel subjPanels = new JPanel();

        subjPanels.setLayout(new BoxLayout(subjPanels, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(subjPanels,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        for (Subject sbj : subjects)
            subjPanels.add(addSubjPanel(sbj, subjPanels));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEtchedBorder());
        bottomPanel.setPreferredSize(new Dimension(800, 25));

        JButton plus = new JButton("Add Subject");
        plus.setMargin(new Insets(5, 5, 5, 5));
        plus.addActionListener(e -> {
            String result = (String) JOptionPane.showInputDialog(
                    subjPanels,
                    "Subject name",
                    "New Subject",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");
            if (result != null && result.length() > 0) {
                subjects.add(new Subject(result));
                subjPanels.add(addSubjPanel(subjects.get(subjects.size()-1), subjPanels));
                subjPanels.updateUI();
            }
        });
        bottomPanel.add(plus, BorderLayout.WEST);

        globalGradeLabel = new JLabel("GPA: " + new DecimalFormat("#0.00").format(globalGrade(subjects)));
        globalGradeLabel.setHorizontalAlignment(JLabel.CENTER);
        globalGradeLabel.setVerticalAlignment(JLabel.CENTER);
        bottomPanel.add(globalGradeLabel, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Adding a new panel to subjects panel.
     *
     * @param subj       the subject
     * @param subjPanels the subjects panel
     * @return the new subject panel
     */
    public JPanel addSubjPanel(Subject subj, JPanel subjPanels) {
        JPanel subjPanel = new JPanel();
        subjPanel.setPreferredSize(new Dimension(800, 60));
        subjPanel.setMinimumSize(new Dimension(640, 60));
        subjPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        subjPanel.setLayout(new BorderLayout());
        subjPanel.setBorder(BorderFactory.createEtchedBorder());

        JLabel subjAvg = new JLabel();

        JPanel gradesPanel = new JPanel();
        gradesPanel.setLayout(new BoxLayout(gradesPanel, BoxLayout.X_AXIS));
        for (int el : subj.getGrades()) {
            gradesPanel.add(Box.createRigidArea(new Dimension(5, 0)));
            gradesPanel.add(addGradeTf(subj, subj.getGrades().indexOf(el), subjAvg));
        }
        JScrollPane scrollGrades = new JScrollPane(gradesPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        subjPanel.add(scrollGrades, BorderLayout.CENTER);

        subjPanel.add(setSubjNamePanel(subj, gradesPanel, subjAvg, subjPanels, subjPanel), BorderLayout.WEST);
        subjPanel.add(setSubjGlobalGradePanel(subj, subjAvg), BorderLayout.EAST);

        return subjPanel;
    }

    /**
     * Creates panel with delete button, title of subject and "+" "-" buttons for grades
     *
     * @param subj the subject
     * @param gradesPanel the grades panel
     * @param subjAvg the subject average grade
     * @param subjPanels the subjects panel
     * @param subjPanel the parent subject panel
     * @return the name panel
     */
    private JPanel setSubjNamePanel(Subject subj,
                                    JPanel gradesPanel,
                                    JLabel subjAvg,
                                    JPanel subjPanels, JPanel subjPanel) {
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton deleteButton = new JButton("×");
        deleteButton.setPreferredSize(new Dimension(25, 25));
        deleteButton.setMargin(new Insets(5, 5, 5, 5));
        deleteButton.addActionListener(e -> {
            subjPanels.remove(subjPanel);
            subjects.remove(subj);
            globalGradeLabel.setText("GPA: " + new DecimalFormat("#0.00").format(globalGrade(subjects)));
            subjPanels.updateUI();
        });
        namePanel.add(deleteButton);

        JLabel sName = new JLabel(subj.getNameSub());
        sName.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 14));
        sName.setPreferredSize(new Dimension(100, 25));
        namePanel.add(sName);

        JButton sPlus = new JButton("+"), sMinus = new JButton("-");
        sPlus.setPreferredSize(new Dimension(25, 25));
        sPlus.setMargin(new Insets(5, 5, 5, 5));
        sMinus.setPreferredSize(new Dimension(25, 25));
        sMinus.setMargin(new Insets(5, 5, 5, 5));

        sPlus.addActionListener(e -> {
            subj.getGrades().add(null);
            gradesPanel.add(Box.createRigidArea(new Dimension(5, 0)));
            gradesPanel.add(addGradeTf(subj, subj.getGrades().size() - 1, subjAvg));
            gradesPanel.updateUI();
        });

        sMinus.addActionListener(e -> {
            if (!subj.getGrades().isEmpty()) {
                gradesPanel.remove(gradesPanel.getComponents().length - 1);
                gradesPanel.remove(gradesPanel.getComponents().length - 1);
                subj.getGrades().remove(subj.getGrades().size() - 1);
                gradesPanel.updateUI();
                if (!subj.isExam())
                    subjAvg.setText("" + new DecimalFormat("#0.00").format(subj.avgGrade()));
                else
                    subjAvg.setText("" + new DecimalFormat("#0.00").format(subj.avgExGrade()));
                globalGradeLabel.setText("GPA: " + new DecimalFormat("#0.00").format(globalGrade(subjects)));
            }
        });

        namePanel.add(sPlus);
        namePanel.add(sMinus);

        return namePanel;
    }

    /**
     * Creates panel with exam grade text field and average grade label for subject panel
     *
     * @param subj the subject
     * @param subjAvg the subject average grade
     * @return the global grade panel
     */
    private JPanel setSubjGlobalGradePanel(Subject subj, JLabel subjAvg) {
        JPanel subjGrade = new JPanel();
        subjGrade.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        if (!subj.isExam())
            subjAvg.setText("" + new DecimalFormat("#0.00").format(subj.avgGrade()));
        else
            subjAvg.setText("" + new DecimalFormat("#0.00").format(subj.avgExGrade()));
        subjAvg.setPreferredSize(new Dimension(40, 25));
        subjAvg.setHorizontalAlignment(JLabel.CENTER);
        subjAvg.setVerticalAlignment(JLabel.CENTER);

        JTextField exTf = new JTextField();
        if (subj.isExam()) {
            exTf.setEditable(true);
            exTf.setText("" + subj.getExGrade());
        } else {
            exTf.setEditable(false);
            if (subj.getExGrade() != null && subj.getExGrade() != 0) {
                exTf.setText("" + subj.getExGrade());
            }
        }
        exTf.setPreferredSize(new Dimension(30, 30));
        makeTfForGrades(exTf);
        exTf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                if (exTf.getText().length() > 0 && exTf.getText() != null)
                    subj.setExGrade(Integer.parseInt(exTf.getText()));
                else
                    subj.setExGrade(0);
                subjAvg.setText("" + new DecimalFormat("#0.00").format(subj.avgExGrade()));
                globalGradeLabel.setText("GPA: " + new DecimalFormat("#0.00").format(globalGrade(subjects)));
            }
        });

        JCheckBox exCheckbox = new JCheckBox();
        exCheckbox.setText("Exam: ");
        if (subj.isExam())
            exCheckbox.setSelected(true);
        exCheckbox.addItemListener(e -> {
            exTf.setEditable(e.getStateChange() == ItemEvent.SELECTED);
            subj.setExam(e.getStateChange() == ItemEvent.SELECTED);
            if (e.getStateChange() == ItemEvent.SELECTED) {
                subjAvg.setText("" + new DecimalFormat("#0.00").format(subj.avgExGrade()));
            } else
                subjAvg.setText("" + new DecimalFormat("#0.00").format(subj.avgGrade()));
            globalGradeLabel.setText("GPA: " + new DecimalFormat("#0.00").format(globalGrade(subjects)));
        });

        subjGrade.add(exCheckbox);
        subjGrade.add(exTf);
        subjGrade.add(subjAvg);

        return subjGrade;
    }

    /**
     * Creates text field for grade
     *
     * @param subj the subject
     * @param ind the index of subject
     * @param subjAvg the average grade of the subject
     * @return text field for grade
     */
    private JTextField addGradeTf(Subject subj, int ind, JLabel subjAvg) {
        JTextField tf = new JTextField();
        if (subj.getGrades().get(ind) != null)
            tf.setText("" + subj.getGrades().get(ind));
        tf.setPreferredSize(new Dimension(30, 30));
        tf.setMaximumSize(tf.getPreferredSize());
        tf.setMinimumSize(tf.getPreferredSize());
        makeTfForGrades(tf);
        tf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                if (tf.getText().length() > 0 && tf.getText() != null)
                    subj.setGrade(ind, Integer.parseInt(tf.getText()));
                else
                    subj.setGrade(ind, 0);
                if (!subj.isExam())
                    subjAvg.setText("" + new DecimalFormat("#0.00").format(subj.avgGrade()));
                else
                    subjAvg.setText("" + new DecimalFormat("#0.00").format(subj.avgExGrade()));
                globalGradeLabel.setText("GPA: " + new DecimalFormat("#0.00").format(globalGrade(subjects)));
            }
        });

        return tf;
    }

    private void makeTfForGrades(JTextField tf) {
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    if (Byte.parseByte(tf.getText() + e.getKeyChar()) > 10) e.consume();
                } catch (Exception ex) {
                    e.consume();
                }
            }
        });
    }

    private float globalGrade(List<Subject> subjects) {
        float avg = 0.0f;
        for (Subject sbj : subjects) {
            if (!sbj.isExam())
                avg += sbj.avgGrade();
            else
                avg += sbj.avgExGrade();
        }
        return avg / subjects.size();
    }

    private void readData() {
        try {
            FileInputStream fileInputStream = new FileInputStream("subjectsData.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            subjects = (Vector<Subject>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void writeData() {
        try {
            FileOutputStream outputStream = new FileOutputStream("subjectsData.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(subjects);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private long getIDNP() {
        return Long.parseLong(JOptionPane.showInputDialog(null,
                "Enter IDNP:", "Welcome input dialog"));
    }
}
