package presentation;

import domain.Spieler;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WortAusgabeControllerTest {
@Test
  public void createNewSpieler()

  {


  Spieler spieler1 = new Spieler(1, "nameA", true, 0);
  Spieler spieler2 = new Spieler(2, "nameB", true, 1);
  Spieler spieler3 = new Spieler(3, "nameC", true, 2);

    Assertions.assertEquals(0,spieler1.getRolle());
    Assertions.assertEquals(1,spieler2.getRolle());
    Assertions.assertEquals(2,spieler3.getRolle());

}


}
