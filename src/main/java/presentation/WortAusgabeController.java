package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WortAusgabeController extends Controller{


    @FXML
    private Label WortAusgabe;
    @FXML
    private Label BefehleWortAusgabe;
    @FXML
    private Button HideWord;
    @FXML
    private Button NaechsterSpielerButton;


    private int letzteRunde = 1; //Die Variabel ändert sich nur an die letzte Runde des for
    private boolean wortAngezeigt = false;
    private String printLabelWort;
    private int spielerWortAusgabe = 0;//Variablen für die Anzeige der Wörter zu den Spielern

    //Ausgabe der Wörter zu jedem Spieler
    public void ausgabeWoerter(ActionEvent event) throws IOException {

        NaechsterSpielerButton.setText("Nächster Spieler");
        HideWord.setOpacity(1);
        HideWord.setText("Anzeigen");
        WortAusgabe.setText("");
        wortAngezeigt = false;

        switch (Controller.getSpielerListe().elementAt(spielerWortAusgabe).getRolle()) {
            case 0:
                printLabelWort = addSpielerController.getWortCitizen();
                break;
            case 1:
                printLabelWort = addSpielerController.getWortUndercover();
                break;
            case 2:
                printLabelWort = "Du bist Mr White, versuch dich nicht auffallen zu lassen";
                break;
        }
        BefehleWortAusgabe.setText("Hallo " + Controller.getSpielerListe().elementAt(spielerWortAusgabe).getName());
        if ((Controller.getSpielerListe().size() - 1) >= spielerWortAusgabe && letzteRunde == 1) {
            if (spielerWortAusgabe == (Controller.getSpielerListe().size() - 1)) {
                letzteRunde = 0;
            } else {
                spielerWortAusgabe++;
            }
        } else {
            befehlWindow(event);
        }
    }

    //Wort ein- oder ausblenden
    public void switchToShow(ActionEvent event) throws IOException {
        if (spielerWortAusgabe > 0) {
            if (wortAngezeigt == false) {
                WortAusgabe.setText(printLabelWort + "\n  Wenn du es gesehen hast press den Button unten \n um es zu verstecken!");
                HideWord.setText("Ausblenden");
            } else {
                WortAusgabe.setText("");
                HideWord.setText("Anzeigen");
            }
            wortAngezeigt = !wortAngezeigt;
        }
    }

    //Fenster zur Ausgabe der Wörter am Beginn des Spiels
    private void befehlWindow(ActionEvent event) throws IOException {
        Parent befehlParent = FXMLLoader.load(getClass().getResource("RundeBefehl.fxml"));
        Scene befehlScene = new Scene(befehlParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(befehlScene);
        window.setTitle("Wer fängt an?");
        window.show();
    }
}
