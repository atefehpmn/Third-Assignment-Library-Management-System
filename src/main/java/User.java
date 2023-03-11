import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String username;
    private String password;
    private ArrayList<Book> borrowed = new ArrayList<>();
    public User(){}
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void rentBook(Book book, Library library){
        if (library.doesBookExist(book.getName())){
            borrowed.add(book);
            library.decreaseBook(book.getName());
            System.out.println("Successfully borrowed.");
        }
        else{
            System.out.println("Sorry the book " + book.getName() + " is not available at the moment.");
        }
    }

    public void returnBook(Book book, Library library){
        if (borrowed.contains(book)){
            borrowed.remove(book);
            library.increaseBook(book.getName());
            System.out.println("Successfully returned");
        }
        else {
            System.out.println("This user hasn't borrowed this book.");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Book> getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(ArrayList<Book> borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", borrowed=" + borrowed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(borrowed, user.borrowed);
    }

}
