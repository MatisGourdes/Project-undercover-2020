package Hauptmenue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class spielRegelnController {
    @FXML
    // Zurück zur Hauptmenü View
    public void switchToSpielRegeln(ActionEvent sRegeln) throws IOException {
        Parent spielRegelnParent = FXMLLoader.load(getClass().getResource("hauptmenue.fxml"));
        Scene spielRegelnScene = new Scene(spielRegelnParent);
        //get stage info
        Stage window = (Stage) ((Node) sRegeln.getSource()).getScene().getWindow();
        window.setScene(spielRegelnScene);
        window.show();
    }
}
