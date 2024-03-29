package bcompetition.UnitTest;

import bcompetition.Model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * The {@code KABoxerTest} class contains unit tests for the methods in the {@code KABoxer} class.
 * It utilizes JUnit 4 testing framework for writing and executing tests.
 *
 * <p>These tests cover various functionalities of the {@code KABoxer} class, including:
 * <ul>
 *     <li>Setting and getting competitor details, level, and category</li>
 *     <li>Setting and getting scores for heavyweight, middleweight, and lightweight categories</li>
 *     <li>Calculating and setting the mean scores for heavyweight, middleweight, and lightweight categories</li>
 *     <li>Calculating and setting the overall score for a boxer</li>
 *     <li>Getting short, full, and specific details of a boxer</li>
 * </ul>
 *
 * <p>Each test method is annotated with {@code}{@Test}, and assertions are made using methods from
 * {@code org.junit.Assert} and {@code org.junit.Assert.assertEquals}.
 *
 * <p>It's recommended to run these tests with various test cases and data to ensure the correct
 * behavior of the {@code KABoxer} class.
 *
 * @author Klevi Alliu
 * @version 08/12/2023
 */
public class KABoxerTest {
    private KABoxer testBoxer;
    private Person testPerson;

    @Before
    public void setUp() {
        testPerson = new Person("John", "Doe", "M", "UK", 23, "male");
        testBoxer = new NoviceBoxer(1, testPerson, Level.NOVICE, Category.HEAVYWEIGHT);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(1, testBoxer.getCompetitorId());
        assertEquals(testPerson, testBoxer.getCompetitorDetails());
        assertEquals(Level.NOVICE, testBoxer.getCompetitorLvl());
        assertEquals(Category.HEAVYWEIGHT, testBoxer.getCompetitorCategory());

        // Test setter methods
        testBoxer.setCompetitorLvl(Level.PROFESSIONAL);
        testBoxer.setCompetitorCategory(Category.LIGHTWEIGHT);

        assertEquals(Level.PROFESSIONAL, testBoxer.getCompetitorLvl());
        assertEquals(Category.LIGHTWEIGHT, testBoxer.getCompetitorCategory());
    }

    @Test
    public void testMeanCalculation() {
        // Set scores for testing
        int[] testScores = {5, 10, 4, 3, 2, 5};
        testBoxer.setScoresHeavy(testScores);

        // Calculate mean and weights mean
        double mean = testBoxer.calculateAvgScore(testScores);
        double weightsMean = testBoxer.calculateWeightsMean(mean, testBoxer.getWeightHeavy());

        assertEquals(4.833333333333333, mean, 0.00001);
        assertEquals(2.4166666666666665, weightsMean, 0.0001);
    }

    @Test
    public void testOverallScoreCalculation() {
        // Set scores for testing
        int[] testScores = {10, 15, 20, 25, 30, 35};
        testBoxer.setScoresHeavy(testScores);

        double overallScore = testBoxer.getOverallScore();
        assertEquals(11.25, overallScore, 0.0001);
    }

    @Test
    public void setScoreArray_shouldSetScoresForHeavyCategory() {
        testPerson = new Person("John", "Doe", "M", "UK", 23, "male");
        testBoxer = new NoviceBoxer(1, testPerson, Level.NOVICE, Category.HEAVYWEIGHT);
        int[] scores = {1, 2, 3, 4, 5, 6};

        // Act
        testBoxer.setScoreArray(Category.HEAVYWEIGHT, scores);

        // Assert
        assertArrayEquals(scores, testBoxer.getScoresHeavy());
        assertArrayEquals(new int[6], testBoxer.getScoresMiddle()); // Ensure other categories are not affected
        assertArrayEquals(new int[6], testBoxer.getScoresLight());
    }

    @Test
    public void setScoreArray_shouldSetScoresForMiddleCategory() {
        // Arrange
        testPerson = new Person("John", "Doe", "M", "UK", 23, "male");
        testBoxer = new NoviceBoxer(1, testPerson, Level.NOVICE, Category.HEAVYWEIGHT);
        int[] testScores = {7, 8, 9, 10, 11, 12};

        // Act
        testBoxer.setScoreArray(Category.MIDDLEWEIGHT, testScores);

        // Assert
        assertArrayEquals(testScores, testBoxer.getScoresMiddle());
        assertArrayEquals(new int[6], testBoxer.getScoresHeavy()); // Ensure other categories are not affected
        assertArrayEquals(new int[6], testBoxer.getScoresLight());
    }

    @Test
    public void setScoreArray_shouldSetScoresForLightCategory() {
        testPerson = new Person("John", "Doe", "M", "UK", 23, "male");
        testBoxer = new NoviceBoxer(1, testPerson, Level.NOVICE, Category.HEAVYWEIGHT);
        int[] testScores = {13, 14, 15, 16, 17, 18};

        // Act
        testBoxer.setScoreArray(Category.LIGHTWEIGHT, testScores);

        // Assert
        assertArrayEquals(testScores, testBoxer.getScoresLight());
        assertArrayEquals(new int[6], testBoxer.getScoresHeavy()); // Ensure other categories are not affected
        assertArrayEquals(new int[6], testBoxer.getScoresMiddle());
    }
}
