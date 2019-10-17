package Webview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private WebView mywebview;
    @FXML
    private WebEngine engine;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        engine=mywebview.getEngine();
    }
    public void BtnOne(ActionEvent event){
        engine.load("https://www.google.com/?gws_rd=ssl");
    }
    public void BtnTwo(ActionEvent event){
        engine.executeScript("window.location=\"https://www.youtube.com/\";");
    }
    public void Btnthree(ActionEvent event){
        engine.loadContent("<html><head>Webview</head><body><h3>Welcom to webview Class</h3></body></html>");

    }
    public  void Btnfour(ActionEvent event){
        engine.reload();
    }
}
