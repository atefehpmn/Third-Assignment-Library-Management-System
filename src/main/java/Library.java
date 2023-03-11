import java.util.ArrayList;
import java.util.HashMap;
public class Library {
    //book related functions
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Librarian> librarians = new ArrayList<>();
    HashMap <String, Integer> amount = new HashMap <>();
    public void addBook(Book book, int num){
        books.add(book);
        if (amount.get(book.getISBN()) == null){
            amount.put(book.getISBN(), num);
        }
        else {
            int cnt = amount.get(book.getISBN());
            cnt += num;
            amount.put(book.getISBN(), cnt);
        }
        amount.put(book.getISBN(), num);
    }

    public void removeBook(String name){
        if (getIndexOf(name) != -1) {
            books.remove(getIndexOf(name));
            amount.remove(name);
            System.out.println(name + " successfully removed");
            return;
        }
        System.out.println("There was no such book.");
    }

    public int getIndexOf(String name){
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void searchBook(String name){
        if (getIndexOf(name) != -1){
            System.out.println(books.get(getIndexOf(name)));
        }
        else {
            System.out.println("Book not Found in The Library!");
        }
    }

    public void updateBook(String name, int num){
        if (num > 0) {
            for (int i = 0; i < num; i++) {
                increaseBook(name);
            }
        }
        else {
            for (int i = 0; i > num; i--){
                decreaseBook(name);
            }
        }
        System.out.println("Book updated!");
    }

    public boolean doesBookExist(String name){
        if (getIndexOf(name) != -1){
            if (amount.get(books.get(getIndexOf(name)).getISBN()) > 0){
                System.out.println("There are " + amount.get(books.get(getIndexOf(name)).getISBN()) + " " + name + " books available.");
                return true;
            }
            else {
                System.out.println("All " + name + " books are borrowed at the moment!");
                return false;
            }
        }
        else {
            System.out.println("There are no " + name + " books available.");
            return false;
        }
    }

    public void increaseBook(String name){
        int cnt = amount.get(books.get(getIndexOf(name)).getISBN());
        amount.put(books.get(getIndexOf(name)).getISBN(), cnt + 1);
    }

    public void decreaseBook(String name){
        int cnt = amount.get(books.get(getIndexOf(name)).getISBN());
        amount.put(books.get(getIndexOf(name)).getISBN(), cnt - 1);
    }

    //user related functions

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        for (User searchUser : users) {
            if (searchUser.equals(user)){
                users.remove(user);
                return;
            }
        }
        System.out.println("There is no such user.");
    }

    public void searchUser(String username){
        for (User searchUser : users){
            if (searchUser.getUsername().equals(username)){
                System.out.println(searchUser);
                return;
            }
        }
        System.out.println("There's no user with username " + username);
    }

    public boolean doesUserExist(User user){
        for (User searchUser : users){
            if (searchUser.equals(user)){
                return true;
            }
        }
        return false;
    }

    public boolean doesUsernameExist(String username){
        for (User searchUser : users){
            if (searchUser.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    //librarian related functions

    public void addLibrarian(Librarian librarian){
        librarians.add(librarian);
    }

    public void removeLibrarian(Librarian librarian){
        if (doesLibrarianExist(librarian)) {
            librarians.remove(librarian);
        }
        else {
            System.err.println("Librarian with this username and password doesn't exist!");
        }
    }

    public void searchLibrarian(String username){
        for (Librarian searchlibr : librarians){
            if (searchlibr.getUsername().equals(username)){
                System.out.println(searchlibr);
                return;
            }
        }
        System.out.println("There's no librarian with username " + username);
    }

    public boolean doesLibrarianExist(Librarian librarian){
        for (Librarian searchlibr : librarians){
            if (searchlibr.equals(librarian)){
                return true;
            }
        }
        return false;
    }


}
