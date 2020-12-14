package domain;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import presentation.Controller;

import static org.junit.jupiter.api.Assertions.*;

public class winConditionTest extends TestCase {




@Test
public void TtestUndercover() {





    System.out.println("This is the testcase in this class");
    String str1="This is the testcase in this class";
    assertEquals("This is the testcase in this class", str1);




}

    @Test
    void Ttest2Spieler() {
        boolean boolCitizen = false;
        int spielerAmLeben = 0;
        for(int i = 0; i< Controller.getSpielerListe().size(); i++) {
            if(Controller.getSpielerListe().elementAt(i).getStatus()==true){
                spielerAmLeben ++;
            }}
        if( spielerAmLeben == 2){
            boolCitizen = true;

        }
        else {
            boolCitizen = false;

        }
        assertTrue(boolCitizen);
    }


    @Test
    void TtestCitizen() {


        boolean boolCitizen = false;
        int summeRollen = 0;
        for(int i = 0; i< Controller.getSpielerListe().size(); i++) {
            if(Controller.getSpielerListe().elementAt(i).getStatus()==true){
                summeRollen += Controller.getSpielerListe().elementAt(i).getRolle();
            }}
        if(summeRollen == 0){
            boolCitizen = true;

        }
        else {
            boolCitizen = false;

        }
        assertTrue(boolCitizen);
    }

}