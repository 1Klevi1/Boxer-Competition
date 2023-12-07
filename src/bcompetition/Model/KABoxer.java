package bcompetition.Model;

import java.util.Arrays;

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

    public KABoxer(int competitorId, Person competitorDetails, Level competitorLvl, Category competitorCategory) {
        CompetitorId = competitorId;
        CompetitorDetails = competitorDetails;
        CompetitorLvl = competitorLvl;
        CompetitorCategory = competitorCategory;
    }

    public double getWeightHeavy() {
        return weightHeavy;
    }

    public void setWeightHeavy(double weightHeavy) {
        this.weightHeavy = weightHeavy;
    }

    public double getWeightMiddle() {
        return weightMiddle;
    }

    public void setWeightMiddle(double weightMiddle) {
        this.weightMiddle = weightMiddle;
    }

    public double getWeightLight() {
        return weightLight;
    }

    public void setWeightLight(double weightLight) {
        this.weightLight = weightLight;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public double getMeanHeavy() {
        return meanHeavy;
    }

    public void setMeanHeavy(double meanHeavy) {
        this.meanHeavy = meanHeavy;
    }

    public double getMeanMiddle() {
        return meanMiddle;
    }

    public void setMeanMiddle(double meanMiddle) {
        this.meanMiddle = meanMiddle;
    }

    public double getMeanLight() {
        return meanLight;
    }

    public void setMeanLight(double meanLight) {
        this.meanLight = meanLight;
    }

    public void setBoxerName(String value){
        CompetitorDetails.setName(value);
    }
    public void setBoxerMiddleName(String value){
        CompetitorDetails.setMiddleName(value);
    }
    public void setBoxerSurname(String value){
        CompetitorDetails.setSurname(value);
    }
    public void setBoxerCountry(String value){
        CompetitorDetails.setCountry(value);
    }
    public void setBoxerAge(int value){
        CompetitorDetails.setAge(value);
    }
    public void setBoxerGender(String value){
        CompetitorDetails.setGender(value);
    }

    public void setCompetitorLvl(Level competitorLvl) {
        CompetitorLvl = competitorLvl;
    }

    public Person getCompetitorDetails() {
        return CompetitorDetails;
    }

    public Level getCompetitorLvl() {
        return CompetitorLvl;
    }

    public int[] getScoresHeavy() {
        return ScoresHeavy;
    }

    public int[] getScoresMiddle() {
        return ScoresMiddle;
    }

    public int[] getScoresLight() {
        return ScoresLight;
    }

    public String getFullDetails(){
        return
                "<Boxer Id: " + CompetitorId  + " - Name: " + CompetitorDetails.getFullName() + ".\n"
                + CompetitorDetails.getName() + " has a " + CompetitorLvl
                + " level, is aged " + CompetitorDetails.getAge() +". The Category is "+ getCompetitorCategory()+
                " and the gender is "+ CompetitorDetails.getGender()
                +".\nThe boxer received these scores : " +getAllScores()
                +"and has an overall score of " + getOverallScore() + ">";

    }
    public String getShortDetails(){
        return
                "<CN: " + CompetitorId  + "(" + CompetitorDetails.getInitials() +")"+ " has overall score " + getOverallScore() + ">";

    }

    public int getCompetitorId() {
        return CompetitorId;
    }

    public void setScoresHeavy(int[] scoresHeavy) { ScoresHeavy = Arrays.copyOf(scoresHeavy, 6); }

    public void setScoresMiddle(int[] scoresMiddle) { ScoresMiddle = Arrays.copyOf(scoresMiddle, 6); }

    public void setScoresLight(int[] scoresLight) { ScoresLight = Arrays.copyOf(scoresLight, 6); }

    public void setCompetitorCategory(Category competitorCategory) {
        CompetitorCategory = competitorCategory;
    }

    public Category getCompetitorCategory() {
        return CompetitorCategory;
    }

    public int[] getScoreArray( ){
        return switch (CompetitorCategory) {
            case HEAVYWEIGHT -> ScoresHeavy;
            case MIDDLEWEIGHT -> ScoresMiddle;
            case LIGHTWEIGHT -> ScoresLight;
        };

    }
    public void setScoreArray(Category competitorCategory, int[] scores) {
         switch (competitorCategory) {
            case HEAVYWEIGHT -> ScoresHeavy = Arrays.copyOf(scores, 6);
            case MIDDLEWEIGHT -> ScoresMiddle = Arrays.copyOf(scores, 6);
            case LIGHTWEIGHT -> ScoresLight = Arrays.copyOf(scores, 6);
        }
    }
    public String getAllScores(){
        String s = "";
        s+="\n##############\nScores in Heavy Category: {";
        for(int value = 0; value < ScoresHeavy.length; value++){
            s += ScoresHeavy[value];
            if (value < ScoresHeavy.length - 1) {
                s += ", ";
            }
        }
        s+="}\nScores in Middle Category: {";
        for(int value = 0; value < ScoresMiddle.length; value++){
            s += ScoresMiddle[value];
            if (value < ScoresMiddle.length - 1) {
                s += ", ";
            }
        }
        s+="}\nScores in Light Category: {";
        for(int value = 0; value < ScoresLight.length; value++){
            s += ScoresLight[value];
            if (value < ScoresLight.length - 1) {
                s += ", ";
            }
        }
        s+="}\n##############\n";
        return s;
    }
    public double calculateAvgScore(int[] score){
        int sum  = 0;
        for(int value : score){
            sum += value;
        }
        return (double) sum / score.length;
    }
    public double calculateWeightsMean(double mean, double weight){
        return mean * weight;
    }
    public abstract double getOverallScore();
    @Override
    public String toString() {
        return "\n<Boxer {" +
                "\n - Id: " + CompetitorId +
                "\n - Details { " + CompetitorDetails +
                " - Level: " + CompetitorLvl +
                "\n - All Scores: "+ getAllScores()+
                " - Category: " + CompetitorCategory +
                "} >"+"\n";
    }
}
