package bcompetition.Model;

public class ProfessionalBoxer extends KABoxer {
    private int championshipsWon;
    public ProfessionalBoxer(int competitorId, Person competitorDetails,
                             Level competitorLvl, Category competitorCategory, int champWin) {
        super(competitorId, competitorDetails, competitorLvl, competitorCategory);
        championshipsWon = champWin;
    }
    public ProfessionalBoxer(int competitorId, Person competitorDetails,
                             Level competitorLvl, Category competitorCategory) {
        super(competitorId, competitorDetails, competitorLvl, competitorCategory);
        championshipsWon = 0;
    }

    public void setChampionshipsWon(int championshipsWon) {
        this.championshipsWon = championshipsWon;
    }

    public int getChampionshipsWon() {
        return championshipsWon;
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
                "<Professional Boxer { Id: " + getCompetitorId()  + " - Name: "
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
    return "\n<Professional Boxer {" +
            "\n - Id: " + getCompetitorId() +
            "\n - Details { " + getCompetitorDetails() +
            " - Level: " + getCompetitorLvl() +
            "\n - All Scores: "+ getAllScores()+
            " - Category: " + getCompetitorCategory() +
            "\n - Championships won: "+ getChampionshipsWon()+
            "\n - Overall Score: "+ getOverallScore()+
            "} >"+"\n";
}
}
