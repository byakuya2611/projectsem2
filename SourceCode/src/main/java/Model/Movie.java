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
    private String description;
    private String img;
    private String cast;
    private int type_id;
    private String director;
    private String age;
    private String start_at;
    private String type;

    public Movie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void Movie() {
    }

    public Movie(Integer id, String name, String description, String img, String cast, int type_id, String director, String age, String start_at, String type) {
        this.id = id;
        this.name = name;
        this.description = description;    
        this.img = img;
        this.cast = cast;
        this.type_id = type_id;
        this.director = director;
        this.age = age;
        this.start_at = start_at;
        this.type = type;
    }
    public Movie(String name, String description, String img, String cast, int type_id, String director, String age, String start_at, String type) {
        this.name = name;
        this.description = description;    
        this.img = img;
        this.cast = cast;
        this.type_id = type_id;
        this.director = director;
        this.age = age;
        this.start_at = start_at;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }
    

    
}
