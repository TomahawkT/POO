package primerosParciales;

public class DictionaryEntry<K extends Comparable<? super K>> implements Comparable<DictionaryEntry<K>>{
    private final K word;
    private final String definition;

    public DictionaryEntry(K word, String definition) {
        this.word = word;
        this.definition = definition;
    }
    @Override
    public String toString(){
        return String.format("{ %s <> %s }", word.toString(), definition);
    }

    @Override
    public int compareTo(DictionaryEntry<K> o) {
        int cmp = word.compareTo(o.word);
        if (cmp == 0){
            return definition.compareTo(o.definition);
        }
        return cmp;
    }

    public K getWord() {
        return word;
    }
}
