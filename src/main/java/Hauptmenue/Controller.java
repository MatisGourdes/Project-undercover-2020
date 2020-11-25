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
import java.util.Random;
import java.util.Vector;

public class Controller {
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
    private Button addPlayerBtn = new Button();//Spieler addieren
    @FXML
    private TableView<Spieler> tableViewSpieler; //Tabelle zur Anzeige der Spielers
    @FXML
    private TableColumn<Spieler, Integer> nrTableView; //Anzeige des Spielernummers in der Tabelle
    @FXML
    private TableColumn<Spieler, String> nameTableView; //Anzeise des Namens

    private double anzahlSpieler; //Anzahl Spieler
    private static int spielerNr = 1; //Variable für die Nummerierung der Spieler
    private int spielerZahl = 0;
    private static Vector<Spieler> spielerListe = new Vector<Spieler>(); //Vektor zur Speicherung aller Spieler inkl. Daten

    //commenter
    String printLabelWort;
    static int WortRandom;
    private static String wortCitizen = " ";
    private static String wortUndercover = " ";
    int i = 0;
    boolean swich = false;
    boolean  inOrdnung = true;
    boolean inOrdnung1 = true;


    int declic = 1;
    @FXML
    private Label befehlAusgabe;
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


    // Wechseln zu Einstellungen View
    @FXML
    public void switchToEinstellungen(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("Einstellungen.fxml"));
        Scene spielScene = new Scene(spielParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Einstellungen");
        window.show();
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
    @FXML
    public void switchToSpiel(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("addSpieler.fxml"));
        Scene spielScene = new Scene(spielParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Init");
        window.show();
    }

    // Anzahl Spieler eingeben
    public void save(ActionEvent event) throws IOException{
        try{
            anzahlSpieler = Integer.parseInt(eingabeAnzahlSpieler.getText());
            eingabeAnzahlSpieler.setDisable(true);
            speichern.setText("gespeichert !");
            speichern.setDisable(true);
            spielerNrLabel.setText("Spieler 1:");
            addPlayerBtn.setDisable(false);
            //initialise colonnes tableviewSpieler
            nrTableView.setCellValueFactory(new PropertyValueFactory<Spieler, Integer>("spielerNr"));
            nameTableView.setCellValueFactory(new PropertyValueFactory<Spieler, String>("name"));
        }
        catch (NumberFormatException e){
            eingabeAnzahlSpieler.clear();
            System.out.println("Sie müssen eine Zahl eingeben, Ohne Buchstabe!!");//debug
        }
    }



    // Spieler hinzufügen
    public void addPlayer(ActionEvent event) throws IOException {

//Lucas
        if(spielerZahl < anzahlSpieler) {
            if ("".contentEquals(eingabeName.getText())){
                spielerNrLabel.setText("Sie müssen eine Name eingeben");
                inOrdnung = false;
                eingabeName.clear();
            }
            else{
                inOrdnung = true;
            }

            if (spielerListe.size()>0) {
                for (int i = 0; i < spielerZahl; i++) {

                    if (spielerListe.elementAt(i).getName().contentEquals(eingabeName.getText())) {
                        spielerNrLabel.setText("Schon vorhanden !");
                        eingabeName.clear();
                        inOrdnung1 = false;
                    }
                    else {
                        inOrdnung1 = true;
                    }
                }
            }

            if (inOrdnung == true  && inOrdnung1 ==true){
                Spieler temp = new Spieler(spielerNr, eingabeName.getText(), true, 4);
                spielerListe.add(temp);
                spielerNrLabel.setText("Spieler " + (spielerNr + 1) + ":");
                eingabeName.clear();
                spielerNr++;
                spielerZahl++;
            }
        }

//Alle Spieler wurden eingetragen
        if (spielerZahl >= anzahlSpieler) {
            addPlayerBtn.setDisable(true);
            eingabeName.setDisable(true);
            spielerNrLabel.setText("Tip top");
            RolleZuweisung.randomRolle();
            //debug
            for (int i = 0; i < spielerListe.size(); i++) {
                System.out.println(spielerListe.elementAt(i).getSpielerNr() + ": " +
                        spielerListe.elementAt(i).getName() + " " + Spieler.rolleName(spielerListe.elementAt(i).getRolle()));
            }
            //Zuweisung der Rollen zu jeden eingetragenen Spieler
        }

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

    @FXML
    void spielerListeLeeren(ActionEvent event) {
        speichern.setDisable(false);
        speichern.setText("Speichern");
        eingabeAnzahlSpieler.setDisable(false);
        eingabeName.setDisable(false);
        spielerListe.clear();
        anzahlSpieler = 0;
        spielerNr = 1;
        spielerZahl = 0;
        tableViewSpieler.setItems(showSpieler());
    }


    public void startGame(ActionEvent event) throws IOException {
        Parent WortAusgabeParent = FXMLLoader.load(getClass().getResource("WortAusgabe.fxml"));// Hier werden die Spieler Namen gefragt
        Scene WortAusgabeScene = new Scene(WortAusgabeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(WortAusgabeScene);
        window.setTitle("WortAusgabe");
        window.show();
        //Suchen eines Wortes
        WortReserve.readFile();//Speichert alle Wörter der Textdatei im Vektor woerterListe
        Random rand = new Random();
        WortRandom = rand.nextInt(WortReserve.woerterListe.size()/4)*2;//Generiert ein zufällige gerade Zahl
        wortCitizen = WortReserve.woerterListe.elementAt(WortRandom);//speichert das zu erratende Wort
        wortUndercover = WortReserve.woerterListe.elementAt(WortRandom+1);
        //debug
        for(int i = 0; i < WortReserve.woerterListe.size(); i++){
            System.out.println(i + " " + WortReserve.woerterListe.elementAt(i));
        }
        System.out.println("___ ");
        System.out.println(wortCitizen);
        System.out.println(wortUndercover);
        System.out.println(WortRandom);
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
                printLabelWort = wortCitizen;
                break;
            case 1:
                printLabelWort = wortUndercover;
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
        Parent befehlParent = FXMLLoader.load(getClass().getResource("RundeBefehl.fxml"));
        Scene befehlScene = new Scene(befehlParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(befehlScene);
        window.setTitle("Wer fängt an?");
        window.show();

    }
    public void SwitchtoShowBefehle(ActionEvent event) throws IOException {
        befehlAusgabe.setText("Player 2 fängt an");// Hier noch Random
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
        tableViewSpieler.setPlaceholder(new Label("Keine Dataien"));
        //Initialisierung der Tabelle
        nrTableView.setCellValueFactory(new PropertyValueFactory<Spieler, Integer>("spielerNr"));
        nameTableView.setCellValueFactory(new PropertyValueFactory<Spieler, String>("name"));
        tableViewSpieler.setItems(showLebendigeSpieler());
    }

    //Spieler wählen und entfernen
    @FXML
    void spielerAusschliessen(ActionEvent event) throws IOException {
        Spieler entfernt = tableViewSpieler.getSelectionModel().getSelectedItem();
        entfernt.setStatus(false);
        //der Spieler wird ausgeschlossen
        System.out.println("voted out: " + entfernt.getName() + "- Rolle: " + Spieler.rolleName(entfernt.getRolle())); //debug

        if (entfernt.getRolle() == 2) {
            Parent spielParent = FXMLLoader.load(getClass().getResource("MrWhite.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("Mr White");
            window.show();
        } else {  finishTest(event);
        }
    }

    public void finishTest(ActionEvent event) throws IOException {
        //Test si il reste que des citizen

        if(testUndercover() == true) {
            Parent spielParent = FXMLLoader.load(getClass().getResource("UndercoverGewinnen.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("WIN !!!!!");
            window.show();
        }
        else if(testCitizen() == true){
            Parent spielParent = FXMLLoader.load(getClass().getResource("CitizenGewinnen.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("WIN !!!!!");
            window.show();
        }
        else { Parent spielParent = FXMLLoader.load(getClass().getResource("RundeBefehl.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("Wer ist dran?");
            window.show();}
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



    //mr white
    @FXML
    public void valid(ActionEvent event) throws IOException {
        System.out.println(printLabelWort);
        if (Input.getText().equalsIgnoreCase(wortCitizen)) {
            Parent spielParent = FXMLLoader.load(getClass().getResource("MrWhiteGewinnen.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("WIN !!!");
            window.show();
        }
        else {
            finishTest(event);
        }
    }

    @FXML
    public void newgame(ActionEvent event) throws IOException{
        Parent spielParent = FXMLLoader.load(getClass().getResource("hauptmenue.fxml"));
        Scene spielScene = new Scene(spielParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Hauptmenü");
        window.show();
    }

    @FXML
    public void exit(ActionEvent event)throws IOException{
        Platform.exit();
    }


    private boolean testUndercover() {
        boolean boolCitizen = false;
        double summeRollen = 0;
        int SpielerAmLeben=0;
        for(int i = 0; i< spielerListe.size(); i++) {
            if(spielerListe.elementAt(i).getStatus()==true){
                SpielerAmLeben++;
                if(spielerListe.elementAt(i).getRolle()==1){
                    summeRollen += 1 ;
                }}
        }
        summeRollen = summeRollen/ SpielerAmLeben;
        if(summeRollen == 1)
        {boolCitizen = true;}

        else{boolCitizen = false; }

        return boolCitizen;
    }


    public boolean testCitizen() {
        boolean boolCitizen = false;
        int summeRollen = 0;
        for(int i = 0; i< spielerListe.size(); i++) {
            if(spielerListe.elementAt(i).getStatus()==true){
                summeRollen += spielerListe.elementAt(i).getRolle();
            }}
        if(summeRollen == 0){
            boolCitizen = true;

        }
        else {
            boolCitizen = false;

        }
        return boolCitizen;
    }


    // getter + setter für den Zugang zur Spieler Liste
    public static Vector<Spieler> getSpielerListe() {
        return spielerListe;
    }
    public static void setSpielerListe(Vector<Spieler> spielerListe) {
        Controller.spielerListe = spielerListe;
    }
}