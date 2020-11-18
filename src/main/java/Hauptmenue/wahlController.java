package Hauptmenue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Vector;

public class wahlController {
    @FXML
    private Label spielerNrwaehlt;
    @FXML
    private TextField gewaehlterSpielerEingabe;
    public int anzahlSpieler;


    /* Wahl --- TO DO :
    - faire afficher l'écran wahl à la fin du round (au lieu de quand on clique sur spiel)
    - définir variable nb_joueurs dans le if(count<...)


     */

    Vector<String> vote = new Vector<>();
    int count = 1;
    public void wahl(ActionEvent event) throws IOException {
        if(count<4){
            spielerNrwaehlt.setText("Spieler " + (count+1) + " wählt:");
            vote.add(gewaehlterSpielerEingabe.getText());
            count++;
            gewaehlterSpielerEingabe.setText("");
        }

        else if(count>3) {
            for (int i = 0; i < vote.size(); i++) {
                System.out.println(vote.elementAt(i));
            }
        }

    }

   // public void wahl(ActionEvent event) throws IOException{
     //   for(int i = 0; i < anzahlSpieler; i++){

        }


