package Hauptmenue;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import java.util.Vector;

public class Person {

    static int SpielerZahl1 = 8;// Hier Wächseln um SpielerZahl zu ändern

    public static String[] Spieler = new String [8];



   public static int[] RolleArray= new int[8];// Hier falls mehr als 8 Spielern auch 8 wechseln
    // 0 = Citizen
    // 1 = Undercover
    // 2 = Mr White
    public static String[] RolleInPlayerOrder= new String[8];// Hier sind die Die Rollen geordnet in die Player Reihe

  public static boolean[] StateArray= new boolean[8];
    private static String Speicher;

    public static void DefineAllAlive(int SpielerZahl) { //Nous allons définir si les personnes sont en vie ou non avec ce boolean
    for(int i=0; i<SpielerZahl;i++){
        StateArray[i] = true;// True = Spieler alive   False = has been ejected
    }
}


        public static void DefineRolle(int SpielerZahl){
        switch (SpielerZahl) {
            case 4:
                RolleArray[0] = 0;
                RolleArray[1] = 1;
                RolleArray[2] = 0;
                RolleArray[3] = (int) (Math.random() * 2)+1;
            break;

            case 5:
                RolleArray[0] = 0;
                RolleArray[1] = 0;
                RolleArray[2] = 1;
                RolleArray[3] = 0;
                RolleArray[4] = (int) (Math.random() * 2)+1;
            break;

            case 6:
                RolleArray[0] = 1;
                RolleArray[1] = 0;
                RolleArray[2] = 0;
                RolleArray[3] = 0;
                RolleArray[4] = (int) (Math.random() * 2)+1;
                RolleArray[5] = (int) (Math.random() * 2);

            break;

            case 7:
                RolleArray[0] = 0;
                RolleArray[1] = 0;
                RolleArray[2] = 0;
                RolleArray[3] = (int) (Math.random() * 2)+1;
                RolleArray[4] = 1;
                RolleArray[5] = (int) (Math.random() * 3);
                RolleArray[6] = (int) (Math.random() * 2)+1;
            break;

            case 8:
                RolleArray[0] = 0;
                RolleArray[1] = 0;
                RolleArray[2] = 0;
                RolleArray[3] = 0;
                RolleArray[4] = 1;
                RolleArray[5] = (int) (Math.random() * 2)+1;
                RolleArray[6] = (int) (Math.random() * 2);
                RolleArray[7] = 3;
                break;

        }}


    public static void DefineRolleZuSpieler(int SpielerZahl) {
        int random =(int) (Math.random() * 2);
        int random2 =(int) (Math.random() * 2);
        switch (SpielerZahl) {
            case 4:
                Spieler[0] = "Player 1";
                Spieler[1] = "Player 2";
                Spieler[2] = "Player 3";
                Spieler[3] = "Player 4";



                 if (random == 0) {Speicher = Spieler[0];
                 Spieler[0] = Spieler[2];
                 Spieler[2]=Speicher;}
                 else if(random2 == 0){ Speicher = Spieler[1];
                     Spieler[1] = Spieler[3];
                     Spieler[3]=Speicher;}
                 else if (random==1){Speicher = Spieler[2];
                     Spieler[2] = Spieler[3];
                     Spieler[3]=Speicher;}

                 else{Speicher = Spieler[1];
            Spieler[1] = Spieler[0];
            Spieler[0]=Speicher;}

        for(int i=0; i<4; i++) {
            RolleInPlayerOrder[i]=Spieler[i];
        }

                break;

            case 5:
                Spieler[0] = "Player 1";
                Spieler[1] = "Player 2";
                Spieler[2] = "Player 3";
                Spieler[3] = "Player 4";
                Spieler[4] = "Player 5";


                if (random == 0) {Speicher = Spieler[0];
                    Spieler[0] = Spieler[2];
                    Spieler[2]=Speicher;}
                else if(random2 == 0){ Speicher = Spieler[1];
                    Spieler[1] = Spieler[3];
                    Spieler[3]=Speicher;}
                else if (random==1){Speicher = Spieler[2];
                    Spieler[2] = Spieler[3];
                    Spieler[3]=Speicher;}
                else if (random2==1){Speicher = Spieler[4];
                    Spieler[4] = Spieler[3];
                    Spieler[3]=Speicher;}
                else{Speicher = Spieler[1];
                    Spieler[1] = Spieler[0];
                    Spieler[0]=Speicher;
                    Speicher = Spieler[4];
                    Spieler[4] = Spieler[0];
                    Spieler[0]=Speicher;}

                for(int i=0; i<5; i++) {
                    RolleInPlayerOrder[i]=Spieler[i];
                }
                break;

            case 6:
                Spieler[0] = "Player 1";
                Spieler[1] = "Player 2";
                Spieler[2] = "Player 3";
                Spieler[3] = "Player 4";
                Spieler[4] = "Player 5";
                Spieler[5] = "Player 6";

                if (random == 0) {Speicher = Spieler[0];
                    Spieler[0] = Spieler[2];
                    Spieler[2]=Speicher;}
                else if(random2 == 0){ Speicher = Spieler[1];
                    Spieler[1] = Spieler[3];
                    Spieler[3]=Speicher;}
                else if (random==1){Speicher = Spieler[2];
                    Spieler[2] = Spieler[3];
                    Spieler[3]=Speicher;}
                else if (random2==1){Speicher = Spieler[4];
                    Spieler[4] = Spieler[3];
                    Spieler[3]=Speicher;}
                else{Speicher = Spieler[1];
                    Spieler[1] = Spieler[0];
                    Spieler[0]=Speicher;
                    Speicher = Spieler[4];
                    Spieler[4] = Spieler[0];
                    Spieler[0]=Speicher;}

                for(int i=0; i<5; i++) {
                    RolleInPlayerOrder[i]=Spieler[i];
                }

                break;

            case 7:

                break;

            case 8:

                break;

        }}





    public static void ShowMyWork(int SpielerZahl) {
    for(int i=0; i<SpielerZahl;i++){
        System.out.println("Spieler: " + i + "    Alive?: " + StateArray[i] +"    Rolle : " + RolleArray[i]);
    }
}


}

