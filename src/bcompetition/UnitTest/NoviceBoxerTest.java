package bcompetition.UnitTest;
import bcompetition.Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoviceBoxerTest {

    @Test
    void constructor_withRank_shouldSetAmateurRank() {
        // Arrange
        Person competitorDetails = new Person("John", "Doe",
                "M", "USA",25,"male");
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
                "Doe", "F", "Canada",22, "female" );
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
                "UK",28,"female" );
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
}
