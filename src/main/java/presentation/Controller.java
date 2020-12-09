package presentation;

import domain.RolleZuweisung;
import domain.Spieler;
import domain.WortReserve;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class Controller extends Einstellungen {

    @FXML
    public TableView<Spieler> tableViewSpieler; //Tabelle zur Anzeige der Spielers
    @FXML
    public TextField eingabeAnzahlSpieler; //Eingabe der Anzahl Mitspielern
    @FXML
    private Button addPlayerBtn = new Button();//Spieler addieren
    @FXML
    public TableColumn<Spieler, Integer> nrTableView; //Anzeige des Spielernummers in der Tabelle
    @FXML
    public TableColumn<Spieler, String> nameTableView; //Anzeige des Namens der Spieler

    public int anzahlSpieler; //Anzahl Spieler
    public int spielerNr = 1; //Variable für die Nummerierung der Spieler
    private static Vector<Spieler> spielerListe = new Vector<Spieler>(); //Vektor zur Speicherung aller Spieler inkl. Daten
    public static int WerGewinnt;

    public void initialize() {
            addPlayerBtn.setDisable(true);//Spieler darf erst addiert werden, wenn die Anzahl Spieler eingegeben wurde
    }


    // Wechseln zu Einstellungen View, wenn Button "Einstellungen" betätigt wird
    @FXML
    public void switchToEinstellungen(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("Einstellungen.fxml"));
        Scene spielScene = new Scene(spielParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Einstellungen");
        window.show();
    }

    // Öffnet das Fenster der Spielregeln, wenn Button "Spielregeln" betätigt wird
    @FXML
    public void switchToSpielregeln(ActionEvent event) throws IOException {
        Parent spielRegelnScene = FXMLLoader.load(getClass().getResource("spielRegeln.fxml"));
        Stage window = new Stage();
        window.setScene(new Scene(spielRegelnScene));
        window.setTitle("Spielregeln");
        window.show();
    }

    //Öffnet Fenster "Mindmap"
    @FXML
    public void showMindmap() throws IOException {
        Parent gameMindmapParent = FXMLLoader.load(getClass().getResource("mindmap.fxml"));
        Stage MindmapStage = new Stage();
        MindmapStage.setScene(new Scene(gameMindmapParent));
        MindmapStage.setTitle("Mindmap");
        MindmapStage.show();
    }

    // Wechseln zu Spiel View, wenn Button "Spielen" betätigt wird
    @FXML
    public void switchToSpiel(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("addSpieler.fxml"));
        Scene spielScene = new Scene(spielParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Undercover");
        window.show();
    }


    //display in der Tabelle
    public ObservableList<Spieler> showSpieler() {
        ObservableList<Spieler> list = FXCollections.observableArrayList();
        for (int i = 0; i < getSpielerListe().size(); i++) {
            list.add(getSpielerListe().elementAt(i));
        }
        return list;
    }

    //Zeige an, welche Spieler noch spielen
    public ObservableList<Spieler> showLebendigeSpieler() {
        ObservableList<Spieler> list2 = FXCollections.observableArrayList();
        for (int i = 0; i < Controller.getSpielerListe().size(); i++) {
            if (Controller.getSpielerListe().elementAt(i).getStatus() == true) {
                list2.add(Controller.getSpielerListe().elementAt(i));
            }
        }
        return list2;

    }





    // getter für den Zugang zur Spieler Liste
    public static Vector<Spieler> getSpielerListe() {
        return spielerListe;
    }
}