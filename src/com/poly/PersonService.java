package com.poly;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();
    boolean addPerson(Person p);
    boolean deletePerson(long id);
    Person getPerson(long id);
    boolean updatePerson(Person p);
    Person getPersonByName(String nom);
}