package Hauptmenue;


import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;

        import java.io.IOException;

public class ControllerWortAusgabe {

    @FXML
    private Button btnWorter;

    @FXML
    private Label WortAusgabe;
    int WortRandom;
    String printLabelWort;



    public void SwitchToNextPLayer (ActionEvent event ) throws IOException {
        WortRandom= (int)(Math.random()*5);
        PrintWord();



    }
    public void PrintWord(){
        switch(Person.RolleArray[1]){// Ici changer le 1
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