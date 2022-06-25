package primerosParciales;

public class TVResponse{
    private TVShow tvShow;
    private boolean inRange;
    public TVResponse (TVShow tvShow, boolean inRange){
        this.tvShow = tvShow;
        this.inRange = inRange;
    }
    public String toString(){
        return tvShow.toString() + (inRange ? " In Range" : " Out of Range");
    }
}
