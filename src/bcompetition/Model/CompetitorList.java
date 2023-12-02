package bcompetition.Model;

import bcompetition.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CompetitorList {

    String fileName;
    ArrayList<KABoxer> allParticipants = new ArrayList<KABoxer>();
    public  CompetitorList(String fileName){
        this.fileName = fileName;
        readAllParticipants(fileName);
    }
    public String highestOverallScore(){
        HashMap<KABoxer,Double> boxerDoubleMap = new HashMap<KABoxer,Double>();
        double highestValue = 0;
        String s = "";
        for(KABoxer boxer: allParticipants){
            double result = boxer.getOverallScore();
            boxerDoubleMap.put(boxer, result);
            if (result > highestValue){
                highestValue = result;
            }
        }
        s+= "The participant with the highest overall score is:\n ";
        for(Map.Entry<KABoxer, Double> elem : boxerDoubleMap.entrySet()){
            if(elem.getValue() == highestValue){
                s += "\n" + elem.getKey().getFullDetails();
                return s;
            }
        }
        return null;
    }

    public String boxerTable(){
        String s = "";
        for(KABoxer boxer: allParticipants){
            s += "\n"+boxer.getFullDetails()+"\n" +
                 "\n - Total is: "+ calcTotals(boxer) +
                 "\n - Maximum element in the Score array is: "+ calcMax(boxer)+
                 "\n - Minimum element in the Score array is: "+calcMin(boxer) +
                 "\n - Frequency of the elements inside the Score array is: " + calcFrequency(boxer) +
                 "\n - The average is: " + calcAverages(boxer) + "\n";
        }
        return s;
    }
    public String getCompetitorShortDetails(int id){
        for(KABoxer boxer: allParticipants){
            if(boxer.getCompetitorId() == id){
                return boxer.getShortDetails();
            }
        }
        return null;
    }
    public String getCompetitorFullDetails(int id){
        for(KABoxer boxer: allParticipants){
            if(boxer.getCompetitorId() == id){
                return boxer.getFullDetails();
            }
        }
        return null;
    }
    public int calcTotals(KABoxer boxer){
        int result = 0;
        int[] tempArray = boxer.getScoreArray();
        for(int value: tempArray){
            result += value;
        }
        return result;
    }
    public double calcAverages(KABoxer boxer){
        int sum = 0;
        int[] tempArray = boxer.getScoreArray();
            for(int value: tempArray){
                sum += value;
            }
            return (double) sum / tempArray.length;
    }
    public int calcMax(KABoxer boxer){
        int max = 0;
        int[] tempArray = boxer.getScoreArray();
            for(int value: tempArray){
                if(value > max){
                    max = value;
                }
            }
            return max;
    }
    public int calcMin(KABoxer boxer){
        int[] tempArray = boxer.getScoreArray();
            int min = calcMax(boxer);
            for(int value: tempArray){
                if(value < min){
                    min = value;
                }
            }
            return min;
    }
    public String calcFrequency(KABoxer boxer){
            int[] tempArray = boxer.getScoreArray();
            String s = "";
            LinkedHashMap<Integer, Integer> frequency = new LinkedHashMap<>();
            for(int value: tempArray){
                if(frequency.containsKey(value)){
                    int tempValv = frequency.get(value);
                    tempValv += 1;
                    frequency.put(value, tempValv);
                }else{
                    frequency.put(value,1);
                }
            }
            s += "\n{";
            for(Map.Entry<Integer,Integer> entry : frequency.entrySet()){
                s += "\n Element - " + entry.getKey() + " Frequency - " + entry.getValue();
            }
            s+= "\n}";
        return s;
    }
    public int writeToFile(String fileName){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write("Table of competitors: \n" + boxerTable()
                            + "\n" + highestOverallScore());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
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
                            boxer = new AmateurBoxer(id, person, Level.valueOf(level.toUpperCase()), Category.valueOf(category.toUpperCase()));
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
    public ArrayList<String> setDetailsForPerson(String value){
        ArrayList<String> detailsArray = new ArrayList<String>();
        String Name,Surname,middleName;

        String[] elements = value.split(" ");
        if(elements.length >= 2){
             Name = elements[0];
             Surname = elements[elements.length-1];
            if(elements.length > 2){
                 middleName = elements[1];
            }else{
                 middleName = "";
            }
        }else{
             Name = "";
             middleName = "";
             Surname = elements[0];
        }
        detailsArray.add(Name);
        detailsArray.add(middleName);
        detailsArray.add(Surname);
        return detailsArray;
    }

    @Override
    public String toString() {
        String s = "";
        for(KABoxer boxer: allParticipants){
            s += boxer;
        }
        return s;
    }
}
