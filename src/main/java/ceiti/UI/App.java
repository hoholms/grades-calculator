package ceiti.UI;

import ceiti.parser.http.HTTPHandler;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class App
{
    private final int SCREEN_WIDTH = 500;
    private final int SCREEN_HEIGHT = 80;
    private final JFrame frame;
    private JTextField textField;
    private JLabel inputLabel;
    private JButton searchButton;

    public App(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        frame = new JFrame();
        frame.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
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

    private JPanel createInputPanel(){
        final JPanel inputPanel = new JPanel();
        textField = new JTextField(13);

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

        inputLabel = new JLabel("Enter an INDP (13 digits): ");

        inputPanel.add(inputLabel);
        inputPanel.add(textField);
        inputPanel.add(searchButton);

        return inputPanel;
    }

    public Document handleWebPage(){
        frame.dispose();

        Response response = HTTPHandler.getLastResponse();
        try{
            String responseBody = response.body().string();
            Document document = Jsoup.parse(responseBody);
            return document;
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public void onInputButtonClick(ActionEvent e) {
        String idnp = textField.getText();

        try {
            HTTPHandler.ResponseCode code = HTTPHandler.getHTMLDocument(idnp);
            if (code == HTTPHandler.ResponseCode.SUCCESS) {
                new Window(handleWebPage());
            } else {
                JOptionPane.showMessageDialog(null, "An error has happened while receiving a response", "Response error", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error has happened while sending a request", "Request error", JOptionPane.PLAIN_MESSAGE);
            ex.printStackTrace();
        }

    }
}