package Hauptmenue;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;

public class Person {

    static int SpielerZahl1 = 8;// Hier Wächseln um SpielerZahl zu ändern




   public static int[] RolleArray= new int[8];// Hier falls mehr als 8 Spielern auch 8 wechseln
    // 0 = Citizen
    // 1 = Undercover
    // 2 = Mr White


  public static boolean[] StateArray= new boolean[8];

public static void DefineAllAlive(int SpielerZahl) { //Nous allons définir si les personnes sont en vie ou non avec ce boolean
    for(int i=0; i<SpielerZahl;i++){
        StateArray[i] = true;// True = Spieler alive   False = has been ejected
    }
}


        public static void DefineRolle(int SpielerZahl){
        switch (SpielerZahl) {
            case 4:
                RolleArray[0] = 0;
                RolleArray[1] = 0;
                RolleArray[2] = 1;
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

    public static void ShowMyWork(int SpielerZahl) {
    for(int i=0; i<SpielerZahl;i++){
        System.out.println("Spieler: " + i + "    Alive?: " + StateArray[i] +"    Rolle : " + RolleArray[i]);
    }
}

}

