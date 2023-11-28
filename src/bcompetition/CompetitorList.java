package bcompetition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CompetitorList {
    ArrayList<KABoxer> allParticipants = new ArrayList<KABoxer>();
    public  CompetitorList(){
    }

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
