package ceiti.UI;


import ceiti.parser.http.HTTPHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.regex.Pattern;

public class InputPanel extends JPanel {
    private JTextField textField;
    private JLabel inputLabel;
    private JButton button;

    private App dispatcher;

    public InputPanel(App dispatcher){
        this.dispatcher = dispatcher;

        textField = new JTextField(15);
        inputLabel = new JLabel("Enter an INDP (13 digits): ");
        button = new JButton();
        button.setText("Search");
        button.addActionListener(this::onInputButtonClick);

        add(inputLabel);
        add(textField);
        add(button);
    }

    public void onInputButtonClick(ActionEvent e){
        button.setEnabled(false);
        inputLabel.setText("Waiting for the response...");
        String idnp = textField.getText();
        if (!isCorrectIDNP(textField.getText())){
            JOptionPane.showMessageDialog(null, "Wrongly formatted IDNP!", "Format error", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            try{
                HTTPHandler.ResponseCode code = HTTPHandler.getHTMLDocument(idnp);
                if (code == HTTPHandler.ResponseCode.SUCCESS){
                    new Window(dispatcher.handleWebPage());
                }
                else{
                    JOptionPane.showMessageDialog(null, "An error has happened while receiving a response", "Response error", JOptionPane.PLAIN_MESSAGE);
                }
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "An error has happened while sending a request", "Request error", JOptionPane.PLAIN_MESSAGE);
                ex.printStackTrace();
            }
        }
        inputLabel.setText("Enter an INDP (13 digits): ");
        button.setEnabled(true);
    }

    private boolean isCorrectIDNP(String idnp){
        return (idnp != null) && (idnp.length() == 13) && (Pattern.matches("[0-9]+", idnp));
    }

}
