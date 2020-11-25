package Hauptmenue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class Einstellungen {

    @FXML
    private TextField neuerWertMrWhite;
    @FXML
    private TextField neuerWertUndercover;
    @FXML
    private Label aktuelleVarMrWhite;
    @FXML
    private Label aktuelleVarUndercover;
    @FXML
    private Button woerterListeAnzeigenBtn;
    @FXML
    private TextField wortCitizen;
    @FXML
    private TextField wortUndercover;
    @FXML
    private Button neuesWortBestaetigen;
    @FXML
    private Button backToHauptmenueBtn;

    // Zurück zum Hauptmenü
    @FXML
    public void switchToHauptmenue(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("hauptmenue.fxml"));
        Scene spielScene = new Scene(spielParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Hauptmenü");
        window.show();
    }

    //Wörter für citizen und Undercover addieren
    @FXML
    void woerterAddieren(ActionEvent event) {
        try (FileWriter w = new FileWriter("src\\main\\resources\\Hauptmenue\\woerterDatenBank", true)) {
            String eingabe = wortCitizen.getText() + ";" + wortUndercover.getText();
            w.write("\r" + eingabe);
        }
        catch (IOException e) {
            System.err.println("Fehler beim Schreiben in der Datei.");
            System.err.println(e.getMessage());
        }
        wortUndercover.clear();
        wortCitizen.clear();
        neuesWortBestaetigen.setText("gespeichert!");
    }

    //aktuelle Wörterliste anzeigen
    @FXML
    void woerterListeAnzeigen(ActionEvent event) {

    }

}
