package presentation;

import domain.WortReserve;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Einstellungen extends WortReserve implements Initializable {

    @FXML
    private TextField wortCitizen;
    @FXML
    private TextField wortUndercover;
    @FXML
    private TableColumn spalteCitizen = new TableColumn ("Wort Citizen");
    @FXML
    private TableColumn spalteUndercover = new TableColumn ("Wort Undercover");
    @FXML
    private TableView<Wort> tableViewWoerter;
    private ObservableList<Wort> wortObs = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int j = 0;
        wortObs.removeAll();
        spalteCitizen.setCellValueFactory(new PropertyValueFactory<Wort, String>("wortC"));
        spalteUndercover.setCellValueFactory(new PropertyValueFactory<Wort, String>("wortU"));
        readFile();

        //Eintrag der Wörter in einer ObservableList
        while (j < woerterListe.size()-1){
            wortObs.add(new Wort(woerterListe.elementAt(j), woerterListe.elementAt(j + 1)));
            j +=2;
        }
        tableViewWoerter.setItems(wortObs);
    }


    // Zurück zum Hauptmenü
    @FXML
    public void switchToHauptmenue(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("hauptmenue.fxml"));
        Scene spielScene = new Scene(spielParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Hauptmenü");
        window.show();
    }

    //Wörter für citizen und Undercover addieren
    @FXML
    void woerterAddieren(ActionEvent event) {
        try (FileWriter w = new FileWriter("src/main/resources/domain/woerterDatenBank", true)) {
            String eingabe = wortCitizen.getText() + ";" + wortUndercover.getText() + "\n";
            w.write(eingabe);
        }
        catch (IOException e) {
            System.err.println("Fehler beim Schreiben in der Datei.");
            System.err.println(e.getMessage());
        }

        //anzeigen in der Tabelle
        Wort temp = new Wort(wortCitizen.getText(), wortUndercover.getText());
        tableViewWoerter.getItems().add(temp);
        wortUndercover.clear();
        wortCitizen.clear();
        //update Liste der Wörter
        readFile();
    }

    //Methode zur speicherung der Wörter für die Tableview
    public static class Wort extends Controller {
        private String wortC, wortU;
        public String getWortC(){
            return wortC;
        }
        public String getWortU(){
            return wortU;
        }

        public void setWortC(String wortC) {
            this.wortC = wortC;
        }

        public void setWortU(String wortU) {
            this.wortU = wortU;
        }

        public Wort(String wortC, String wortU){
            super();
            this.wortC = wortC;
            this.wortU = wortU;
        }
    }

}
