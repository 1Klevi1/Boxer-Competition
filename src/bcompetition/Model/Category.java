package bcompetition.Model;

public enum Category {
    LIGHTWEIGHT("Lightweight"), MIDDLEWEIGHT("Middleweight"), HEAVYWEIGHT("Heavyweight");
    private final String category;
    Category(String typ) {
        category = typ;
    }
    public String toString() {
        return category;
    }
}
