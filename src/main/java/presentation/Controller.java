package presentation;

import domain.RolleZuweisung;
import domain.Spieler;
import domain.WortReserve;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class Controller {

    @FXML
    private TextField eingabeName; //Name des Spielers eingeben
    @FXML
    private Label spielerAnzahlLabel; //Label für die Anzeige des Spielers, als er sein Name eingibt
    @FXML
    private Label spielerNrLabel; //Label für die Anzeige des Spielers, als er sein Name eingibt
    @FXML
    private TextField eingabeAnzahlSpieler; //Eingabe der Anzahl Mitspielern
    @FXML
    private Button speichern = new Button(); //Speichern der Spieleranzahl
    @FXML
    private Button addPlayerBtn = new Button();//Spieler addieren
    @FXML
    private TableView<Spieler> tableViewSpieler; //Tabelle zur Anzeige der Spielers
    @FXML
    private TableColumn<Spieler, Integer> nrTableView; //Anzeige des Spielernummers in der Tabelle
    @FXML
    private TableColumn<Spieler, String> nameTableView; //Anzeige des Namens der Spieler
    @FXML
    private Label befehlAusgabe;
    @FXML
    private Label WortAusgabe;
    @FXML
    private Label BefehleWortAusgabe;
    @FXML
    private Button HideWord;
    @FXML
    private Button btnWorter;
    @FXML
    private TextField Input;

    private int anzahlSpieler; //Anzahl Spieler
    private static int spielerNr = 1; //Variable für die Nummerierung der Spieler
    private static Vector<Spieler> spielerListe = new Vector<Spieler>(); //Vektor zur Speicherung aller Spieler inkl. Daten
    private boolean korrekteEingabeName1 = true; //Variablen zur Überprüfung der Eingabe des Namens
    private boolean korrekteEingabeName2 = true;
    static int WortRandom; //Variable für die Bestimmung des Wortes aus der Text-Datei
    private static String wortCitizen = " "; //Speicherung der Wörter
    private static String wortUndercover = " ";
    private int spielerWortAusgabe = 0;//Variablen für die Anzeige der Wörter zu den Spielern
    private boolean wortAngezeigt = false;
    private String printLabelWort;
    private int declic = 1; //??

    private int spielerZahl = 0; //on a besoin de celui-là ?


    public void initialize(){
        addPlayerBtn.setDisable(true);//Spieler darf erst addiert werden, wenn die Anzahl Spieler eingegeben wurde

    }


    // Wechseln zu Einstellungen View, wenn Button "Einstellungen" betätigt wird
    @FXML
    public void switchToEinstellungen(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("Einstellungen.fxml"));
        Scene spielScene = new Scene(spielParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Einstellungen");
        window.show();
    }

    // Öffnet das Fenster der Spielregeln, wenn Button "Spielregeln" betätigt wird
    @FXML
    public void switchToSpielregeln(ActionEvent event) throws IOException {
        Parent spielRegelnScene = FXMLLoader.load(getClass().getResource("spielRegeln.fxml"));
        Stage window = new Stage();
        window.setScene(new Scene(spielRegelnScene));
        window.setTitle("Spielregeln");
        window.show();
    }

    //Öffnet Fenster "Mindmap"
    @FXML
    public void showMindmap() throws IOException {
        Parent gameMindmapParent = FXMLLoader.load(getClass().getResource("mindmap.fxml"));
        Stage MindmapStage = new Stage();
        MindmapStage.setScene(new Scene(gameMindmapParent));
        MindmapStage.setTitle("Mindmap");
        MindmapStage.show();
    }

    // Wechseln zu Spiel View, wenn Button "Spielen" betätigt wird
    @FXML
    public void switchToSpiel(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("addSpieler.fxml"));
        Scene spielScene = new Scene(spielParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Undercover");
        window.show();
    }

    // Anzahl Spieler wird gespeichert, wenn auf Btn "speichern" gedrückt wird
    public void save(ActionEvent event) throws IOException{
        try{
            anzahlSpieler = Integer.parseInt(eingabeAnzahlSpieler.getText());
            eingabeAnzahlSpieler.setDisable(true);
            speichern.setText("gespeichert !");
            speichern.setDisable(true);
            spielerNrLabel.setText("Spieler 1:");
            addPlayerBtn.setDisable(false);
            //Initialisierung der Tableview für die Anzeige der Spieler
            nrTableView.setCellValueFactory(new PropertyValueFactory<Spieler, Integer>("spielerNr"));
            nameTableView.setCellValueFactory(new PropertyValueFactory<Spieler, String>("name"));
        }
        //Meldung, falls eine inkorrekte Eingabe gegeben wurde
        catch (NumberFormatException e){
            eingabeAnzahlSpieler.clear();
            spielerAnzahlLabel.setText("Geben Sie eine Zahl ein.");
        }
    }


    //Ein Spieler wird addiert, wenn auf Btn "add" gedrückt wird
    public void addPlayer(ActionEvent event) throws IOException {

//Überprüfung der Angabe (Leere Eingabe, Name des Spielers bereits existierend)
        if(showLebendigeSpieler().size() < anzahlSpieler) {
            if ("".contentEquals(eingabeName.getText())){
                spielerNrLabel.setText("Sie müssen einen Namen eingeben");
                korrekteEingabeName1 = false;
                eingabeName.clear();
            }
            else{
                korrekteEingabeName1 = true;
            }
            if (spielerListe.size()>0) {
                for (int i = 0; i < showLebendigeSpieler().size(); i++) {

                    if (spielerListe.elementAt(i).getName().contentEquals(eingabeName.getText())) {
                        spielerNrLabel.setText("Schon vorhanden !");
                        eingabeName.clear();
                        korrekteEingabeName2 = false;
                    }
                    else {
                        korrekteEingabeName2 = true;
                    }
                }
            }
            //Falls die Eingabe korrekt ist wird den Namen gespeichert
            if (korrekteEingabeName1 == true  && korrekteEingabeName2 == true){
                Spieler temp = new Spieler(spielerNr, eingabeName.getText(), true, 4);
                spielerListe.add(temp);
                spielerNrLabel.setText("Spieler " + (spielerNr + 1) + ":");
                eingabeName.clear();
                spielerNr++;
            }
        }

//Alle Spieler wurden eingetragen
        if (showLebendigeSpieler().size() >= anzahlSpieler) {
            addPlayerBtn.setDisable(true);
            eingabeName.setDisable(true);
            spielerNrLabel.setText("Tip top");
            RolleZuweisung.randomRolle();
            //debug : zeige alle Spieler inkl. Rolle in der Konsole
            for (int i = 0; i < spielerListe.size(); i++) {
                System.out.println(spielerListe.elementAt(i).getSpielerNr() + ": " +
                        spielerListe.elementAt(i).getName() + " " + Spieler.rolleName(spielerListe.elementAt(i).getRolle()));
            }
        }
        //display in der Tabelle
        tableViewSpieler.setItems(showSpieler());
    }

    //display in der Tabelle
    public ObservableList<Spieler> showSpieler(){
        ObservableList<Spieler> list = FXCollections.observableArrayList();
        for (int i = 0; i < spielerListe.size(); i++) {
            list.add(spielerListe.elementAt(i));
        }
        return list;
    }

    @FXML
    void spielerListeLeeren(ActionEvent event) {
        speichern.setDisable(false);
        speichern.setText("Speichern");
        eingabeAnzahlSpieler.setDisable(false);
        eingabeName.setDisable(false);
        spielerListe.clear();
        anzahlSpieler = 0;
        spielerNr = 1;
        tableViewSpieler.setItems(showSpieler());
        showLebendigeSpieler().clear();
        showSpieler().clear();
    }

    //das Spiel beginnt
    public void startGame(ActionEvent event) throws IOException {
        Parent WortAusgabeParent = FXMLLoader.load(getClass().getResource("WortAusgabe.fxml"));// Hier werden die Spieler Namen gefragt
        Scene WortAusgabeScene = new Scene(WortAusgabeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(WortAusgabeScene);
        window.setTitle("WortAusgabe");
        window.show();
        //Suchen eines Wortes
        WortReserve.readFile();//Speichert alle Wörter der Textdatei im Vektor woerterListe
        Random rand = new Random();
        WortRandom = rand.nextInt(WortReserve.woerterListe.size()/4)*2; // Generiert ein zufällige gerade Zahl
        wortCitizen = WortReserve.woerterListe.elementAt(WortRandom); // speichert das zu erratende Wort
        wortUndercover = WortReserve.woerterListe.elementAt(WortRandom+1); // speichert das Wort der Undercover

        //debug: Anzeige der Liste aller Wörter
        for(int i = 0; i < WortReserve.woerterListe.size(); i++){
            System.out.println(i + " " + WortReserve.woerterListe.elementAt(i));
        }
        System.out.println("___ ");
        System.out.println(wortCitizen);
        System.out.println(wortUndercover);
        System.out.println(WortRandom);
    }


    //Ausgabe der Wörter zu jedem Spieler
    public void ausgabeWoerter(ActionEvent event) throws IOException {

        btnWorter.setText("Nächster Spieler");
        WortAusgabe.setText("");
        HideWord.setText("click to show");
        wortAngezeigt = false;

        switch (spielerListe.elementAt(spielerWortAusgabe).getRolle()) {
            case 0:
                printLabelWort = wortCitizen;
                break;
            case 1:
                printLabelWort = wortUndercover;
                break;
            case 2:
                printLabelWort = "Du bist Mr White, versuch dich nicht auffallen zu lassen";
                break;
        }
        BefehleWortAusgabe.setText("Hallo " + spielerListe.elementAt(spielerWortAusgabe).getName());
        if ((spielerListe.size() - 1) >= spielerWortAusgabe && declic == 1) {
            if (spielerWortAusgabe == (spielerListe.size() - 1)) {
                declic = 0;
            }
            else {
                spielerWortAusgabe++;
            }
        }
        else {
            befehlWindow(event);
        }
    }
//Fenster zur Ausgabe der Wörter am Beginn des Spiels
    private void befehlWindow(ActionEvent event) throws IOException {
        Parent befehlParent = FXMLLoader.load(getClass().getResource("RundeBefehl.fxml"));
        Scene befehlScene = new Scene(befehlParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(befehlScene);
        window.setTitle("Wer fängt an?");
        window.show();
    }

    public void SwitchtoShowBefehle(ActionEvent event) throws IOException {
        int anfaenger = (int) (Math.random()*showLebendigeSpieler().size());

        if (spielerListe.elementAt(anfaenger).getRolle() == 2 || !spielerListe.elementAt(anfaenger).getStatus()){
            while (spielerListe.elementAt(anfaenger).getRolle() == 2 || !spielerListe.elementAt(anfaenger).getStatus()) {
                anfaenger = (int) (Math.random() *  showLebendigeSpieler().size());
            }
            befehlAusgabe.setText("Player " + spielerListe.elementAt(anfaenger).getName() + " fängt an");
        }

        else if (spielerListe.elementAt(anfaenger).getRolle() != 2 || spielerListe.elementAt(anfaenger).getStatus()) {
            befehlAusgabe.setText("Player " + spielerListe.elementAt(anfaenger).getName() + " fängt an!");// Hier noch Random
        }

    }

    //Wort ein- oder ausblenden
    public void switchToShow(ActionEvent event) throws IOException {
        if (spielerWortAusgabe > 0) {
            if (wortAngezeigt == false) {
                WortAusgabe.setText(printLabelWort + "\n  Wenn du es gesehen hast press den Button unten \n um es zu verstecken!");
                HideWord.setText("Click to hide");
            }
            else {
                WortAusgabe.setText("");
                HideWord.setText("Click to show");
            }
            wortAngezeigt = !wortAngezeigt;
        }
    }

    //Ende der Runde, Wechseln zur Wahl-Ansicht
    public void switchToVote(ActionEvent event) throws IOException {
        Parent spielParent = FXMLLoader.load(getClass().getResource("wahl.fxml"));
        Scene spielScene = new Scene(spielParent);
        //get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Ende der Runde - Wahl");
        window.show();
    }

    //Tabelle der lebendigen Spieler neu Anzeigen
    @FXML
    private void setupTableViewVote(ActionEvent event) {
        //display in der Tabelle
        tableViewSpieler.setItems(showLebendigeSpieler());
        tableViewSpieler.setPlaceholder(new Label("Keine Dataien"));
        //Initialisierung der Tabelle
        nrTableView.setCellValueFactory(new PropertyValueFactory<Spieler, Integer>("spielerNr"));
        nameTableView.setCellValueFactory(new PropertyValueFactory<Spieler, String>("name"));
        tableViewSpieler.setItems(showLebendigeSpieler());
    }

    //Spieler wählen und entfernen
    @FXML
    private void spielerAusschliessen(ActionEvent event) throws IOException {
        Spieler entfernt = tableViewSpieler.getSelectionModel().getSelectedItem();
        entfernt.setStatus(false);
        //der Spieler wird ausgeschlossen
        System.out.println("voted out: " + entfernt.getName() + "- Rolle: " + Spieler.rolleName(entfernt.getRolle())); //debug

        if (entfernt.getRolle() == 2) {
            Parent spielParent = FXMLLoader.load(getClass().getResource("MrWhite.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("Mr White");
            window.show();
        }
        else {
            finishTest(event);
        }
    }


    //Überprüfe, ob nur noch Citizen Leben
    private void finishTest(ActionEvent event) throws IOException {

        if(domain.winCondition.testUndercover() == true) {
            Parent spielParent = FXMLLoader.load(getClass().getResource("UndercoverGewinnen.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("WIN !!!!!");
            window.show();
        }
        else if(domain.winCondition.testCitizen() == true){
            Parent spielParent = FXMLLoader.load(getClass().getResource("CitizenGewinnen.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("WIN !!!!!");
            window.show();
        }
        else if(domain.winCondition.test2Spieler() == true){
            for(int i = 0; i< spielerListe.size(); i++) {
                if(spielerListe.elementAt(i).getStatus()==true){
                    if(spielerListe.elementAt(i).getRolle()==1){
                        Parent spielParent = FXMLLoader.load(getClass().getResource("UndercoverGewinnen.fxml"));
                        Scene spielScene = new Scene(spielParent);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(spielScene);
                        window.setTitle("WIN !!!");
                        window.show();}
                    else if(spielerListe.elementAt(i).getRolle()==2){
                        Parent spielParent = FXMLLoader.load(getClass().getResource("MrWhiteGewinnen.fxml"));
                        Scene spielScene = new Scene(spielParent);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(spielScene);
                        window.setTitle("WIN !!!");
                        window.show();
                    }}

            }}
        else { Parent spielParent = FXMLLoader.load(getClass().getResource("RundeBefehl.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("Wer ist dran ?");
            window.show();}
    }

    //Zeige an, welche Spieler noch spielen
    public ObservableList<Spieler> showLebendigeSpieler(){
        ObservableList<Spieler> list2 = FXCollections.observableArrayList();
        for (int i = 0; i < spielerListe.size(); i++) {
            if (spielerListe.elementAt(i).getStatus() == true) {
                list2.add(spielerListe.elementAt(i));
            }
        }
        return list2;

    }
    //ENDE WAHL

    //Mr White versucht das Wort zu erraten
    @FXML
    private void valid(ActionEvent event) throws IOException {
        System.out.println(printLabelWort);
        if (Input.getText().equalsIgnoreCase(wortCitizen)) {
            Parent spielParent = FXMLLoader.load(getClass().getResource("MrWhiteGewinnen.fxml"));
            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("WIN !!!");
            window.show();
        }
        else {
            finishTest(event);
        }
    }

    @FXML
    private void neuesSpiel(ActionEvent event) throws IOException{
        //reset Aller Variablen
        spielerListe.clear();
        anzahlSpieler = 0;
        spielerNr = 1;
        showLebendigeSpieler().clear();
        showSpieler().clear();
        //Zurück zum Hauptmenü
        Parent spielParent = FXMLLoader.load(getClass().getResource("hauptmenue.fxml"));
        Scene spielScene = new Scene(spielParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(spielScene);
        window.setTitle("Hauptmenü");
        window.show();
    }

    //Java-Fenster quittieren
    @FXML
    private void exit(ActionEvent event)throws IOException{
        Platform.exit();
    }

    // getter + setter für den Zugang zur Spieler Liste
    public static Vector<Spieler> getSpielerListe() {
        return spielerListe;
    }
    public static void setSpielerListe(Vector<Spieler> spielerListe) {
        Controller.spielerListe = spielerListe;
    }
}