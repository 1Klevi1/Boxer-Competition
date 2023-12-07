package bcompetition.Model;

/**
 * The {@code Category} enum represents different categories.
 * It includes three constants: {@code LIGHTWEIGHT}, {@code MIDDLEWEIGHT} and {@code HEAVYWEIGHT}.
 * @author Klevi
 * @version 07/12/2023
 */
public enum Category {
    LIGHTWEIGHT("Lightweight"), MIDDLEWEIGHT("Middleweight"), HEAVYWEIGHT("Heavyweight");
    private final String category;
    /**
     * Constructs a Category enum with the given string representation.
     *
     * @param typ The string representation of the category.
     */
    Category(String typ) {
        category = typ;
    }

    /**
     * Returns the string representation of the category.
     *
     * @return The string representation of the category.
     */
    public String toString() {
        return category;
    }
}
