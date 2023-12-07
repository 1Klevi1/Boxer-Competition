package bcompetition.UnitTest;

import bcompetition.Model.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
