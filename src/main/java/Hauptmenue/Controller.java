package Hauptmenue;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.Vector;

public class Controller {
    @FXML
    private Button addPlayerBtn = new Button();//Spieler addieren

    @FXML
    private TextField Input;
    @FXML
    private TextField eingabeName; //Name des Spielers eingeben
    @FXML
    private Label spielerNrLabel; //Label für die Anzeige des Spielers, als er sein Name eingibt
    @FXML
    private TextField eingabeAnzahlSpieler; //Eingabe der Anzahl Mitspielern
    @FXML
    private Button speichern = new Button(); //Speichern der Spieleranzahl
    @FXML
    private TableView<Spieler> tableViewSpieler; //Tabelle zur Anzeige der Spielers
    @FXML
    private TableColumn<Spieler, Integer> nrTableView; //Anzeige des Spielernummers in der Tabelle
    @FXML
    private TableColumn<Spieler, String> nameTableView; //Anzeise des Namens

    private double anzahlSpieler; //Anzahl Spieler
    private static int spielerNr = 1; //Variable für die Nummerierung der Spieler
    private static Vector<Spieler> spielerListe = new Vector<Spieler>(); //Vektor zur Speicherung aller Spieler inkl. Daten

    //commenter
    String printLabelWort;
    String wort;


    static int WortRandom = (int)(Math.random() * 10);// Hier die Nummer muss geändert sein falls wir mehr Wörter in der liste schreiben
    private static String temp = WortReserve.CitizenWort[WortRandom];
    int i = 0;
    boolean swich = false;

    int declic = 1;
    @FXML
    private Label befehlAnfang;
    @FXML
    private Label WortAusgabe;
    @FXML
    private Label BefehleWortAusgabe;
    @FXML
    private Button HideWord;
    @FXML
    private Button btnWorter;



    public void initialize(){
        addPlayerBtn.setDisable(true);//Spieler darf erst addiert werden, wenn die Anzahl Spieler eingegeben wurde

    }


