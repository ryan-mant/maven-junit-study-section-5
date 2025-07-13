package org.example;

import org.example.model.Person;
import org.example.service.IPersonService;
import org.example.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PersonServiceTest {

    Person person;

    @BeforeEach
    void setUp() {
         person = new Person(
                "Lucas",
                "Silva",
                "Austin - TX",
                "Male",
                "lucas.silva@email.com"
        );
    }


    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("When Create a Person With Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
    	// Given / Arrange
        IPersonService personService = new PersonService();

    	// When / Act
        Person actual = personService.createPerson(person);

    	// Then / Assert

        assertNotNull(actual, "The createPerson() should not have return null");
    }

    @DisplayName("When Create a Person With Success Should Contains Valid Fields In Returned Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsValidFieldsInReturnedPersonObject() {
        // Given / Arrange
        IPersonService personService = new PersonService();

        // When / Act
        Person actual = personService.createPerson(person);

        // Then / Assert

        assertNotNull(actual, "The createPerson() should not have return null");

        assertNotNull(person.getId(), "The ID is missing!");

        assertEquals(person.getFirstName(), actual.getFirstName(), "The first name should be equal");
        assertEquals(person.getLastName(), actual.getLastName(), "The last name should be equal");
        assertEquals(person.getAddress(), actual.getAddress(), "The address should be equal");
        assertEquals(person.getEmail(), actual.getEmail(), "The e-mail should be equal");
        assertEquals(person.getGender(), actual.getGender(), "The gender should be equal");
    }

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("When Create a Person With Null Email Should Throw Exception")
    @Test
    void testCreatePerson_WhithNullEmail_ShouldThrowIllegalArgumentException() {
        // Given / Arrange
        IPersonService personService = new PersonService();

        person.setEmail(null);

        // When / Act
    	// Then / Assert
        String message = assertThrows(IllegalArgumentException.class, () -> personService.createPerson(person),
                () -> "Empty Email Should Have cause an IllegalArgumentException").getMessage();

        assertEquals("The Person email is null or empty", message,
                "The exception message is difference of expected");
    }
}
