package bcompetition;

public class ProfessionalBoxer extends KABoxer {
    private int championshipsWon;
    public ProfessionalBoxer(int competitorId, Person competitorDetails,
                             Level competitorLvl, Category competitorCategory, int champWin) {
        super(competitorId, competitorDetails, competitorLvl, competitorCategory);
        championshipsWon = champWin;
    }

    public int getChampionshipsWon() {
        return championshipsWon;
    }

//    @Override TO DO
//    public double ABSTRACT getOverallScore() {
//        return super.getOverallScore();
//    }
@Override
public String toString() {
    return "\n<Professional Boxer {" +
            "\n - Id: " + getCompetitorId() +
            "\n - Details { " + getCompetitorDetails() +
            " - Level: " + getCompetitorLvl() +
            "\n - All Scores: "+ getAllScores()+
            " - Category: " + getCompetitorCategory() +
            "\n - Championships won: "+ getChampionshipsWon()+
            "} >"+"\n";
}
}
