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
    private Button btnHide;


    @FXML
    private Label WortAusgabe;

    @FXML
      private Label BefehleWortAusgabe;

    @FXML
            private Button HideWord ;

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
                     printLabelWort = "  ";

                     break;
             }

    BefehleWortAusgabe.setText("Hallo "+Person.SpielerUngeordnet[i]);
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
            WortAusgabe.setText(" Hier ist dein Wort :\n " + printLabelWort + "\n  Wenn du es gesehen hast press den Button unten recht um es zu verstecken");

        }
    }

public void swichToHideWord (ActionEvent event) throws IOException{
    WortAusgabe.setText("");


    }}

