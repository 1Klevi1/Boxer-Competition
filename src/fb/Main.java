package fb;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Person p = new Person("Ben", null, "Smith", "132", 21, "uk");
        Person p1 = new Person(" Bill", "Toronto", "Alabama", 18);
        System.out.println(p1.getInitials());
        Competitior p11 = new Competitior(10, p1, Level.NOVICE, 4);
        System.out.println(p11.getFullDetails());
        System.out.println(p11.getShortDetails());
    }

}