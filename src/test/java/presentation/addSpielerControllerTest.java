package presentation;

import domain.Spieler;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.scene.control.Button;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class addSpielerControllerTest {

    private addSpielerController addSpielerControllerUnderTest;

    @BeforeEach
    void setUp() {
        addSpielerControllerUnderTest = new addSpielerController();
    }

    @Test
    void testAddPlayer() throws Exception {

        final ActionEvent event = new ActionEvent("o", null);


        addSpielerControllerUnderTest.addPlayer(event);

    }

    @Test
    void testAddPlayer_ThrowsIOException() {

        final ActionEvent event = new ActionEvent("o", null);


        assertThatThrownBy(() -> addSpielerControllerUnderTest.addPlayer(event)).isInstanceOf(IOException.class);
    }

    @Test
    void testShowSpieler() {

        final ObservableList<Spieler> result = addSpielerControllerUnderTest.showSpieler();


    }

    @Test
    void testSave() throws Exception {

        final ActionEvent event = new ActionEvent("o", null);


        addSpielerControllerUnderTest.save(event);


    }

    @Test
    void testSave_ThrowsIOException() {

        final ActionEvent event = new ActionEvent("o", null);


        assertThatThrownBy(() -> addSpielerControllerUnderTest.save(event)).isInstanceOf(IOException.class);
    }

    @Test
    void testStartGame() throws Exception {

        final ActionEvent event = new ActionEvent("o", null);


        addSpielerControllerUnderTest.startGame(event);


    }

    @Test
    void testStartGame_ThrowsIOException() {

        final ActionEvent event = new ActionEvent("o", null);


        assertThatThrownBy(() -> addSpielerControllerUnderTest.startGame(event)).isInstanceOf(IOException.class);
    }

    @Test
    void testSpielerListeLeeren() {

        final ActionEvent event = new ActionEvent("o", null);


        addSpielerControllerUnderTest.spielerListeLeeren(event);


    }

    @Test
    void testGetWortCitizen() {
        assertThat(addSpielerController.getWortCitizen()).isEqualTo("result");
    }

    @Test
    void testGetWortUndercover() {
        assertThat(addSpielerController.getWortUndercover()).isEqualTo("result");
    }
}
