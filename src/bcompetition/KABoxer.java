package bcompetition;

import com.sun.source.tree.ReturnTree;

import java.util.Arrays;
import java.util.Scanner;

public  class KABoxer {
    private int CompetitorId;
    private Person CompetitorDetails;
    private Level CompetitorLvl;
    private int[] ScoresHeavy = new int[6];
    private int[] ScoresMiddle = new int[6];
    private int[] ScoresLight = new int[6];

    private Category CompetitorCategory;

    public KABoxer(int competitorId, Person competitorDetails, Level competitorLvl, Category competitorCategory) {
        CompetitorId = competitorId;
        CompetitorDetails = competitorDetails;
        CompetitorLvl = competitorLvl;
        CompetitorCategory = competitorCategory;
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

    public void setScoresHeavy(int[] scoresHeavy) {
        ScoresHeavy = scoresHeavy;
    }

    public void setScoresMiddle(int[] scoresMiddle) {
        ScoresMiddle = scoresMiddle;
    }

    public void setScoresLight(int[] scoresLight) {
        ScoresLight = scoresLight;
    }

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
            case HEAVYWEIGHT -> ScoresHeavy = scores;
            case MIDDLEWEIGHT -> ScoresMiddle = scores;
            case LIGHTWEIGHT -> ScoresLight = scores;
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
    public  double getOverallScore() {

        double weightHeavy = 0.5;
        double weightMiddle = 0.3;
        double weightLight = 0.2;
        double totalWeight = 0.5 + 0.2 + 0.3;

        double meanHeavy = Double.NaN;
        double meanMiddle = Double.NaN;
        double meanLight = Double.NaN;

        if (ScoresHeavy.length != 0){
            meanHeavy = calculateAvgScore(ScoresHeavy);
        }
        if (ScoresMiddle.length != 0) {
            meanMiddle = calculateAvgScore(ScoresMiddle);
        }
        if (ScoresLight.length != 0) {
            meanLight = calculateAvgScore(ScoresLight);
        }

//        If you want to print means and want more details in the output
//        System.out.println("meanHeavy : " + meanHeavy +"- meanMiddle : " + meanMiddle + "- meanLight : " + meanLight);

        double calcCategoryHeavy = calculateWeightsMean(meanHeavy,weightHeavy);
        double calcCategoryMiddle = calculateWeightsMean(meanMiddle,weightMiddle);
        double calcCategoryLight = calculateWeightsMean(meanLight,weightLight);

//        if u want to print the weights x mean
//        System.out.println("calcCategoryHeavy : " + calcCategoryHeavy +"- calcCategoryMiddle : " + calcCategoryMiddle + "- calcCategoryLight : " + calcCategoryLight);

        return (calcCategoryHeavy + calcCategoryMiddle + calcCategoryLight) / totalWeight;

    }

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
