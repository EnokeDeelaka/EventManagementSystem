/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_register_controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login_register_design.Event_User;
import static login_register_design.My_CNX.getConnection;

/**
 *
 * @author enoke
 */
public class EventFunctionController {
    public void executeSQlQuery(String query,String message){
        Connection con = getConnection();
        Statement st;
        
        try {
            st = con.createStatement();
            if((st.executeUpdate(query)) == 1)
            {
                
//                DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
//                model.setRowCount(0);
//                Show_Users_In_JTable();
                
                JOptionPane.showMessageDialog(null," Data "+message+" Succesfully");
            }else{
                JOptionPane.showMessageDialog(null," Data not "+message);
                    
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Event_User> getUsersList(){
        ArrayList<Event_User> usersList = new ArrayList<Event_User>();
        Connection connection = getConnection();
        String query = "SELECT * FROM  `event` ";
        Statement st;
        ResultSet rs;
        
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Event_User user;
            while(rs.next()){
                user = new Event_User(rs.getInt("Event_id"),rs.getString("Event_type"),rs.getString("Event_name"),rs.getString("Event_venue"),rs.getString("Event_address"),rs.getString("Event_city"),rs.getInt("Customer_id"),rs.getString("Customer_ideas"));
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }
}
