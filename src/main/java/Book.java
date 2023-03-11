
public class Book {
    private String name;
    private String author;
    private int year;
    private String ISBN;
    public Book(){}
    public Book(String name, String author, int year, String ISBN, int num){
        this.name = name;
        this.author = author;
        this.year = year;
        this.ISBN = ISBN;
    }

    public String getName() { return name; }

    public String getAuthor() { return author; }

    public int getYear() { return year; }

    public String getISBN() { return ISBN; }

    public void setAuthor(String author) { this.author = author; }

    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    public void setName(String name) { this.name = name; }

    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
