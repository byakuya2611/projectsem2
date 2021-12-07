/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Chair;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngomi
 */
public class ChairDAO extends BaseDAO{
    public static List<Chair> getChairList(int room_id) { 
        openConn();
        List<Chair> listChairs = new ArrayList<>();
        String sql = "select * from chair where room_id = " + room_id + " order by chair_column asc, chair_row asc";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Chair chair = new Chair(
                        resultSet.getInt("id"),
                        resultSet.getInt("chair_column"),
                        resultSet.getInt("chair_row"),
                        resultSet.getString("chair_name"),
                        resultSet.getInt("room_id")
                );
                listChairs.add(chair);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChairDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConn();
        return listChairs;
    }     
    
    public static int getNumberofColumn(int room_id) {
        openConn();
        int result  = 0;
        String sql = "select max(`chair_column`) from chair where room_id = " + room_id;
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChairDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConn();
        return result;
    }
    
    public static int getNumberOfRow(int room_id) {
        openConn();
        int result  = 0;
        String sql = "select max(`chair_row`) from chair where room_id = " + room_id;
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChairDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConn();
        return result;
    }

    public static List<Integer> getChairOrdered(int room_id) {
        openConn();
        List<Integer> list = new ArrayList<>();
        String sql = "select t.chair_id from ticket as t, movie_schedule as ms where t.schedule_id = ms.id and ms.room_id = " + room_id;
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                list.add(resultSet.getInt(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChairDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConn();
        return list;
    }
}

