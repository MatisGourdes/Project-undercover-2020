package presentation;

import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TestSpielFertigTest {

    @Test
    void testFinishTest() throws Exception {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        TestSpielFertig.finishTest(event);

        // Verify the results
    }

    @Test
    void testFinishTest_ThrowsIOException() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        assertThatThrownBy(() -> TestSpielFertig.finishTest(event)).isInstanceOf(IOException.class);
    }

    @Test
    void testLaunchGewinner() throws Exception {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        TestSpielFertig.LaunchGewinner(event);

        // Verify the results
    }

    @Test
    void testLaunchGewinner_ThrowsIOException() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        assertThatThrownBy(() -> TestSpielFertig.LaunchGewinner(event)).isInstanceOf(IOException.class);
    }
}
