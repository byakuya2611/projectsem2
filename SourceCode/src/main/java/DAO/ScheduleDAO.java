/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Schedule;
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
public class ScheduleDAO extends BaseDAO{
    public static List<Schedule> getScheduleList(int idMovie) {
        openConn();
        List<Schedule> scheduleList = new ArrayList<>();
        String sql = "select s.id, s.movie_id, s.room_id ,s.schedule_date, s.start_time, s.price, r.room_name from movie_schedule as s, room as r where s.room_id = r.id and s.movie_id = " + idMovie + " limit 10;";
        try {
            statement  = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Schedule schedule = new Schedule(
                        resultSet.getInt("id"),
                        resultSet.getInt("movie_id"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("schedule_date"),
                        resultSet.getString("start_time"),
                        resultSet.getString("room_name"),
                        resultSet.getInt("price")
                );
                scheduleList.add(schedule);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConn();
        return scheduleList;
    }
    
    public static void Insert(Schedule schedule) {
        openConn();
        String sql = "insert into movie_schedule(movie_id, room_id, schedule_date, start_time, price) values (?, ?, ?, ?, ?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, schedule.getMovie_id());
            statement.setInt(2, schedule.getRoom_id());
            statement.setString(3, schedule.getDate());
            statement.setString(4, schedule.getTime());
            statement.setInt(5, schedule.getPrice());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConn();
    }
    
    public static void Update(Schedule schedule, Integer id) {
        openConn();
        String sql = "update movie_schedule set room_id = ?, schedule_date = ?, start_time = ?, price = ? where id = " + id;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, schedule.getRoom_id());
            statement.setString(2, schedule.getDate());
            statement.setString(3, schedule.getTime());
            statement.setInt(4, schedule.getPrice());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConn();
    }
    
    public static void Delete(Integer id) {
        openConn();
        String sql = "delete from movie_schedule where id = " + id;
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConn();
    }
    
}
