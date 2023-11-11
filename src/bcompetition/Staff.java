package bcompetition;

import java.util.Arrays;

public class Staff {
    private Person StaffDetails;
    private int AccessLevel;

    public Staff(Person staffDetails, int accessLevel) {
        StaffDetails = staffDetails;
        AccessLevel = accessLevel;
    }

    public Person getStaffDetails() {
        return StaffDetails;
    }

    public int getAccessLevel() {
        return AccessLevel;
    }

    public void setStaffDetails(Person staffDetails) {
        StaffDetails = staffDetails;
    }

    public void setAccessLevel(int accessLevel) {
        AccessLevel = accessLevel;
    }

    public void setCompetitorCategory(KABoxer temp, Category category) {
        temp.setCompetitorCategory(category);
    }
    public void recordScores(KABoxer temp,Category category, int[] score) {
        int[] validScores = Arrays.copyOf(score, 6);
        switch (category) {
            case HEAVYWEIGHT -> temp.setScoresHeavy(validScores);
            case MIDDLEWEIGHT -> temp.setScoresMiddle(validScores);
            case LIGHTWEIGHT -> temp.setScoresLight(validScores);
        }
    }

    @Override
    public String toString() {
        return "Staff{" +
                "StaffDetails=" + StaffDetails +
                ", AccessLevel=" + AccessLevel +
                '}';
    }
}
