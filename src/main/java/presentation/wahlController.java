package presentation;

import domain.Spieler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class wahlController extends Controller{




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
            TestSpielFertig.finishTest(event);
        }
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




}
