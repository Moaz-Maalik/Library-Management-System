import javax.swing.plaf.ColorUIResource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    public static Library instance = new Library();
    public Staff currentLogedIn;
    private double fineAmount = 1000.00;

    private Library() {
        this._db = DBAPI.getInstance();
        this.populateDB();
        this.currentLogedIn = _librarianList.get(1);
    }

    private List<Librarian> _librarianList = new ArrayList<>();
    private List<DeskClerk> _deskClerkList = new ArrayList<>();
    private List<Borrower> _borrowerList = new ArrayList<>();
    private List<Book> _bookList = new ArrayList<>();
    private List<Loan> _loanList = new ArrayList<>();
    private List<Dvd> _dvdList = new ArrayList<>();
    private List<Magazine> _magazineList = new ArrayList<>();
    private List<Reserve> _reserveList = new ArrayList<>();
    private DBAPI _db;

    public static Library getInstance() {
        return instance;
    }

    public void populateDB() {
        this._librarianList = _db.getLibrarian();
        this._borrowerList = _db.getBorrower();
        this._deskClerkList = _db.getDeskClerk();
        this._bookList = _db.getBooks();
        this._dvdList = _db.getDvd();
        this._magazineList = _db.getMagazine();
    }

    public void populateLoan() {
        _loanList = new ArrayList<>();
        List<LoanDb> loanDbList = _db.getLoanDB();

        for (LoanDb ldb : loanDbList) {
            Loan l = new Loan(ldb._loanID, ldb._issueDate, ldb._returnDate, ldb._finePaid, getStaff(ldb._issuer), getStaff(ldb._receiver), getBorrower(ldb._borrower), getBook(ldb._book));
            System.out.println(l);
        }
    }

    public Staff getStaff(int id) {
        for (DeskClerk deskClerk : _deskClerkList) {
            System.out.println(deskClerk);
            if (deskClerk.getId() == id) {
                return deskClerk;
            }
        }
        for (Librarian librarian : _librarianList) {
            System.out.println(librarian);
            if (librarian.getId() == id) {
                return librarian;
            }
        }
        return null;
    }

    public Book getBook(int id) {
        for (Book book : _bookList) {
            if (book.get_ID() == id)
                return book;
        }
        return null;
    }

    public Borrower getBorrower(int id) {
        for (Borrower borrower : _borrowerList) {
            if (borrower.get_id() == id)
                return borrower;
        }
        return null;
    }

    public void PrintAllLibrarians() {
        for (Librarian librarian : _librarianList) {
            Color.Print(Color.ANSI_BLUE, librarian.toString());
            System.out.println("------------------------------------------------");
        }
    }

    public void PrintAllDeskClerk() {
        for (DeskClerk deskClerk : _deskClerkList) {
            System.out.println("------------------------------------------------");
            Color.Print(Color.ANSI_CYAN, deskClerk.toString());
        }
    }

    public void PrintAllBooks() {
        for (Book book : _bookList) {
            System.out.println("------------------------------------------------");
            Color.Print(Color.ANSI_PURPLE, book.toString());

        }
    }

    public void AddNewDeskClerk() {
        Scanner scanner = new Scanner(System.in);
        int id = 6000;
        System.out.println("Enter New Name");
        String name = scanner.nextLine();
        System.out.println("Enter New Password");
        String password = scanner.nextLine();
        System.out.println("Enter New Phone Number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter New Address");
        String address = scanner.nextLine();
        System.out.println("Enter New Salary");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter New DeskNumber");
        int deskNumber = Integer.parseInt(scanner.nextLine());
        DeskClerk deskClerk = new DeskClerk(id, name, password, phoneNumber, address, salary, deskNumber);
        _deskClerkList.add(deskClerk);
    }

    public void AddNewLibrarian() {
        Scanner scanner = new Scanner(System.in);
        int id = 6000;
        System.out.println("Enter New Name");
        String name = scanner.nextLine();
        System.out.println("Enter New Password");
        String password = scanner.nextLine();
        System.out.println("Enter New Phone Number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter New Address");
        String address = scanner.nextLine();
        System.out.println("Enter New Salary");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter New Office Number");
        int officeNumber = Integer.parseInt(scanner.nextLine());
        Librarian librarian = new Librarian(id, name, password, phoneNumber, address, salary, officeNumber);
        _librarianList.add(librarian);
    }

    public void AddNewBorrower() {
        Scanner scanner = new Scanner(System.in);
        int id = 6000;
        System.out.println("Enter New Name");
        String name = scanner.nextLine();
        System.out.println("Enter New Password");
        String password = scanner.nextLine();
        System.out.println("Enter New Phone Number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter New Address");
        String address = scanner.nextLine();
        Borrower borrower = new Borrower(id, name, password, phoneNumber, address);
        _borrowerList.add(borrower);
    }

    public void AddNewBook() {
        Scanner scanner = new Scanner(System.in);
        int id = 698;
        System.out.println("Enter New Name");
        String name = scanner.nextLine();
        System.out.println("Enter New Title");
        String title = scanner.nextLine();
        Book book = new Book(id, name, false, title, false);
        _bookList.add(book);
    }

    public void AddNewDvd() {
        Scanner scanner = new Scanner(System.in);
        int id = 56;
        System.out.println("Enter New Name");
        String name = scanner.nextLine();
        System.out.println("Enter New Composer Name");
        String composer = scanner.nextLine();
        Dvd dvd = new Dvd(id, name, composer);
        _dvdList.add(dvd);
    }

    public void AddNewMagazine() {
        Scanner scanner = new Scanner(System.in);
        int id = 56;
        System.out.println("Enter New Name");
        String name = scanner.nextLine();
        System.out.println("Enter New Company Name");
        String company = scanner.nextLine();
        Magazine magazine = new Magazine(id, name, company);
        _magazineList.add(magazine);

    }

    public void EditDeskClerk() {
        Scanner scanner = new Scanner(System.in);
        DeskClerk deskClerk = null;
        System.out.println("Enter id");
        int dId = Integer.parseInt(scanner.nextLine());
        for (DeskClerk deskClerk1 : _deskClerkList) {
            if (deskClerk1.getId() == dId) {
                deskClerk = deskClerk1;
            }
        }
        if (deskClerk == null) {
            Color.Print(Color.ANSI_RED, "DeskClerk dose not exists");
        } else {
            deskClerk.EditDeskClerk();
        }
    }

    public void EditBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The ID to edit : ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Book book : _bookList) {
            if (book.get_ID() == id) {
                book.EditBook();
                return;
            }
        }
        Color.Print(Color.ANSI_RED, "No Book Found with " + id);
    }

    public void EditBorrower() {
        Scanner scanner = new Scanner(System.in);
        Borrower borrower = null;
        System.out.println("Enter id");
        int dId = Integer.parseInt(scanner.nextLine());
        for (Borrower borrower1 : _borrowerList) {
            if (borrower1.get_id() == dId) {
                borrower = borrower1;
            }
        }
        if (borrower == null) {
            Color.Print(Color.ANSI_RED, "Librarian dose not exists");
        } else {
            borrower.EditBorrower();
        }

    }

    public void EditLibrarian() {
        Scanner scanner = new Scanner(System.in);
        Librarian librarian = null;
        System.out.println("Enter id");
        int dId = Integer.parseInt(scanner.nextLine());
        for (Librarian librarian1 : _librarianList) {
            if (librarian1.getId() == dId) {
                librarian = librarian1;
            }
        }
        if (librarian == null) {
            Color.Print(Color.ANSI_RED, "Librarian dose not exists");
        } else {
            librarian.EditLibrarian();
        }


    }

    public void GiveLoanToBorrower() {
        Scanner scanner = new Scanner(System.in);
        int loanId = 1;
        int option = -1;
        Borrower borrower = _borrowerList.get(1);
        Book book = _bookList.get(2);
        System.out.println("Enter The Borrower Info");
        while (option != 0) {
            System.out.println("1 to Print All Borrower");
            System.out.println("2 to Enter Id of Borrower");
            System.out.println("0 to Exit");
            System.out.print("Enter New Option : ");
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.PrintAllBorrower();
            } else if (option == 2) {
                int id;
                Borrower temp = null;
                while (temp == null) {
                    System.out.print("Enter The Id Of Borrower : ");
                    id = Integer.parseInt(scanner.nextLine());
                    temp = getBorrower(id);
                    if (temp == null) {
                        Color.Print(Color.ANSI_RED, "Borrower with id " + id + " dose not exist");
                    }
                }
                borrower = temp;
                option = 0;
            } else if (option == 0) {
                Color.Print(Color.ANSI_RED, "Operation Rejected");
                return;
            }

        }
        int option1 = -1;
        System.out.println("Enter The Book Info");
        while (option1 != 0) {
            System.out.println("1 to Print All Book");
            System.out.println("2 to Enter Id of Book");
            System.out.println("0 to Exit");
            option1 = Integer.parseInt(scanner.nextLine());
            if (option1 == 1) {
                this.PrintAllBooks();
            } else if (option1 == 2) {
                int id;
                Book temp = null;
                while (temp == null) {
                    System.out.print("Enter The Id Of Book : ");
                    id = Integer.parseInt(scanner.nextLine());
                    temp = getBook(id);
                    if (temp == null) {
                        Color.Print(Color.ANSI_RED, "Book with id " + id + " dose not exist");
                    }
                }
                book = temp;
                option1 = 0;
            } else if (option1 == 0) {
                Color.Print(Color.ANSI_RED, "Operation Rejected");
                return;
            }
        }
        if (borrower == null || book == null) {
            Color.Print(Color.ANSI_RED, "Operation Cancelled due to incomplete requirements");
            return;
        }
        System.out.println("Enter Issue Date");
        System.out.print("Enter Day   : ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Month : ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Year  : ");
        int year = Integer.parseInt(scanner.nextLine());
        Date IssueDate = new Date(year, month, day);
        System.out.println("Enter return Date");
        System.out.print("Enter Day   : ");
        day = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Month : ");
        month = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Year  : ");
        year = Integer.parseInt(scanner.nextLine());
        Date returnDate = new Date(year, month, day);


        Loan loan = new Loan(loanId, IssueDate, returnDate, false, this.currentLogedIn, null, borrower, book);
        _loanList.add(loan);
        borrower.get_loanBooksList().add(book);
        book.get_loanList().add(loan);
        Color.Print(Color.ANSI_GREEN_BACKGROUND + Color.ANSI_WHITE, "New Loan Book Added");
    }

    public void PrintAllBorrower() {
        for (Borrower borrower : _borrowerList) {
            Color.Print(Color.ANSI_YELLOW, borrower.toString());
        }
    }

    public void PrintAllLoans() {
        for (Loan loan : _loanList) {
            Color.Print(Color.ANSI_CYAN, loan.toString());
        }
    }

    public void RenewLoan() {
        Scanner scanner = new Scanner(System.in);
        String optionmenu = "\n1 to Print All loans" +
                "\n2 to Enter id to Renew Loan" +
                "\n0 to Exit";
        int option = -1;
        while (option != 0) {
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.PrintAllLoans();
            } else if (option == 2) {
                Loan loan = null;
                while (loan == null) {
                    System.out.print("Enter Loan Id : ");
                    int id = Integer.parseInt(scanner.nextLine());
                    loan = this.getLoan(id);
                    if (loan == null) {
                        Color.Print(Color.ANSI_RED, "Loan dose not exists");
                    }
                }
                System.out.println("Enter extended return Date");
                System.out.print("Enter Day   : ");
                int day = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Month : ");
                int month = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Year  : ");
                int year = Integer.parseInt(scanner.nextLine());
                Date returnDate = new Date(year, month, day);
                loan.set_returnDate(returnDate);
            }
        }
    }

    public Loan getLoan(int id) {
        for (Loan loan : _loanList) {
            if (loan.get_loanID() == id)
                return loan;
        }
        return null;
    }

    public void Run() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String options =
                "\n1 for DeskClerk Options" +
                        "\n2 for Librarians Options" +
                        "\n3 for Borrowers Options" +
                        "\n4 for Books Options" +
                        "\n5 for Item Options" +
                        "\n6 for Loan Options" +
                        "\n7 for Reserve" +
                        "\n0 to exit";

        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, options);
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.deskClerkMenu();
            } else if (option == 2) {
                this.librarianMenu();
            } else if (option == 3) {
                this.borrowerMenu();
            } else if (option == 4) {
                this.BookMenu();
            } else if (option == 5) {
                this.itemMenu();
            } else if (option == 6) {
                this.loanMenu();
            } else if (option == 7) {
                this.reserveMenu();
            } else if (option == 0) {
                Color.Print(Color.ANSI_RED, "Exiting the Program");
            } else {
                Color.Print(Color.ANSI_RED, "Option dose not exists");
            }

        }
    }

    /**
     * @param bookArg = book subject query
     * @return returns the books having book subject query
     */
    public ArrayList<Book> searchBookBySubject(String bookArg) {

        ArrayList<Book> booksToReturn = new ArrayList<Book>();

        for (Book book : this._bookList) {
            if (book.get_subject().contains(bookArg)) {
                booksToReturn.add(book);
            }
        }

        return booksToReturn;
    }

    /**
     * @param authorArg = author query
     * @return returns the books having book title query
     */
    public ArrayList<Book> searchBookByAuthor(String authorArg) {

        ArrayList<Book> booksToReturn = new ArrayList<Book>();

        for (Book book : this._bookList) {
            boolean found = false;
            for (int i = 0; i < book.get_authorList().size() && !found; i++) {
                if (book.get_authorList().get(i).contains(authorArg)) {
                    booksToReturn.add(book);
                }
            }
        }

        return booksToReturn;
    }

    /**
     * @param composerArg = composer query
     * @return returns the dvds having composer query
     */
    public ArrayList<Dvd> searchDvdByComposer(String composerArg) {

        ArrayList<Dvd> dvdsToReturn = new ArrayList<Dvd>();

        for (Dvd dvd : this._dvdList) {
            if (dvd._composer.contains(composerArg))
                dvdsToReturn.add(dvd);
        }

        return dvdsToReturn;
    }

    /**
     * @param companyArg = company query
     * @return returns the magazines having company query
     */
    public ArrayList<Magazine> searchMagazineByCompany(String companyArg) {

        ArrayList<Magazine> magazinesToReturn = new ArrayList<Magazine>();

        for (Magazine magazine : this._magazineList) {
            if (magazine._company.contains(companyArg)) {
                magazinesToReturn.add(magazine);
            }
        }

        return magazinesToReturn;
    }

    /**
     * @param itemName = item name query
     * @return returns the items having itemName query
     */
    public ArrayList<Item> searchItemsByName(String itemName) {

        ArrayList<Item> itemsToReturn = new ArrayList<Item>();

        for (Item item : this._magazineList) {
            if (item.get_name().contains(itemName)) {
                itemsToReturn.add(item);
            }
        }

        for (Item item : this._dvdList) {
            if (item.get_name().contains(itemName)) {
                itemsToReturn.add(item);
            }
        }

        for (Item item : this._bookList) {
            if (item.get_name().contains(itemName)) {
                itemsToReturn.add(item);
            }
        }

        return itemsToReturn;
    }

    public ArrayList<Item> megaSearch() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String options = "\n1 for Search Item by Name" +
                "\n2 for Search Book by Subject" +
                "\n3 for Search Book by Author" +
                "\n4 for Search Magazine by Company" +
                "\n5 for Search Dvd by Composer" +
                "\n0 to exit";
        ArrayList<Item> items = new ArrayList<Item>();

        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, options);
            option = scanner.nextInt();
            scanner.nextLine();
            String searchQuery;
            if (option == 1) {
                System.out.print("Enter Item Name: ");
                searchQuery = scanner.nextLine();
                items = this.searchItemsByName(searchQuery);
            } else if (option == 2) {
                System.out.print("Enter Book Subject: ");
                searchQuery = scanner.nextLine();
                ArrayList<Book> books = this.searchBookBySubject(searchQuery);
                for (Book book : books) {
                    items.add(book);
                }
            } else if (option == 3) {
                System.out.print("Enter Book Author Name: ");
                searchQuery = scanner.nextLine();
                ArrayList<Book> books = this.searchBookByAuthor(searchQuery);
                for (Book book : books) {
                    items.add(book);
                }

            } else if (option == 4) {
                System.out.print("Enter Magazine Company: ");
                searchQuery = scanner.nextLine();
                ArrayList<Magazine> magazines = this.searchMagazineByCompany(searchQuery);
                for (Magazine magazine : magazines) {
                    items.add(magazine);
                }

            } else if (option == 5) {
                System.out.print("Enter DVD Composer: ");
                searchQuery = scanner.nextLine();
                ArrayList<Dvd> dvds = this.searchDvdByComposer(searchQuery);
                for (Dvd dvd : dvds) {
                    items.add(dvd);
                }

            } else {
                Color.Print(Color.ANSI_RED, "Option dose not exists");
            }

        }
        return items;
    }

    void DeleteDeskClerk() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter DeskClerk Id to delete");
        int id = Integer.parseInt(scanner.nextLine());
        _deskClerkList.removeIf(deskClerk -> deskClerk.getId() == id);
    }

    void deskClerkMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String optionMenu =
                "\n1 to view DeskClerk" +
                        "\n2 to edit DeskClerk" +
                        "\n3 to delete DeskClerk" +
                        "\n4 to create DeskClerk" +
                        "\n0 to Exit(Previous Menu)";
        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, optionMenu);
            System.out.print("Enter The Option : ");
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.PrintAllDeskClerk();
            } else if (option == 2) {
                this.EditDeskClerk();
            } else if (option == 3) {
                DeleteDeskClerk();
            } else if (option == 4) {
                this.AddNewDeskClerk();
            } else if (option == 0) {
                Color.Print(Color.ANSI_RED, "Exiting to Previous Menu");

            } else {
                Color.Print(Color.ANSI_RED, "Option dose not exists");

            }
        }
    }

    void DeleteLibrarian() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Librarian Id to delete");
        int id = Integer.parseInt(scanner.nextLine());
        _librarianList.removeIf(librarian -> librarian.get_id() == id);
    }

    void librarianMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String optionMenu =
                "\n1 to view Librarian" +
                        "\n2 to edit Librarian" +
                        "\n3 to delete Librarian" +
                        "\n4 to create Librarian" +
                        "\n0 to Exit(Previous Menu)";
        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, optionMenu);
            System.out.print("Enter The Option : ");
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.PrintAllLibrarians();
            } else if (option == 2) {
                this.EditLibrarian();
            } else if (option == 3) {
                this.DeleteLibrarian();
            } else if (option == 4) {
                this.AddNewLibrarian();
            } else if (option == 0) {
                Color.Print(Color.ANSI_RED, "Exiting to Previous Menu");

            } else {
                Color.Print(Color.ANSI_RED, "Option dose not exists");

            }
        }
    }

    void DeleteBorrower() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Borrower Id to delete");
        int id = Integer.parseInt(scanner.nextLine());
        _borrowerList.removeIf(borrower -> borrower.get_id() == id);
    }

    void borrowerMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String optionMenu =
                "\n1 to view Borrower" +
                        "\n2 to edit Borrower" +
                        "\n3 to delete Borrower" +
                        "\n4 to create Borrower" +
                        "\n0 to Exit(Previous Menu)";
        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, optionMenu);
            System.out.print("Enter The Option : ");
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.PrintAllBorrower();
            } else if (option == 2) {
                this.EditBorrower();
            } else if (option == 3) {
                this.DeleteBorrower();
            } else if (option == 4) {
                this.AddNewBorrower();
            } else if (option == 0) {
                Color.Print(Color.ANSI_RED, "Exiting to Previous Menu");

            } else {
                Color.Print(Color.ANSI_RED, "Option dose not exists");

            }
        }
    }


    void DeleteBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Librarian Id to delete");
        int id = Integer.parseInt(scanner.nextLine());
        _bookList.removeIf(book -> book.get_ID() == id);
    }

    void loanMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String optionMenu =
                "\n1 to view Loans" +
                        "\n2 to Renew" +
                        "\n3 to Create Loan" +
                        "\n0 to Exit(Previous Menu)";
        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, optionMenu);
            System.out.print("Enter The Option : ");
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.PrintAllLoans();
            } else if (option == 2) {
                this.RenewLoan();
            } else if (option == 3) {
                this.GiveLoanToBorrower();
            } else if (option == 0) {
                Color.Print(Color.ANSI_RED, "Exiting to Previous Menu");

            } else {
                Color.Print(Color.ANSI_RED, "Option dose not exists");
            }
        }
    }

    void BookMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String optionMenu =
                "\n1 to view Book" +
                        "\n2 to edit Book" +
                        "\n3 to delete Book" +
                        "\n4 to create Book" +
                        "\n0 to Exit(Previous Menu)";
        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, optionMenu);
            System.out.print("Enter The Option : ");
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.PrintAllBooks();
            } else if (option == 2) {
                this.EditBook();
            } else if (option == 3) {
                this.DeleteBook();
            } else if (option == 4) {
                this.AddNewBook();
            } else if (option == 0) {
                Color.Print(Color.ANSI_RED, "Exiting to Previous Menu");

            } else {
                Color.Print(Color.ANSI_RED, "Option dose not exists");

            }
        }
    }

    void printAllReservations() {
        for (Reserve reserve : _reserveList) {
            System.out.println("--------------------------------");
            Color.Print(Color.ANSI_PURPLE, reserve.toString());
        }
    }

    void removeReservation() {
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());

        for (Reserve reserve : _reserveList) {
            if (reserve.get_id() == id) {
                reserve.get_book().removeReserve(reserve);
                reserve.get_borrower().removeReservedBook(reserve.get_book());
            }
        }
        _reserveList.removeIf(reserve -> reserve.get_id() == id);


        System.out.println("Reservation of id " + id + " Removed");
    }

    void RemoveReservationMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String optionMenu = "\n1 to view All reservation" +
                "\n2 to Enter Id to remove Reservation" +
                "\n0 to Exit";

        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, optionMenu);
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.printAllReservations();
            } else if (option == 2) {
                this.removeReservation();
            } else if (option == 0) {
                Color.Print(Color.ANSI_RED, "Exiting to Previous Menu");

            } else {
                Color.Print(Color.ANSI_RED, "Option dose not exists");

            }
        }
    }

    void addNewReservation() {
        Scanner scanner = new Scanner(System.in);
        int id = 5;
        System.out.println("Enter Reservation Date");
        System.out.print("Enter Day   : ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Month : ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Year  : ");
        int year = Integer.parseInt(scanner.nextLine());
        Date ReserveDate = new Date(year, month, day);


        Borrower borrower = getBorrower();
        Book book = getBook();
        if (borrower == null || book == null) {
            Color.Print(Color.ANSI_RED, "Operation Cancelled due to incomplete requirements");
            return;
        }

        borrower.get_reservedBooksList().add(book);
        Reserve reserve = new Reserve(id, ReserveDate, borrower, book);
        book.addReserve(reserve);
    }

    Borrower getBorrower() {
        Borrower borrower = null;
        Scanner scanner = new Scanner(System.in);
        String optionMenu = "\n1 to Print Borrower" +
                "\n2 to select borrower by id";
        int option = -1;
        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, optionMenu);
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.PrintAllBorrower();
            } else if (option == 2) {
                int id = Integer.parseInt(scanner.nextLine());
                borrower = getBorrower(id);
                option = 0;
            }
        }
        if (borrower == null) {
            Color.Print(Color.ANSI_RED, "Id dont exit");
        }
        return borrower;
    }

    Book getBook() {
        Book book = null;
        Scanner scanner = new Scanner(System.in);
        String optionMenu = "\n1 to Print Book" +
                "\n2 to select Book by id";
        int option = -1;
        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, optionMenu);
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.PrintAllBorrower();
            } else if (option == 2) {
                int id = Integer.parseInt(scanner.nextLine());
                book = getBook(id);
                option = 0;
            }
        }
        if (book == null) {
            Color.Print(Color.ANSI_RED, "Id dont exit");
        }
        return book;
    }

    void reserveMenu() {

        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String optionMenu =
                "\n1 to view Reservations" +
                        "\n2 to Add new Reservation" +
                        "\n3 to Remove Reservation" +
                        "\n0 to Exit(Previous Menu)";
        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, optionMenu);
            System.out.print("Enter The Option : ");
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.printAllReservations();
            } else if (option == 2) {
                this.addNewReservation();
            } else if (option == 3) {
                this.RemoveReservationMenu();
            } else if (option == 0) {
                Color.Print(Color.ANSI_RED, "Exiting to Previous Menu");

            } else {
                Color.Print(Color.ANSI_RED, "Option dose not exists");
            }
        }
    }

    void printAllDvd() {
        for (Dvd dvd : _dvdList) {
            System.out.println("--------------------------");
            Color.Print(Color.ANSI_WHITE, dvd.toString());
        }
    }

    void printAllMagazine() {
        for (Magazine magazine : _magazineList) {
            System.out.println("--------------------------");
            Color.Print(Color.ANSI_WHITE, magazine.toString());
        }
    }

    void itemMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String optionMenu =
                "\n1 to view Dvd" +
                        "\n2 to view Magazine" +
                        "\n3 to add DVD" +
                        "\n4 to add Magazine" +
                        "\n0 to Exit(Previous Menu)";
        while (option != 0) {
            Color.Print(Color.ANSI_GREEN, optionMenu);
            System.out.print("Enter The Option : ");
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.printAllDvd();
            } else if (option == 2) {
                this.printAllMagazine();
            } else if (option == 3) {
                this.AddNewDvd();
            } else if (option == 4) {
                this.AddNewMagazine();
            } else if (option == 0) {
                Color.Print(Color.ANSI_RED, "Exiting to Previous Menu");

            } else {
                Color.Print(Color.ANSI_RED, "Option dose not exists");
            }
        }
    }
}
