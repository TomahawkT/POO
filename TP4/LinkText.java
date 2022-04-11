package TP4;

public class LinkText implements HTMLText{

    private HTMLText element;
    private String link;

    public LinkText(HTMLText element, String link) {
        this.element = element;
        this.link = link;
    }

    @Override
    public String source() {
        return String.format("<a href:\"%s\">%s</a>", link, element.source());
    }

    @Override
    public String toString(){
        return source();
    }
}
