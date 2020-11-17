package Hauptmenue;


import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;

        import java.io.IOException;

public class ControllerWortAusgabe extends Controller {


    @FXML
    private Button btnWorter;

    @FXML
    private Label WortAusgabe;

    String printLabelWort;

    int WortRandom= (int)(Math.random()*5);


public void SwitchToNextPLayer(ActionEvent event) throws IOException {

        for (int i = 0; i < spielerZahl; i++) {
            PrintWord(i); // demander je veux mtn que ca continue quand j'appuie sur le bouton michael aide moi wsh
           WortAusgabe.setText(" ");
        }
    }




    public void PrintWord(int i){
        switch(Person.RolleArray[i]){// Ici changer le 1
            case 0:
            printLabelWort = WortReserve.CitizenWort[WortRandom];
                WortAusgabe.setText(printLabelWort);
                break;
            case 1:
                printLabelWort = WortReserve.UndercoverWort[WortRandom];
                WortAusgabe.setText(printLabelWort);

                break;
            case 2 :


                break;
    }

}}