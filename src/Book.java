import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book extends Item {
    boolean _isIssued;
    String _subject;
    boolean _isReferenced;

    public boolean is_isIssued() {
        return _isIssued;
    }

    public void set_isIssued(boolean _isIssued) {
        this._isIssued = _isIssued;
    }

    public String get_subject() {
        return _subject;
    }

    public void set_subject(String _subject) {
        this._subject = _subject;
    }

    public boolean is_isReferenced() {
        return _isReferenced;
    }

    public void set_isReferenced(boolean _isReferenced) {
        this._isReferenced = _isReferenced;
    }

    public List<String> get_authorList() {
        return _authorList;
    }

    public void set_authorList(List<String> _authorList) {
        this._authorList = _authorList;
    }

    public List<Loan> get_loanList() {
        return _loanList;
    }

    public void set_loanList(List<Loan> _loanList) {
        this._loanList = _loanList;
    }

    public List<Reserve> get_reserveList() {
        return _reserveList;
    }

    public void set_reserveList(List<Reserve> _reserveList) {
        this._reserveList = _reserveList;
    }

    public void addReserve(Reserve reserve) {
        this._reserveList.add(reserve);
    }

    public void removeReserve(Reserve reserve) {
        _reserveList.remove(reserve);
    }

    public void addLoan(Loan loan) {
        this._loanList.add(loan);
    }

    public void removeLoan(Loan loan) {
        this._loanList.remove(loan);
    }

    List<String> _authorList = new ArrayList<>();
    List<Loan> _loanList = new ArrayList<>();
    List<Reserve> _reserveList = new ArrayList<>();

    Book(int ID, String name, boolean isIssued, String title, boolean isReferenced) {
        super(ID, name);
        this._isIssued = isIssued;
        this._subject = title;
        this._isReferenced = isReferenced;
    }

    String print() {
        return "Book{" +
                "\nID              : " + _ID +
                "\nName            : " + _name +
                "\nIsIssued        : " + _isIssued +
                "\nTitle           : " + _subject +
                "\nIsReferenced    : " + _isReferenced +
                "\nAuthorList      : " + _authorList +
                "\n} ";
    }

    @Override
    public String toString() {
        return "Book{" +
                "\nID              : " + _ID +
                "\nName            : " + _name +
                "\nIsIssued        : " + _isIssued +
                "\nTitle           : " + _subject +
                "\nIsReferenced    : " + _isReferenced +
                "\nAuthorList      : " + _authorList +
                "\nLoanList        : " + _loanList +
                "\nReserveList     : " + _reserveList +
                "\n} ";
    }

    public void EditBook() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String optionMenu = new String("\n1 to edit ID" +
                "\n2 to edit Name" +
                "\n3 to edit Title" +
                "\n4 to edit AuthorList" +
                "\n0 to Exit");

        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, optionMenu);
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                System.out.println("Previous Name = " + this._name);
                System.out.print("Enter The New Name : ");
                this._name = scanner.nextLine();
            } else if (option == 2) {
                System.out.println("Previous Title = " + this._subject);
                System.out.print("Enter The New Title : ");
                this._subject = scanner.nextLine();
            } else if (option == 3) {
                System.out.println("Previous Authors = [" + _authorList + "]");
                System.out.print("Enter The New Auther : ");
                this._authorList.add(scanner.nextLine());
            } else if (option == 4) {
                Color.Print(Color.ANSI_WHITE + Color.ANSI_RED_BACKGROUND, "Exiting Menu :)");
            } else {
                Color.Print(Color.ANSI_RED, "Option Dose not Exist");
            }
        }
    }
}
