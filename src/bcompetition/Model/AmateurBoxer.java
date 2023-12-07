package bcompetition.Model;

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

        if (getScoresHeavy().length != 0){
            setMeanHeavy(calculateAvgScore(getScoresHeavy()));
        }
        if (getScoresMiddle().length != 0) {
            setMeanMiddle(calculateAvgScore(getScoresMiddle()));
        }
        if (getScoresLight().length != 0) {
            setMeanLight(calculateAvgScore(getScoresLight()));
        }
        double calcCategoryHeavy = calculateWeightsMean(getMeanHeavy(),getWeightHeavy());
        double calcCategoryMiddle = calculateWeightsMean(getMeanMiddle(),getWeightMiddle());
        double calcCategoryLight = calculateWeightsMean(getMeanLight(),getWeightLight());
        return (calcCategoryHeavy + calcCategoryMiddle + calcCategoryLight) / getTotalWeight();
    }
    public String getFullDetails(){
        return
                "<Amateur Boxer { Id: " + getCompetitorId()  + " - Name: "
                        + getCompetitorDetails().getFullName() + ".\n"
                        + getCompetitorDetails().getName() + " has a " + getCompetitorLvl()
                        + " level, is aged " + getCompetitorDetails().getAge()
                        +". The Category is "+ getCompetitorCategory()
                        + " and the gender is "+ getCompetitorDetails().getGender()
                        +".\nThe boxer received these scores : " +getAllScores()
                        +"and has an overall score of " + getOverallScore() + "}>";

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
                "\n - Overall Score: "+ getOverallScore()+
                "} >"+"\n";
    }
}
