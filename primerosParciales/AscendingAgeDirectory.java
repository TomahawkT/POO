package primerosParciales;

public class AscendingAgeDirectory extends Directory{
    public AscendingAgeDirectory(int limit){
        super(limit);
    }
    @Override
    public Person[] persons(){
        return persons((o1,o2) -> {
            int cmp = Integer.compare(o1.getAge(), o2.getAge());
            if(cmp == 0){
                return o1.getName().compareTo(o2.getName());
            }
            return cmp;
        });
    }
}
