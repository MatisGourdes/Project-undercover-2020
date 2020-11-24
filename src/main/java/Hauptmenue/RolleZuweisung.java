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
            System.out.println(Controller.getSpielerListe().size());//ca c'est bon

            while(zahlGeteilteteRolle<Controller.getSpielerListe().size()){//ca c'est bon

                for (int j=0; j<Controller.getSpielerListe().size();j++) {//ca c'est bon

                    if(Controller.getSpielerListe().elementAt(j).getRolle()==4) {//ca c'est bon
                        rolle = (int) (Math.random()* variabelRandom);//ca c'est bon


                        if(rolle ==0 && zahlCitizen<citizen ) {//ca c'est bon
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

        }



        public static void rolleVerteilung(){
            citizen = (int)((Controller.getSpielerListe().size()-1)*0.8);
            //System.out.println("nb joueur "+spielerNr + "  citizen "+citizen);
            undercover = Controller.getSpielerListe().size()-1-citizen;

            System.out.println("Citizen: " +citizen+"  Undercover: " + undercover+" MrWhite: " +1);
        }

    }





