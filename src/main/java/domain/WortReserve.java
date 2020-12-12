package domain;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class WortReserve {

    //Vektor, der alle Wörter beinhaltet
public static Vector<String> woerterListe = new Vector<>();

    public static void readFile(){
        woerterListe.clear();
        //speichert alle Wörter der txt-Datei in einem Vektor
        String path = System.getProperty("user.dir") + File.separator + "src"
        + File.separator + "main" + File.separator + "resources" + File.separator + "domain" + File.separator + "woerterDatenBank";
        System.out.println("file read, path: " + path);

        try (FileReader f = new FileReader(path)) {
            char c[] = new char[10000];
            f.read(c);
            String s = new String(c);
            String[] result = s.split("\n|;");

            for (int i = 0; i < result.length; i++) {
                if (!result[i].equals("") && result[i] != null){
                    woerterListe.add(result[i]);
                    f.close();
                }
            }
        }
        catch (IOException e) {
            System.err.println("Fehler beim Einlesen der Datei.");
            System.err.println(e.getMessage());
        }
    }
}


