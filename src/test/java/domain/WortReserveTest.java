package domain;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WortReserveTest {

    @Test
    void testCreateWoerterListe() throws Exception {

        WortReserve.createWoerterListe();


    }



    @Test
    void testReadFile() {

        WortReserve.readFile();


    }

    @Test
    void testWortAddieren() {

        WortReserve.wortAddieren("wortC", "wortU");


    }
}
