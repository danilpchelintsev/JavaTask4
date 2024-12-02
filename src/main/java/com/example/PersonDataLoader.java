package com.example;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Responsible for loading person data from a CSV file.
 */
public class PersonDataLoader {

    /**
     * Loads a list of persons from the specified CSV file.
     *
     * @param filePath the path to the CSV file in resources
     * @return a list of persons parsed from the file
     * @throws IOException if an error occurs during file reading
     */
    public List<Person> loadPersons(String filePath) throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream(filePath);
        if (in == null) {
            throw new FileNotFoundException("File not found: " + filePath);
        }

        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(in))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            List<Person> persons = new ArrayList<>();
            String[] nextLine;
            AtomicInteger divisionIdCounter = new AtomicInteger(1);
            Map<String, Division> divisions = new HashMap<>();

            reader.readNext(); // Пропускаем заголовок
            while ((nextLine = reader.readNext()) != null) {
                try {
                    int id = Integer.parseInt(nextLine[0]);
                    String name = nextLine[1];
                    String gender = nextLine[2];
                    LocalDate birthDate = LocalDate.parse(nextLine[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    String divisionName = nextLine[4];
                    double salary = Double.parseDouble(nextLine[5]);

                    Division division = divisions.computeIfAbsent(divisionName, key -> new Division(divisionIdCounter.getAndIncrement(), key));
                    persons.add(new Person(id, name, gender, division, salary, birthDate));
                } catch (NumberFormatException | DateTimeParseException e) {
                    System.err.println("Ошибка при обработке строки: " + Arrays.toString(nextLine) + " - " + e.getMessage());
                }
            }
            return persons;
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }


}
