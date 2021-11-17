/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilities.Utility;

/**
 *
 * @author ngomi
 */
public class UserDAO extends BaseDAO{
    public static boolean getLogin(String username, String password) {
        openConn();
        User user = new User();
        String sql = "select * from user where email = '" + username + "' and password = '" + password + "'";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                return  true;
            }          
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConn(); 
        return  false;
    }
    
    public static void Insert(User user) {
        openConn();
        String sql = "insert into user(fullname,email,phone_number,address,password,role_id,create_at,update_at,gender) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhoneNumber());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPassWord());
            statement.setInt(6, user.getRoleId());
            statement.setString(7, Utilities.Utility.CovertDateToString(user.getCreateAccountDate()));
            statement.setString(8, Utilities.Utility.CovertDateToString(user.getUpdateAccoutDate()));
            statement.setString(9, user.getGender());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
        closeConn();
    }
    
    
}
