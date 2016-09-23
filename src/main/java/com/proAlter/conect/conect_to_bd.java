package com.proAlter.conect;
import org.firebirdsql.jdbc.FBDriver;



import java.sql.*;



public class conect_to_bd {
    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:firebirdsql:192.168.20.13/3050:alter_curent?lc_ctype=WIN1251;sql_dialect=3";
    private static final String user = "sysdba";
    private static final String password = "sysadmin";

    private Connection connection;

    public conect_to_bd() {
        Driver driver = new FBDriver();
        try {
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // JDBC variables for opening and managing connection
//    private static Connection con;
//    private static Statement stmt;
//    private static ResultSet rs;
}

