package DAO;

import Model.Book;
import Model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DAO.DBConnection.getConnection;

public class CategoryDaoImpl implements CategoryDAO {


    @Override
    public Category findCategoryById(int categoryID) {
        String sql = "SELECT*FROM Category WHERE category_id LIKE ? ";

        Category category = null;
        try {
            category = null;
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, categoryID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                category = new Category(
                        resultSet.getInt("category_id"),
                        resultSet.getString("category_name"));
            }
            getConnection().close();

        } catch (SQLException sq) {
            sq.printStackTrace();
        }
        return category;


    }

    @Override
    public void addCategory(Category categoryname) {

        String sql = "INSERT INTO Category (category_name ) VALUES(?)";

        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, categoryname.getCategoryName());
            ResultSet re = preparedStatement.executeQuery();

            getConnection().close();


        } catch (SQLException sq) {
            sq.printStackTrace();
        }



    }

    @Override
    public void setCategoryForBook(Category category, Book book) {
        book.setBookCategory(category);
    }

    @Override
    public void removeCategoryFromBook( Book book) {
    book.setBookCategory(null);
    }

}
