package Hauptmenue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    int SpielerZahl = 8; // Hier in der Variabel wächseln
   // private Button Spielen = new Button();
@FXML
    // Wechseln zu Spielregeln View
    public void switchToSpielregeln(ActionEvent event) throws IOException {
        Parent spielRegelnParent = FXMLLoader.load(getClass().getResource("spielRegeln.fxml"));
        Scene spielRegelnScene = new Scene(spielRegelnParent);
        //get stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(spielRegelnScene);
        window.setTitle("Spielregeln");
        window.show();
    }
    @FXML
    public void startGame(ActionEvent event) throws IOException {
        Person.DefineRolle(SpielerZahl);
        Person.DefineAllAlive(SpielerZahl);
        Person.ShowMyWork(SpielerZahl);
        Parent getWordParent = FXMLLoader.load(getClass().getResource("GetWord.fxml"));
        Scene getWordScene = new Scene(getWordParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(getWordScene);
        window.setTitle("GetWord");
        window.show();
    }
}
