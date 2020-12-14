package domain;


public class Spieler {
    /*In dieser Klasse werden die Spieler erstellt.
          Ein Spieler enthält dieser dateien:
          - die SpielerNummer (0 für den ersten)
          - den Namen vom Spieler
          - den Status (true = am leben  False = gestorben)
          - Die Rolle (O=Citizen   1=Undercover  2=Mr White)

           */
    private String name;
    private boolean status;
    private int rolle, spielerNr;

    //Konstruktor Spieler, der alle Infos beinhaltet
    public Spieler(int spielerNr, String name, boolean status, int rolle){
        this.spielerNr = spielerNr;
        this.name = name;
        this.status = status;
        this.rolle = rolle;
        rolleName(this.rolle);
    }

    //Methode für die Rückgabe der Rolle des Spielers als String anstatt von Integer
    public static String rolleName(int rolle){
        String Rolle ="";
        switch (rolle){
            case 0:
                Rolle = "Citizen";
                break;
            case 1:
                Rolle = "Undercover";
                break;
            case 2:
                Rolle = "Mr White";
                break;
        }
        return Rolle;
    }

    //Getter + Setter für den Zugriff auf die Infos der jeweiligen Spieler
    public int getSpielerNr() { return spielerNr; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRolle() {
        return rolle;
    }

    public void setRolle(int rolle) {
        this.rolle = rolle;
    }
}
