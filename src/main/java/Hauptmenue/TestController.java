package Hauptmenue;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TestController {
@FXML
Button sp1btn = Controller.sp1.btn;

    public static void main(String[] args){

        Controller.sp1.btn.setText("Spieler1");
        Controller.sp1.btn.setDisable(Controller.sp1.getStatus());


        //Controller.sp2.getBtn().setText("Spieler2");
        //Controller.sp3.getBtn().setText("Spieler3");
        //Controller.sp4.getBtn().setText("Spieler4");
    }
}
