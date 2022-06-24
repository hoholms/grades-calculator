package ceiti.UI;

import ceiti.model.Subject;
import ceiti.parser.http.HTMLParser;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.List;

import static ceiti.UI.App.getSemester;

/**
 * Class Window creates a new window and sets the content in it.
 */
public class Window extends JFrame {
    /**
     * List of all subjects.
     */
    List<Subject> subjects;

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

        subjects = HTMLParser.parseSubjects(document, getSemester());
        subjects.removeIf(el -> el.getNameSub().equals("Bolnav") ||
                el.getNameSub().equals("Motivate") ||
                el.getNameSub().equals("Nemotivate") || el.getGrades().isEmpty());

        setTitle("CEITI grades calculator");
        ImageIcon logo = new ImageIcon("src/main/resources/img/logo.png");
        setIconImage(logo.getImage());
        setSize(new Dimension(1000, 600));
        setMinimumSize(new Dimension(820, 615));
        setResizable(true);
        setComponents();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Exit Program?", "Exit Program Message Box",
                        JOptionPane.OK_CANCEL_OPTION);

                if (confirmed == JOptionPane.OK_OPTION) {
                    dispose();
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setComponents() {
        JPanel subjPanels = new JPanel();

        subjPanels.setLayout(new BoxLayout(subjPanels, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(subjPanels,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        for (Subject sbj : subjects)
            subjPanels.add(addSubjPanel(sbj));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEtchedBorder());

        globalGradeLabel = new JLabel("GPA: " + new DecimalFormat("#0.00").format(globalGrade(subjects)));
        globalGradeLabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 16));
        globalGradeLabel.setHorizontalAlignment(JLabel.CENTER);
        globalGradeLabel.setVerticalAlignment(JLabel.CENTER);
        bottomPanel.add(globalGradeLabel, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Adding a new panel to subjects panel.
     *
     * @param subj the subject
     * @return the new subject panel
     */
    public JPanel addSubjPanel(Subject subj) {
        JPanel subjPanel = new JPanel();
        subjPanel.setPreferredSize(new Dimension(800, 60));
        subjPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        subjPanel.setLayout(new BorderLayout());
        subjPanel.setBorder(BorderFactory.createEtchedBorder());

        JLabel subjAvg = new JLabel();

        JPanel gradesPanel = new JPanel();
        gradesPanel.setLayout(new BoxLayout(gradesPanel, BoxLayout.X_AXIS));
        gradesPanel.setMinimumSize(new Dimension(20, 60));
        for (int el : subj.getGrades()) {
            gradesPanel.add(Box.createRigidArea(new Dimension(5, 0)));
            gradesPanel.add(addGradeTf(subj, subj.getGrades().indexOf(el)));
        }
        JScrollPane scrollGrades = new JScrollPane(gradesPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        subjPanel.add(scrollGrades, BorderLayout.CENTER);

        subjPanel.add(setSubjNamePanel(subj), BorderLayout.WEST);
        subjPanel.add(setSubjGlobalGradePanel(subj, subjAvg), BorderLayout.EAST);

        return subjPanel;
    }

    /**
     * Creates panel with delete button, title of subject and "+" "-" buttons for grades
     *
     * @param subj the subject
     * @return the name panel
     */
    private JPanel setSubjNamePanel(Subject subj) {
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel nameLabel = new JLabel(subj.getNameSub());
        nameLabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        nameLabel.setPreferredSize(new Dimension(200, 25));
        namePanel.add(nameLabel);

        return namePanel;
    }

    /**
     * Creates panel with exam grade text field and average grade label for subject panel
     *
     * @param subj    the subject
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
        exTf.setEditable(false);
        if (subj.isExam()) {
            exTf.setText("" + subj.getExGrade());
        } else {
            if (subj.getExGrade() != 0) {
                exTf.setText("" + subj.getExGrade());
            }
        }
        exTf.setPreferredSize(new Dimension(30, 30));

        JCheckBox exCheckbox = new JCheckBox();
        exCheckbox.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exCheckbox.setSelected(!e.equals("0"));
            }
        });
        if (!subj.isExam())
            exCheckbox.setEnabled(false);
        exCheckbox.setText("Exam: ");
        if (subj.isExam())
            exCheckbox.setSelected(true);

        subjGrade.add(exCheckbox);
        subjGrade.add(exTf);
        subjGrade.add(subjAvg);

        return subjGrade;
    }

    /**
     * Creates text field for grade
     *
     * @param subj the subject
     * @param ind  the index of subject
     * @return text field for grade
     */
    private JTextField addGradeTf(Subject subj, int ind) {
        JTextField tf = new JTextField();
        tf.setEditable(false);
        if (subj.getGrades().get(ind) != null)
            tf.setText("" + subj.getGrades().get(ind));
        tf.setPreferredSize(new Dimension(30, 30));
        tf.setMaximumSize(tf.getPreferredSize());
        tf.setMinimumSize(tf.getPreferredSize());

        return tf;
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
}
