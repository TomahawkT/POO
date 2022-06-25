package primerosParciales;

public class TextElement extends Element{
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String getContents() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
