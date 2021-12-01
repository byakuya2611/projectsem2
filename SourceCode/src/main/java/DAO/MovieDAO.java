/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Movie;
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
public class MovieDAO extends BaseDAO{
    public static List<Movie> getListMovie() {
        openConn();
        List<Movie> movies = new ArrayList<>();
        String sql = "select * from movie";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("thumbnail"),
                        resultSet.getString("description"),
                        resultSet.getDate("start_at"),
                        resultSet.getTime("time")
                        
                );
                movies.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConn();
        return movies;
    }
    
    public static void Insert(Movie movie) {
        openConn();
        String sql = "insert into movie(name,thumbnail,start_at, time, description) values(?, ?, ?, ?, ?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, movie.getName());
            statement.setString(2, movie.getThumbnail());
            statement.setString(3, Utilities.Utility.ConvertDateToString(movie.getStartDate()));
            statement.setString(4, Utilities.Utility.ConvertTimeToString(movie.getStartTime()));
            statement.setString(5, movie.getDescription());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConn();
    }
    
    public static void Update(Movie movie, Integer id) {
        openConn();
        String sql = "update movie set name = ?, thumbnail = ?, start_at = ?, time = ?, description = ? where id = " + id;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, movie.getName());
            statement.setString(2, movie.getThumbnail());
            statement.setString(3, Utilities.Utility.ConvertDateToString(movie.getStartDate()));
            statement.setString(4, Utilities.Utility.ConvertTimeToString(movie.getStartTime()));
            statement.setString(5, movie.getDescription());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConn();
    }
    
    public static void Delete(Integer id) {
        openConn();
        String sql = "Delete from movie where id = " + id;
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConn();
    }
    
    public static List<Movie> Find(String name) {
        List<Movie> movies = new ArrayList<>();
        openConn();
        String sql = "select * from movie where name like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("thumbnail"),
                        resultSet.getString("description"),
                        resultSet.getDate("start_at"),
                        resultSet.getTime("time")
                );
                movies.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConn();
        return movies;
    }
}
