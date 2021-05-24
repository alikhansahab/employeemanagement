package com.example.demo.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionProvider {
    
    private ConnectionProvider(){

    }

    public static Connection getConnection()
    {
        Connection conn = null;
        try
        {
            Class.forName(DatabaseDetails.DATABASE_DRIVER);
            conn = DriverManager.getConnection(DatabaseDetails.DATABASE_URL,
            DatabaseDetails.DATABASE_USER,DatabaseDetails.DATABASE_PASS);
            return conn;
        }
        catch(Exception e)
        {
            System.out.println("Connection Error"+e.getMessage());
        }
        return conn;
    }

}
