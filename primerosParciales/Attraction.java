package primerosParciales;

import java.util.Objects;

public class Attraction {
    private final String name;

    public Attraction(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Attraction)){
            return false;
        }
        Attraction attraction = (Attraction) o;
        return name.equals(attraction.toString());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
