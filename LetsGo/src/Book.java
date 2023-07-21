public class Book {
    private int id;
    private String title;
    private String author;
    private String ISBN;
    private String genre;
    private int quantityAvailable;

    // Constructors
    public Book(int id, String title, String author, String ISBN, String genre, int quantityAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.quantityAvailable = quantityAvailable;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    @Override
    public String toString() {
        return  title + " "+ author +" " + " " + genre;
    }
}