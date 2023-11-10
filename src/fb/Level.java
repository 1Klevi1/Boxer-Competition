package fb;

public enum Level {
    NOVICE("Novice"), STANDARD("Standard"), VETERAN("Veteran");
    private final String level;


    Level(String typ) {
        level = typ;
    }


    public String toString() {
        return level;
    }
}
