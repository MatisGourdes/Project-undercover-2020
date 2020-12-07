package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class RundeBefehlController extends Controller{

    @FXML
    private Label befehlAusgabe;


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


    public void SwitchtoShowBefehle(ActionEvent event) throws IOException {
        int anfaenger = (int) (Math.random() * showLebendigeSpieler().size());

        if (getSpielerListe().elementAt(anfaenger).getRolle() == 2 || !getSpielerListe().elementAt(anfaenger).getStatus()) {
            while (Controller.getSpielerListe().elementAt(anfaenger).getRolle() == 2 || !getSpielerListe().elementAt(anfaenger).getStatus()) {
                anfaenger = (int) (Math.random() * showLebendigeSpieler().size());
            }
            befehlAusgabe.setText("Player " + getSpielerListe().elementAt(anfaenger).getName() + " fängt an");
        } else if (getSpielerListe().elementAt(anfaenger).getRolle() != 2 || getSpielerListe().elementAt(anfaenger).getStatus()) {
            befehlAusgabe.setText("Player " +getSpielerListe().elementAt(anfaenger).getName() + " fängt an!");
        }

    }
}
