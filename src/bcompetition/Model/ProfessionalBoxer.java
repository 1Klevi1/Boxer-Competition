package bcompetition.Model;

/**
 * Represents a professional boxer, extending the base KABoxer class.
 * @author Klevi
 * @version 07/12/2023
 */
public class ProfessionalBoxer extends KABoxer {
    private int championshipsWon;

    /**
     * Constructs a ProfessionalBoxerTest with specified attributes.
     *
     * @param competitorId      The unique identifier for the boxer.
     * @param competitorDetails Personal details of the boxer.
     * @param competitorLvl     Competitor's level.
     * @param competitorCategory Competitor's category.
     * @param champWin          Number of championships won.
     */
    public ProfessionalBoxer(int competitorId, Person competitorDetails,
                             Level competitorLvl, Category competitorCategory, int champWin) {
        super(competitorId, competitorDetails, competitorLvl, competitorCategory);
        championshipsWon = champWin;
    }

    /**
     * Constructs a ProfessionalBoxerTest with default values for championships won.
     *
     * @param competitorId      The unique identifier for the boxer.
     * @param competitorDetails Personal details of the boxer.
     * @param competitorLvl     Competitor's level.
     * @param competitorCategory Competitor's category.
     */
    public ProfessionalBoxer(int competitorId, Person competitorDetails,
                             Level competitorLvl, Category competitorCategory) {
        super(competitorId, competitorDetails, competitorLvl, competitorCategory);
        championshipsWon = 0;
    }

    /**
     * Gets the number of championships won by the boxer.
     *
     * @return The number of championships won.
     */
    public int getChampionshipsWon() {
        return championshipsWon;
    }

    /**
     * Sets the number of championships won by the boxer.
     *
     * @param championshipsWon The number of championships won to set.
     */
    public void setChampionshipsWon(int championshipsWon) {
        this.championshipsWon = championshipsWon;
    }

    /**
     * Calculates and returns the overall score of the professional boxer.
     * Overrides the method in the base class KABoxer.
     *
     * @return The overall score of the boxer.
     */
    @Override
    public double getOverallScore() {

        if (getScoresHeavy().length != 0) {
            setMeanHeavy(calculateAvgScore(getScoresHeavy()));
        }
        if (getScoresMiddle().length != 0) {
            setMeanMiddle(calculateAvgScore(getScoresMiddle()));
        }
        if (getScoresLight().length != 0) {
            setMeanLight(calculateAvgScore(getScoresLight()));
        }
        double calcCategoryHeavy = calculateWeightsMean(getMeanHeavy(), getWeightHeavy());
        double calcCategoryMiddle = calculateWeightsMean(getMeanMiddle(), getWeightMiddle());
        double calcCategoryLight = calculateWeightsMean(getMeanLight(), getWeightLight());
        return (calcCategoryHeavy + calcCategoryMiddle + calcCategoryLight) / getTotalWeight();
    }

    /**
     * Gets the full details of the professional boxer, including personal details,
     * scores, and overall score.
     *
     * @return A string containing the full details of the boxer.
     */

    public String getFullDetails() {
        return
                "<" + getCompetitorLvl() + " Boxer {" + " Id: " + getCompetitorId() + " - Name: "
                        + getCompetitorDetails().getFullName() + ".\n"
                        + getCompetitorDetails().getName() + " has a " + getCompetitorLvl()
                        + " level, is aged " + getCompetitorDetails().getAge()
                        + ". The Category is " + getCompetitorCategory()
                        + " and the gender is " + getCompetitorDetails().getGender()
                        + ".\nThe boxer received these scores : " + getAllScores()
                        + " The boxer is from " + getCompetitorDetails().getCountry()
                        + " and has an overall score of " + getOverallScore() + "}>";

    }

    /**
     * Returns a string representation of the ProfessionalBoxerTest.
     *
     * @return A string representation of the ProfessionalBoxerTest object.
     */
    @Override
    public String toString() {
        return "\n<" + getCompetitorLvl() + " Boxer {" +
                "\n - Id: " + getCompetitorId() +
                "\n - Details { " + getCompetitorDetails() +
                " - Level: " + getCompetitorLvl() +
                "\n - All Scores: " + getAllScores() +
                " - Category: " + getCompetitorCategory() +
                "\n - Championships won: " + getChampionshipsWon() +
                "\n - Overall Score: " + getOverallScore() +
                "} >" + "\n";
    }
}
