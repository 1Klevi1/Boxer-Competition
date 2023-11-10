package fb;

import java.util.ArrayList;

public class Competitior {

    private int CompetitorId;
    private Person CompetitorDetails;
    private Level CompetitorLvl;
    private ArrayList<Integer> Scores;
    private int CompetitorCategory;

    public Competitior(int competitorId, Person competitorDetails, Level competitorLvl, int competitorCategory) {
        CompetitorId = competitorId;
        CompetitorDetails = competitorDetails;
        CompetitorLvl = competitorLvl;
        CompetitorCategory = competitorCategory;
    }
    public double getOverallScore() { return 5; }


}
