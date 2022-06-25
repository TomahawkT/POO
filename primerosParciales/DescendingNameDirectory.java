package primerosParciales;

import java.util.Comparator;

public class DescendingNameDirectory extends Directory{
    public DescendingNameDirectory(int limit){
        super(limit);
    }
    @Override
    public Person[] persons(){
        return persons(Comparator.reverseOrder());
    }
}
