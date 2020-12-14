package presentation;

import domain.Spieler;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WortAusgabeControllerTest  {
@Test
  public void createNewSpieler()

  {


  Spieler spieler1 = new Spieler(1, "nameA", true, 0);
    presentation.Controller.getSpielerListe().add(spieler1);
 // Spieler spieler2 = new Spieler(2, "nameB", true, 1);
 // Spieler spieler3 = new Spieler(3, "nameC", true, 2);

    Assertions.assertEquals(spieler1.getRolle(), Controller.getSpielerListe().elementAt(0).getRolle());

}


}