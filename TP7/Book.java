package TP7;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private final String title, author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Book)){
            return false;
        }
        Book book = (Book) o;
        return title.equals(book.getTitle()) && author.equals(book.getAuthor());
    }

    @Override
    public int hashCode(){
        return Objects.hash(title, author);
    }

    @Override
    public int compareTo(Book o) {
        int titleCmp = title.compareTo(o.title);
        if (titleCmp != 0){
            return titleCmp;
        }
        return author.compareTo(o.author);
    }
}
