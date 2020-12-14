package domain;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static domain.WortReserve.woerterListe;

public class WortReserveTest extends TestCase {


    public static Vector<String> woerterListe = new Vector<>();
    public static String wort="Tomate";


   @Test
    public void testEingabeWoerter() throws Exception {

        try (
                FileReader f = new FileReader("src/main/resources/domain/woerterDatenBank")) {
            char c[] = new char[10000];
            f.read(c);
            String s = new String(c);
            String[] result = s.split("\n|;");

            for (int i = 0; i < result.length; i++) {
                woerterListe.add(result[i]);
                f.close();
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Einlesen der Datei.");
            System.err.println(e.getMessage());

        }

        assertEquals(woerterListe.get(0), wort);
    }

}
