package primerosParciales;

public enum ChairType {
    AMANCAY(true),
    HORSETOOTH(false),
    SIXFOLD(true);

    private boolean skier;
    ChairType(boolean skier){
        this.skier = skier;
    }
    public boolean forSkier(){
        return skier;
    }
}
