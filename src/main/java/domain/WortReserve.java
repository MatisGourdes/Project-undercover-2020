package domain;

import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class WortReserve {

public static Vector<String> woerterListe = new Vector<>();

    public static void readFile(){
        //speichert alle Wörter der txt-Datei in einem Vektor
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
        }
        catch (IOException e) {
            System.err.println("Fehler beim Einlesen der Datei.");
            System.err.println(e.getMessage());
        }
    }
}


