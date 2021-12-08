/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Ticket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class TicketDAO extends BaseDAO{
    public static List<Ticket> GetTicketList(int user_id) {
        openConn();
        List<Ticket> tickets = new ArrayList<>();
        String sql =  "select t.id, t.schedule_id, t.chair_id, t.user_id, t.code, m.name, r.room_name, c.chair_name, ms.schedule_date, ms.start_time, ms.price from ticket as t, movie as m, room as r, chair as c, movie_schedule as ms where t.schedule_id = ms.id and ms.schedule_date >= CURDATE() and ms.movie_id = m.id and ms.room_id = r.id and c.id = t.chair_id and t.user_id = " + user_id;
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("schedule_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("chair_id"),
                        resultSet.getString("code"),
                        resultSet.getString("room_name"),
                        resultSet.getString("chair_name"),
                        resultSet.getString("schedule_date"),
                        resultSet.getString("start_time"),
                        resultSet.getString("name")          
                );
                tickets.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConn();
        return tickets;
    }
    
    public static String Order(int user_id, int chair_id, int schedule_id) {
       
        openConn();
        String code = randomString();
        String sql = "insert into ticket(schedule_id, chair_id, user_id, code) values(?, ?, ?, ?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, schedule_id);
            statement.setInt(2, chair_id);
            statement.setInt(3, user_id);
            statement.setString(4, code);
            statement.execute();
            return code;
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConn();
        return "";
    }
    
    public static String randomString() {
        int a = 65;
        int b = 90;
        Random rand = new Random();
        int capicity = 8;
        StringBuilder sb = new StringBuilder(capicity);
        for(int i = 0; i< capicity; i++) {
            int random = a + (int)(rand.nextFloat() * (b -a + 1));
            sb.append((char) random);
        }
        String randString = sb.toString();
        return  randString;
    }
}