    // Wechseln zu Spielregeln View
    @FXML
    public void switchToSpielregeln(ActionEvent event) throws IOException {
        Parent spielRegelnScene = FXMLLoader.load(getClass().getResource("spielRegeln.fxml"));
        Stage window = new Stage();
        window.setScene(new Scene(spielRegelnScene));
        window.setTitle("Spielregeln");
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
    public void save(ActionEvent event) throws IOException {
        anzahlSpieler = Integer.parseInt(eingabeAnzahlSpieler.getText());
        eingabeAnzahlSpieler.setDisable(true);
        speichern.setText("gespeichert !");
        speichern.setDisable(true);
        spielerNrLabel.setText("Spieler 1:");
        addPlayerBtn.setDisable(false);
        //Initialisierung der Spalten für die Tableview
        nrTableView.setCellValueFactory(new PropertyValueFactory<Spieler, Integer>("spielerNr"));
        nameTableView.setCellValueFactory(new PropertyValueFactory<Spieler, String>("name"));
    }



    // Spieler hinzufügen
    public void addPlayer(ActionEvent event) throws IOException {
        Spieler temp = new Spieler(spielerNr, eingabeName.getText(), true, 4);
        spielerListe.add(temp);

        if (spielerNr < anzahlSpieler) {
            eingabeName.clear();
            spielerNrLabel.setText("Spieler " + (spielerNr + 1) + ":");
        }
        else {
            addPlayerBtn.setDisable(true);
            eingabeName.setDisable(true);
            spielerNrLabel.setText("Tip top");
            //debug
            for (int i = 0; i < spielerListe.size(); i++) {
                System.out.println(spielerListe.elementAt(i).getSpielerNr() + ": " +
                        spielerListe.elementAt(i).getName() + " " + Spieler.rolleName(spielerListe.elementAt(i).getRolle()));
            }
            RolleZuweisung.randomRolle(); //Zuweisung der Rollen zu jeden eingetragenen Spieler
        }
        spielerNr++;

        //display in der Tabelle
        tableViewSpieler.setItems(showSpieler());
    }

    //display in der Tabelle
    public ObservableList<Spieler> showSpieler(){
        ObservableList<Spieler> list = FXCollections.observableArrayList();
        for (int i = 0; i < spielerListe.size(); i++) {
            list.add(spielerListe.elementAt(i));
        }
        return list;

    }


    public void startGame(ActionEvent event) throws IOException {
        Parent WortAusgabeParent = FXMLLoader.load(getClass().getResource("WortAusgabe.fxml"));// Hier werden die Spieler Namen gefragt
        Scene WortAusgabeScene = new Scene(WortAusgabeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(WortAusgabeScene);
        window.setTitle("WortAusgabe");
        window.show();
    }


    //RENAME INTO SWITCHNEXTPLAYER TO GIVE WORD
    //Programm to give the word
    public void SwitchToNextPLayer(ActionEvent event) throws IOException {

        btnWorter.setText("Nächste Spieler");
        WortAusgabe.setText("");
        HideWord.setText("click to show");
        swich = false;

        switch (spielerListe.elementAt(i).getRolle()) {
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
        BefehleWortAusgabe.setText("Hallo " + spielerListe.elementAt(i).getName());
        if ((spielerListe.size() - 1) >= i && declic == 1) {
            if (i == (spielerListe.size() - 1)) {
                declic = 0;
            } else {
                i++;
            }


        }
        else {befehlWindow(event);}
    }

    public void befehlWindow(ActionEvent event) throws IOException {
        Parent befehlParent = FXMLLoader.load(getClass().getResource("AnfangRundeBefehl.fxml"));
        Scene befehlScene = new Scene(befehlParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(befehlScene);
        window.setTitle("Wer fängt an?");
        window.show();

    }


    //Method um den Wort zu zeigen oder nicht wen er gegeben ist
    public void switchToShow(ActionEvent event) throws IOException {
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



    //Ende der Runde, Wechseln zur Wahl-Ansicht
    public void switchToVote(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("wahl.fxml"));
        Scene spielScene = new Scene(spielParent);
        //get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Ende der Runde - Wahl");
        window.show();
    }

    //Tabelle der lebendigen Spieler neu Anzeigen
    @FXML
    void setupTableViewVote(ActionEvent event) {
        //display in der Tabelle
        tableViewSpieler.setItems(showLebendigeSpieler());
        //Initialisierung der Tabelle
        nrTableView.setCellValueFactory(new PropertyValueFactory<Spieler, Integer>("spielerNr"));
        nameTableView.setCellValueFactory(new PropertyValueFactory<Spieler, String>("name"));
        tableViewSpieler.setItems(showLebendigeSpieler());
    }

    //Spieler wählen und entfernen
    @FXML
    void spielerAusschliessen(ActionEvent event) throws IOException {
        Spieler entfernt = tableViewSpieler.getSelectionModel().getSelectedItem();
        entfernt.setStatus(false); //der Spieler wird ausgeschlossen
        System.out.println("voted out: " + entfernt.getName() + "- Rolle: " + Spieler.rolleName(entfernt.getRolle())); //debug

        if (entfernt.getRolle() == 2) {

            Parent spielParent = FXMLLoader.load(getClass().getResource("MrWhite.fxml"));
            Scene spielScene = new Scene(spielParent);

            //get stage info
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("UnderCover");
            window.show(); }
        else{
            Parent spielParent = FXMLLoader.load(getClass().getResource("AnfangRundeBefehl.fxml"));
            Scene spielScene = new Scene(spielParent);

            //get stage info
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("UnderCover");
            window.show(); }


    }

    //Zeige an, welche Spieler noch spielen
    public ObservableList<Spieler> showLebendigeSpieler(){
        ObservableList<Spieler> list2 = FXCollections.observableArrayList();
        for (int i = 0; i < spielerListe.size(); i++) {
            if (spielerListe.elementAt(i).getStatus() == true) {
                list2.add(spielerListe.elementAt(i));
            }
        }
        return list2;

    }
    //ENDE WAHL

    // getter + setter für den Zugang zur Spieler Liste
    public static Vector<Spieler> getSpielerListe() {
        return spielerListe;
    }

    public static void setSpielerListe(Vector<Spieler> spielerListe) {
        Controller.spielerListe = spielerListe;
    }

    //ENDE WAHL8
    @FXML
    public void valid(ActionEvent event) throws IOException {
        wort = Input.getText();
        System.out.println(printLabelWort);
        if (wort.equalsIgnoreCase(temp)) {
            Parent spielParent = FXMLLoader.load(getClass().getResource("Win.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("UnderCover");
            window.show();
        }
         else {
            System.out.println(WortReserve.CitizenWort[WortRandom]);
        }



    }
    @FXML
    public void newgame(ActionEvent event) throws IOException{
        Parent spielParent = FXMLLoader.load(getClass().getResource("hauptmenue.fxml"));
        Scene spielScene = new Scene(spielParent);

        //get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("UnderCover");
        window.show();
    }
@FXML
    public void exit(ActionEvent event)throws IOException{

        Platform.exit();
    }
}