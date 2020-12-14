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
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        addSpielerControllerUnderTest.addPlayer(event);

        // Verify the results
    }

    @Test
    void testAddPlayer_ThrowsIOException() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        assertThatThrownBy(() -> addSpielerControllerUnderTest.addPlayer(event)).isInstanceOf(IOException.class);
    }

    @Test
    void testShowSpieler() {
        // Setup

        // Run the test
        final ObservableList<Spieler> result = addSpielerControllerUnderTest.showSpieler();

        // Verify the results
    }

    @Test
    void testSave() throws Exception {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        addSpielerControllerUnderTest.save(event);

        // Verify the results
    }

    @Test
    void testSave_ThrowsIOException() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        assertThatThrownBy(() -> addSpielerControllerUnderTest.save(event)).isInstanceOf(IOException.class);
    }

    @Test
    void testStartGame() throws Exception {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        addSpielerControllerUnderTest.startGame(event);

        // Verify the results
    }

    @Test
    void testStartGame_ThrowsIOException() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        assertThatThrownBy(() -> addSpielerControllerUnderTest.startGame(event)).isInstanceOf(IOException.class);
    }

    @Test
    void testSpielerListeLeeren() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        addSpielerControllerUnderTest.spielerListeLeeren(event);

        // Verify the results
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
