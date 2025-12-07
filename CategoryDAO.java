package DAO;

import Model.Book;
import Model.Category;

public interface CategoryDAO {

    public static int findCategorybyName(String categoryName) {
        return 0;
    }

    public Category findCategoryById(int categoryID);

    public void addCategory(Category categoryName);

    public void setCategoryForBook(Category category , Book book) ;

    public void removeCategoryFromBook( Book book) ;

}
