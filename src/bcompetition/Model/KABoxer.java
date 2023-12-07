package bcompetition.Model;

import java.util.Arrays;

/**
 * Abstract class representing a KABoxer in a boxing competition.
 * @author Klevi
 * @version 07/12/2023
 */
public abstract class KABoxer {
    private int CompetitorId;
    private Person CompetitorDetails;
    private Level CompetitorLvl;
    private int[] ScoresHeavy = new int[6];
    private int[] ScoresMiddle = new int[6];
    private int[] ScoresLight = new int[6];
    private Category CompetitorCategory;
    private double weightHeavy = 0.5;
    private double weightMiddle = 0.3;
    private double weightLight = 0.2;
    private double totalWeight = 0.5 + 0.2 + 0.3;
    private double meanHeavy = Double.NaN;
    private double meanMiddle = Double.NaN;
    private double meanLight = Double.NaN;

    /**
     * Constructs a KABoxer with the specified attributes.
     *
     * @param competitorId      The competitor's ID.
     * @param competitorDetails Details of the competitor (name, country, age, gender, etc.).
     * @param competitorLvl     The competitor's level.
     * @param competitorCategory The competitor's category (Heavyweight, Middleweight, or Lightweight).
     */
    public KABoxer(int competitorId, Person competitorDetails, Level competitorLvl, Category competitorCategory) {
        CompetitorId = competitorId;
        CompetitorDetails = competitorDetails;
        CompetitorLvl = competitorLvl;
        CompetitorCategory = competitorCategory;
    }

    // Getter and setter methods

    /**
     * Gets the weight for the heavy category.
     * @return The weight for the heavy category.
     */
    public double getWeightHeavy() {
        return weightHeavy;
    }

    /**
     * Sets the weight for the heavy category.
     * @param weightHeavy The weight to set for the heavy category.
     */
    public void setWeightHeavy(double weightHeavy) {
        this.weightHeavy = weightHeavy;
    }

    /**
     * Gets the weight for the middle category.
     * @return The weight for the middle category.
     */
    public double getWeightMiddle() {
        return weightMiddle;
    }

    /**
     * Sets the weight for the middle category.
     * @param weightMiddle The weight to set for the middle category.
     */
    public void setWeightMiddle(double weightMiddle) {
        this.weightMiddle = weightMiddle;
    }

    /**
     * Gets the weight for the light category.
     * @return The weight for the light category.
     */
    public double getWeightLight() {
        return weightLight;
    }

    /**
     * Sets the weight for the light category.
     * @param weightLight The weight to set for the light category.
     */
    public void setWeightLight(double weightLight) {
        this.weightLight = weightLight;
    }

    /**
     * Gets the total weight.
     * @return The total weight.
     */
    public double getTotalWeight() {
        return totalWeight;
    }

    /**
     * Sets the total weight.
     * @param totalWeight The total weight to be set.
     */
    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    /**
     * Gets the mean weight for the heavy category.
     * @return The mean weight for the heavy category.
     */
    public double getMeanHeavy() {
        return meanHeavy;
    }

    /**
     * Sets the mean weight for the heavy category.
     * @param meanHeavy The mean weight to set for the heavy category.
     */
    public void setMeanHeavy(double meanHeavy) {
        this.meanHeavy = meanHeavy;
    }

    /**
     * Gets the mean weight for the middle category.
     * @return The mean weight for the middle category.
     */
    public double getMeanMiddle() {
        return meanMiddle;
    }

    /**
     * Sets the mean weight for the middle category.
     * @param meanMiddle The mean weight to set for the middle category.
     */
    public void setMeanMiddle(double meanMiddle) {
        this.meanMiddle = meanMiddle;
    }

    /**
     * Gets the mean weight for the light category.
     * @return The mean weight for the light category.
     */
    public double getMeanLight() {
        return meanLight;
    }

    /**
     * Sets the mean weight for the light category.
     * @param meanLight The mean weight to set for the light category.
     */
    public void setMeanLight(double meanLight) {
        this.meanLight = meanLight;
    }

    /**
     * Sets the name of the boxer.
     * @param value The name to set.
     */
    public void setBoxerName(String value) {
        CompetitorDetails.setName(value);
    }

    /**
     * Sets the middle name of the boxer.
     * @param value The middle name to set.
     */
    public void setBoxerMiddleName(String value) {
        CompetitorDetails.setMiddleName(value);
    }

    /**
     * Sets the surname of the boxer.
     * @param value The surname to set.
     */
    public void setBoxerSurname(String value) {
        CompetitorDetails.setSurname(value);
    }

    /**
     * Sets the country of the boxer.
     * @param value The country to set.
     */
    public void setBoxerCountry(String value) {
        CompetitorDetails.setCountry(value);
    }

    /**
     * Sets the age of the boxer.
     * @param value The age to set.
     */
    public void setBoxerAge(int value) {
        CompetitorDetails.setAge(value);
    }

    /**
     * Sets the gender of the boxer.
     * @param value The gender to set.
     */
    public void setBoxerGender(String value) {
        CompetitorDetails.setGender(value);
    }

    /**
     * Gets the details of the competitor.
     * @return The details of the competitor.
     */
    public Person getCompetitorDetails() {
        return CompetitorDetails;
    }

    /**
     * Gets the level of the competitor.
     * @return The level of the competitor.
     */
    public Level getCompetitorLvl() {
        return CompetitorLvl;
    }

    /**
     * Sets the level of the competitor.
     * @param competitorLvl The level to set for the competitor.
     */
    public void setCompetitorLvl(Level competitorLvl) {
        CompetitorLvl = competitorLvl;
    }

    /**
     * Gets the scores for the heavy category.
     * @return The scores for the heavy category.
     */
    public int[] getScoresHeavy() {
        return ScoresHeavy;
    }

