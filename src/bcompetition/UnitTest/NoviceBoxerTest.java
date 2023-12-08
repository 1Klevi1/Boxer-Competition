package bcompetition.UnitTest;

import bcompetition.Model.Category;
import bcompetition.Model.Level;
import bcompetition.Model.NoviceBoxer;
import bcompetition.Model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The {@code NoviceBoxerTest} class contains unit tests for the methods in the {@code NoviceBoxer} class.
 * It utilizes JUnit 5 testing framework for writing and executing tests.
 *
 * <p>These tests cover various functionalities of the {@code NoviceBoxer} class, including:
 * <ul>
 *     <li>Constructing a novice boxer with specified details, level, and category</li>
 *     <li>Constructing a novice boxer with specified details, level, category, and amateur rank</li>
 *     <li>Getting and setting the amateur rank of a novice boxer</li>
 *     <li>Calculating the overall score of a novice boxer based on scores and weights</li>
 *     <li>Getting a string representation of the full details and general information of a novice boxer</li>
 * </ul>
 *
 * <p>Each test method is annotated with {@code}{@Test}, and assertions are made using methods from
 * {@code org.junit.jupiter.api.Assertions}.
 *
 * <p>It's recommended to run these tests with various test cases and data to ensure the correct
 * behavior of the {@code NoviceBoxer} class.
 *
 * @author Klevi Alliu
 * @version 08/12/2023
 */
public class NoviceBoxerTest {

    @Test
    void constructor_withRank_shouldSetAmateurRank() {
        // Arrange
        Person competitorDetails = new Person("John", "Doe",
                "M", "USA", 25, "male");
        Level competitorLvl = Level.NOVICE;
        Category competitorCategory = Category.HEAVYWEIGHT;
        int rank = 5;

        // Act
        NoviceBoxer noviceBoxer = new NoviceBoxer(1, competitorDetails,
                competitorLvl, competitorCategory, rank);

        // Assert
        assertEquals(rank, noviceBoxer.getAmateurRank());
    }

    @Test
    void constructor_withoutRank_shouldSetDefaultAmateurRank() {
        // Arrange
        Person competitorDetails = new Person("Jane",
                "Doe", "F", "Canada", 22, "female");
        Level competitorLvl = Level.NOVICE;
        Category competitorCategory = Category.MIDDLEWEIGHT;

        // Act
        NoviceBoxer noviceBoxer = new NoviceBoxer(2, competitorDetails,
                competitorLvl, competitorCategory);

        // Assert
        assertEquals(0, noviceBoxer.getAmateurRank());
    }

    @Test
    void getAmateurRank_afterSetting_shouldReturnCorrectRank() {
        // Arrange
        Person competitorDetails = new Person("Alice", "Smith", "F",
                "UK", 28, "female");
        Level competitorLvl = Level.NOVICE;
        Category competitorCategory = Category.LIGHTWEIGHT;
        NoviceBoxer noviceBoxer = new NoviceBoxer(3, competitorDetails,
                competitorLvl, competitorCategory);
        int rank = 3;

        // Act
        noviceBoxer.setAmateurRank(rank);

        // Assert
        assertEquals(rank, noviceBoxer.getAmateurRank());
    }

    @Test
    void getOverallScore_withScores_shouldCalculateCorrectOverallScore() {
        // Arrange
        Person competitorDetails = new Person("John", "Doe",
                "M", "USA", 25, "male");
        Level competitorLvl = Level.NOVICE;
        Category competitorCategory = Category.HEAVYWEIGHT;
        NoviceBoxer noviceBoxer = new NoviceBoxer(4, competitorDetails, competitorLvl, competitorCategory);
        int[] scoresHeavy = {8, 7, 9, 6, 8, 7};
        int[] scoresMiddle = {6, 5, 7, 5, 6, 5};
        int[] scoresLight = {9, 8, 10, 7, 9, 8};
        noviceBoxer.setScoresHeavy(scoresHeavy);
        noviceBoxer.setScoresMiddle(scoresMiddle);
        noviceBoxer.setScoresLight(scoresLight);

        // Act
        double overallScore = noviceBoxer.getOverallScore();

        // Assert
        assertEquals(7.15, overallScore, 0.001);
    }

    @Test
    void toString_shouldReturnStringRepresentation() {
        // Arrange
        Person competitorDetails = new Person("Eva", "Davis", "Suarez",
                "Germany", 26, "female");
        Level competitorLvl = Level.NOVICE;
        Category competitorCategory = Category.LIGHTWEIGHT;
        NoviceBoxer noviceBoxer = new NoviceBoxer(5, competitorDetails,
                competitorLvl, competitorCategory);
        noviceBoxer.setAmateurRank(2);

        // Act
        String stringRepresentation = noviceBoxer.toString();

        // Assert
        assertTrue(stringRepresentation.contains("Level: " + competitorLvl));
        assertTrue(stringRepresentation.contains("Amateur rank: 2"));
    }
}
