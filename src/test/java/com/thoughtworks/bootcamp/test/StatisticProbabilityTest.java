package com.thoughtworks.bootcamp.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticProbabilityTest {
    private static StatisticProbability probabilityOfHeadInTossingACoin;
    private static StatisticProbability probabilityOfEvenNumbersComesInDice;

    @BeforeAll
    static void setUp() {
        probabilityOfHeadInTossingACoin = new StatisticProbability(0.5f);
        probabilityOfEvenNumbersComesInDice = new StatisticProbability(0.5f);
    }
    @Test
    void givenProbabilityOfHeadComesInCoinAndProbabilityOfEvenNumberComesInDice_whenCheckEquality_thenShouldReturnTrue() {
        assertTrue(probabilityOfHeadInTossingACoin.equals(probabilityOfEvenNumbersComesInDice));
    }
    @Test
    void givenProbabilityOfHeadComesInCoinIsOneAndProbabilityOfEvenNumberComesInDiceIsZeroPointFive_whenCheckEquality_thenShouldReturnFalse() {
        probabilityOfHeadInTossingACoin=new StatisticProbability(1.0f);
        assertFalse(probabilityOfHeadInTossingACoin.equals(probabilityOfEvenNumbersComesInDice));
    }
}