    /**
     * Sets the scores for the heavy category.
     * @param scoresHeavy The scores to set for the heavy category.
     */
    public void setScoresHeavy(int[] scoresHeavy) {
        ScoresHeavy = Arrays.copyOf(scoresHeavy, 6);
    }

    /**
     * Gets the scores for the middle category.
     * @return The scores for the middle category.
     */
    public int[] getScoresMiddle() {
        return ScoresMiddle;
    }

    /**
     * Sets the scores for the middle category.
     * @param scoresMiddle The scores to set for the middle category.
     */
    public void setScoresMiddle(int[] scoresMiddle) {
        ScoresMiddle = Arrays.copyOf(scoresMiddle, 6);
    }

    /**
     * Gets the scores for the light category.
     * @return The scores for the light category.
     */
    public int[] getScoresLight() {
        return ScoresLight;
    }

    /**
     * Sets the scores for the light category.
     * @param scoresLight The scores to set for the light category.
     */
    public void setScoresLight(int[] scoresLight) {
        ScoresLight = Arrays.copyOf(scoresLight, 6);
    }

    /**
     * Gets the ID of the competitor.
     * @return The ID of the competitor.
     */
    public int getCompetitorId() {
        return CompetitorId;
    }

    /**
     * Gets the category of the competitor.
     * @return The category of the competitor.
     */
    public Category getCompetitorCategory() {
        return CompetitorCategory;
    }

    /**
     * Sets the category of the competitor.
     * @param competitorCategory The category to set for the competitor.
     */
    public void setCompetitorCategory(Category competitorCategory) {
        CompetitorCategory = competitorCategory;
    }

    /**
     * Retrieves the full details of the KABoxer, including ID, name,
     * level, age, category, gender, scores, and overall score.
     *
     * @return A string containing the full details of the KABoxer.
     */
    public String getFullDetails() {
        return
                "<Boxer Id: " + CompetitorId + " - Name: " + CompetitorDetails.getFullName() + ".\n"
                        + CompetitorDetails.getName() + " has a " + CompetitorLvl
                        + " level, is aged " + CompetitorDetails.getAge() +
                        ". The Category is " + getCompetitorCategory() +
                        " and the gender is " + CompetitorDetails.getGender()
                        + ".\nThe boxer received these scores : " + getAllScores()
                        + "and has an overall score of " + getOverallScore() + ">";

    }

    /**
     * Retrieves the short details of the KABoxer, including competitor number, initials, and overall score.
     *
     * @return A string containing the short details of the KABoxer.
     */
    public String getShortDetails() {
        return
                "<CN: " + CompetitorId + "(" + CompetitorDetails.getInitials() + ")"
                        + " has overall score " + getOverallScore() + ">";

    }

    /**
     * Retrieves the scores of the KABoxer based on the specified category.
     *
     * @return An array of scores for the specified category.
     */
    public int[] getScoreArray() {
        return switch (CompetitorCategory) {
            case HEAVYWEIGHT -> ScoresHeavy;
            case MIDDLEWEIGHT -> ScoresMiddle;
            case LIGHTWEIGHT -> ScoresLight;
        };

    }

    /**
     * Sets the scores of the KABoxer based on the specified category.
     *
     * @param competitorCategory The competitor's category (Heavyweight, Middleweight, or Lightweight).
     * @param scores             An array of scores for the specified category.
     */
    public void setScoreArray(Category competitorCategory, int[] scores) {
        switch (competitorCategory) {
            case HEAVYWEIGHT -> ScoresHeavy = Arrays.copyOf(scores, 6);
            case MIDDLEWEIGHT -> ScoresMiddle = Arrays.copyOf(scores, 6);
            case LIGHTWEIGHT -> ScoresLight = Arrays.copyOf(scores, 6);
        }
    }

    /**
     * Retrieves all scores of the KABoxer, including scores in Heavy, Middle, and Light categories.
     *
     * @return A string containing all scores of the KABoxer.
     */
    public String getAllScores() {
        String s = "";
        s += "\n##############\nScores in Heavy Category: {";
        for (int value = 0; value < ScoresHeavy.length; value++) {
            s += ScoresHeavy[value];
            if (value < ScoresHeavy.length - 1) {
                s += ", ";
            }
        }
        s += "}\nScores in Middle Category: {";
        for (int value = 0; value < ScoresMiddle.length; value++) {
            s += ScoresMiddle[value];
            if (value < ScoresMiddle.length - 1) {
                s += ", ";
            }
        }
        s += "}\nScores in Light Category: {";
        for (int value = 0; value < ScoresLight.length; value++) {
            s += ScoresLight[value];
            if (value < ScoresLight.length - 1) {
                s += ", ";
            }
        }
        s += "}\n##############\n";
        return s;
    }

    public double calculateAvgScore(int[] score) {
        int sum = 0;
        for (int value : score) {
            sum += value;
        }
        return (double) sum / score.length;
    }

    public double calculateWeightsMean(double mean, double weight) {
        return mean * weight;
    }

    /**
     * Abstract method to calculate the overall score of the KABoxer.
     *
     * @return The overall score of the KABoxer.
     */
    public abstract double getOverallScore();

    /**
     * Overrides the default toString() method to provide a string representation of the KABoxer.
     *
     * @return A string representation of the KABoxer.
     */
    @Override
    public String toString() {
        return "\n<Boxer {" +
                "\n - Id: " + CompetitorId +
                "\n - Details { " + CompetitorDetails +
                " - Level: " + CompetitorLvl +
                "\n - All Scores: " + getAllScores() +
                " - Category: " + CompetitorCategory +
                "} >" + "\n";
    }
}
