package Model;

public class Book {
    private int book_id;
    private String author;
    private String bookName;
    private int availableCopies;
    private Category bookCategory;
    private Boolean available;

    public Book(int book_id, String author, String bookName, int availableCopies, Category bookCategory) {
        this.book_id = book_id;
        this.author = author;
        this.bookName = bookName;
        this.availableCopies = availableCopies;
        this.bookCategory = bookCategory;
        this.available = false;
    }

    public Book(int book_id, String author, String bookName, int availableCopies, String bookCategory , int isBorrowed) {
        this.book_id = book_id;
        this.author = author;
        this.bookName = bookName;
        this.availableCopies = availableCopies;
        this.bookCategory.setCategoryName(bookCategory) ;
        if(isBorrowed == 0)
        this.available = false;
        else this.available = true;
    }

    public Book(String author, String bookName, int availableCopies, Category bookCategory) {
        this.author = author;
        this.bookName = bookName;
        this.availableCopies = availableCopies;
        this.bookCategory = bookCategory;
        this.available = false;

    }

    public Boolean getBorrowed() {
        return available;
    }

    public void setAvailable(Boolean available) {
        available = available;
    }

    public Book(String author, String bookName, Category bookCategory) {
        this.author = author;
        this.bookName = bookName;
        this.bookCategory = bookCategory;
        this.available = false;

    }

    public Book() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public Category getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(Category bookCategory) {
        this.bookCategory = bookCategory;
    }
}
