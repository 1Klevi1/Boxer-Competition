package bcompetition.UnitTest;

import org.junit.Before;
import org.junit.Test;
import bcompetition.Model.*;
import static org.junit.Assert.*;

public class KABoxerTest {
    private KABoxer testBoxer;
    private Person testPerson;

    @Before
    public void setUp() {
        testPerson = new Person("John", "Doe", "M", "UK", 23,"male");
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
}
