package bcompetition;

import bcompetition.Model.CompetitorList;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//
//        Person p = new Person("Ben", null, "Smith", "132", 21, "uk","Male");
//        Person p1 = new Person(" Bill", "Toronto", "Alabama", 18);
//        System.out.println(p1.getInitials());
//        KABoxer p11 = new KABoxer(10, p1, Level.NOVICE, Category.LIGHTWEIGHT);
//        System.out.println(p11.getFullDetails());
//        System.out.println(p11.getShortDetails());
//        Staff s1 = new Staff(p,4);
//
//        s1.recordScores(p11,Category.HEAVYWEIGHT, new int[]{0,3,5,2,1,4});
//        s1.recordScores(p11,Category.MIDDLEWEIGHT, new int[]{});
//        s1.recordScores(p11,Category.LIGHTWEIGHT, new int[]{});
//
//        System.out.println("getOverALLsCORE :  " + p11.getOverallScore());
//        System.out.println(p11.getFullDetails());
//        System.out.println(p11.getShortDetails());
        CompetitorList l = new CompetitorList("src/bcompetition/RunCompetitor.csv");
//        l.writeToFile("test");
        l.getAllParticipants();
    }
}