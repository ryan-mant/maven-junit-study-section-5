package org.example;

import org.example.service.IPersonService;
import org.example.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("When Create a Person With Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
    	// Given / Arrange
        IPersonService personService = new PersonService();

    	// When / Act


    	// Then / Assert
    }
}
