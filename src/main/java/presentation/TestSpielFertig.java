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


        if (domain.winCondition.testUndercover() == true) {//Es bleiben Nur Undercover
             WerGewinnt=1;//UNDERCOVER HABEN GEWONNEN
            LaunchGewinner(event);// Gewinner fxml datei starten
        } else if (domain.winCondition.testCitizen() == true) {// Es bleiben nur Citizen
            WerGewinnt=0;//CITIZEN HABEN GEWONNEN
            LaunchGewinner(event);// Gewinner fxml datei starten
        } else if (domain.winCondition.test2Spieler() == true) {// Kontrolle um zu prüfen ob es nur noch 2 Personen gibt
            for (int i = 0; i < getSpielerListe().size(); i++) {
                if (getSpielerListe().elementAt(i).getStatus() == true) {
                    if (getSpielerListe().elementAt(i).getRolle() == 1) {//Hier gibt es noch 1 Undercover im Spiel
                        WerGewinnt=1;//UNDERCOVER HABEN GEWONNEN
                        LaunchGewinner(event);// Gewinner fxml datei starten
                    } else if (getSpielerListe().elementAt(i).getRolle() == 2) {// Es gibt noch ein Mr White im Spiel
                        WerGewinnt=2;//MR WHITE HABEN GEWONNEN
                        LaunchGewinner(event);// Gewinner fxml datei starten
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

    public static void LaunchGewinner(ActionEvent event) throws IOException{// Gewinner fxml datei wird hier gestartet
        Parent spielParent = FXMLLoader.load(Controller.class.getResource("Gewinner.fxml"));
        Scene spielScene = new Scene(spielParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("WIN !!!");
        window.show();
    }
}
