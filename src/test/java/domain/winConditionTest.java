package domain;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import presentation.Controller;

import static org.junit.jupiter.api.Assertions.*;

class winConditionTest extends TestCase {


    Spieler testSpieler = new Spieler(1, "TestS", true, 2);
        @Test
        public void testUndercover() throws Exception {

            boolean boolCitizen = false;
            double summeRollen = 0;
            int SpielerAmLeben=0;
            Controller.getSpielerListe().setSize(1);


            for(int i = 0; i< Controller.getSpielerListe().size(); i++) {

                if(testSpieler.getStatus()==true){
                    SpielerAmLeben++;
                    if(testSpieler.getRolle()==1){
                        summeRollen += 1 ;
                    }}
            }
            summeRollen = summeRollen/ SpielerAmLeben;
            if(summeRollen == 1)
            {boolCitizen = true;}

            else{boolCitizen = false; }






            assertFalse(boolCitizen);
        }

        public void TestCitizen() throws Exception{

            boolean boolCitizen = false;
            int summeRollen = 0;
            Controller.getSpielerListe().setSize(1);
            for(int i = 0; i< Controller.getSpielerListe().size(); i++) {
                if(testSpieler.getStatus()==true){
                    summeRollen += Controller.getSpielerListe().elementAt(i).getRolle();
                }}
            if(summeRollen == 0){
                boolCitizen = true;

            }
            else {
                boolCitizen = false;

            }
            assertFalse(boolCitizen);

        }

    }


