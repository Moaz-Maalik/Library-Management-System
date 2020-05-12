import java.sql.Date;

public class Loan {
    int _loanID;
    Date _issueDate;
    Date _returnDate;
    boolean _finePaid;
    Staff _issuer;
    Staff _receiver;
    Borrower _borrower;
    Book _book;

    Loan(int loanID, Date issueDate, Date returnDate, boolean finePaid, Staff issuer, Staff receiver, Borrower borrower, Book book) {
        this._loanID = loanID;
        this._issueDate = issueDate;
        this._returnDate = returnDate;
        this._finePaid = finePaid;
        this._issuer = issuer;
        this._receiver = receiver;
        this._borrower = borrower;
        this._book = book;
    }

    Loan(int loadid, Date returnDate,Date issueDate,boolean finePaid) {
        this._loanID =loadid;
        this._issueDate = issueDate;
        this._returnDate = returnDate;
        this._finePaid = finePaid;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "\nLoan Id       : " + _loanID +
                "\nissueDate     : " + _issueDate +
                "\nreturnDate    : " + _returnDate +
                "\nfinePaid      : " + _finePaid +
                "\nissuer        : " + _issuer +
                "\nreceiver      : " + _receiver +
                "\nborrower      : " + _borrower.print() +
                "\nbook          : " + _book.print() +
                '}';
    }

    public int get_loanID() {
        return _loanID;
    }

    public void set_loanID(int _loanID) {
        this._loanID = _loanID;
    }

    public Date get_issueDate() {
        return _issueDate;
    }

    public void set_issueDate(Date _issueDate) {
        this._issueDate = _issueDate;
    }

    public Date get_returnDate() {
        return _returnDate;
    }

    public void set_returnDate(Date _returnDate) {
        this._returnDate = _returnDate;
    }

    public boolean is_finePaid() {
        return _finePaid;
    }

    public void set_finePaid(boolean _finePaid) {
        this._finePaid = _finePaid;
    }

    public Staff get_issuer() {
        return _issuer;
    }

    public void set_issuer(Staff _issuer) {
        this._issuer = _issuer;
    }

    public Staff get_receiver() {
        return _receiver;
    }

    public void set_receiver(Staff _receiver) {
        this._receiver = _receiver;
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
}
