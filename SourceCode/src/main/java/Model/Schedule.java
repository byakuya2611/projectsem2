/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ngomi
 */
public class Schedule {
    private int id;
    private int movie_id;
    private int room_id;
    private String date;
    private String time;
    private String room_name;
    private int price;
    public Schedule() {
        
    }
    public Schedule(int id, int movie_id, int room_id, String date, String time, String room_name, int price) {
        this.id = id;
        this.movie_id = movie_id;
        this.room_id = room_id;
        this.date = date;
        this.time = time;
        this.room_name = room_name;
        this.price = price;
    }
    public Schedule(int movie_id, int room_id, String date, String time, String room_name, int price) {
        this.movie_id = movie_id;
        this.room_id = room_id;
        this.date = date;
        this.time = time;
        this.room_name = room_name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    } 
}
