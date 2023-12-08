package bcompetition.UnitTest;

import bcompetition.Model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The {@code PersonTest} class contains unit tests for the methods in the {@code Person} class.
 * It utilizes JUnit 5 testing framework for writing and executing tests.
 *
 * <p>These tests cover various functionalities of the {@code Person} class, including:
 * <ul>
 *     <li>Setting and getting the name, middle name, and surname of a person</li>
 *     <li>Setting and getting the country, age, and gender of a person</li>
 *     <li>Constructing a person with provided details</li>
 *     <li>Creating a string representation of the full name of a person</li>
 * </ul>
 *
 * <p>Each test method is annotated with {@code }{@Test}, and assertions are made using methods from
 * {@code org.junit.jupiter.api.Assertions.assertEquals}.
 *
 * <p>It's recommended to run these tests with various test cases and data to ensure the correct
 * behavior of the {@code Person} class.
 *
 * @author Klevi Alliu
 * @version 08/12/2023
 */
public class PersonTest {
    @Test
    void getFullName() {
        Person personWithoutMiddleName = new Person("John", "", "Doe", "USA", 25, "Male");
        Person personWithMiddleName = new Person("Jane", "Mary", "Doe", "Canada", 30, "Female");

        assertEquals("John Doe", personWithoutMiddleName.getFullName());
        assertEquals("Jane Mary Doe", personWithMiddleName.getFullName());
    }

    @Test
    void getInitials() {
        Person personWithoutMiddleName = new Person("John", "", "Doe", "USA", 25, "Male");
        Person personWithMiddleName = new Person("Jane", "Mary", "Doe", "Canada", 30, "Female");

        assertEquals("JD", personWithoutMiddleName.getInitials());
        assertEquals("JMD", personWithMiddleName.getInitials());
    }

    @Test
    void setAndGetAge() {
        Person person = new Person("Alice", "", "Smith", "UK", 22, "Female");

        assertEquals(22, person.getAge());

        person.setAge(25);

        assertEquals(25, person.getAge());
    }

    @Test
    void getAndSetCountry() {
        Person person = new Person("Bob", "James", "Johnson", "Australia", 40, "Male");

        assertEquals("Australia", person.getCountry());

        person.setCountry("New Zealand");

        assertEquals("New Zealand", person.getCountry());
    }
}
