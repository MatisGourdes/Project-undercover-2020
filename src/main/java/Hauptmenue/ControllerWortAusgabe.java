package Hauptmenue;


import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;

        import java.io.IOException;

public class ControllerWortAusgabe extends Controller  {


    @FXML
    private Button btnWorter;


    @FXML
    private Label WortAusgabe;

    @FXML
      private Label BefehleWortAusgabe;

    @FXML
            private Button HideWord;

    String printLabelWort;

    int WortRandom= (int)(Math.random()*5);

int i=0;
    boolean swich = false;


    public void SwitchToNextPLayer(ActionEvent event) throws IOException {


   WortAusgabe.setText("");
   HideWord.setText("click to show");
   swich=false;

             switch(Person.RolleArray[i]){// Ici changer le 1
                 case 0:
                     printLabelWort = WortReserve.CitizenWort[WortRandom];

                     break;
                 case 1:
                     printLabelWort = WortReserve.UndercoverWort[WortRandom];


                     break;
                 case 2 :
                     printLabelWort = "  ";

                     break;
             }

    BefehleWortAusgabe.setText("Hallo "+Person.Spieler[i]);
             i++;
        }

    public void setWortRandom(int wortRandom) {
        WortRandom = wortRandom;
    }

    public int getWortRandom() {
        return WortRandom;
    }

public void swichToShow (ActionEvent event) throws IOException{

        if (i>0) {

            if (swich==false ) {
                WortAusgabe.setText(" Hier ist dein Wort :\n " + printLabelWort + "\n  Wenn du es gesehen hast press den Button unten recht um es zu verstecken");
                HideWord.setText("click to hide");
            }
          else { WortAusgabe.setText("");
                HideWord.setText("click to show");
            }

     swich=!swich;
        }
    }

}

