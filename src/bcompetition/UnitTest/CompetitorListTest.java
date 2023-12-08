package bcompetition.UnitTest;

import bcompetition.Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CompetitorListTest {
    private CompetitorList competitorList;

    @BeforeEach
    void setUp() {
        competitorList = new CompetitorList("src/bcompetition/RunCompetitor.csv");
    }

    @Test
    void highestOverallScore_shouldReturnParticipantWithHighestOverallScore() {
        // Arrange
        CompetitorList competitorList = new CompetitorList("src/bcompetition/UnitTest/testData.csv");

        // Act
        String result = competitorList.highestOverallScore();

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("The participant with the highest overall score is:"));
    }

    @Test
    void removeBoxer_shouldRemoveBoxerWithSpecifiedId() {
        // Arrange
        CompetitorList competitorList = new CompetitorList("src/bcompetition/UnitTest/testData.csv");
        int initialSize = competitorList.getAllParticipants().size();
        int boxerIdToRemove = 103;

        // Act
        String result = competitorList.removeBoxer(boxerIdToRemove);

        // Assert
        assertNotNull(result);
        assertEquals("Boxer removed successfully", result);
        assertEquals(initialSize - 1, competitorList.getAllParticipants().size());
    }
    @Test
    void viewDetailsCategory_shouldReturnCorrectStringRepresentation() {
        // Arrange
        competitorList.getAllParticipants().clear(); // Clear existing participants
        competitorList.getAllParticipants().add(new NoviceBoxer(1, new
                Person("John", "Doe", "M", "USA", 23, "MALE"), Level.NOVICE,
                Category.HEAVYWEIGHT, 1));
        competitorList.getAllParticipants().add(new NoviceBoxer(2, new Person
                ("Alice", "Smith", "F", "Canada", 22, "female"),
                Level.NOVICE, Category.LIGHTWEIGHT, 2));

        // Act
        String result = competitorList.viewDetailsCategory(Category.LIGHTWEIGHT);

        // Assert
        assertTrue(result.contains("Alice"));
        assertFalse(result.contains("John Doe"));
    }

    @Test
    void getAllParticipants_shouldReturnCorrectList() {
        // Arrange
        competitorList.getAllParticipants().clear(); // Clear existing participants
        competitorList.getAllParticipants().add(new NoviceBoxer(1, new
                Person("John", "Doe", "M", "USA", 23, "MALE"), Level.NOVICE,
                Category.HEAVYWEIGHT, 1));
        competitorList.getAllParticipants().add(new NoviceBoxer(2, new Person
                ("Alice", "Smith", "F", "Canada", 22, "female"),
                Level.NOVICE, Category.LIGHTWEIGHT, 2));

        // Act
        int result = competitorList.getAllParticipants().size();

        // Assert
        assertEquals(2, result);
    }

    @Test
    void alterBoxerScores_shouldUpdateScoresAndReturnDetails() {
        // Arrange
        competitorList.getAllParticipants().clear(); // Clear existing participants
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        int[] newScores = {9, 8, 7, 6, 8, 9};
        String result = competitorList.alterBoxerScores(1, newScores);

        // Assert
        assertTrue(result.contains("John Doe"));
        assertEquals(newScores[0], boxer.getScoresHeavy()[0]);
        assertEquals(newScores[1], boxer.getScoresHeavy()[1]);
        assertEquals(newScores[2], boxer.getScoresHeavy()[2]);
        assertEquals(newScores[3], boxer.getScoresHeavy()[3]);
        assertEquals(newScores[4], boxer.getScoresHeavy()[4]);
        assertEquals(newScores[5], boxer.getScoresHeavy()[5]);
    }
    @Test
    void getCompetitorShortDetails_shouldReturnCorrectShortDetails() {
        // Arrange
        competitorList.getAllParticipants().clear(); // Clear existing participants
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "Subaru",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.getCompetitorShortDetails(1);

        // Assert
        assertTrue(result.contains("JDS"));
    }

    @Test
    void boxerExists_shouldReturnTrueForExistingBoxer() {
        // Arrange
        competitorList.getAllParticipants().clear(); // Clear existing participants
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        boolean result = competitorList.boxerExists(1);

        // Assert
        assertTrue(result);
    }

    @Test
    void boxerExists_shouldReturnFalseForNonExistingBoxer() {
        // Arrange
        competitorList.getAllParticipants().clear(); // Clear existing participants
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        boolean result = competitorList.boxerExists(2);

        // Assert
        assertFalse(result);
    }

    @Test
    void getCompetitorFullDetails_shouldReturnCorrectFullDetails() {
        // Arrange
        competitorList.getAllParticipants().clear(); // Clear existing participants
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.getCompetitorFullDetails(1);

        // Assert
        assertTrue(result.contains("John Doe"));
    }
    @Test
    void editBoxerDetails_shouldEditNameCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear(); // Clear existing participants
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Name", "Alice");

        // Assert
        assertTrue(result.contains("Alice"));
    }

    @Test
    void editBoxerDetails_shouldReturnInvalidInputForInvalidName() {
        // Arrange
        competitorList.getAllParticipants().clear(); // Clear existing participants
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Name", "123");

        // Assert
        assertEquals("Invalid input", result);
    }
    @Test
    void editBoxerDetails_shouldEditMiddleNameCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Middle Name", "Michael");

        // Assert
        assertTrue(result.contains("Michael"));
    }

    @Test
    void editBoxerDetails_shouldReturnInvalidInputForInvalidMiddleName() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Middle Name", "123");

        // Assert
        assertEquals("Invalid input", result);
    }

    @Test
    void editBoxerDetails_shouldEditSurnameCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Surname", "Smith");

        // Assert
        assertTrue(result.contains("Smith"));
    }

    @Test
    void editBoxerDetails_shouldReturnInvalidInputForInvalidSurname() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Surname", "123");

        // Assert
        assertEquals("Invalid input", result);
    }

    @Test
    void editBoxerDetails_shouldEditCountryCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Country", "Canada");
        // Assert
        assertTrue(boxer.toString().contains("Canada"));
    }

    @Test
    void editBoxerDetails_shouldReturnInvalidInputForInvalidCountry() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Country", "123");

        // Assert
        assertEquals("Invalid input", result);
    }

    @Test
    void editBoxerDetails_shouldEditAgeCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Age", "30");

        // Assert
        assertTrue(result.contains("30"));
    }

    @Test
    void editBoxerDetails_shouldReturnInvalidInputForInvalidAge() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Age", "abc");

        // Assert
        assertEquals("Invalid input", result);
    }

    @Test
    void editBoxerDetails_shouldEditGenderCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Gender", "Female");

        // Assert
        assertTrue(result.contains("Female"));
    }

    @Test
    void editBoxerDetails_shouldReturnInvalidInputForInvalidGender() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Gender", "123");

        // Assert
        assertEquals("Invalid input", result);
    }

    @Test
    void editBoxerDetails_shouldEditCompetitorLevelCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Competitor Level", "NOVICE");

        // Assert
        assertTrue(result.contains("Novice"));
    }

    @Test
    void editBoxerDetails_shouldEditCompetitorCategoryCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Competitor Category", "MIDDLEWEIGHT");

        // Assert
        assertTrue(result.contains("Middleweight"));
    }

    @Test
    void editBoxerDetails_shouldEditScoresHeavyCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Scores Heavy (comma-separated)", "90, 80, 70, 60, 50, 40");

        // Assert
        assertTrue(result.contains("90, 80, 70, 60, 50, 40"));
    }

    @Test
    void editBoxerDetails_shouldReturnInvalidInputForInvalidScoresHeavy() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        competitorList.getAllParticipants().add(boxer);

        // Act
        String result = competitorList.editBoxerDetails(1, "Scores Heavy (comma-separated)", "90, 80, invalid, 60, 50, 40");

        // Assert
        assertEquals("Invalid input. Please enter valid integers.", result);
    }

    @Test
    void calcTotals_shouldCalculateCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        boxer.setScoreArray(Category.HEAVYWEIGHT, new int[]{10, 20, 30, 40, 50, 60});

        // Act
        int result = competitorList.calcTotals(boxer);

        // Assert
        assertEquals(210, result);
    }

    @Test
    void calcAverages_shouldCalculateCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        boxer.setScoreArray(Category.HEAVYWEIGHT, new int[]{10, 20, 30, 40, 50, 60});

        // Act
        double result = competitorList.calcAverages(boxer);

        // Assert
        assertEquals(35.0, result, 0.001);
    }

    @Test
    void calcMax_shouldFindMaxCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        boxer.setScoreArray(Category.HEAVYWEIGHT, new int[]{10, 20, 30, 40, 50, 60});

        // Act
        int result = competitorList.calcMax(boxer);

        // Assert
        assertEquals(60, result);
    }

    @Test
    void calcMin_shouldFindMinCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        boxer.setScoreArray(Category.HEAVYWEIGHT, new int[]{10, 20, 30, 40, 50, 60});

        // Act
        int result = competitorList.calcMin(boxer);

        // Assert
        assertEquals(10, result);
    }

    @Test
    void calcFrequency_shouldCalculateFrequencyCorrectly() {
        // Arrange
        competitorList.getAllParticipants().clear();
        NoviceBoxer boxer = new NoviceBoxer(1, new Person("John", "Doe", "M",
                "Uk", 23,"male"), Level.NOVICE, Category.HEAVYWEIGHT, 1);
        boxer.setScoreArray(Category.HEAVYWEIGHT, new int[]{1,1,2,2,3,3});

        // Act
        String result = competitorList.calcFrequency(boxer);

        // Assert
        assertTrue(result.contains("Elm - 1 Freq - 2"));
        assertTrue(result.contains("Elm - 2 Freq - 2"));
        assertTrue(result.contains("Elm - 3 Freq - 2"));
    }

}
