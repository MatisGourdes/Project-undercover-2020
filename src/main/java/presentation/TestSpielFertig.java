package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TestSpielFertig extends Controller{


    //Überprüfe, ob nur noch Citizen Leben
    public static void finishTest(ActionEvent event) throws IOException {


        if (domain.winCondition.testUndercover() == true) {
             WerGewinnt=1;//UNDERCOVER HABEN GEWONNEN
            Parent spielParent = FXMLLoader.load(Controller.class.getResource("Gewinner.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("WIN !!!!!");
            window.show();
        } else if (domain.winCondition.testCitizen() == true) {
            WerGewinnt=0;//CITIZEN HABEN GEWONNEN
            Parent spielParent = FXMLLoader.load(Controller.class.getResource("Gewinner.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("WIN !!!!!");
            window.show();
        } else if (domain.winCondition.test2Spieler() == true) {
            for (int i = 0; i < getSpielerListe().size(); i++) {
                if (getSpielerListe().elementAt(i).getStatus() == true) {
                    if (getSpielerListe().elementAt(i).getRolle() == 1) {
                        WerGewinnt=1;//UNDERCOVER HABEN GEWONNEN
                        Parent spielParent = FXMLLoader.load(Controller.class.getResource("Gewinner.fxml"));
                        Scene spielScene = new Scene(spielParent);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(spielScene);
                        window.setTitle("WIN !!!");
                        window.show();
                    } else if (getSpielerListe().elementAt(i).getRolle() == 2) {
                        WerGewinnt=2;//MR WHITE HABEN GEWONNEN
                        Parent spielParent = FXMLLoader.load(Controller.class.getResource("Gewinner.fxml"));
                        Scene spielScene = new Scene(spielParent);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(spielScene);
                        window.setTitle("WIN !!!");
                        window.show();
                    }
                }

            }
        } else {
            Parent spielParent = FXMLLoader.load(Controller.class.getResource("RundeBefehl.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("Wer ist dran ?");
            window.show();
        }
    }

    public void LaunchGewinner(){

    }
}
