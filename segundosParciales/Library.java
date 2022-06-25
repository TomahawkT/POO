package segundosParciales;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, BookInfo> booksInfo = new HashMap<>();
    private final Map<Person, Loan> loans = new HashMap<>();

    public Library addBook(String bookName, int stock){
        booksInfo.put(bookName, new BookInfo(bookName, stock));
        return this;
    }

    public void borrowBook(Person borrower, String bookName, LocalDate date){
        if (loans.containsKey(borrower)){
            throw new IllegalStateException();
        }
        BookInfo bookInfo = booksInfo.get(bookName);
        if (bookInfo == null){
            throw new IllegalStateException("Book not found");
        }
        bookInfo.borrowBook();
        loans.put(borrower, new Loan(borrower, bookName, date));
    }
    public void returnBook(Person person) {
        Loan loan = loans.remove(person);
        if (loan == null) {
            throw new IllegalArgumentException();
        }
        BookInfo info = booksInfo.get(loan.getBookName());
        info.returnBook();
    }
    public void printDueLoansBooks(LocalDate date) {
        System.out.println("Due loans at " + date);
        for (Loan loan: loans.values()) {
            if (loan.isDueAt(date)) {
                System.out.println(loan);
            }
        }
        System.out.println();
    }

}
