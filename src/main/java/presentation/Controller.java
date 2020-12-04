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

public class Controller {


    @FXML
    public Label spielerNrLabel; //Label für die Anzeige des Spielers, als er sein Name eingibt
    @FXML
    public TextField eingabeAnzahlSpieler; //Eingabe der Anzahl Mitspielern

    @FXML
    private Button addPlayerBtn = new Button();//Spieler addieren
    @FXML
    public TableView<Spieler> tableViewSpieler; //Tabelle zur Anzeige der Spielers
    @FXML
    public TableColumn<Spieler, Integer> nrTableView; //Anzeige des Spielernummers in der Tabelle
    @FXML
    public TableColumn<Spieler, String> nameTableView; //Anzeige des Namens der Spieler
    @FXML
    private Label befehlAusgabe;



    public int anzahlSpieler; //Anzahl Spieler
    public int spielerNr = 1; //Variable für die Nummerierung der Spieler


    private static Vector<Spieler> spielerListe = new Vector<Spieler>(); //Vektor zur Speicherung aller Spieler inkl. Daten






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
        for (int i = 0; i < spielerListe.size(); i++) {
            list.add(spielerListe.elementAt(i));
        }
        return list;
    }






    public void SwitchtoShowBefehle(ActionEvent event) throws IOException {
        int anfaenger = (int) (Math.random() * showLebendigeSpieler().size());

        if (spielerListe.elementAt(anfaenger).getRolle() == 2 || !spielerListe.elementAt(anfaenger).getStatus()) {
            while (spielerListe.elementAt(anfaenger).getRolle() == 2 || !spielerListe.elementAt(anfaenger).getStatus()) {
                anfaenger = (int) (Math.random() * showLebendigeSpieler().size());
            }
            befehlAusgabe.setText("Player " + spielerListe.elementAt(anfaenger).getName() + " fängt an");
        } else if (spielerListe.elementAt(anfaenger).getRolle() != 2 || spielerListe.elementAt(anfaenger).getStatus()) {
            befehlAusgabe.setText("Player " + spielerListe.elementAt(anfaenger).getName() + " fängt an!");// Hier noch Random
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
    private void setupTableViewVote(ActionEvent event) {
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
    private void spielerAusschliessen(ActionEvent event) throws IOException {
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
        } else {
            finishTest(event);
        }
    }


    //Überprüfe, ob nur noch Citizen Leben
    public static void finishTest(ActionEvent event) throws IOException {

        if (domain.winCondition.testUndercover() == true) {
            Parent spielParent = FXMLLoader.load(Controller.class.getResource("UndercoverGewinnen.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("WIN !!!!!");
            window.show();
        } else if (domain.winCondition.testCitizen() == true) {
            Parent spielParent = FXMLLoader.load(Controller.class.getResource("CitizenGewinnen.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("WIN !!!!!");
            window.show();
        } else if (domain.winCondition.test2Spieler() == true) {
            for (int i = 0; i < spielerListe.size(); i++) {
                if (spielerListe.elementAt(i).getStatus() == true) {
                    if (spielerListe.elementAt(i).getRolle() == 1) {
                        Parent spielParent = FXMLLoader.load(Controller.class.getResource("UndercoverGewinnen.fxml"));
                        Scene spielScene = new Scene(spielParent);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(spielScene);
                        window.setTitle("WIN !!!");
                        window.show();
                    } else if (spielerListe.elementAt(i).getRolle() == 2) {
                        Parent spielParent = FXMLLoader.load(Controller.class.getResource("MrWhiteGewinnen.fxml"));
                        Scene spielScene = new Scene(spielParent);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(spielScene);
                        window.setTitle("WIN !!!");
                        window.show();
                    }
                }

            }
        } else {
            Parent spielParent = FXMLLoader.load(Controller.class.getResource("RundeBefehl.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("Wer ist dran ?");
            window.show();
        }
    }

    //Zeige an, welche Spieler noch spielen
    public ObservableList<Spieler> showLebendigeSpieler() {
        ObservableList<Spieler> list2 = FXCollections.observableArrayList();
        for (int i = 0; i < spielerListe.size(); i++) {
            if (spielerListe.elementAt(i).getStatus() == true) {
                list2.add(spielerListe.elementAt(i));
            }
        }
        return list2;

    }
    //ENDE WAHL

    @FXML
    private void neuesSpiel(ActionEvent event) throws IOException {
        //reset Aller Variablen
        spielerListe.clear();
        anzahlSpieler = 0;
        spielerNr = 1;
        showLebendigeSpieler().clear();
        showSpieler().clear();
        //Zurück zum Hauptmenü
        Parent spielParent = FXMLLoader.load(getClass().getResource("hauptmenue.fxml"));
        Scene spielScene = new Scene(spielParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Hauptmenü");
        window.show();
    }

    //Java-Fenster quittieren
    @FXML
    private void exit(ActionEvent event) throws IOException {
        Platform.exit();
    }

    // getter + setter für den Zugang zur Spieler Liste
    public static Vector<Spieler> getSpielerListe() {
        return spielerListe;
    }

    public static void setSpielerListe(Vector<Spieler> spielerListe) {
        Controller.spielerListe = spielerListe;
    }

}