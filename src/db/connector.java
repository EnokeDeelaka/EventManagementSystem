/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author enoke
 */
public class connector {
    public static Connection getConnection() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
    Connection cn = (Connection)
            DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
    
    return cn;
            
    }
    
   private static connector dbConnect;
    private Connection conn;

    public static connector getInstance() throws ClassNotFoundException, SQLException {
        return (dbConnect == null) ? (new connector()) : (dbConnect);
    }
}
