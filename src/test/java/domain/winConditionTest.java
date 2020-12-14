package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class winConditionTest {

    @Test
    void testTestUndercover() {
        assertThat(winCondition.testUndercover()).isFalse();
    }

    @Test
    void testTestCitizen() {
        assertThat(winCondition.testCitizen()).isTrue();
    }

    @Test
    void testTest2Spieler() {
        assertThat(winCondition.test2Spieler()).isFalse();
    }
}
