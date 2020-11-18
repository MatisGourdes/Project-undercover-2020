package Hauptmenue;

import javafx.scene.control.Button;

public class Person2 {

    private String name;
    public static Button btn;
    private boolean status;
    private int rolle;

    public Person2(String name, boolean status, int rolle, Button btn){
        this.name = name;
        this.status = status;
        this.rolle = rolle;
        this.btn = btn;
        this.btn.setText(name);
        this.btn.setId(name);
    }



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
