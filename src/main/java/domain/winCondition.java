package domain;

import presentation.Controller;

public class winCondition {
     /*In dieser Klasse werd nach jeder Wahl getestet ob der Spiel Fertig ist:
       Der Spiel ist Fertig falls:
        - Alle Lebendige Spieler Undercover sind
        - Alle Lebendige Spieler Citizen sind
        - Falls es nur noch 2 lebendige Spieler gibt (Undercover oder Mr White Gewinnen gegen Citizen)
        */

    public static boolean testUndercover() {
        boolean boolUndercover = false;
        double summeRollen = 0;
        int SpielerAmLeben=0;
        for(int i = 0; i< Controller.getSpielerListe().size(); i++) {

            if(Controller.getSpielerListe().elementAt(i).getStatus()==true){
                SpielerAmLeben++;
                if(Controller.getSpielerListe().elementAt(i).getRolle()==1){
                    summeRollen += 1 ;
                }}
        }
        summeRollen = summeRollen/ SpielerAmLeben;
        if(summeRollen == 1)
        {boolUndercover = true;}

        else{boolUndercover = false; }

        return boolUndercover;
    }


    public static boolean testCitizen() {
        boolean boolCitizen = false;
        int summeRollen = 0;
        for(int i = 0; i< Controller.getSpielerListe().size(); i++) {
            if(Controller.getSpielerListe().elementAt(i).getStatus()==true){
                summeRollen += Controller.getSpielerListe().elementAt(i).getRolle();
            }}
        if(summeRollen == 0){
            boolCitizen = true;

        }
        else {
            boolCitizen = false;

        }
        return boolCitizen;
    }
    public static boolean test2Spieler() {
        boolean boolCitizen = false;
        int spielerAmLeben = 0;
        for(int i = 0; i< Controller.getSpielerListe().size(); i++) {
            if(Controller.getSpielerListe().elementAt(i).getStatus()==true){
                spielerAmLeben ++;
            }}
        if( spielerAmLeben == 2){
            boolCitizen = true;

        }
        else {
            boolCitizen = false;

        }
        return boolCitizen;
    }
}
