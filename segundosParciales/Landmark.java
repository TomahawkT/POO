package segundosParciales;

public class Landmark implements Comparable<Landmark>{
    private final String landmarkName;
    private final double rating;

    public Landmark(String landmarkName, double rating) {
        this.landmarkName = landmarkName;
        this.rating = rating;
    }

    @Override
    public int compareTo(Landmark o) {
        int cmp = Double.compare(o.rating, rating);
        if (cmp == 0){
            cmp = landmarkName.compareTo(o.landmarkName);
        }
        return cmp;
    }

    @Override
    public String toString(){
        return String.format("# %s # %.1f #", landmarkName, rating);
    }
}
