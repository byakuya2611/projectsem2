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
}
