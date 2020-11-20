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

import java.io.IOException;
import java.util.Vector;

public class Controller {
    @FXML
    private Button addPlayerBtn = new Button();
    @FXML
    private TextField eingabeName;

    @FXML
    private Label spielerNrLabel;
    @FXML
    private TextField eingabeAnzahlSpieler;
    @FXML
    private Button speichern = new Button();

    private double anzahlSpieler;
    private static int spielerNr = 1;
    //Liste aller Spieler
    static Vector<Spieler> spielerListe = new Vector<Spieler>();



    public void initialize(){
        addPlayerBtn.setDisable(true);

    }


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
    // Wechseln zu Spiel View
    public void switchToSpiel(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("addSpieler.fxml"));
        Scene spielScene = new Scene(spielParent);
        //get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Init");
        window.show();
    }

    // Anzahl Spieler eingeben
    public void save(ActionEvent event) throws IOException{
        anzahlSpieler = Integer.parseInt(eingabeAnzahlSpieler.getText());
        eingabeAnzahlSpieler.setDisable(true);
        speichern.setText("gespeichert !");
        speichern.setDisable(true);
        spielerNrLabel.setText("Spieler 1:");
        addPlayerBtn.setDisable(false);
    }
// Spieler hinzufügen --> Ajouter tableau avec nom et numéro des joueurs ajoutés
    public void addPlayer(ActionEvent event) throws IOException{

        if(spielerNr < anzahlSpieler) {
            Spieler temp = new Spieler(spielerNr, eingabeName.getText(), true, 0, new Button());
            spielerListe.add(temp);
            eingabeName.clear();
            spielerNrLabel.setText("Spieler " + String.valueOf(spielerNr+1) + ":");

        }
        else {
            addPlayerBtn.setDisable(true);
            spielerNrLabel.setText("Tip top");
            eingabeName.setDisable(true);
        }
        spielerNr++;

        //vérifications print dans la console
        for (int i = 0; i < spielerListe.size(); i++){
            System.out.println(spielerListe.elementAt(i).getSpielerNr() + ": " +
                    spielerListe.elementAt(i).getName() + " " + Spieler.rolleName(spielerListe.elementAt(i).getRolle()));
        }
        System.out.println("___");
    }


    //ajouter ICI ecran jeu

    /*
// WAHL
//ajout joueurs
//Wechseln zu AddSpielerview
public void switchToWahl(ActionEvent event) throws IOException {
    Parent spielParent = FXMLLoader.load(getClass().getResource("wahl.fxml"));
    Scene spielScene = new Scene(spielParent);
    //get stage info
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(spielScene);
    window.setTitle("Wahl");
    window.show();
}

    static Person2 sp1 = new Person2(1,"Kevin", true, 2, new Button());
    static Person2 sp2 = new Person2(2, "Josué", true, 0, new Button());
    static Person2 sp3 = new Person2(3,"Suzon", true, 0, new Button());
    static Person2 sp4 = new Person2(4,"Jenny", true, 2, new Button());
    @FXML
    Button sp1btn = sp1.btn;
    @FXML
    Button sp2btn = sp2.btn;
    @FXML
    Button sp3btn = sp3.btn;
    @FXML
    Button sp4btn = sp4.btn;

    //Spieler1
    public void wahlSp1(ActionEvent event) throws IOException{
        sp1btn.setText(Person2.rolleName(sp1.getRolle()));
        sp1btn.setDisable(true);
        sp1.setStatus(false);

    }

    //Spieler2
    public void wahlSp2(ActionEvent event) throws IOException{
        sp2btn.setText(Person2.rolleName(sp2.getRolle()));
        sp2btn.setDisable(true);
        sp2.setStatus(false);

    }
    //Spieler3
    public void wahlSp3(ActionEvent event) throws IOException{
        sp3btn.setText(Person2.rolleName(sp3.getRolle()));
        sp3btn.setDisable(true);
        sp3.setStatus(false);

    }
    //Spieler4
    public void wahlSp4(ActionEvent event) throws IOException{
        sp4btn.setText(Person2.rolleName(sp4.getRolle()));
        sp4btn.setDisable(true);
        sp4.setStatus(false);

    }
*/
// Ajouter ICI ecran Mr White essai trouver mot

    // getter + setter pour accéder à la liste de joueurs (vecteur)
    public static Vector<Spieler> getSpielerListe() {
        return spielerListe;
    }
    public static void setSpielerListe(Vector<Spieler> spielerListe) {
        Controller.spielerListe = spielerListe;
    }
}

