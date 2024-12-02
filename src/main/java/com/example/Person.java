package com.example;

import java.time.LocalDate;

/**
 * Represents a person with personal details and organizational affiliation.
 */
public class Person {
    private final int id;
    private final String name;
    private final String gender;
    private final Division division;
    private final double salary;
    private final LocalDate birthDate;

    /**
     * Creates a new person instance.
     *
     * @param id        the unique ID of the person
     * @param name      the name of the person
     * @param gender    the gender of the person (Male/Female)
     * @param division  the division the person belongs to
     * @param salary    the salary of the person
     * @param birthDate the birth date of the person
     */
    public Person(int id, String name, String gender, Division division, double salary, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Division getDivision() {
        return division;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", division=" + division +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                '}';
    }
}
