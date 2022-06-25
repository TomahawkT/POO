package segundosParciales;

import java.time.LocalDate;

public class Loan {
    private final Person person;
    private final String bookName;
    private final LocalDate date;

    public Loan(Person person, String bookName, LocalDate date) {
        this.person = person;
        this.bookName = bookName;
        this.date = date;
    }

    public boolean isDueAt(LocalDate when){
        return when.isAfter(date.plusDays(person.getLoanDays()));
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return String.format("%s (%s-%s)", person, bookName, date);
    }

}
