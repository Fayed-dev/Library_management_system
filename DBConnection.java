package DAO;

import java.sql.*;

public class DBConnection {

    private static final String host = "localhost";
    private static final int port = 3307;
    private static final String DB_NAME = "Library_management_system";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123123";
    private static final String URL = "jdbc:mysql://" +  host +":"+port+"/"+DB_NAME;


    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);

        } catch (SQLException se){
            se.printStackTrace();
            return null;

        }
    }

}
