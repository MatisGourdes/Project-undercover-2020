package presentation;

import domain.WortReserve;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class Einstellungen {

    @FXML
    private TextField wortCitizen;
    @FXML
    private TextField wortUndercover;
    @FXML
    private Button neuesWortBestaetigen;
    @FXML
    private TableColumn<String, String> spalteCitizen;
    @FXML
    private TableColumn<String, String> spalteUndercover;
    @FXML
    private TableView<String> tableViewWoerter;

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
            String eingabe = wortCitizen.getText() + ";" + wortUndercover.getText();
            w.write("\r" + eingabe);
        }
        catch (IOException e) {
            System.err.println("Fehler beim Schreiben in der Datei.");
            System.err.println(e.getMessage());
        }
        wortUndercover.clear();
        wortCitizen.clear();
        neuesWortBestaetigen.setText("gespeichert!");
    }

    //aktuelle Wörterliste anzeigen
    @FXML
    void woerterListeAnzeigen(ActionEvent event) {
        WortReserve.readFile();
      //  spalteCitizen.setCellValueFactory(cellData ->
        //      new ReadOnlyObjectWrapper<>(showWoerterCitizen()));
       // spalteUndercover.setCellValueFactory(cellData ->
       //         new SimpleStringProperty(new String("13")));

       //tableViewWoerter.getItems().addAll("data1", "data2");

    }

    //display in der ersten Spalte
    private ObservableList<String> showWoerterCitizen(){
        ObservableList<String> listCitizen = FXCollections.observableArrayList();
        for (int i = 0; i < WortReserve.woerterListe.size(); i +=2) {
            listCitizen.add(WortReserve.woerterListe.elementAt(i));
        }
        return listCitizen;
    }
    //display in der zweiten Spalte
    private ObservableList<String> showWoerterUndercover(){
        ObservableList<String> listUndercover = FXCollections.observableArrayList();
        for (int i = 1; i < WortReserve.woerterListe.size(); i +=2) {
            listUndercover.add(WortReserve.woerterListe.elementAt(i));
        }
        return listUndercover;
    }

}
