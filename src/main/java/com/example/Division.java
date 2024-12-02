package com.example;

/**
 * Represents a division in the organization.
 * Each division has a unique ID and a name.
 */
public class Division {
    private static int nextId = 1;
    private final int id;
    private final String name;

    /**
     * Creates a new division with the specified name.
     *
     * @param andIncrement
     * @param name         the name of the division
     */
    public Division(int andIncrement, String name) {
        this.id = nextId++;
        this.name = name;
    }

    /**
     * Gets the unique ID of the division.
     *
     * @return the division ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the division.
     *
     * @return the division name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
