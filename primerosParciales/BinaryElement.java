package primerosParciales;

public class BinaryElement extends Element{
    private final Element above, below;

    public BinaryElement(Element above, Element below) {
        this.above = above;
        this.below = below;
    }

    @Override
    public String getContents() {
        return above + "\n" + below;
    }
}
