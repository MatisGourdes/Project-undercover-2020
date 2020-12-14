package domain;

import presentation.Controller;

public class winCondition {

    public static boolean testUndercover() {
        boolean boolCitizen = false;
        double summeRollen = 0;
        int SpielerAmLeben=0;
        for(int i = 0; i< Controller.getSpielerListe().size(); i++) {


        }
        summeRollen = summeRollen/ SpielerAmLeben;
        if(summeRollen == 1)
        {boolCitizen = true;}

        else{boolCitizen = false; }

        return boolCitizen;
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
