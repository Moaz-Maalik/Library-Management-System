import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Borrower extends Person {
    List<Book> _reservedBooksList = new ArrayList<>();
    List<Book> _loanBooksList = new ArrayList<>();

    Borrower(int id, String name, String password, String phoneNumber, String address) {
        super(id, name, password, phoneNumber, address);
    }

    public List<Book> get_reservedBooksList() {
        return _reservedBooksList;
    }

    public void set_reservedBooksList(List<Book> _reservedBooksList) {
        this._reservedBooksList = _reservedBooksList;
    }

    public List<Book> get_loanBooksList() {
        return _loanBooksList;
    }

    public void set_loanBooksList(List<Book> _loanBooksList) {
        this._loanBooksList = _loanBooksList;
    }
    public void addLoanBook(Book book){
        this._loanBooksList.add(book);
    }
    public void addRerservedBook(Book book){
        this._reservedBooksList.add(book);
    }
    public void removeReservedBook(Book book){
        this._reservedBooksList.remove(book);
    }
    @Override
    public String toString() {
        return "Borrower{" +
                "\nId                : " + _id +
                "\nName              : " + _name +
                "\nPassword          : " + _password +
                "\nPhoneNumber       : " + _phoneNumber +
                "\nAddress           : " + _address +
                "\nReservedBooksList : " + _reservedBooksList +
                "\nLoanBooksList     : " + _loanBooksList +
                "\n}";
    }
    public String print(){
        return super.toString();
    }
    public void EditBorrower() {
        Scanner scanner = new Scanner(System.in);
        int editOption = -1;

        String editMenu = "\n1 to edit id" +
                "\n2 to edit name" +
                "\n3 to edit password" +
                "\n4 to edit phoneNumber" +
                "\n5 to edit address" +
                "\n0 to exit";
        while (editOption != 0) {
            Color.Print(Color.ANSI_GREEN, editMenu);
            editOption = Integer.parseInt(scanner.nextLine());
            if (editOption == 1) {
                int id;
                System.out.println("Previous id = " + this.get_id());
                System.out.println("Enter New Borrower id ");
                id = Integer.parseInt(scanner.nextLine());
                this.set_id(id);
            } else if (editOption == 2) {
                String name;
                System.out.println("Previous name = " + this.get_name());
                System.out.println("Enter New Borrower Name ");
                name = scanner.nextLine();
                this.set_name(name);
            } else if (editOption == 3) {
                String password;
                System.out.println("Previous Password = " + this.get_password());
                System.out.println("Enter New Borrower Password ");
                password = scanner.nextLine();
                this.set_password(password);
            } else if (editOption == 4) {
                String phoneNumber;
                System.out.println("Previous Phone Number = " + this.get_phoneNumber());
                System.out.println("Enter New Borrower PhoneNumber ");
                phoneNumber = scanner.nextLine();
                this.set_phoneNumber(phoneNumber);
            } else if (editOption == 5) {
                String address;
                System.out.println("Previous address = " + this.get_address());
                System.out.println("Enter New Borrower address ");
                address = scanner.nextLine();
                this.set_address(address);
            } else {
                Color.Print(Color.ANSI_RED, "Option dose not exists");
            }
        }
    }
}
