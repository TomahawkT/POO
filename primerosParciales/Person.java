package primerosParciales;

public class Person implements Comparable<Person> {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        return String.format("Person Name=%s, Age=%d", name, age);
    }

    @Override
    public int compareTo(Person o) {
        int cmp = getName().compareTo(o.getName());
        if(cmp == 0){
            return Integer.compare(o.getAge(),getAge());
        }
        return cmp;
    }
}
