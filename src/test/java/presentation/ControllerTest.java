package presentation;

import domain.Spieler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ControllerTest extends TestCase {
  @Test
  public void testGetSpielerListe()// Testen dass der Rolle der Liste derselbe wie der Rolle ist

  {
    Spieler spieler1 = new Spieler(1, "nameA", true, 0);
    presentation.Controller.getSpielerListe().add(spieler1);

    Assertions.assertEquals(spieler1.getRolle(), Controller.getSpielerListe().elementAt(0).getRolle());

  }

  @Test
  public void testkillSomeone() // Test set statut false oder right ,  Test Funktion showLebendigeSpieler
  {
    Controller.getSpielerListe().clear();
    Spieler spieler1 = new Spieler(1, "nameA", true, 0);
    Spieler spieler2 = new Spieler(2, "nameB", true, 1);
    presentation.Controller.getSpielerListe().add(spieler1);
    presentation.Controller.getSpielerListe().add(spieler2);

    spieler1.setStatus(false);


    ObservableList<Spieler> list1 = FXCollections.observableArrayList();
    list1.add(spieler2);

    Assertions.assertEquals(list1, Controller.showLebendigeSpieler());
  }



}
