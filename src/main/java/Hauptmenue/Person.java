package Hauptmenue;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Random;

public class Person {

    static int SpielerZahl1 = 8;// Hier Wächseln um SpielerZahl zu ändern





   public static int[] RolleArray= new int[8];// Hier sind die Rolen
    // 0 = Citizen
    // 1 = Undercover
    // 2 = Mr White
  public static boolean[] StateArray= new boolean[8];// Hier können wir wissen ob ein Spieler entfernt ist oder nicht
    // True =Alive
    //False = No more alive...;(

    public static String[] Spieler = new String [8];// Dieses Array nicht nützen nur in Person nötig um die Spieler zu mischen

    public static void DefineAllAlive(int SpielerZahl) { //Nous allons définir si les personnes sont en vie ou non avec ce boolean
    for(int i=0; i<SpielerZahl;i++){
        StateArray[i] = true;// True = Spieler alive   False = has been ejected
    }
}
        public static void DefineRolle(int SpielerZahl){
        /* Diese Programm definiert die Rollen  in abhängigkeit von die Spielerzahl.
           Wir müssen folgende Anforderung erfüllen:
               - Die erste Rolle muss nicht ein Mr White sein (Rolle :2)
               - Es muss immer mehr Citizen als Undercover geben
               - Die Rollen müssen nicht vorhersehbar sein    */
        switch (SpielerZahl) {
            case 4:
                RolleArray[0] = (int) (Math.random() * 2);
                if (RolleArray[0] == 1) { RolleArray[1] = 0;}
                else{RolleArray[1] = (int)(Math.random() * 2);}
                if (RolleArray[0] == 1 || RolleArray[1] == 1 ) { RolleArray[2] = 0;}
                else{RolleArray[2] = (int)(Math.random() * 2);}
                if (RolleArray[0] == 0 && RolleArray[1] == 0 && RolleArray[2]== 0) { RolleArray[3] = (int) (Math.random() * 2)+1;}
                else{RolleArray[3] = 0;}
            break;

            case 5:
                RolleArray[0] = (int) (Math.random() * 2);
                if (RolleArray[0] == 1) { RolleArray[1] = 0;}
                else{RolleArray[1] = (int)(Math.random() * 2);}
                if (RolleArray[0] == 1 || RolleArray[1] == 1 ) { RolleArray[2] = 0;}
                else{RolleArray[2] = 1;}
                RolleArray[3] = (int) (Math.random() * 3);
                if (RolleArray[3] == 0 ) { RolleArray[4] = (int) (Math.random() * 2)+1;}
                else{RolleArray[4] = 0;}
                break;

            case 6:
                RolleArray[0] = (int) (Math.random() * 2);
                if (RolleArray[0] == 1) { RolleArray[1] = 0;}
                else{RolleArray[1] = (int)(Math.random() * 2);}
                if (RolleArray[0] == 1 || RolleArray[1] == 1 ) { RolleArray[2] = 0;}
                else{RolleArray[2] = 1;}
                RolleArray[3] = (int) (Math.random() * 3);
                if (RolleArray[3] == 0 ) { RolleArray[4] = (int) (Math.random() * 2)+1;}
                else{RolleArray[4] = (int) (Math.random() * 3);}
                if (RolleArray[4] == 0 ) { RolleArray[5] = (int) (Math.random() * 3);}
                else{RolleArray[5] = 0;}
                break;

            case 7:
                RolleArray[0] = (int) (Math.random() * 2);
                if (RolleArray[0] == 1) { RolleArray[1] = 0;}
                else{RolleArray[1] = (int)(Math.random() * 2);}
                if (RolleArray[0] == 1 || RolleArray[1] == 1 ) { RolleArray[2] = 0;}
                else{RolleArray[2] = 1;}
                RolleArray[3] = (int) (Math.random() * 3);
                if (RolleArray[3] == 0 ) { RolleArray[4] = (int) (Math.random() * 2)+1;}
                else{RolleArray[4] = (int) (Math.random() * 3);}
                if (RolleArray[4] == 0 ) { RolleArray[5] = (int) (Math.random() * 3);}
                else{RolleArray[5] = 0;}
                if (RolleArray[5] == 2 ) { RolleArray[5] = (int) (Math.random() * 2);}
                else{RolleArray[5] = 0;}
            break;

            case 8:
                RolleArray[0] = (int) (Math.random() * 2); // 0 oder 1
                RolleArray[1] = (int) (Math.random() * 2);// 0 oder 1
                RolleArray[2] = (int) (Math.random() * 2);// 0 oder 1
                RolleArray[3] = (int) (Math.random() * 2)+1;// 1 oder 2
                if (RolleArray[0] == 1||RolleArray[1] == 1){RolleArray[4] = 0;}
                else{RolleArray[4] = (int)(Math.random() * 2);}// 1 oder 2
                if (RolleArray[0] == 1||RolleArray[1] == 1){RolleArray[5] = 0;}
                else{RolleArray[5] = (int)(Math.random() * 2);}// 1 oder 2
                RolleArray[6] = (int) (Math.random() * 3); // 1  oder 2 oder 3
                if (RolleArray[6] == 0){RolleArray[7] = (int)(Math.random() * 3);}
                else{RolleArray[7] = 0;}
                break;

        }}

    public static void DefineRolleZuSpieler(int SpielerZahl) {// Dieser Programm nützt die Klasse Pioche um die Spieler in eine Ungeordnete Reihe zu setzen
        //Wir definieren zuerst die Spieler 1 bis 8
        // Hier später die Spieler Namen eintragen
                Spieler[0] = "Player 1";
                Spieler[1] = "Player 2";
                Spieler[2] = "Player 3";
                Spieler[3] = "Player 4";
                Spieler[4] = "Player 5";
                Spieler[5] = "Player 6";
                Spieler[6] = "Player 7";
                Spieler[7] = "Player 8";
        }

    public static void ShowMyWork(int SpielerZahl) {
    for(int i=0; i<SpielerZahl;i++){
        System.out.println( Spieler[i] + "    Alive?: " + StateArray[i] +"    Rolle : " + RolleArray[i]);
    }
}
}

