package bcompetition.Model;

/**
 * The {@code Level} enum represents different skill levels.
 * It includes two constants: {@code NOVICE} and {@code PROFESSIONAL}.
 * @author Klevi
 * @version 07/12/2023
 */
public enum Level {
    NOVICE("Novice"), PROFESSIONAL("Professional");
    private final String level;
    /**
     * Constructs a new Level with the specified type.
     *
     * @param typ The string representation of the skill level.
     */
    Level(String typ) {
        level = typ;
    }

    /**
     * Returns the string representation of the skill level.
     *
     * @return The string representation of the skill level.
     */
    public String toString() {
        return level;
    }
}
