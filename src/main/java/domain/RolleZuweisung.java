package domain;

import presentation.Controller;

public class RolleZuweisung {
    private static int citizen, undercover, mrWhite, rolle;
    private static int zahlCitizen = 0;
    private static int zahlUndercover = 0;
    private static int zahlMrWhite = 0;
    private static int zahlGeteilteteRolle = 0;
    private static int variabelRandom = 3;

    public static void randomRolle() {
        rolleVerteilung();
        while (zahlGeteilteteRolle < Controller.getSpielerListe().size()) {

            for (int j = 0; j < Controller.getSpielerListe().size(); j++) {

                if (Controller.getSpielerListe().elementAt(j).getRolle() == 4) {
                    rolle = (int) (Math.random() * variabelRandom);

                    if (rolle == 0 && zahlCitizen < citizen) {
                        zahlCitizen++;
                        Controller.getSpielerListe().elementAt(j).setRolle(rolle);
                        zahlGeteilteteRolle++;
                    }
                    else if (rolle == 1 && zahlUndercover < undercover) {
                        zahlUndercover++;
                        Controller.getSpielerListe().elementAt(j).setRolle(rolle);
                        zahlGeteilteteRolle++;
                    }
                    else if (rolle == 2 && zahlMrWhite < mrWhite) {
                        zahlMrWhite++;
                        Controller.getSpielerListe().elementAt(j).setRolle(rolle);
                        zahlGeteilteteRolle++;
                    }
                }
            }
        }

    }


    private static void rolleVerteilung() {
        zahlMrWhite();
        citizen = (int) ((Controller.getSpielerListe().size() - mrWhite) * 0.8);
        undercover = Controller.getSpielerListe().size() - mrWhite - citizen;
        System.out.println("Citizen: " + citizen + "  Undercover: " + undercover + " MrWhite: " + mrWhite);//debug
    }


    private static void zahlMrWhite() {
        if(4<=Controller.getSpielerListe().size() &&  Controller.getSpielerListe().size()  <=6) {
            mrWhite = (int) (Math.random()*2);
        }
        else if (7<=Controller.getSpielerListe().size() &&  Controller.getSpielerListe().size()  <=10) {
            mrWhite = (int) (Math.random()*3);
        }

    }
}




