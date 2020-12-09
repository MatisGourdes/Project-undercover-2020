package presentation;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GewinnerController extends Controller {

    @FXML
    public Label TextWerHatGewonnen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    if(WerGewinnt==0) {TextWerHatGewonnen.setText("Citizen haben gewonnen!!");}
    else if(WerGewinnt==1){TextWerHatGewonnen.setText("Undercover haben gewonnen!!");}
    else if(WerGewinnt==2){TextWerHatGewonnen.setText("Mr White hat gewonnen!!");}
    }



    @FXML
    public void neuesSpiel(ActionEvent event) throws IOException {
        //reset Aller Variablen
        getSpielerListe().removeAllElements();
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
}
