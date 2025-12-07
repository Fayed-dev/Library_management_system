package DAO;

import Model.Book;

import java.util.List;

public interface BookDAO {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void deleteBook(Book book);

    public List<Book> getAllBooks();

    public List<Book> getBookByTitle(String bookTitle);

    public Book getBookById(int bookId);

    public void increaseAvailableCopies(Book book);

    public void decreaseAvailableCopies(Book book);

}
