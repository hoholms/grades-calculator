package ceiti.UI;

import ceiti.model.MySubject;
import ceiti.parser.http.HTTPHandler;

import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class App
{
    private final int SCREEN_WIDTH = 500;
    private final int SCREEN_HEIGHT = 500;
    private JFrame frame;
    public App(){
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(SCREEN_WIDTH, 80));
        frame.add(new InputPanel(this));

        configureFrame("CEITI average grade scraper");
    }
    private void configureFrame(String title){
        frame.setTitle(title);
        frame.validate();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public Document handleWebPage(){
        frame.dispose();
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

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

    public static void main( String[] args ) {
        new App();
    }

}
