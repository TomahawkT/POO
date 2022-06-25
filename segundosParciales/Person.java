package segundosParciales;

import java.util.Objects;

public class Person {
    private String name;
    private Role role;

    public Person(String name, Role role) {
        this.name = name;
        this.role = role;
    }
    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
    public int getLoanDays(){
        return role.getLoanDays();
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Person person)){
            return false;
        }
        return name.equals(person.name);
    }
}
