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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class TicketDAO extends BaseDAO{
    public static List<Ticket> getListTicket() {
        openConn();
        List<Ticket> tickets = new ArrayList<>();
        String sql = "select * from ticket";
        
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("movie_id"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("chair_id"),
                        resultSet.getInt("price"),
                        resultSet.getInt("discount"),
                        resultSet.getString("create_at"),
                        resultSet.getString("update_at")
                );
                tickets.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConn();
        return tickets;
    }
    public static void Insert(Ticket ticket) {
        openConn();
        String sql = "insert into ticket(movie_id,room_id,chair_id,price,discount,create_at,update_at) values(?,?,?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, ticket.getMovieId());
            statement.setInt(2, ticket.getRoomId());
            statement.setString(3, ticket.getChairId());
            statement.setInt(4, ticket.getPrice());
            statement.setInt(5, ticket.getDiscount());
            statement.setString(6, Utilities.Utility.ConvertDateToString(ticket.getCreateTicketDate()));
            statement.setString(7, Utilities.Utility.ConvertDateToString(ticket.getUpdateTicketDate()));
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConn();
    }
    
    public static void Update(Ticket ticket, Integer id) {
        openConn();
        String sql = "update ticket set movie_id = ?, room_id = ?, chair_id = ?, price = ?, discount = ?, create_at = ?, update_at = ? where id = " + id;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, ticket.getMovieId());
            statement.setInt(2, ticket.getRoomId());
            statement.setString(3, ticket.getChairId());
            statement.setInt(4, ticket.getPrice());
            statement.setInt(5, ticket.getDiscount());
            statement.setString(6, Utilities.Utility.ConvertDateToString(ticket.getCreateTicketDate()));
            statement.setString(7, Utilities.Utility.ConvertDateToString(ticket.getUpdateTicketDate()));
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConn();
    }
    
    public static void Delete(Integer id) {
        openConn();
        String sql = "delete from ticket where id = " + id;
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConn();
    }
    
    public static List<Ticket> Find(Integer id) {
        List<Ticket> tickets = new ArrayList<>();
        openConn();
        String sql = "select * from ticket where id = " + id;
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("movie_id"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("chair_id"),
                        resultSet.getInt("price"),
                        resultSet.getInt("discount"),
                        resultSet.getString("create_at"),
                        resultSet.getString("update_at")
                );
                tickets.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConn();
        return tickets;
    }
}
