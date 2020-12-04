package domain;

import junit.framework.TestCase;

public class spielerTest extends TestCase {
    private Spieler testSpieler;

    protected void setUp() throws Exception {
        testSpieler = new Spieler(1, "Test", true, 4);
    }

    //Überprüfe das Wechsel "Spieler ist am Leben/ Tod"
    public void testStatus() throws Exception {
        testSpieler.setStatus(false);
        assertEquals(new Spieler(1, "Test", false, 4).getStatus(), testSpieler.getStatus());
    }

    //Überprüfe die Zuweisung des Spielernummern
    public void testRollezuweisung() throws Exception {
        try {
            presentation.Controller.getSpielerListe().add(testSpieler);
            RolleZuweisung.randomRolle();
        }
        catch (IllegalArgumentException ex) {
            fail("Failed to attribute role");
        }
        assertNotSame(testSpieler.getRolle(), 4);
    }


}
