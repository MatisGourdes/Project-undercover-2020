package domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.Vector;
import java.io.FileWriter;
import java.io.File;

public class WortReserve {

    //Vektor, der alle Wörter beinhaltet
    public static Vector<String> woerterListe = new Vector<>();
    //Variablen zur Erstellung des Verzeichnises + der Textdatei
    private static final Logger LOG = LogManager.getLogger(woerterSpeichern.class);
    private static final String wortFileName = "WoerterDatenbank.txt";
    private final static String wortVerzeichnis = "Woerter";
    private static final String wortVerzeichnisPath = System.getProperty("user.dir") + File.separator + wortVerzeichnis;
    private static final String wortFilePath = wortVerzeichnisPath + File.separator + wortFileName;

    //Schreibe ursprüngliche Wörter - falls nicht bereits vorhanden -
    public static void createWoerterListe() throws IOException {
        createUserHomeFolder();
        if (new File(wortFilePath).isFile()) {
            LOG.info(wortFilePath + " already present, will not change the property file!");
        } else {
            LOG.info(wortFilePath + " property file NOT present, we will initialize the file with the properties from the resources");
            initWoerterListe("Paris;New York\nBerliner Mauer;\nChinesische Mauer\nTheater;Oper\nBaum;Tannenbaum\nNemo;Willy\n");
        }
    }

    //speichert alle Wörter der txt-Datei in einem Vektor
    public static void readFile(){
        woerterListe.clear();
        System.out.println("file read, path: " + wortFilePath); //debug

        try (FileReader f = new FileReader(wortFilePath)) {
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
    //Speichere das Wort in der Text-Datei
    public static void wortAddieren(String wortC,String wortU){
        try (FileWriter w = new FileWriter(wortFilePath, true)) {
            String eingabe = wortC + ";" + wortU + "\n";
            w.write(eingabe);
        }
        catch (IOException e) {
            System.err.println("Fehler beim Schreiben in der Datei.");
            System.err.println(e.getMessage());
        }
    }

    //Initialisierung der WoerterListe
    protected static void initWoerterListe(String initWoerter) throws IOException {

        try{
            File outputStream = new File(wortFilePath);
            FileWriter temp = new FileWriter(wortFilePath);
            temp.write(initWoerter);
            temp.close();
            LOG.info("Woerter: " + initWoerter + " saved to " + wortFilePath);
        }
        catch(IOException e){
            System.err.println("Fehler beim Schreiben in der Datei.");
        }
    }

    //erstelle - falls nötig - das Verzeichnis
    private static void createUserHomeFolder() throws IOException {
        File f=new File(wortVerzeichnisPath);
        if(!f.exists()) {
            boolean success = f.mkdir();
            if (!success) {
                throw new IOException("cannot create " + wortVerzeichnisPath);
            } else {
                LOG.info(wortVerzeichnisPath + " created");
            }
        }
        else {
            LOG.info(wortVerzeichnisPath + " already present!");
        }
    }
}


