package bcompetition;

public class AmateurBoxer extends KABoxer {
    private int amateurRank;

    public AmateurBoxer(int competitorId, Person competitorDetails,
                        Level competitorLvl, Category competitorCategory, int rank) {
        super(competitorId, competitorDetails, competitorLvl, competitorCategory);
        amateurRank = rank;
    }
    public AmateurBoxer(int competitorId, Person competitorDetails,
                        Level competitorLvl, Category competitorCategory) {
        super(competitorId, competitorDetails, competitorLvl, competitorCategory);
        amateurRank = 0;
    }
    public int getAmateurRank() {
        return amateurRank;
    }

    public void setAmateurRank(int amateurRank) {
        this.amateurRank = amateurRank;
    }

    @Override
    public double getOverallScore() {
        double weightHeavy = 0.5;
        double weightMiddle = 0.3;
        double weightLight = 0.2;
        double totalWeight = 0.5 + 0.2 + 0.3;

        double meanHeavy = Double.NaN;
        double meanMiddle = Double.NaN;
        double meanLight = Double.NaN;

        if (getScoresHeavy().length != 0){
            meanHeavy = calculateAvgScore(getScoresHeavy());
        }
        if (getScoresMiddle().length != 0) {
            meanMiddle = calculateAvgScore(getScoresMiddle());
        }
        if (getScoresLight().length != 0) {
            meanLight = calculateAvgScore(getScoresLight());
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
        return "\n<Amateur Boxer {" +
                "\n - Id: " + getCompetitorId() +
                "\n - Details { " + getCompetitorDetails() +
                " - Level: " + getCompetitorLvl() +
                "\n - All Scores: "+ getAllScores()+
                " - Category: " + getCompetitorCategory() +
                "\n - Amateur rank: "+ getAmateurRank()+
                "} >"+"\n";
    }
}
