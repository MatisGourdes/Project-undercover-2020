package presentation;

import domain.RolleZuweisung;
import domain.Spieler;
import domain.WortReserve;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class addSpielerController extends Controller{



    static int WortRandom; //Variable für die Bestimmung des Wortes aus der Text-Datei
    public static String wortCitizen = " "; //Speicherung der Wörter
    public static String wortUndercover = " ";
    private static int spielerNr = 1; //Variable für die Nummerierung der Spieler
    public boolean korrekteEingabeName1 = true; //Variablen zur Überprüfung der Eingabe des Namens
    private boolean korrekteEingabeName2 = true;

    @FXML
    private Label spielerAnzahlLabel; //Label für die Anzeige des Spielers, als er sein Name eingibt
    @FXML
    private Button addPlayerBtn = new Button();//Spieler addieren
    @FXML
    private TextField eingabeName; //Name des Spielers eingeben
    @FXML
    private Button speichern = new Button(); //Speichern der Spieleranzahl



    //Ein Spieler wird addiert, wenn auf Btn "add" gedrückt wird
    public void addPlayer(ActionEvent event) throws IOException {

//Überprüfung der Angabe (Leere Eingabe, Name des Spielers bereits existierend)
        if(showLebendigeSpieler().size() < anzahlSpieler) {
            if ("".contentEquals(eingabeName.getText())){
                spielerNrLabel.setText("Sie müssen einen Namen eingeben");
                korrekteEingabeName1 = false;
                eingabeName.clear();
            }
            else{
                korrekteEingabeName1 = true;
            }
            if (getSpielerListe().size()>0) {
                for (int i = 0; i < showLebendigeSpieler().size(); i++) {

                    if (getSpielerListe().elementAt(i).getName().contentEquals(eingabeName.getText())) {
                        spielerNrLabel.setText("Schon vorhanden !");
                        eingabeName.clear();
                        korrekteEingabeName2 = false;
                    }
                    else {
                        korrekteEingabeName2 = true;
                    }
                }
            }
            //Falls die Eingabe korrekt ist wird den Namen gespeichert
            if (korrekteEingabeName1 == true  && korrekteEingabeName2 == true){
                Spieler temp = new Spieler(spielerNr, eingabeName.getText(), true, 4);
                getSpielerListe().add(temp);
                spielerNrLabel.setText("Spieler " + (spielerNr + 1) + ":");
                eingabeName.clear();
                spielerNr++;
            }
        }

//Alle Spieler wurden eingetragen
        if (showLebendigeSpieler().size() >= anzahlSpieler) {
            addPlayerBtn.setDisable(true);
            eingabeName.setDisable(true);
            spielerNrLabel.setText("Tip top");
            RolleZuweisung.randomRolle();
            //debug : zeige alle Spieler inkl. Rolle in der Konsole
            for (int i = 0; i < getSpielerListe().size(); i++) {
                System.out.println(getSpielerListe().elementAt(i).getSpielerNr() + ": " +
                        getSpielerListe().elementAt(i).getName() + " " + Spieler.rolleName(getSpielerListe().elementAt(i).getRolle()));
            }
        }
        //display in der Tabelle
        tableViewSpieler.setItems(showSpieler());
    }

    //display in der Tabelle
    public ObservableList<Spieler> showSpieler(){
        ObservableList<Spieler> list = FXCollections.observableArrayList();
        for (int i = 0; i < getSpielerListe().size(); i++) {
            list.add(getSpielerListe().elementAt(i));
        }
        return list;
    }




    //das Spiel beginnt
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
        WortRandom = rand.nextInt(WortReserve.woerterListe.size()/4)*2; // Generiert ein zufällige gerade Zahl
        wortCitizen = WortReserve.woerterListe.elementAt(WortRandom); // speichert das zu erratende Wort
        wortUndercover = WortReserve.woerterListe.elementAt(WortRandom+1); // speichert das Wort der Undercover

        //debug: Anzeige der Liste aller Wörter
        for(int i = 0; i < WortReserve.woerterListe.size(); i++){
            System.out.println(i + " " + WortReserve.woerterListe.elementAt(i));
        }
        System.out.println("___ ");
        System.out.println(wortCitizen);
        System.out.println(wortUndercover);
        System.out.println(WortRandom);
    }


    // Anzahl Spieler wird gespeichert, wenn auf Btn "speichern" gedrückt wird
    public void save(ActionEvent event) throws IOException{
        try{
            anzahlSpieler = Integer.parseInt(eingabeAnzahlSpieler.getText());
            eingabeAnzahlSpieler.setDisable(true);
            speichern.setText("gespeichert !");
            speichern.setDisable(true);
            spielerNrLabel.setText("Spieler 1:");
            addPlayerBtn.setDisable(false);
            //Initialisierung der Tableview für die Anzeige der Spieler
            nrTableView.setCellValueFactory(new PropertyValueFactory<Spieler, Integer>("spielerNr"));
            nameTableView.setCellValueFactory(new PropertyValueFactory<Spieler, String>("name"));
        }
        //Meldung, falls eine inkorrekte Eingabe gegeben wurde
        catch (NumberFormatException e){
            eingabeAnzahlSpieler.clear();
            spielerAnzahlLabel.setText("Geben Sie eine Zahl ein.");
        }
    }

    @FXML
    void spielerListeLeeren(ActionEvent event) {
        speichern.setDisable(false);
        speichern.setText("Speichern");
        eingabeAnzahlSpieler.setDisable(false);
        eingabeName.setDisable(false);
        getSpielerListe().clear();
        anzahlSpieler = 0;
        spielerNr = 1;
        tableViewSpieler.setItems(showSpieler());
        showLebendigeSpieler().clear();
        showSpieler().clear();
    }
    public static String getWortCitizen() {
        return wortCitizen;
    }

    public static String getWortUndercover() {
        return wortUndercover;
    }

}
