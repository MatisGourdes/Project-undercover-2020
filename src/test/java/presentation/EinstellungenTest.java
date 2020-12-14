package presentation;

import domain.WortReserve;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.testfx.util.NodeQueryUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.internal.invocation.finder.VerifiableInvocationsFinder.find;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;


class EinstellungenTest {


    @FXML
    public TextField wortCitizen;
    @FXML
    public TextField wortUndercover;
    @FXML
    private Button neuesWortBestaetigen;
    @FXML
    private TableColumn<String, String> spalteCitizen;
    @FXML
    private TableColumn<String, String> spalteUndercover;
    @FXML
    private TableView<String> tableViewWoerter;



    public ObservableList<String> showWoerterUndercover(){
        ObservableList<java.lang.String> listUndercover = FXCollections.observableArrayList();
        for (int i = 1; i < WortReserve.woerterListe.size(); i +=2) {
            listUndercover.add(WortReserve.woerterListe.elementAt(i));
        }

        return listUndercover;
    }

    public ObservableList<String> showWoerterCitizen(){
        ObservableList<String> listCitizen = FXCollections.observableArrayList();
        for (int i = 0; i < WortReserve.woerterListe.size(); i +=2) {
            listCitizen.add(WortReserve.woerterListe.elementAt(i));
        }

        return listCitizen;
    }


public void setUp() {

   if (wortCitizen == null) {
        wortCitizen.setText("wortC");
    } else {
        wortCitizen.setText("wortC");
    }
    if (wortUndercover == null) {
        wortUndercover.setText("wortU");
    } else {
        wortUndercover.setText("wortU");
    }


    wortCitizen.setText("wortC");
    wortUndercover.setText("wortU");
    WortReserve.readFile();

}
    @Test
    void switchToHauptmenue() {

    }

    @Test
    void woerterAddieren() {
        String WortC=wortCitizen.getText();
        String WortU=wortUndercover.getText();


        try (FileWriter w = new FileWriter("src/main/resources/domain/woerterDatenBank", true)) {
            String eingabe = wortCitizen.getText() + ";" + wortUndercover.getText();
            w.write("\r" + eingabe);
        }
        catch (IOException e) {
            System.err.println("Fehler beim Schreiben in der Datei.");
            System.err.println(e.getMessage());
        };

        Assert.assertEquals(WortU, "wortU");
          Assert.assertEquals(WortC, "wortC");

            verifyThat(neuesWortBestaetigen, hasText("Bestätigen"));
            wortUndercover.clear();
            wortCitizen.clear();
            neuesWortBestaetigen.setText("gespeichert!");

            Assert.assertNull(wortCitizen);
            Assert.assertNull(wortUndercover);


            final Button neuesWortBestaetigen = (Button) find(Collections.singletonList("#neuesWortBestaetigen"));
            Assert.assertNotNull(neuesWortBestaetigen);
            verifyThat(neuesWortBestaetigen, hasText("gespeichert"));
        }

        @Test
        void woerterListeAnzeigen () {



            //display in der zweiten Spalte


        }

    }




