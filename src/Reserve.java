import java.sql.Date;

public class Reserve {
    int _id;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    Date _reserveDate;
    Borrower _borrower;
    Book _book;

    public Date get_reserveDate() {
        return _reserveDate;
    }

    public void set_reserveDate(Date _reserveDate) {
        this._reserveDate = _reserveDate;
    }

    public Borrower get_borrower() {
        return _borrower;
    }

    public void set_borrower(Borrower _borrower) {
        this._borrower = _borrower;
    }

    public Book get_book() {
        return _book;
    }

    public void set_book(Book _book) {
        this._book = _book;
    }

    Reserve(int id,Date reserveDate, Borrower borrower, Book book) {
        this._id = id;
        this._book = book;
        this._borrower = borrower;
        this._reserveDate = reserveDate;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "\nReserve Date = " + _reserveDate +
                "\nBorrower = " + _borrower +
                "\nBook = " + _book +
                '}';
    }

    void printInfo() {
        System.out.println(this);
    }
}

