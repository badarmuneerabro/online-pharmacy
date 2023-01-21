package com.pharmacy.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect 
{
	private static Connect connect;
    private Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/online-pharmacy?autoReconnect=true&useSSL=false";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Got Connection!");
        } catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Exception: " + e);
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static Connect getInstance() {
        return (connect == null) ? connect = new Connect() : connect;
    }

    public PreparedStatement getPreparedStatement(String query)
    {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex);
        }
        
        return statement;
    }
}
