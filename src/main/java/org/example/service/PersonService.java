package org.example.service;

import org.example.model.Person;

public class PersonService implements IPersonService{


    @Override
    public Person createPerson(Person person) {
        return person;
    }
}
