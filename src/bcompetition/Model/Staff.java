package bcompetition.Model;

import java.util.Arrays;

/**
 * The Staff class represents a staff member in the system, including their personal details
 * and access level.
 * @author Klevi
 * @version 07/12/2023
 */
public class Staff {
    private Person StaffDetails;
    private int AccessLevel;

    /**
     * Constructs a new Staff object with the specified personal details and access level.
     *
     * @param staffDetails The personal details of the staff member.
     * @param accessLevel The access level of the staff member.
     */
    public Staff(Person staffDetails, int accessLevel) {
        StaffDetails = staffDetails;
        AccessLevel = accessLevel;
    }

    /**
     * Gets the personal details of the staff member.
     *
     * @return The personal details of the staff member.
     */
    public Person getStaffDetails() {
        return StaffDetails;
    }

    /**
     * Sets the personal details of the staff member.
     *
     * @param staffDetails The new personal details of the staff member.
     */
    public void setStaffDetails(Person staffDetails) {
        StaffDetails = staffDetails;
    }

    /**
     * Gets the access level of the staff member.
     *
     * @return The access level of the staff member.
     */
    public int getAccessLevel() {
        return AccessLevel;
    }

    /**
     * Sets the access level of the staff member.
     *
     * @param accessLevel The new access level of the staff member.
     */
    public void setAccessLevel(int accessLevel) {
        AccessLevel = accessLevel;
    }

    /**
     * Sets the competitor category for a given KABoxer.
     *
     * @param temp The KABoxer for which to set the competitor category.
     * @param category The new competitor category.
     */
    public void setCompetitorCategory(KABoxer temp, Category category) {
        temp.setCompetitorCategory(category);
    }

    /**
     * Records scores for a given KABoxer in a specific category.
     *
     * @param temp The KABoxer for which to record scores.
     * @param category The category for which to record scores.
     * @param score An array of scores to be recorded.
     */
    public void recordScores(KABoxer temp, Category category, int[] score) {
        int[] validScores = Arrays.copyOf(score, 6);
        switch (category) {
            case HEAVYWEIGHT -> temp.setScoresHeavy(validScores);
            case MIDDLEWEIGHT -> temp.setScoresMiddle(validScores);
            case LIGHTWEIGHT -> temp.setScoresLight(validScores);
        }
    }

    /**
     * Returns a string representation of the Staff object.
     *
     * @return A string representation of the Staff object.
     */
    @Override
    public String toString() {
        return "Staff{" +
                "StaffDetails=" + StaffDetails +
                ", AccessLevel=" + AccessLevel +
                '}';
    }
}
