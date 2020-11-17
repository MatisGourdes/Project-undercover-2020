package Hauptmenue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    int SpielerZahl = 8; //Programm ist bis Sprint 2 immer mit 8 Spieler, Hier in der Variabel wechseln

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
        Person.DefineRolle(SpielerZahl);// Programm definiert eine Random rolle für die Spieler von 0 bis 7
        Person.DefineAllAlive(SpielerZahl);// Dieser programm definiert das alle Spieler am Leben sind
        Person.DefineRolleZuSpieler(SpielerZahl);
        Person.ShowMyWork(SpielerZahl);// Ce programme est provisoire et donne les informations que les joueurs ne veront pas
        Parent getNameParent = FXMLLoader.load(getClass().getResource("getName.fxml"));// Hier werden die Spieler Namen gefragt
        Scene getNameScene = new Scene(getNameParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(getNameScene);
        window.setTitle("Name Eintragen");
        window.show();
    }
}
