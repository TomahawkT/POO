package primerosParciales;

import java.util.Arrays;
import java.util.Comparator;

public abstract class AbstractDirectory {
    private final Person[] persons;
    private int dim;

    public AbstractDirectory(int limit){
        this.persons = new Person[limit];
    }

    public AbstractDirectory addPerson(Person person) throws ReachedLimitException {
        if(dim == persons.length) {
            throw new ReachedLimitException(dim);
        }
        persons[dim++] = person;
        return this;
    }
    public Person[] persons() {
        Person[] personsCopy = Arrays.copyOf(persons, dim);
        Arrays.sort(personsCopy, getComparator());
        return personsCopy;
    }
    protected abstract Comparator<Person> getComparator();
}
