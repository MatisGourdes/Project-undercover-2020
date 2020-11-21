package Hauptmenue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    int SpielerZahl = 8; //Programm ist bis Sprint 2 immer mit 8 Spieler, Hier in der Variabel wechseln

    String printLabelWort;

    int WortRandom = (int) (Math.random() * 10);// Hier die Nummer muss geändert sein falls wir mehr Wörter in der liste schreiben

    int i = 0;
    boolean swich = false;

    int declic = 1;

    @FXML
    private Label befehlRundenAnfang;

    @FXML
    private Label WortAusgabe;

    @FXML
    private Label BefehleWortAusgabe;

    @FXML
    private Button HideWord;

    @FXML
    private Button btnWorter;

    @FXML
    // Wechseln zu Spielregeln View
    public void switchToSpielregeln(ActionEvent event) throws IOException {
        Parent spielRegelnScene = FXMLLoader.load(getClass().getResource("spielRegeln.fxml"));
        Stage window = new Stage();
        window.setScene(new Scene(spielRegelnScene));
        window.setTitle("Spielregeln");
        window.show();
    }


    @FXML
    public void startGame(ActionEvent event) throws IOException {
        Person.DefineRolle(SpielerZahl);// Programm definiert eine Random rolle für die Spieler von 0 bis 7
        Person.DefineAllAlive(SpielerZahl);// Dieser programm definiert das alle Spieler am Leben sind
        Person.DefineRolleZuSpieler(SpielerZahl);
        Person.ShowMyWork(SpielerZahl);// Ce programme est provisoire et donne les informations que les joueurs ne veront pas
        Parent WortAusgabeParent = FXMLLoader.load(getClass().getResource("WortAusgabe.fxml"));// Hier werden die Spieler Namen gefragt
        Scene WortAusgabeScene = new Scene(WortAusgabeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(WortAusgabeScene);
        window.setTitle("WortAusgabe");
        window.show();
    }


    //Zeige die Mindmap
    @FXML
    public void showMindmap() throws IOException {
        Parent gameMindmapParent = FXMLLoader.load(getClass().getResource("mindmap.fxml"));
        Stage MindmapStage = new Stage();
        MindmapStage.setScene(new Scene(gameMindmapParent));
        MindmapStage.setTitle("Mindmap");
        MindmapStage.show();
    }


    public void SwitchToNextPLayer(ActionEvent event) throws IOException {

        btnWorter.setText("Nächste Spieler");
        HideWord.setText("click to show");
        swich = false;

        switch (Person.RolleArray[i]) {// Ici changer le 1
            case 0:
                printLabelWort = WortReserve.CitizenWort[WortRandom];

                break;
            case 1:
                printLabelWort = WortReserve.UndercoverWort[WortRandom];
                break;
            case 2:
                printLabelWort = "Du bist Mr White, versuch dich nicht auffallen lassen  ";
                break;
        }
        BefehleWortAusgabe.setText("Hallo " + Person.Spieler[i]);
        if (7 >= i && declic == 1) {
            if (i == 7) {
                i = 7;
                declic = 0;
            } else {
                i++;
            }
        } else {

            befehlWindow(event);

        }

    }


    public void swichToShow(ActionEvent event) throws IOException {

        if (i > 0) {

            if (swich == false) {
                WortAusgabe.setText(printLabelWort + "\n  Wenn du es gesehen hast press den Button unten recht um es zu verstecken");
                HideWord.setText("click to hide");
            } else {
                WortAusgabe.setText("");
                HideWord.setText("click to show");
            }

            swich = !swich;
        }
    }


    public void befehlWindow(ActionEvent event) throws IOException {
        Parent befehlParent = FXMLLoader.load(getClass().getResource("AnfangRundeBefehl.fxml"));
        Scene befehlScene = new Scene(befehlParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(befehlScene);
        window.setTitle("Wer fängt an?");
        window.show();
        BefehlAusgabe(event);
    }


    public void BefehlAusgabe(ActionEvent event) throws IOException {
        befehlRundenAnfang.setText("Player 1 fängt an");

    }
}