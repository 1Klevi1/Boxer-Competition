package bcompetition;

public class AmateurBoxer extends KABoxer {
    private int amateurRank;

    public AmateurBoxer(int competitorId, Person competitorDetails,
                        Level competitorLvl, Category competitorCategory, int rank) {
        super(competitorId, competitorDetails, competitorLvl, competitorCategory);
        amateurRank = rank;
    }

    public int getAmateurRank() {
        return amateurRank;
    }

//    @Override TO DO
//    public double ABSTRACT getOverallScore() {
//        return super.getOverallScore();
//    }

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
