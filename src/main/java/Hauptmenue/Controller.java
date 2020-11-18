package Hauptmenue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private Button Spielen = new Button();

    //test
    static Person2 sp1 = new Person2("Spieler1", true, 2, new Button());
   // static Person2 sp2 = new Person2("sp2", true, 0, new Button());
    //static Person2 sp3 = new Person2("sp3", true, 0, new Button());
   // static Person2 sp4 = new Person2("sp4", true, 2, new Button());
@FXML
    Button sp1btn = sp1.btn;
   // public static Button sp2btn = sp2.btn;
   // public static Button sp3btn = sp3.btn;
   // public static Button sp4btn = sp4.btn;




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
    // Wechseln zu Spiel View
    public void switchToSpiel(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("test.fxml"));
        Scene spielScene = new Scene(spielParent);
        //get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Undercover");
        window.show();
    }

    //Test
    public void test(ActionEvent event) throws IOException{

        sp1.setName("MORT");
        sp1btn.setText(sp1.btn.getId());
        sp1btn.setDisable(sp1.getStatus());
        sp1.setStatus(false);

    }


}

