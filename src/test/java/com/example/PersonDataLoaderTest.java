package com.example;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDataLoaderTest {

    @Test
    void testLoadPersons_validFile() throws IOException {
        PersonDataLoader loader = new PersonDataLoader();
        List<Person> persons = loader.loadPersons("foreign_names.csv");

        assertNotNull(persons, "Persons list should not be null");
        assertFalse(persons.isEmpty(), "Persons list should not be empty");

        // Проверяем первую строку
        Person firstPerson = persons.get(0);
        assertEquals(28281, firstPerson.getId());
        assertEquals("Aahan", firstPerson.getName());
        assertEquals("Male", firstPerson.getGender());
        assertEquals("I", firstPerson.getDivision().getName());
        assertEquals(4800.0, firstPerson.getSalary());
        assertEquals(LocalDate.of(1970, 5, 15), firstPerson.getBirthDate());
    }


    @Test
    void testLoadPersons_invalidFile() {
        PersonDataLoader loader = new PersonDataLoader();
        assertThrows(IOException.class, () -> loader.loadPersons("non_existent_file.csv"),
                "Expected IOException for non-existent file");
    }
}
