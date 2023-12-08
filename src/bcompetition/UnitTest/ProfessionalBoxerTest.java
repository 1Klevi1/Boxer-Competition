package bcompetition.UnitTest;
import bcompetition.Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfessionalBoxerTest {

    @Test
    void constructor_withChamp_shouldSetProfessionalChampionships() {
        // Arrange
        Person competitorDetails = new Person("John", "Doe",
                "M", "USA",25,"male");
        Level competitorLvl = Level.PROFESSIONAL;
        Category competitorCategory = Category.HEAVYWEIGHT;
        int champWin = 5;

        // Act
        ProfessionalBoxer professionalBoxer = new ProfessionalBoxer(1, competitorDetails,
                competitorLvl, competitorCategory,5);

        // Assert
        assertEquals(champWin, professionalBoxer.getChampionshipsWon());
    }

    @Test
    void getOverallScore_withScores_shouldCalculateCorrectOverallScore() {
        // Arrange
        Person competitorDetails = new Person("John", "Doe",
                "M", "USA",25,"male");
        Level competitorLvl = Level.PROFESSIONAL;
        Category competitorCategory = Category.HEAVYWEIGHT;
        ProfessionalBoxer noviceBoxer = new ProfessionalBoxer(4, competitorDetails,
                competitorLvl, competitorCategory);
        int[] scoresHeavy = {5, 2, 5, 2, 1, 4};
        int[] scoresMiddle = {2, 3, 5, 1, 7, 3};
        int[] scoresLight = {9, 8, 10, 7, 9, 8};
        noviceBoxer.setScoresHeavy(scoresHeavy);
        noviceBoxer.setScoresMiddle(scoresMiddle);
        noviceBoxer.setScoresLight(scoresLight);

        // Act
        double overallScore = noviceBoxer.getOverallScore();

        // Assert
        assertEquals(4.333333333333334, overallScore, 0.001);
    }

    @Test
    void toString_shouldReturnStringRepresentation() {
        // Arrange
        Person competitorDetails = new Person("Eva", "Davis", "Suarez",
                "Germany",26, "female" );
        Level competitorLvl = Level.PROFESSIONAL;
        Category competitorCategory = Category.HEAVYWEIGHT;
        ProfessionalBoxer noviceBoxer = new ProfessionalBoxer(5, competitorDetails,
                competitorLvl, competitorCategory);
        noviceBoxer.setChampionshipsWon(2);

        // Act
        String stringRepresentation = noviceBoxer.toString();

        // Assert
        assertTrue(stringRepresentation.contains("Level: " + competitorLvl));
        assertTrue(stringRepresentation.contains("Championships won: 2"));
    }
}
