package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MrWhiteController extends Controller {
    @FXML
    private TextField Input;

    //Mr White versucht das Wort zu erraten
    @FXML
    private void valid(ActionEvent event) throws IOException {

        if (Input.getText().equalsIgnoreCase(addSpielerController.getWortCitizen())) {
            Parent spielParent = FXMLLoader.load(getClass().getResource("MrWhiteGewinnen.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("WIN !!!");
            window.show();
        }
        else {
            TestSpielFertig.finishTest(event); //Überprüfung, ob Mr White gewonnen haben
        }
    }
}
