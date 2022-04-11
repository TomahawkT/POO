package TP4;

public class PlainText implements HTMLText{
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public PlainText(String text) {
        setText(text);
    }

    @Override
    public String source() {
        return text;
    }

    @Override
    public String toString() {
        return source();
    }
}

