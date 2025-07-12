package org.example;

import org.example.model.Person;
import org.example.service.IPersonService;
import org.example.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PersonServiceTest {

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("When Create a Person With Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
    	// Given / Arrange
        IPersonService personService = new PersonService();

        Person person = new Person(
                "Lucas",
                "Silva",
                "lucas.silva@email.com",
                "Austin - TX",
                "Male"
        );

    	// When / Act
        Person actual = personService.createPerson(person);

    	// Then / Assert

        assertNotNull(actual, "The createPerson() should not have return null");
    }

    @DisplayName("When Create a Person With Success Should Contains First Name In Returned Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {
        // Given / Arrange
        IPersonService personService = new PersonService();

        Person person = new Person(
                "Lucas",
                "Silva",
                "lucas.silva@email.com",
                "Austin - TX",
                "Male"
        );

        // When / Act
        Person actual = personService.createPerson(person);

        // Then / Assert

        assertNotNull(actual, "The createPerson() should not have return null");

        assertEquals(person.getFirstName(), actual.getFirstName(), "The first name should be equal");
    }
}
