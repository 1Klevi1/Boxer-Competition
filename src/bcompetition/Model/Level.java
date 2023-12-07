package bcompetition.Model;

public enum Level {
    NOVICE("Novice"), PROFESSIONAL("Professional");
    private final String level;
    Level(String typ) {
        level = typ;
    }
    public String toString() {
        return level;
    }
}
