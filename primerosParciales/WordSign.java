package primerosParciales;

import java.util.function.Function;

public class WordSign{
    private String word;
    private int height, width;
    public WordSign(String word, int height, int width) {
        this.word = word;
        this.height = height;
        this.width = width;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                s.append(word);
                s.append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public CustomWordSign custom(Function<String, String> function){
        return new CustomWordSign(function.apply(word),height, width);
    }
    public ResizableWordSign resizable(int multiplier){
        return new ResizableWordSign(word, height * multiplier, width * multiplier);
    }
}