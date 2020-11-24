package Hauptmenue;

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
    @FXML
    private TableView<Spieler> tableViewSpieler;
    @FXML
    private TableColumn<Spieler, Integer> nrTableView;
    @FXML
    private TableColumn<Spieler, String> nameTableView;

    private double anzahlSpieler;
    private int spielerNr = 1;
    private int spielerZahl = 0;
    //Liste aller Spieler
    static Vector<Spieler> spielerListe = new Vector<Spieler>();

    String printLabelWort;

    int WortRandom = (int) (Math.random() * 10);// Hier die Nummer muss geändert sein falls wir mehr Wörter in der liste schreiben

    int i = 0;
    boolean swich = false;
    boolean  inOrdnung = true;
    boolean inOrdnung1 = true;
    boolean bob = false;

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

    @FXML
    private Button startingGame;

    public void initialize(){
        addPlayerBtn.setDisable(true);

    }

    @FXML
    // Wechseln zu Spielregeln View
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
            System.out.println("Sie müssen eine Zahl eingeben, Ohne Buchstabe!!");
        }
    }



    // Spieler hinzufügen
    public void addPlayer(ActionEvent event) throws IOException {

        if(spielerZahl < anzahlSpieler) {
            System.out.println(spielerZahl );

            if ("".contentEquals(eingabeName.getText())){
                System.out.println("Sie müssen eine Name eingeben");
                inOrdnung = false;
                eingabeName.clear();
            }
            else{
                inOrdnung = true;
            }

            if (spielerZahl>=1) {
                for (int i = 0; i < spielerZahl; i++) {

                    if (spielerListe.elementAt(i).getName().contentEquals(eingabeName.getText())) {
                        System.out.println("Schon eingegeben");
                        eingabeName.clear();
                        inOrdnung1 = false;

                    }

                    else {
                        inOrdnung1 = true;

                    }
                }
            }

            if (inOrdnung == true  && inOrdnung1 ==true){
                Spieler temp = new Spieler(spielerNr, eingabeName.getText(), true, 4, new Button());
                spielerListe.add(temp);
                spielerNrLabel.setText("Spieler " + String.valueOf(spielerNr + 1) + ":");
                eingabeName.clear();
                spielerNr++;
                spielerZahl++;
            }
        }



        if (spielerZahl >= anzahlSpieler){
            addPlayerBtn.setDisable(true);
            eingabeName.setDisable(true);
            spielerNrLabel.setText("Tip top");
            for (int i = 0; i < spielerListe.size(); i++) {
                System.out.println(spielerListe.elementAt(i).getSpielerNr() + ": " +
                        spielerListe.elementAt(i).getName() + " " + Spieler.rolleName(spielerListe.elementAt(i).getRolle()));
            }
            RolleZuweisung.randomRolle();
        }


        //debug
  //display in der Tabelle
        tableViewSpieler.setItems(getPeople());
    }

    //display in der Tabelle
    public ObservableList<Spieler> getPeople(){
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

        switch (spielerListe.elementAt(i).getRolle()) {// Ici changer le 1
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
        if ((spielerListe.size()-1) >= i && declic == 1) {
            if (i == (spielerListe.size()-1)) {
                declic = 0;}
            else {i++;}


        }
        else {befehlWindow(event);}
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


    public void befehlWindow(ActionEvent event) throws IOException {
        Parent befehlParent = FXMLLoader.load(getClass().getResource("AnfangRundeBefehl.fxml"));
        Scene befehlScene = new Scene(befehlParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(befehlScene);
        window.setTitle("Wer fängt an?");
        window.show();

    }


        public static Vector<Spieler> getSpielerListe() {
            return spielerListe;
        }
        public static void setSpielerListe(Vector<Spieler> spielerListe) {
            Controller.spielerListe = spielerListe;
        }

}