package primerosParciales;

public class RepeatableElement extends Element{
    private final Element element;
    private final int times;

    public RepeatableElement(Element element, int times) {
        this.element = element;
        this.times = times;
    }

    @Override
    public String getContents() {
        StringBuilder s = new StringBuilder();
        for(int i=0; i < times; i++){
            s.append(element.getContents());
            if(i != times-1){
                s.append("\n");
            }
        }
        return s.toString();
    }
}
