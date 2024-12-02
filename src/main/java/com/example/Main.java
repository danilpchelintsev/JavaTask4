package com.example;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            PersonDataLoader loader = new PersonDataLoader();
            List<Person> persons = loader.loadPersons("foreign_names.csv");

            persons.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error loading persons: " + e.getMessage());
        }
    }
}
