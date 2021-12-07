/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Ticket {
    private int ticket_id, schedule_id, user_id,chair_id;
    private String code, room_name, chair_name, date, time, movie_name;
    
    
    public Ticket(){}

    public Ticket(int ticket_id, int schedule_id, int user_id, int chair_id, String code, String room_name, String chair_name, String date, String time, String movie_name) {
        this.ticket_id = ticket_id;
        this.schedule_id = schedule_id;
        this.user_id = user_id;
        this.chair_id = chair_id;
        this.code = code;
        this.room_name = room_name;
        this.chair_name = chair_name;
        this.date = date;
        this.time = time;
        this.movie_name = movie_name;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setChair_id(int chair_id) {
        this.chair_id = chair_id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public void setChair_name(String chair_name) {
        this.chair_name = chair_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }
    
}
