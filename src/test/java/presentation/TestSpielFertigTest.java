package presentation;

import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TestSpielFertigTest {

    @Test
    void testFinishTest() throws Exception {
        final ActionEvent event = new ActionEvent("o", null);
        TestSpielFertig.finishTest(event);


    }

    @Test
    void testFinishTest_ThrowsIOException() {
        final ActionEvent event = new ActionEvent("o", null);
        assertThatThrownBy(() -> TestSpielFertig.finishTest(event)).isInstanceOf(IOException.class);
    }

    @Test
    void testLaunchGewinner() throws Exception {
        final ActionEvent event = new ActionEvent("o", null);
        TestSpielFertig.LaunchGewinner(event);


    }

    @Test
    void testLaunchGewinner_ThrowsIOException() {
        final ActionEvent event = new ActionEvent("o", null);
        assertThatThrownBy(() -> TestSpielFertig.LaunchGewinner(event)).isInstanceOf(IOException.class);
    }
}
