package presentation;

import domain.Spieler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class wahlController extends Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
            TestSpielFertig.finishTest(event);
        }
    }
}
