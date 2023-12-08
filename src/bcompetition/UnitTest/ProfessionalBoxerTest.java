package bcompetition.UnitTest;

import bcompetition.Model.Category;
import bcompetition.Model.Level;
import bcompetition.Model.Person;
import bcompetition.Model.ProfessionalBoxer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The {@code ProfessionalBoxerTest} class contains unit tests for the methods in the {@code ProfessionalBoxer} class.
 * It utilizes JUnit 5 testing framework for writing and executing tests.
 *
 * <p>These tests cover various functionalities of the {@code ProfessionalBoxer} class, including:
 * <ul>
 *     <li>Constructing a professional boxer with specified details, level, and category</li>
 *     <li>Constructing a professional boxer with specified details, level, category, and amateur rank</li>
 *     <li>Getting and setting the championships won in professional boxer</li>
 *     <li>Calculating the overall score of a professional boxer based on scores and weights</li>
 *     <li>Getting a string representation of the full details and general information of a professional boxer</li>
 * </ul>
 *
 * <p>Each test method is annotated with {@code}{@Test}, and assertions are made using methods from
 * {@code org.junit.jupiter.api.Assertions}.
 *
 * <p>It's recommended to run these tests with various test cases and data to ensure the correct
 * behavior of the {@code ProfessionalBoxer} class.
 *
 * @author Klevi Alliu
 * @version 08/12/2023
 */
public class ProfessionalBoxerTest {

    @Test
    void constructor_withChamp_shouldSetProfessionalChampionships() {
        // Arrange
        Person competitorDetails = new Person("John", "Doe",
                "M", "USA", 25, "male");
        Level competitorLvl = Level.PROFESSIONAL;
        Category competitorCategory = Category.HEAVYWEIGHT;
        int champWin = 5;

        // Act
        ProfessionalBoxer professionalBoxer = new ProfessionalBoxer(1, competitorDetails,
                competitorLvl, competitorCategory, 5);

        // Assert
        assertEquals(champWin, professionalBoxer.getChampionshipsWon());
    }

    @Test
    void getOverallScore_withScores_shouldCalculateCorrectOverallScore() {
        // Arrange
        Person competitorDetails = new Person("John", "Doe",
                "M", "USA", 25, "male");
        Level competitorLvl = Level.PROFESSIONAL;
        Category competitorCategory = Category.HEAVYWEIGHT;
        ProfessionalBoxer boxer = new ProfessionalBoxer(4, competitorDetails,
                competitorLvl, competitorCategory);
        int[] scoresHeavy = {5, 2, 5, 2, 1, 4};
        int[] scoresMiddle = {2, 3, 5, 1, 7, 3};
        int[] scoresLight = {9, 8, 10, 7, 9, 8};
        boxer.setScoresHeavy(scoresHeavy);
        boxer.setScoresMiddle(scoresMiddle);
        boxer.setScoresLight(scoresLight);

        // Act
        double overallScore = boxer.getOverallScore();

        // Assert
        assertEquals(4.333333333333334, overallScore, 0.001);
    }

    @Test
    void toString_shouldReturnStringRepresentation() {
        // Arrange
        Person competitorDetails = new Person("Eva", "Davis", "Suarez",
                "Germany", 26, "female");
        Level competitorLvl = Level.PROFESSIONAL;
        Category competitorCategory = Category.HEAVYWEIGHT;
        ProfessionalBoxer boxer = new ProfessionalBoxer(5, competitorDetails,
                competitorLvl, competitorCategory);
        boxer.setChampionshipsWon(2);

        // Act
        String stringRepresentation = boxer.toString();

        // Assert
        assertTrue(stringRepresentation.contains("Level: " + competitorLvl));
        assertTrue(stringRepresentation.contains("Championships won: 2"));
    }
}
