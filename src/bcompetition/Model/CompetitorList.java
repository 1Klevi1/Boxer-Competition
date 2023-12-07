package bcompetition.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * The CompetitorList class represents a list of competitors in a competition.
 * It provides various methods for managing and analyzing the competitor data.
 *
 * @author Klevi
 * @version 07/12/2023
 */
public class CompetitorList {

    private String fileName;
    private ArrayList<KABoxer> allParticipants = new ArrayList<>();

    /**
     * Constructs a CompetitorList object with the specified file name and reads competitor data from the file.
     *
     * @param fileName The name of the file containing competitor data.
     */
    public CompetitorList(String fileName) {
        this.fileName = fileName;
        readAllParticipants(fileName);
    }

    /**
     * Finds and returns the participant with the highest overall score.
     *
     * @return A string representation of the participant with the highest overall score.
     */
    public String highestOverallScore() {
        HashMap<KABoxer, Double> boxerDoubleMap = new HashMap<>();
        double highestValue = 0;
        String s = "";
        for (KABoxer boxer : allParticipants) {
            double result = boxer.getOverallScore();
            boxerDoubleMap.put(boxer, result);
            if (result > highestValue) {
                highestValue = result;
            }
        }
        s += "The participant with the highest overall score is:\n ";
        for (Map.Entry<KABoxer, Double> elem : boxerDoubleMap.entrySet()) {
            if (elem.getValue() == highestValue) {
                s += "\n" + elem.getKey().getFullDetails();
                return s;
            }
        }
        return null;
    }

    /**
     * Removes a boxer with the specified ID from the list of participants.
     *
     * @param id The ID of the boxer to be removed.
     * @return A message indicating the success or failure of the removal.
     */
    public String removeBoxer(int id) {
        Iterator<KABoxer> iterator = allParticipants.iterator();
        while (iterator.hasNext()) {
            KABoxer boxer = iterator.next();
            if (boxer.getCompetitorId() == id) {
                iterator.remove();
                return "Boxer removed successfully";
            }
        }
        return null;
    }

    /**
     * Returns a string representation of participants in a specific category.
     *
     * @param category The category of participants to view.
     * @return A string representation of participants in the specified category.
     */
    public String viewDetailsCategory(Category category) {
        ArrayList<KABoxer> boxerView = new ArrayList<>();
        String s = "";
        for (KABoxer boxer : allParticipants) {
            if (boxer.getCompetitorCategory() == category) {
                boxerView.add(boxer);
            }
        }
        for (KABoxer boxer : boxerView) {
            s += boxer + "\n";
        }
        return s;
    }

    /**
     * Returns the list of all participants in the competition.
     *
     * @return An ArrayList containing all participants.
     */
    public ArrayList<KABoxer> getAllParticipants() {
        return allParticipants;
    }

    /**
     * Updates the scores of a boxer with the specified ID.
     *
     * @param id    The ID of the boxer.
     * @param score An array of scores to update.
     * @return A string representation of the updated boxer details.
     */
    public String alterBoxerScores(int id, int[] score) {
        for (KABoxer boxer : allParticipants) {
            if (boxer.getCompetitorId() == id) {
                boxer.setScoreArray(boxer.getCompetitorCategory(), score);
                return boxer.getFullDetails();
            }
        }
        return "Boxer doesn't exist";
    }

    /**
     * Generates a formatted string representation of a table containing details for each KABoxer.
     * The table includes information such as full details, total, maximum score, minimum score,
     * frequency of score elements, and average score.
     *
     * @return A formatted string representing the boxer table.
     */
    public String boxerTable() {
        String s = "";
        for (KABoxer boxer : allParticipants) {
            s += "\n" + boxer.getFullDetails() + "\n" +
                    "\n - Total is: " + calcTotals(boxer) +
                    "\n - Maximum element in the Score array is: " + calcMax(boxer) +
                    "\n - Minimum element in the Score array is: " + calcMin(boxer) +
                    "\n - Frequency of the elements inside the Score array is: " + calcFrequency(boxer) +
                    "\n - The average is: " + calcAverages(boxer) +
                    "\n---------------------------------------------------------------\n";

        }
        return s;
    }

    /**
     * Retrieves the short details of a boxer based on the provided competitor ID.
     *
     * @param id The competitor ID to search for.
     * @return The short details of the boxer if found, or "Boxer doesn't exist" otherwise.
     */
    public String getCompetitorShortDetails(int id) {
        for (KABoxer boxer : allParticipants) {
            if (boxer.getCompetitorId() == id) {
                return boxer.getShortDetails();
            }
        }
        return "Boxer doesn't exist";
    }

