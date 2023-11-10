package fb;

public class Person {

    private String Name;
    private String middleName;
    private String Surname;
    private String dateOfBirth;
    private String Country;

    private int Age;

    public Person(String name, String middleName, String surname, String dateOfBirth, int age, String Country) {
        Name = name;
        this.middleName = middleName;
        Surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.Age = age;
        this.Country =  Country;
    }

    public Person(String name, String middleName, String surname, String country, int age) {
        Name = name;
        this.middleName = middleName;
        Surname = surname;
        Country = country;
        Age = age;
    }

    public Person(String name, String surname, String country, int age) {
        Name = name;
        Surname = surname;
        Country = country;
        Age = age;
    }

    public String getName() {
        return Name;
    }
    public String getFullName() {
        if(middleName == null){
            return Name + " " + Surname;

        }else{
            return Name +" "+ middleName + " " + Surname;

        }
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getDateOfBirth() {
        return dateOfBirth;
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
        return "Person{" +
                "Name='" + Name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", Surname='" + Surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", Country='" + Country + '\'' +
                ", Age=" + Age +
                '}';
    }

}
