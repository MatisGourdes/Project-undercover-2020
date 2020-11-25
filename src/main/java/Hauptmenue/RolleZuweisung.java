package Hauptmenue;

public class RolleZuweisung {
    static int citizen, undercover, mrWhite, rolle;
    static int zahlCitizen = 0;
    static int zahlUndercover = 0;
    static int zahlMrWhite = 0;
    static int zahlGeteilteteRolle = 0;
    static int variabelRandom = 3;

    public static void randomRolle() {


        rolleVerteilung();
        System.out.println(Controller.getSpielerListe().size());//ca c'est bon

        while (zahlGeteilteteRolle < Controller.getSpielerListe().size()) {//ca c'est bon

            for (int j = 0; j < Controller.getSpielerListe().size(); j++) {//ca c'est bon

                if (Controller.getSpielerListe().elementAt(j).getRolle() == 4) {//ca c'est bon
                    rolle = (int) (Math.random() * variabelRandom);//ca c'est bon


                    if (rolle == 0 && zahlCitizen < citizen) {//ca c'est bon
                        zahlCitizen++;
                        Controller.getSpielerListe().elementAt(j).setRolle(rolle);
                        zahlGeteilteteRolle++;
                    } else if (rolle == 1 && zahlUndercover < undercover) {
                        zahlUndercover++;
                        Controller.getSpielerListe().elementAt(j).setRolle(rolle);
                        zahlGeteilteteRolle++;
                    } else if (rolle == 2 && zahlMrWhite < mrWhite) {
                        zahlMrWhite++;
                        Controller.getSpielerListe().elementAt(j).setRolle(rolle);
                        zahlGeteilteteRolle++;
                    }
                }

            }


        }

    }


    public static void rolleVerteilung() {
        zahlMrWhite();
        System.out.println(mrWhite);

        citizen = (int) ((Controller.getSpielerListe().size() - mrWhite) * 0.8);
        //System.out.println("nb joueur "+spielerNr + "  citizen "+citizen);
        undercover = Controller.getSpielerListe().size() - mrWhite - citizen;

        System.out.println("Citizen: " + citizen + "  Undercover: " + undercover + " MrWhite: " + mrWhite);
    }


    public static void zahlMrWhite() {
        if(4<=Controller.getSpielerListe().size() &&  Controller.getSpielerListe().size()  <=6) {
            mrWhite = (int) (Math.random()*2);
        }
        else if (7<=Controller.getSpielerListe().size() &&  Controller.getSpielerListe().size()  <=10) {
            mrWhite = (int) (Math.random()*3);
        }

    }
}




