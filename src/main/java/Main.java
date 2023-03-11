
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Library!");
        Library library = new Library();
        Librarian librarian = new Librarian();
        library.addLibrarian(librarian);
        runMenu(library);

    }

    public static void runMenu(Library library){
        Scanner in = new Scanner(System.in);
        String username;
        String password;
        int choice = 0;
        while (choice != 3) {
            System.out.println("Which kind of account you want to login as? \n1. Librarian  \n2. User \n3. Exit the program");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Username: ");
                    username = in.next();
                    System.out.println("Password: ");
                    password = in.next();
                    Librarian librarian = new Librarian(username, password);
                    if (library.doesLibrarianExist(librarian)){
                        int op = 0;
                        while (op != 12) {
                            System.out.println("How can I help you?  \n1. Add books  \n2. Remove books  \n3. Search a book" +
                                    "\n4. Update the inventory of a book \n5. Add user \n6. Remove user \n7. Search a user " +
                                    "\n8. Update a user account \n9. Add librarian \n10. Remove librarian \n11. Search a librarian" +
                                    "\n12. Log out");
                            op = in.nextInt();
                            switch (op) {
                                case 1:
                                    Book book = getBookData();
                                    System.out.println("Number of books:");
                                    int num = in.nextInt();
                                    library.addBook(book, num);
                                    System.out.println("Book(s) added successfully!");
                                    break;
                                case 2:
                                    in.nextLine();
                                    System.out.println("Name of the book: ");
                                    String name = in.nextLine();
                                    if (library.doesBookExist(name)) {
                                        library.removeBook(name);
                                    }
                                    break;
                                case 3:
                                    in.nextLine();
                                    System.out.println("Name of the book: ");
                                    name = in.nextLine();
                                    library.searchBook(name);
                                    break;
                                case 4:
                                    in.nextLine();
                                    System.out.println("Name of the book: ");
                                    name = in.nextLine();
                                    if (library.doesBookExist(name)) {
                                        System.out.println("Do you want to add or remove copies of " + name + "? \n1. Add \n2. Remove");
                                        int up = in.nextInt();
                                        switch (up) {
                                            case 1:
                                                System.out.println("How many copies do you want to add?");
                                                library.updateBook(name, in.nextInt());
                                                break;
                                            case 2:
                                                System.out.println("How many copies do you want to remove?");
                                                library.updateBook(name, -1 * in.nextInt());
                                                break;
                                        }
                                    } else {
                                        System.err.println("Book does not exist!");
                                    }
                                    break;
                                case 5:
                                    in.nextLine();
                                    User newUser = getUserData();
                                    library.addUser(newUser);
                                    System.out.println("User added.");
                                    break;
                                case 6:
                                    in.nextLine();
                                    User toRemoveUser = getUserData();
                                    library.removeUser(toRemoveUser);
                                    break;
                                case 7:
                                    in.nextLine();
                                    System.out.println("Enter username: ");
                                    String searchUser = in.nextLine();
                                    library.searchUser(searchUser);
                                    break;
                                case 8:
                                    in.nextLine();
                                    User upUser = getUserData();
                                    System.out.println("How do you want to update the account? \n1. Add to Borrowed books \n2. Remove from borrowed books");
                                    int up = in.nextInt();
                                    Book changeBook = getBookData();
                                    switch (up) {
                                        case 1:
                                            upUser.rentBook(changeBook, library);
                                            break;
                                        case 2:
                                            upUser.returnBook(changeBook, library);
                                            break;
                                    }
                                    break;
                                case 9:
                                    in.nextLine();
                                    Librarian newLibrarian = getLibrarianData();
                                    library.addLibrarian(newLibrarian);
                                    System.out.println("Librarian added");
                                    break;
                                case 10:
                                    in.nextLine();
                                    Librarian oldLibrarian = getLibrarianData();
                                    library.removeLibrarian(oldLibrarian);
                                    break;
                                case 11:
                                    in.nextLine();
                                    System.out.println("Username: ");
                                    String librarianUser = in.nextLine();
                                    library.searchLibrarian(librarianUser);
                                    break;
                            }
                        }

                    }
                    else {
                        System.err.println("Librarian with this username and password doesn't exist!");
                    }
                    break;
                case 2:
                    System.out.println("1. Sign up \n2. Log in");
                    User user = new User();
                    switch (in.nextInt()){
                        case 1:
                            in.nextLine();
                            String newUsername = in.nextLine();
                            while (library.doesUsernameExist(newUsername)){
                                System.err.println("Username already taken! \nPlease enter another one: ");
                                newUsername = in.nextLine();
                            }
                            System.out.println("Username available");
                            System.out.println("Password: ");
                            User newUser = new User(newUsername, in.nextLine());
                            library.addUser(newUser);
                            break;
                        case 2:
                            in.nextLine();
                            user = getUserData();
                    }
                    if (library.doesUserExist(user)){
                        int op = 0;
                        while (op != 3){
                            System.out.println("How can I help you? \n1. Borrow a book \n2. Return a book \n3. Log out");
                            op = in.nextInt();
                            switch (op){
                                case 1:
                                    Book borrowBook = getBookData();
                                    user.rentBook(borrowBook, library);
                                    break;
                                case 2:
                                    Book returnBook = getBookData();
                                    user.returnBook(returnBook, library);
                                    break;
                            }
                        }
                    }
                    else {
                        System.err.println("User with this username and password doesn't exist!");
                    }
                    break;
            }
        }
    }

    public static Book getBookData(){
        Scanner in = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Name of the book: ");
        book.setName(in.nextLine());
        System.out.println("Name of the author: ");
        book.setAuthor(in.nextLine());
        System.out.println("Year Published: ");
        book.setYear(in.nextInt());
        System.out.println("ISBN: ");
        book.setISBN(in.next());
        return book;
    }

    public static User getUserData(){
        Scanner in = new Scanner(System.in);
        User user = new User();
        System.out.println("Username: ");
        user.setUsername(in.nextLine());
        System.out.println("Password: ");
        user.setPassword(in.nextLine());
        return user;
    }
    public static Librarian getLibrarianData(){
        Scanner in = new Scanner(System.in);
        Librarian librarian = new Librarian();
        System.out.println("Username: ");
        librarian.setUsername(in.nextLine());
        System.out.println("Password: ");
        librarian.setPassword(in.nextLine());
        return librarian;
    }
}
