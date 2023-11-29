package bcompetition;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CompetitorList {
    ArrayList<KABoxer> allParticipants = new ArrayList<KABoxer>();
    public  CompetitorList(){
    }
    public String highestOverallScore(){
        HashMap<KABoxer,Double> boxerDoubleMap = new HashMap<KABoxer,Double>();
        double highestValue = 0;
        for(KABoxer boxer: allParticipants){
            double result = boxer.getOverallScore();
            boxerDoubleMap.put(boxer, result);
            if (result > highestValue){
                highestValue = result;
            }
        }
        for(Map.Entry<KABoxer, Double> elem : boxerDoubleMap.entrySet()){
            if(elem.getValue() == highestValue){
                return elem.getKey().getFullDetails();
            }
        }
        return null;
    }

    public String boxerTable(){
        String s = "";
        for(KABoxer boxer: allParticipants){
            s += boxer.getFullDetails()+"\n";
        }
        return s;
    }

    public String calcTotals(){
        int result = 0;
        String s = "";
        LinkedHashMap<KABoxer,Integer> mapBoxer = new LinkedHashMap<KABoxer,Integer>();
        for(KABoxer boxer: allParticipants){
            int[] tempArray = boxer.getScoreArray();
            for(int value: tempArray){
                result += value;
            }
            mapBoxer.put(boxer,result);
            result = 0;
        }
        s+="Calculate the totals: \n";
        for(Map.Entry<KABoxer, Integer> set : mapBoxer.entrySet()){
                s+=set.getKey().getShortDetails() + " Totals: " + set.getValue()+"\n";
        }
       return s;
    }
    public String calcAverages(){
        int sum = 0;
        double result ;
        String s = "";
        LinkedHashMap<KABoxer,Double> mapBoxer = new LinkedHashMap<>();
        for(KABoxer boxer: allParticipants){
            int[] tempArray = boxer.getScoreArray();
            for(int value: tempArray){
                sum += value;
            }
            result = (double) sum / tempArray.length;
            mapBoxer.put(boxer,result);
            sum = 0;
        }
        s+="Calculate the average: \n";
        for(Map.Entry<KABoxer, Double> set : mapBoxer.entrySet()){
            s+=set.getKey().getShortDetails() + " Average: " + set.getValue()+"\n";
        }
        return s;
    }
    public int getMaxValue(KABoxer boxer){
        int max = 0;
        int[] tempArray = boxer.getScoreArray();
            for(int value: tempArray){
                if(value > max){
                    max = value;
                }
            }
            return max;
    }

    public String calcMax(){
        int max = 0;
        String s = "";
        LinkedHashMap<KABoxer,Integer> mapBoxer = new LinkedHashMap<>();
        for(KABoxer boxer: allParticipants){
            int[] tempArray = boxer.getScoreArray();
            for(int value: tempArray){
                if(value > max){
                    max = value;
                }
            }
            mapBoxer.put(boxer,max);
            max = 0;
        }
        s+="Get the maximum from their individual score array: \n";
        for(Map.Entry<KABoxer, Integer> set : mapBoxer.entrySet()){
            s+=set.getKey().getShortDetails() + " Maximum Score: " + set.getValue()+"\n";
        }
        return s;
    }
    public String calcMin(){
        String s = "";
        LinkedHashMap<KABoxer,Integer> mapBoxer = new LinkedHashMap<>();
        for(KABoxer boxer: allParticipants){
            int[] tempArray = boxer.getScoreArray();
            int min = getMaxValue(boxer);
            for(int value: tempArray){
                if(value < min){
                    min = value;
                }
            }
            mapBoxer.put(boxer,min);
        }
        s+="Get the minimum from their individual score array: \n";
        for(Map.Entry<KABoxer, Integer> set : mapBoxer.entrySet()){
            s+=set.getKey().getShortDetails() + " Minimum Score: " + set.getValue()+"\n";
        }
        return s;
    }
    public String calcFrequency(){
        String s = "";

        for(KABoxer boxer: allParticipants){
            int[] tempArray = boxer.getScoreArray();
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
            s += String.valueOf(boxer.getCompetitorId())+" "+frequency + "\n";
        }
        return s;

    }
    //    public String summaryStatistics(){
//
//        for(KABoxer boxer: allParticipants){
//            tempArray = boxer.getScoreArray();
//
//        }
//
//    }
//    public void writeToFile(String fileName){
//
//        try {
//            FileWriter myWriter = new FileWriter(fileName);
//            StringBuffer val = new StringBuffer ("Table of competitors: \n");
//            val.append(boxerTable());
//            val.append("\nHighest Overall Score: ");
//            val.append(highestOverallScore());
//            val.append("\nAverage age: ");
//            val.append(fastAvgAge());
//            for (Person p : people){
//                val.append("\n"+ p.toString());
//            }
//            myWriter.write(val.toString());
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//    }
    public void readAllParticipants(String fileName){
        try{
            FileReader filereader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(filereader);


            String line = reader.readLine();
            while ((line != null)){

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
                Person person = new Person(storingDetails.get(0),storingDetails.get(1),storingDetails.get(2),country, age, gender);
                KABoxer boxer = new KABoxer(id,person,Level.valueOf(level.toUpperCase()),Category.valueOf(category.toUpperCase()));
                boxer.setScoreArray(Category.valueOf(category.toUpperCase()),scores);
                allParticipants.add(boxer);
                line = reader.readLine();
            }
            reader.close();

        }catch(IOException e){
            e.printStackTrace();
        }
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
