package Hauptmenue;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;

import static Hauptmenue.Person.Spieler;
import static Hauptmenue.WortReserve.CitizenWort;
import static javafx.application.Application.launch;


public class MrWhiteWord extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @FXML
    private TextField Input;

String wort;

    int WortRandom= (int)(Math.random()*5);
    @Override
    public void start(final Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MrWhite.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);


        primaryStage.setTitle("Undercover");
        primaryStage.show();
    }

    @FXML
    public void test(ActionEvent event) throws IOException {

        wort=Input.getText();
System.out.println(WortReserve.CitizenWort[WortRandom]);
        if(wort.equalsIgnoreCase(WortReserve.CitizenWort[WortRandom])){
            System.out.println("Korrektes Wort");}
        else{
            System.out.println("Falsches Wort Citizen haben gewonnen");

}


    }

}



