package bcompetition.Model;

/**
 * The {@code NoviceBoxer} class represents a novice boxer, extending the {@code KABoxer} class.
 * It includes additional attributes such as an amateur rank and methods for calculating overall scores.
 * @author Klevi
 * @version 07/12/2023
 */
public class NoviceBoxer extends KABoxer {
    private int amateurRank;

    /**
     * Constructs a novice boxer with the provided details, level, category, and amateur rank.
     *
     * @param competitorId       The unique identifier for the competitor.
     * @param competitorDetails  The personal details of the competitor.
     * @param competitorLvl      The level of the competitor.
     * @param competitorCategory The category of the competitor.
     * @param rank               The amateur rank of the novice boxer.
     */
    public NoviceBoxer(int competitorId, Person competitorDetails,
                       Level competitorLvl, Category competitorCategory, int rank) {
        super(competitorId, competitorDetails, competitorLvl, competitorCategory);
        amateurRank = rank;
    }

    /**
     * Constructs a novice boxer with the provided details, level, and category,
     * setting the amateur rank to 0.
     *
     * @param competitorId       The unique identifier for the competitor.
     * @param competitorDetails  The personal details of the competitor.
     * @param competitorLvl      The level of the competitor.
     * @param competitorCategory The category of the competitor.
     */
    public NoviceBoxer(int competitorId, Person competitorDetails,
                       Level competitorLvl, Category competitorCategory) {
        super(competitorId, competitorDetails, competitorLvl, competitorCategory);
        amateurRank = 0;
    }

    /**
     * Gets the amateur rank of the novice boxer.
     *
     * @return The amateur rank.
     */
    public int getAmateurRank() {
        return amateurRank;
    }

    /**
     * Sets the amateur rank of the novice boxer.
     *
     * @param amateurRank The amateur rank to be set.
     */
    public void setAmateurRank(int amateurRank) {
        this.amateurRank = amateurRank;
    }

    /**
     * Calculates and returns the overall score of the novice boxer based on scores and weights.
     *
     * @return The overall score.
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
     * Gets a string representation of the full details of the novice boxer.
     *
     * @return A string containing the full details.
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
     * Returns a string representation of the novice boxer, including details, scores, and overall score.
     *
     * @return A string representation of the novice boxer.
     */
    @Override
    public String toString() {
        return "\n<" + getCompetitorLvl() + " Boxer {" +
                "\n - Id: " + getCompetitorId() +
                "\n - Details { " + getCompetitorDetails() +
                " - Level: " + getCompetitorLvl() +
                "\n - All Scores: " + getAllScores() +
                " - Category: " + getCompetitorCategory() +
                "\n - Amateur rank: " + getAmateurRank() +
                "\n - Overall Score: " + getOverallScore() +
                "} >" + "\n";
    }
}
