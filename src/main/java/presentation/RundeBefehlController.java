package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RundeBefehlController extends Controller implements Initializable {

    @FXML
    private Label befehlAusgabe;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int anfaenger = (int) (Math.random() * showLebendigeSpieler().size());

        if (getSpielerListe().elementAt(anfaenger).getRolle() == 2 || !getSpielerListe().elementAt(anfaenger).getStatus()) {
            while (Controller.getSpielerListe().elementAt(anfaenger).getRolle() == 2 || !getSpielerListe().elementAt(anfaenger).getStatus()) {
                anfaenger = (int) (Math.random() * showLebendigeSpieler().size());
            }
            befehlAusgabe.setText(getSpielerListe().elementAt(anfaenger).getName() + " fängt an und sagt ein Wort.\n Ihr dreht dann in Uhrzeigersinn und jeder sagt ein Wort.\n \n Achten sie auf Jedes Wort! \n Es haben sich bestimmt Undercover und Mr White in eure Gruppe versteckt!! \n \uD83E\uDD20 ");
        } else if (getSpielerListe().elementAt(anfaenger).getRolle() != 2 || getSpielerListe().elementAt(anfaenger).getStatus()) {
            befehlAusgabe.setText(getSpielerListe().elementAt(anfaenger).getName() + " fängt an und sagt ein Wort.\n Ihr dreht dann in Uhrzeigersinn und jeder sagt ein Wort.\n \n Achten sie auf Jedes Wort! \n Es haben sich bestimmt Undercover und Mr White in eure Gruppe versteckt!! \n \uD83E\uDD20 ");
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
}
