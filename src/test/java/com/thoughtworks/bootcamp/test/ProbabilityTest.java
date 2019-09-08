package com.thoughtworks.bootcamp.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProbabilityTest {
    private static Probability impossibleEvent;
    private static Probability certainEvent;

    @BeforeAll
    static void setUp() {
        impossibleEvent = new Probability(0.0f);
        certainEvent = new Probability(1.0f);
    }

    @Test
    void givenProbabilitiesOfTwoEventsIsZeroes_WhenChecksEquality_ThenReturnsTrue() {
        Probability zeroProbabilityEventTwo = new Probability(0.0f);
        assertEquals(impossibleEvent, zeroProbabilityEventTwo);
    }

    @Test
    void givenProbabilitiesOfOneEventZeroAndSecondEventOne_WhenChecksEquality_ThenReturnsFalse() {
        assertNotEquals(impossibleEvent, certainEvent);
    }

    @Test
    void givenProbabilitiesOfoneEventsisOneAndSecondIsDummyString_WhenChecksEquality_ThenReturnsFalse() {
        String dummyString = "ABC";
        assertNotEquals(dummyString, certainEvent);
    }

    @Test
    void givenTwoThreeDecimalEqualProbabilities_whenChecksEquality_ThenReturnsFalse() {
        assertNotEquals(new Probability(0.565f), new Probability(0.566f));
    }

    @Test
    void givenZeroOcuurenceProbability_WhenChecksUnoccuredProbability_ThenReturnsOne() {
        assertEquals(certainEvent, impossibleEvent.not());
    }

    @Test
    void givenOneOcuurenceProbability_WhenChecksUnoccuredProbability_ThenReturnsZero() {
        assertEquals(impossibleEvent, certainEvent.not());
    }

    @Test
    void givenTwoZeroProbabilites_WhenCalculatingProbabilityOfEventsOccuringTogether_ThenReturnsZero() {
        assertEquals(impossibleEvent, impossibleEvent.and(impossibleEvent));
    }

    @Test
    void givenOneProbabilityOneAndAnotherProbabilityZeroDotOne_WhenCalculatingProbabilityOfEventsOccuringTogether_ThenReturnsZeroDotOne() {

        Probability ZeroDotOneProbability = new Probability(0.1f);
        assertEquals(new Probability(0.1f), ZeroDotOneProbability.and(certainEvent));
    }

    @Test
    void givenTwoOneProbabilityEvents_WhenCalculatingProbabilityOfEventsOccuringTogether_ThenReturnsOne() {
        Probability headInACoinToss = new Probability(0.5f);
        assertEquals(new Probability(0.25f), headInACoinToss.and(headInACoinToss));
    }

    @Test
    void givenTwoImpossibleEvents_WhenCalculatingProbabilityOfEitherOfTheTwoEventsOccuring_ThenReturnsZero() {
        assertEquals(impossibleEvent, impossibleEvent.or(impossibleEvent));
    }
    @Test
    void givenOneImpossibleEventAndAnotherCertainEvent_WhenCalculatingProbabilityOfEitherOfTheTwoEventsOccuring_ThenReturnsOne() {
        assertEquals(certainEvent, impossibleEvent.or(certainEvent));
    }


}
