package bcompetition;

import java.util.ArrayList;

public class KABoxer {

    private int CompetitorId;
    private Person CompetitorDetails;
    private Level CompetitorLvl;
    private ArrayList<Integer> Scores;
    private int CompetitorCategory;

    public KABoxer(int competitorId, Person competitorDetails, Level competitorLvl, int competitorCategory) {
        CompetitorId = competitorId;
        CompetitorDetails = competitorDetails;
        CompetitorLvl = competitorLvl;
        CompetitorCategory = competitorCategory;
    }

    public double getOverallScore() { return 5; }

    public String getFullDetails(){
        return
                "<Competitor number: " + CompetitorId  + " - Name: " + CompetitorDetails.getFullName() + "\n"
                + CompetitorDetails.getName() + " is a " + CompetitorLvl  + " aged " + CompetitorDetails.getAge()
                + " and has an overall score of " + getOverallScore() + ">";

    }
    public String getShortDetails(){
        return
                "<CN: " + CompetitorId  + "(" + CompetitorDetails.getInitials() +")"+ " has overall score " + getOverallScore() + ">";

    }

}
