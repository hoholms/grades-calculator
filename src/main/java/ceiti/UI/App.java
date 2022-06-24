package ceiti.UI;

import ceiti.parser.http.HTTPHandler;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class App {
    private static ButtonGroup semButtonGroup;
    private final JFrame frame;
    private JTextField textField;
    private JRadioButton sem1, sem2;
    private JButton searchButton;

    public App() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        frame = new JFrame();
        /*int SCREEN_WIDTH = 500;
        int SCREEN_HEIGHT = 80;
        frame.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));*/
        frame.add(createInputPanel());

        ImageIcon logo = new ImageIcon("src/main/resources/img/logo.png");
        frame.setIconImage(logo.getImage());

        frame.setTitle("CEITI average grade scraper");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static String getSemester() {
        return semButtonGroup.getSelection().getActionCommand();
    }

    private JPanel createInputPanel() {
        final JPanel inputPanel = new JPanel(new GridLayout(0, 1)),
                idnpPanel = new JPanel(),
                semesterPanel = new JPanel();
        textField = new JTextField(13);

        sem1 = new JRadioButton("I");
        sem1.setActionCommand("headin3g1");
        sem2 = new JRadioButton("II");
        sem2.setActionCommand("headin3g2");
        semButtonGroup = new ButtonGroup();
        semButtonGroup.add(sem1);
        semButtonGroup.add(sem2);
        semButtonGroup.clearSelection();
        sem1.setSelected(true);

        searchButton = new JButton();
        searchButton.setEnabled(false);
        searchButton.setText("Search");
        searchButton.addActionListener(this::onInputButtonClick);

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    if (Byte.parseByte(String.valueOf(e.getKeyChar())) > 10 || textField.getText().length() > 12) {
                        e.consume();
                    }
                } catch (Exception ex) {
                    e.consume();
                }
            }
        });

        textField.getDocument().addDocumentListener(new DocumentListener() {
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
                searchButton.setEnabled(textField.getText().length() == 13);
            }
        });

        JLabel inputLabel = new JLabel("Enter an INDP (13 digits):");
        JLabel semesterLabel = new JLabel("Choose semester:");

        idnpPanel.add(inputLabel);
        idnpPanel.add(textField);
        idnpPanel.add(searchButton);

        semesterPanel.add(semesterLabel);
        semesterPanel.add(sem1);
        semesterPanel.add(sem2);

        inputPanel.add(idnpPanel);
        inputPanel.add(semesterPanel);

        return inputPanel;
    }

    public void onInputButtonClick(ActionEvent e) {
        String idnp = textField.getText();

        try {
            HTTPHandler.ResponseCode code = HTTPHandler.getHTMLDocument(idnp);
            if (code == HTTPHandler.ResponseCode.SUCCESS) {
                frame.dispose();
                new Window(HTTPHandler.getGradesDocument());
            } else if (code == HTTPHandler.ResponseCode.CONNECTION_TIMEOUT) {
                JOptionPane.showMessageDialog(null,
                        "Could not establish a connection with the server. Check your internet connection.",
                        "Connection timeout",
                        JOptionPane.ERROR_MESSAGE);
            } else if (code == HTTPHandler.ResponseCode.CALL_TIMEOUT) {
                JOptionPane.showMessageDialog(null,
                        "Could not receive a response from the server. The server might be down.",
                        "Response timeout",
                        JOptionPane.ERROR_MESSAGE);
            } else if (code == HTTPHandler.ResponseCode.WRONG_IDNP) {
                JOptionPane.showMessageDialog(null,
                        "IDNP has not been found in the server database. Check if misspelled",
                        "IDNP not found",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "An error has happened while sending a request. Consider reporting a bug",
                    "Unexpected error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}