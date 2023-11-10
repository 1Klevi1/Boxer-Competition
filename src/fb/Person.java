package fb;

public class Person {

    private String Name;
    private String middleName;
    private String Surname;
    private String dateOfBirth;

    public Person(String name, String middleName, String surname, String dateOfBirth) {
        Name = name;
        this.middleName = middleName;
        Surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", Surname='" + Surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
