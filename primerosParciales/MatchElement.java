package primerosParciales;

public class MatchElement<T> {
    private final T element;
    private final boolean matches;

    public MatchElement(T element, boolean matches) {
        this.element = element;
        this.matches = matches;
    }

    @Override
    public String toString() {
        return String.format("### %s : %s ###", element, matches ? "Match" : "No Match");
    }
    public boolean matches(){
        return matches;
    }
}
