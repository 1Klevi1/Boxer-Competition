package bcompetition.Model;

import java.util.Objects;

/**
 * The `Person` class represents an individual with personal details such as name, middle name, surname,
 * country, age, and gender.
 * @author Klevi
 * @version 07/12/2023
 */
public class Person {

    private String Name;
    private String middleName;
    private String Surname;
    private String Country;
    private int Age;
    private String gender;

    /**
     * Constructs a `Person` object with specified details.
     *
     * @param name       The first name of the person.
     * @param middleName The middle name of the person.
     * @param surname    The surname of the person.
     * @param country    The country of residence.
     * @param age        The age of the person.
     * @param gender     The gender of the person.
     */
    public Person(String name, String middleName, String surname, String country, int age, String gender) {
        Name = name;
        this.middleName = middleName;
        Surname = surname;
        Country = country;
        Age = age;
        this.gender = gender;
    }

    // Getter and setter methods

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Gets the gender of the person.
     *
     * @return The gender of the person.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the person.
     *
     * @param gender The new gender to set.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets the middle name of the person.
     *
     * @param middleName The new middle name to set.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Sets the surname of the person.
     *
     * @param surname The new surname to set.
     */
    public void setSurname(String surname) {
        Surname = surname;
    }

    /**
     * Gets the age of the person.
     *
     * @return The age of the person.
     */
    public int getAge() {
        return Age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age The new age to set.
     */
    public void setAge(int age) {
        Age = age;
    }

    /**
     * Gets the country of the person.
     *
     * @return The country of the person.
     */
    public String getCountry() {
        return Country;
    }

    /**
     * Sets the country of the person.
     *
     * @param country The new country to set.
     */
    public void setCountry(String country) {
        Country = country;
    }

    /**
     * Gets the full name of the person.
     *
     * @return The full name.
     */
    public String getFullName() {
        if (Objects.equals(middleName, "")) {
            return Name + " " + Surname;

        } else {
            return Name + " " + middleName + " " + Surname;

        }
    }

    /**
     * Gets the initials of the person.
     *
     * @return The initials.
     */
    public String getInitials() {

        String[] words = getFullName().split(" ");
        String s = "";

        for (String word : words) {
            if (!(word.equals(""))) {
                s += word.charAt(0);
            }
        }
        return s;
    }

    /**
     * Provides a string representation of the `Person` object.
     *
     * @return A string containing details of the person.
     */
    @Override
    public String toString() {
        return "<Name: " + Name +
                " - Middle Name: " + middleName +
                " - Surname: " + Surname +
                " - Gender: " + gender +
                " - Country: " + Country +
                " - Age: " + Age +
                "> }" + "\n";
    }

}
