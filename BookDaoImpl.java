package DAO;

import Model.Book;
import Model.Category;

import javax.management.Query;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static DAO.DBConnection.getConnection;

public class BookDaoImpl implements BookDAO {
    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO books (book_title , book_author , available_copies , category_id) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getAvailableCopies());
            preparedStatement.setInt(4, CategoryDAO.findCategorybyName(book.getBookCategory().getCategoryName()));
            ResultSet resultSet = preparedStatement.executeQuery();
            getConnection().close();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }

        System.out.println("Book added successfully");

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(Book book) {
        String sql = "DELETE FROM Books WHERE book_id = ? ";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, book.getBook_id());
            ResultSet resultSet = preparedStatement.executeQuery();
            getConnection().close();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        String sql = "SELECT*FROM Books";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book newBook = new Book(resultSet.getInt("Book_id"),
                        resultSet.getString("book_author"),
                        resultSet.getString("book_title"),
                        resultSet.getInt("available_copies"),
                        resultSet.getString("book_category"),
                        resultSet.getInt("is_available"));
                allBooks.add(newBook);
            }
            getConnection().close();
            return allBooks;

        } catch (SQLException sq) {
            sq.printStackTrace();
        }


        return List.of();
    }

    @Override
    public List<Book> getBookByTitle(String bookTitle) {
        String sql = "SELECT*FROM Books WHERE book_title LIKE %?% ";
        List<Book> allBooks = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, bookTitle);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book newBook = new Book(resultSet.getInt("Book_id"),
                        resultSet.getString("book_author"),
                        resultSet.getString("book_title"),
                        resultSet.getInt("available_copies"),
                        resultSet.getString("book_category"),
                        resultSet.getInt("is_available"));
                allBooks.add(newBook);
            }
            getConnection().close();
            return allBooks;

        } catch (SQLException sq) {
            sq.printStackTrace();
        }


        return List.of();
    }

    @Override
    public Book getBookById(int bookId) {

        String sql = "SELECT*FROM Books WHERE book_id = ? ";
        try {
            Book newBook = new Book();
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 newBook = new Book(resultSet.getInt("Book_id"),
                        resultSet.getString("book_author"),
                        resultSet.getString("book_title"),
                        resultSet.getInt("available_copies"),
                        resultSet.getString("book_category"),
                        resultSet.getInt("is_available"));

            }
            getConnection().close();
            return newBook;
        } catch (SQLException sq) {
            sq.printStackTrace();
        }


        return null;
    }

    @Override
    public void increaseAvailableCopies(Book book) {
        String sql = "UPDATE Books SET available_copies = available_copies+1 where book_title = ? ";
        // List<Book> allBooks = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, book.getBookName());
            ResultSet resultSet = preparedStatement.executeQuery();
            getConnection().close();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }

    }

    @Override
    public void decreaseAvailableCopies(Book book) {
        String sql = "UPDATE Books SET available_copies = available_copies - 1 where book_title = ? " ;
        // List<Book> allBooks = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1,book.getBookName());
            ResultSet resultSet = preparedStatement.executeQuery();
            getConnection().close();
        }catch (SQLException sq){
            sq.printStackTrace();
        }


    }
}
