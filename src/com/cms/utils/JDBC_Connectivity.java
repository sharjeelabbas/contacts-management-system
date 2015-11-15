package com.cms.utils;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class JDBC_Connectivity {
	
	private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "root";
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/cms";

    private static Connection getConnection() throws Exception {
        Class.forName(DATABASE_DRIVER);
        return (Connection) DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    }

    public static Statement getStatement() throws Exception {
        return (Statement) getConnection().createStatement();
    }

    public static PreparedStatement getPreparedStatement(String query) throws Exception {
        return (PreparedStatement) getConnection().prepareStatement(query);
    }
}
