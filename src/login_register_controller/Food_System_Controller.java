/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_register_controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author enoke
 */
public class Food_System_Controller {
    public boolean addPackage(int pkg, int evtid){
        try {
            Connection conn;
            conn=db.connector.getConnection();
            
            String sql="UPDATE event set package=? WHERE Event_id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, pkg);
            pst.setInt(2, evtid);
            int executeUpdate = pst.executeUpdate();
            if (executeUpdate>0) {
                JOptionPane.showMessageDialog(null, "Added!");
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Food_System_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
