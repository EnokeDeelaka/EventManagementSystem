/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_register_controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import login_register_design.Login_Form;
import login_register_design.My_CNX;

/**
 *
 * @author enoke
 */
public class LoginController {
    public boolean checkLogin(String uname, String pword){
        PreparedStatement st;
        ResultSet rs;
        
         // get the username & password
        String username = uname;
        String password = String.valueOf(pword);
        
        
        //create a select query to check if the username and the password exist in the database
         String query ="SELECT * FROM `users` WHERE `username` = ? AND `password` = ?";
         
           
        // show a message if the username or the password fields are empty
        if(username.trim().equals("username"))
        {
            JOptionPane.showMessageDialog(null, "Enter Your Username", "Empty Username", 2);
        }
        else if(password.trim().equals("password"))
        {
            JOptionPane.showMessageDialog(null, "Enter Your Password", "Empty Password", 2);
        }
        else{
            
            try {
            st = My_CNX.getConnection().prepareStatement(query);
            
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
            
            if(rs.next())
            {
                return true;
            }else{
                // error message
                JOptionPane.showMessageDialog(null, "Invalid Username / Password","Login Error",2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        return false;
    }
}
