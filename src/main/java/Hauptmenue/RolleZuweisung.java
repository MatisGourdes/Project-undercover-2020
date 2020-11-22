package Hauptmenue;

    public class RolleZuweisung {
        static int citizen, undercover, rolle;
        static int zahlCitizen = 0;
        static int zahlUndercover =0;
        static int zahlMrWhite =0;
        static int zahlGeteilteteRolle = 0;
        static int variabelRandom =3;

        public static void randomRolle() {


            rolleVerteilung();

            while(zahlGeteilteteRolle<Controller.getSpielerListe().size()){

                for (int j=0; j<Controller.getSpielerListe().size();j++) {

                    if(Controller.getSpielerListe().elementAt(j).getRolle()==4) {
                        rolle = (int) (Math.random()* variabelRandom);


                        if(rolle ==0 && zahlCitizen<citizen ) {
                            zahlCitizen++;
                            Controller.getSpielerListe().elementAt(j).setRolle(rolle);
                            zahlGeteilteteRolle++;
                        }

                        else if(rolle ==1 && zahlUndercover <undercover) {
                            zahlUndercover++;
                            Controller.getSpielerListe().elementAt(j).setRolle(rolle);
                            zahlGeteilteteRolle++;
                        }


                        else if(rolle ==2 && zahlMrWhite <1) {
                            zahlMrWhite++;
                            variabelRandom--;
                            Controller.getSpielerListe().elementAt(j).setRolle(rolle);
                            zahlGeteilteteRolle++;
                        }
                    }

                }


            }
            for (int i=0; i<Controller.getSpielerListe().size();i++) {
                System.out.println("spieler " + (i+1)+"  " + Controller.getSpielerListe().elementAt(i).getRolle());
            }

        }



        public static void rolleVerteilung(){
            citizen = (int)((Controller.getSpielerListe().size()-1)*0.8);
            //System.out.println("nb joueur "+spielerNr + "  citizen "+citizen);
            undercover = Controller.getSpielerListe().size()-1-citizen;

            System.out.println("Citizen: " +citizen+"  Undercover: " + undercover+" MrWhite: " +1);
        }

    }





