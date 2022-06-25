package primerosParciales;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayTVCatalog implements TVCatalog{
    private TVShow[] tvShows = new TVShow[INITIAL_DIM];
    private int dim = 0;
    private static final int INITIAL_DIM = 5;

    private static final int DEFAULT_MIN = 0;
    private static final int DEFAULT_MAX = 10;
    private double min = DEFAULT_MIN,max = DEFAULT_MAX;

    @Override
    public TVCatalog addTVShow(String name, double rating) {
        if(dim == tvShows.length){
            resize();
        }
        tvShows[dim++] = new TVShow(name, rating);
        return this;
    }

    private void resize(){
        tvShows = Arrays.copyOf(tvShows, tvShows.length + INITIAL_DIM);
    }

    @Override
    public void setRatingRange(double min, double max) {
        if (!TVShow.validateRating(min) || !TVShow.validateRating(max)){
            throw new IllegalArgumentException("Invalid parameters");
        }
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<TVResponse> iterator() {
        return new Iterator<TVResponse>() {
            final double currentMin = min;
            final double currentMax = max;
            int idx = 0;

            @Override
            public boolean hasNext() {
                return idx < dim;
            }

            @Override
            public TVResponse next() {
                if (!hasNext()){
                    throw new NoSuchElementException();
                }
                TVShow tvShow = tvShows[idx++];
                boolean isInRange = tvShow.getRating() >= currentMin && tvShow.getRating() <= currentMax;
                return new TVResponse(tvShow, isInRange);
            }
        };
    }
}
