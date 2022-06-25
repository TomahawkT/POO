package TP7;

public class RankedBook implements Comparable<RankedBook>{
    Book book;
    Genre genre;
    private int ranking;

    public RankedBook(Book book, Genre genre) {
        this.book = book;
        this.genre = genre;
    }
    public RankedBook(Book book){
        this.book = book;
        this.ranking = 1;
    }
    public RankedBook(RankedBook rankedBook){
        this.book = rankedBook.book;
        this.ranking = rankedBook.ranking + 1;
        this.genre = rankedBook.genre;
    }
    @Override
    public String toString(){
        return book + " : " + ranking;
    }

    @Override
    public int compareTo(RankedBook o) {
        int rankingCmp = ranking - o.ranking;
        if (rankingCmp == 0){
            return book.compareTo(o.book);
        }
        return rankingCmp;
    }

}
