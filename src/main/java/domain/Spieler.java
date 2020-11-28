package domain;


public class Spieler {

    private String name;
    private boolean status;
    private int rolle, spielerNr;

    public Spieler(int spielerNr, String name, boolean status, int rolle){
        this.spielerNr = spielerNr;
        this.name = name;
        this.status = status;
        this.rolle = rolle;
        rolleName(this.rolle);
    }

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