    /**
     * Checks if a boxer with the specified competitor ID exists.
     *
     * @param id The competitor ID to check.
     * @return True if a boxer with the given ID exists, false otherwise.
     */
    public boolean boxerExists(int id) {
        for (KABoxer boxer : allParticipants) {
            if (id == boxer.getCompetitorId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the full details of a boxer based on the provided competitor ID.
     *
     * @param id The competitor ID to search for.
     * @return The full details of the boxer if found, or "Boxer doesn't exist" otherwise.
     */
    public String getCompetitorFullDetails(int id) {
        for (KABoxer boxer : allParticipants) {
            if (boxer.getCompetitorId() == id) {
                return boxer.getFullDetails();
            }
        }
        return "Boxer doesn't exist";
    }

    /**
     * Edits details of a boxer identified by their competitor ID.
     *
     * @param id      The competitor ID of the boxer to be edited.
     * @param detail  The detail to be edited (e.g., Name, Middle Name, Age).
     * @param input   The new value to be set for the specified detail.
     * @return        A string indicating the outcome of the edit operation or an error message.
     */
    public String editBoxerDetails(int id, String detail, String input) {
        for (KABoxer boxer : allParticipants) {
            if (boxer.getCompetitorId() == id) {
                switch (detail) {
                    case "Name" -> {
                        if (input.matches("[a-zA-Z]+")) {
                            boxer.setBoxerName(input);
                        } else {
                            return "Invalid input";
                        }
                    }
                    case "Middle Name" -> {
                        if (input.matches("[a-zA-Z]+")) {
                            boxer.setBoxerMiddleName(input);
                        } else {
                            return "Invalid input";
                        }
                    }
                    case "Surname" -> {
                        if (input.matches("[a-zA-Z]+")) {
                            boxer.setBoxerSurname(input);
                        } else {
                            return "Invalid input";
                        }
                    }
                    case "Country" -> {
                        if (input.matches("[a-zA-Z]+")) {
                            boxer.setBoxerCountry(input);
                        } else {
                            return "Invalid input";
                        }
                    }
                    case "Age" -> {
                        int result = -1;
                        try {
                            result = Integer.parseInt(input);
                            boxer.setBoxerAge(result);
                        } catch (NumberFormatException e) {
                            return "Invalid input";
                        }
                    }
                    case "Gender" -> {
                        if (input.matches("[a-zA-Z]+")) {
                            boxer.setBoxerGender(input);
                        } else {
                            return "Invalid input";
                        }
                    }
                    case "Competitor Level" -> {
                        Level lvl = Level.valueOf(input);  // Convert string to integer
                        boxer.setCompetitorLvl(lvl);
                    }
                    case "Competitor Category" -> {
                        Category categ = Category.valueOf(input);  // Convert string to integer
                        boxer.setCompetitorCategory(categ);
                    }
                    case "Scores Heavy (comma-separated)" -> {
                        String[] scoreStrings = input.split(",");
                        int[] boxerScores = new int[scoreStrings.length];
                        for (int i = 0; i < scoreStrings.length; i++) {
                            try {
                                boxerScores[i] = Integer.parseInt(scoreStrings[i].trim());
                            } catch (NumberFormatException j) {
                                return "Invalid input. Please enter valid integers.";
                            }
                        }
                        boxer.setScoresHeavy(boxerScores);
                    }
                    case "Scores Middle (comma-separated)" -> {
                        String[] scoreStrings1 = input.split(",");
                        int[] boxerScores1 = new int[scoreStrings1.length];
                        for (int i = 0; i < scoreStrings1.length; i++) {
                            try {
                                boxerScores1[i] = Integer.parseInt(scoreStrings1[i].trim());
                            } catch (NumberFormatException j) {
                                return "Invalid input. Please enter valid integers.";
                            }
                        }
                        boxer.setScoresMiddle(boxerScores1);
                    }
                    case "Scores Light (comma-separated)" -> {
                        String[] scoreStrings2 = input.split(",");
                        int[] boxerScores2 = new int[scoreStrings2.length];
                        for (int i = 0; i < scoreStrings2.length; i++) {
                            try {
                                boxerScores2[i] = Integer.parseInt(scoreStrings2[i].trim());
                            } catch (NumberFormatException j) {
                                return "Invalid input. Please enter valid integers.";
                            }
                        }
                        boxer.setScoresLight(boxerScores2);
                    }
                }
                return boxer.getFullDetails();
            }
        }
        return "Boxer doesn't exist";
    }

    /**
     * Calculates the sum of scores for a given boxer.
     *
     * @param boxer The boxer for whom the scores are calculated.
     * @return The total sum of scores.
     */
    public int calcTotals(KABoxer boxer) {
        int result = 0;
        int[] tempArray = boxer.getScoreArray();
        for (int value : tempArray) {
            result += value;
        }
        return result;
    }

    /**
     * Calculates the average of scores for a given boxer.
     *
     * @param boxer The boxer for whom the average is calculated.
     * @return The average of scores as a double.
     */
    public double calcAverages(KABoxer boxer) {
        int sum = 0;
        int[] tempArray = boxer.getScoreArray();
        for (int value : tempArray) {
            sum += value;
        }
        return (double) sum / tempArray.length;
    }

    /**
     * Finds the maximum score among a boxer's scores.
     *
     * @param boxer The boxer for whom the maximum score is found.
     * @return The maximum score.
     */
    public int calcMax(KABoxer boxer) {
        int max = 0;
        int[] tempArray = boxer.getScoreArray();
        for (int value : tempArray) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Finds the minimum score among a boxer's scores.
     *
     * @param boxer The boxer for whom the minimum score is found.
     * @return The minimum score.
     */
    public int calcMin(KABoxer boxer) {
        int[] tempArray = boxer.getScoreArray();
        int min = calcMax(boxer);
        for (int value : tempArray) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /**
     * Calculates the frequency of each score in a boxer's array.
     *
     * @param boxer The boxer for whom the frequency is calculated.
     * @return A formatted string representing the frequency of each score.
     */
    public String calcFrequency(KABoxer boxer) {
        int[] tempArray = boxer.getScoreArray();
        String s = "";
        LinkedHashMap<Integer, Integer> frequency = new LinkedHashMap<>();
        for (int value : tempArray) {
            if (frequency.containsKey(value)) {
                int tempValv = frequency.get(value);
                tempValv += 1;
                frequency.put(value, tempValv);
            } else {
                frequency.put(value, 1);
            }
        }
        s += "\n{";
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            s += "\n Elm - " + entry.getKey() + " Freq - " + entry.getValue() + "  ";
        }
        s += "\n}";
        return s;
    }

    /**
     * Writes the competitor data to a specified file.
     *
     * @param fileName The name of the file to write the data to.
     */
    public void writeToFile(String fileName) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write("Table of competitors: \n" + boxerTable()
                    + "\n" + highestOverallScore());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads competitor data from a file and populates the list of participants.
     *
     * @param fileName The name of the file to read data from.
     * @return 1 if the operation is successful, -1 if the level is invalid, -2 if the category is missing.
     */
    public int readAllParticipants(String fileName) {
        try {
            FileReader filereader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(filereader);


            String line = reader.readLine();
            while ((line != null)) {

                String[] elements = line.split(",");
                int id = Integer.parseInt(elements[0]);
                String details = elements[1];
                int age = Integer.parseInt(elements[2]);
                String gender = elements[3];
                String country = elements[4];
                String level = elements[5];
                String category = elements[6];

                // Extract the scores part of the line
                String[] scoreStrings = Arrays.copyOfRange(elements, 7, elements.length);
                // Parse the scores into an array of integers
                int[] scores = new int[scoreStrings.length];
                for (int i = 0; i < scoreStrings.length; i++) {
                    scores[i] = Integer.parseInt(scoreStrings[i]);
                }

                ArrayList<String> storingDetails = setDetailsForPerson(details);
                Person person = new Person(storingDetails.get(0), storingDetails.get(1),
                        storingDetails.get(2), country, age, gender);
                KABoxer boxer;

                if ("Novice".equals(level) || "Professional".equals(level)) {
                    if (category != null) {
                        if ("Novice".equals(level)) {
                            boxer = new NoviceBoxer(id, person, Level.valueOf(level.toUpperCase()), Category.valueOf(category.toUpperCase()));
                        } else {
                            boxer = new ProfessionalBoxer(id, person, Level.valueOf(level.toUpperCase()), Category.valueOf(category.toUpperCase()));
                        }
                    } else {
                        return -2;
                    }

                } else {
                    return -1;
                }

                boxer.setScoreArray(Category.valueOf(category.toUpperCase()), scores);
                allParticipants.add(boxer);
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * Parses the input string to extract details for a person, including first name,
     * middle name, and last name.The input string should contain space-separated elements.
     * If a middle name is not present, an empty string is assigned.
     *
     * @param value The input string containing details for a person.
     * @return An ArrayList containing the parsed details: [firstName, middleName, lastName].
     */
    public ArrayList<String> setDetailsForPerson(String value) {
        ArrayList<String> detailsArray = new ArrayList<String>();
        String Name, Surname, middleName;

        String[] elements = value.split(" ");
        if (elements.length >= 2) {
            Name = elements[0];
            Surname = elements[elements.length - 1];
            if (elements.length > 2) {
                middleName = elements[1];
            } else {
                middleName = "";
            }
        } else {
            Name = "";
            middleName = "";
            Surname = elements[0];
        }
        detailsArray.add(Name);
        detailsArray.add(middleName);
        detailsArray.add(Surname);
        return detailsArray;
    }

    /**
     * Returns a string representation of the list of KABoxer objects in this instance.
     * The string is generated by concatenating the string representations of each KABoxer in the list.
     *
     * @return A string representation of the list of KABoxer objects.
     */
    @Override
    public String toString() {
        String s = "";
        for (KABoxer boxer : allParticipants) {
            s += boxer;
        }
        return s;
    }
}
