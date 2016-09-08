package com.proAlter.conect;

import org.firebirdsql.jdbc.FBDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conect_to_bd {
    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private final String url = "jdbc:firebirdsql:192.168.20.13/3050:alter_curent?lc_ctype=WIN1251;sql_dialect=3";
    private final String user = "sysdba";
    private final String pass = "sysadmin";
    Connection connection;

    public conect_to_bd() {

        try {
            Driver driver = new FBDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


