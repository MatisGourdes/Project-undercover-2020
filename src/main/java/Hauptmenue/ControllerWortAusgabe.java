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

    @FXML
      private Label BefehleWortAusgabe;

    String printLabelWort;

    int WortRandom= (int)(Math.random()*5);

int i=0;
public void SwitchToNextPLayer(ActionEvent event) throws IOException {




             switch(Person.RolleArray[i]){// Ici changer le 1
                 case 0:
                     printLabelWort = WortReserve.CitizenWort[WortRandom];

                     break;
                 case 1:
                     printLabelWort = WortReserve.UndercoverWort[WortRandom];


                     break;
                 case 2 :


                     break;
             }
           WortAusgabe.setText(" voici ton mot "+printLabelWort);
    BefehleWortAusgabe.setText("salam "+i);
             i++;
        }







    }

