package presentation;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MainTest {

    private Main mainUnderTest;

    @BeforeEach
    void setUp() {
        mainUnderTest = new Main();
    }

    @Test
    void testStart() throws Exception {

        final Stage stage = new Stage(StageStyle.DECORATED);


        mainUnderTest.start(stage);


    }

    @Test
    void testStart_ThrowsException() {

        final Stage stage = new Stage(StageStyle.DECORATED);


        assertThatThrownBy(() -> mainUnderTest.start(stage)).isInstanceOf(Exception.class);
    }

    @Test
    void testMain() {

        Main.main(new String[]{"value"});

    }
}
