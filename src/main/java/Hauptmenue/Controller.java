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

public class Controller  {

    int SpielerZahl =8; //Programm ist bis Sprint 2 immer mit 8 Spieler, Hier in der Variabel wechseln

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

    @FXML
    private Label WortAusgabe;

    @FXML
    private Label BefehleWortAusgabe;

    @FXML
    private Button HideWord;

    String printLabelWort;

    int WortRandom= (int)(Math.random()*10);// Hier die Nummer muss geändert sein falls wir mehr Wörter in der liste schreiben

    int i=0;
    boolean swich = false;

int declic =1;
    public void SwitchToNextPLayer(ActionEvent event) throws IOException {


        WortAusgabe.setText("");
        HideWord.setText("click to show");
        swich=false;

        switch(Person.RolleArray[i]){// Ici changer le 1
            case 0:
                printLabelWort = WortReserve.CitizenWort[WortRandom];

                break;
            case 1:
                printLabelWort = WortReserve.UndercoverWort[WortRandom];
                break;
            case 2 :
                printLabelWort = "Du bist Mr White, versuch dich nicht auffallen lassen  ";
                break;
        }
        BefehleWortAusgabe.setText("Hallo "+Person.Spieler[i]);
        if(7>=i && declic ==1) {if (i==7){i=7;
        declic =0;}
        else {i++;}}

        else{ befehl(event); }// Hier geht der Programm weiter

    }





    public void swichToShow (ActionEvent event) throws IOException{

        if (i>0) {

            if (swich==false ) {
                WortAusgabe.setText( printLabelWort + "\n  Wenn du es gesehen hast press den Button unten recht um es zu verstecken");
                HideWord.setText("click to hide");
            }
            else { WortAusgabe.setText("");
                HideWord.setText("click to show");
            }

            swich=!swich;
        }
    }


    public void befehl(ActionEvent event) throws IOException {
        Parent befehlParent = FXMLLoader.load(getClass().getResource("AnfangRundeBefehl.fxml"));
        Scene befehlScene = new Scene(befehlParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(befehlScene);
        window.setTitle("Wer fängt an?");
        window.show();
    }
}