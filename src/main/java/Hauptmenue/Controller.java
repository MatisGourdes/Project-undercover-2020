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
    @FXML
    private Button testVote;

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

    //Wechseln zu den Spielregeln
    @FXML
    private void switchBackToHauptmenu(ActionEvent event) throws IOException {
        Parent spielRegelnParent = FXMLLoader.load(getClass().getResource("hauptmenue.fxml"));
        Scene spielRegelnScene = new Scene(spielRegelnParent);
        //get stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(spielRegelnScene);
        window.setTitle("Undercover");
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
    // Spieler hinzufügen
    public void addPlayer(ActionEvent event) throws IOException {
        Spieler temp = new Spieler(spielerNr, eingabeName.getText(), true, 4, new Button());
        spielerListe.add(temp);

        if (spielerNr < anzahlSpieler) {
            eingabeName.clear();
            spielerNrLabel.setText("Spieler " + String.valueOf(spielerNr + 1) + ":");

        }
        else {
            addPlayerBtn.setDisable(true);
            eingabeName.setDisable(true);
            spielerNrLabel.setText("Tip top");
            // Zuweisung der Rollen
            RolleZuweisung.randomRolle();
        }
        spielerNr++;

        //debug
        for (int i = 0; i < spielerListe.size(); i++) {
            System.out.println(spielerListe.elementAt(i).getSpielerNr() + ": " +
                    spielerListe.elementAt(i).getName() + " " + Spieler.rolleName(spielerListe.elementAt(i).getRolle()));
        }
        System.out.println("___");

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


    //ajouter ICI ecran jeu


    // WAHL
// Wechseln zu Wahl View
    public void switchToVote(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("wahl.fxml"));
        Scene spielScene = new Scene(spielParent);
        //get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Ende der Runde - Wahl");
        window.show();

    }

    //Tabelle neu Anzeigen
    @FXML
    void setupTableViewVote(ActionEvent event) {
        //display in der Tabelle
        tableViewSpieler.setItems(getPeopleAlive());
        //initialise colonnes tableviewSpieler
        nrTableView.setCellValueFactory(new PropertyValueFactory<Spieler, Integer>("spielerNr"));
        nameTableView.setCellValueFactory(new PropertyValueFactory<Spieler, String>("name"));
        tableViewSpieler.setItems(getPeopleAlive());
    }

//Spieler wählen und entfernen
    @FXML
    void spielerAusschliessenBtn(ActionEvent event) {
        Spieler entfernt = tableViewSpieler.getSelectionModel().getSelectedItem();
        entfernt.setStatus(false);
        System.out.println("voted out: " + entfernt.getName() + "- Rolle: " + Spieler.rolleName(entfernt.getRolle()));
    }

    //display in der Tabelle der Spieler, die noch alive sind
    public ObservableList<Spieler> getPeopleAlive(){
        ObservableList<Spieler> list2 = FXCollections.observableArrayList();
        for (int i = 0; i < spielerListe.size(); i++) {
            if(spielerListe.elementAt(i).getStatus()==true) {
                list2.add(spielerListe.elementAt(i));
            }
        }
        return list2;

    }
// Ajouter ICI ecran Mr White essai trouver mot

    // getter + setter pour accéder à la liste de joueurs (vecteur)
    public static Vector<Spieler> getSpielerListe() {
        return spielerListe;
    }
    public static void setSpielerListe(Vector<Spieler> spielerListe) {
        Controller.spielerListe = spielerListe;
    }
}

