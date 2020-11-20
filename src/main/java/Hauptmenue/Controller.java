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
import java.util.Random;

public class Controller {
    @FXML
    private Button Spielen = new Button();

    //test
    static Person2 sp1 = new Person2("Kevin", true, 2, new Button());
    static Person2 sp2 = new Person2("Josué", true, 0, new Button());
    static Person2 sp3 = new Person2("Suzon", true, 0, new Button());
    static Person2 sp4 = new Person2("Jenny", true, 2, new Button());
    @FXML
    Button sp1btn = sp1.btn;
    @FXML
    Button sp2btn = sp2.btn;
    @FXML
    Button sp3btn = sp3.btn;
    @FXML
    Button sp4btn = sp4.btn;


public void initialize(){
    sp1btn.setText(sp1.getName());
    sp2btn.setText(sp2.getName());
    sp3btn.setText(sp3.getName());
    sp4btn.setText(sp4.getName());
}
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

    //Spieler1
    public void wahlSp1(ActionEvent event) throws IOException{
        sp1btn.setText(Person2.rolleName(sp1.getRolle()));
        sp1btn.setDisable(true);
        sp1.setStatus(false);

    }

    //Spieler2
    public void wahlSp2(ActionEvent event) throws IOException{
        sp2btn.setText(Person2.rolleName(sp2.getRolle()));
        sp2btn.setDisable(true);
        sp2.setStatus(false);

    }
    //Spieler3
    public void wahlSp3(ActionEvent event) throws IOException{
        sp3btn.setText(Person2.rolleName(sp3.getRolle()));
        sp3btn.setDisable(true);
        sp3.setStatus(false);

    }
    //Spieler4
    public void wahlSp4(ActionEvent event) throws IOException{
        sp4btn.setText(Person2.rolleName(sp4.getRolle()));
        sp4btn.setDisable(true);
        sp3.setStatus(false);

    }


}

