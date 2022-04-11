package TP4;

public class FormatText implements HTMLText{

    private HTMLText element;
    private String format;

    public FormatText(HTMLText element, String format) {
        this.element = element;
        this.format = format;
    }

    @Override
    public String source() {
        return String.format("<%s>%s<%s>", format, element.source(), format);
    }
}
