package TP6;

import java.util.*;

public class PersonCollectionImpl implements PersonCollection{
    private Map<String, Map<String,Person>> peopleMap = new HashMap<>();

    @Override
    public void addPerson(Person aPerson) {
        peopleMap.putIfAbsent(aPerson.getLastName(), new HashMap<>());
        peopleMap.get(aPerson.getLastName()).put(aPerson.getFirstName(), aPerson);
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        return new ArrayList<>(peopleMap.getOrDefault(lastName,new HashMap<>()).values());
    }

    @Override
    public Person findByName(String firstName, String lastName) {
        return peopleMap.getOrDefault(lastName, new HashMap<>()).get(firstName);
    }
}
