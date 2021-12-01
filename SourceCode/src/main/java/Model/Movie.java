package Model;


import java.sql.Time;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Movie {
    private Integer id;
    private String name;
    private String thumbnail;
    private String description;
    private Date startDate;
    private Time startTime;

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    
    public Movie(Integer id, String name, String thumbnail, String description, Date startDate, Time startTime) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.description = description;
        this.startDate = startDate;
        this.startTime = startTime;
        
    }
    public Movie(String name, String thumbnail, String description, Date startDate, Time startTime) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.description = description;
        this.startDate = startDate;
        this.startTime = startTime;
        
    }
    public  Movie() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
