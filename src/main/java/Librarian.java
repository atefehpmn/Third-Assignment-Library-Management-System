import java.util.Objects;

public class Librarian {
    private String username;
    private String password;
    public Librarian(){
        username = "admin";
        password = "admin";
    }
    public Librarian(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() { return password; }

    public String getUsername() { return username; }

    public void setPassword(String password) { this.password = password; }

    public void setUsername(String username) { this.username = username; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return Objects.equals(username, librarian.username) && Objects.equals(password, librarian.password);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
