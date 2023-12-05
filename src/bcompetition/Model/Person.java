package bcompetition.Model;

import java.util.Objects;

public class Person {

    private String Name;
    private String middleName;
    private String Surname;
    private String Country;
    private int Age;
    private String gender;



    public Person(String name, String middleName, String surname, int age, String Country, String gender) {
        Name = name;
        this.middleName = middleName;
        Surname = surname;
        this.Age = age;
        this.Country =  Country;
        this.gender = gender;
    }

    public Person(String name, String middleName, String surname, String country, int age, String gender) {
        Name = name;
        this.middleName = middleName;
        Surname = surname;
        Country = country;
        Age = age;
        this.gender = gender;
    }

    public Person(String name, String surname, String country, int age) {
        Name = name;
        Surname = surname;
        Country = country;
        Age = age;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return Name;
    }
    public String getFullName() {
        if(Objects.equals(middleName, "")){
            return Name + " " + Surname;

        }else{
            return Name +" "+ middleName + " " + Surname;

        }
    }

    public String getGender() {
        return gender;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return Surname;
    }

    public int getAge() {
        return Age;
    }

    public String getCountry() {
        return Country;
    }
    public String getInitials(){

        String[] words = getFullName().split(" ");
        String s = "";

        for (String word: words) {
            if(!(word.equals(""))){
                s += word.charAt(0);
            }
        }
        return s;
    }
    @Override
    public String toString() {
        return "<Name: " + Name  +
                " - Middle Name: " + middleName +
                " - Surname: " + Surname +
                " - Gender: " + gender +
                " - Country: " + Country +
                " - Age: " + Age +
                "> }"+"\n";
    }

}
