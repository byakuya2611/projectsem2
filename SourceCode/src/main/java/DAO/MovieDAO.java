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
public class MovieDAO extends BaseDAO {

    public static List<Movie> getListMovie() {
        openConn();
        List<Movie> movies = new ArrayList<>();
        String sql = "select m.id, m.name, m.thumbnail, m.start_at, m.description, m.type_id, m.director, m.cast, m.age, mt.type_name from movie as m , movie_type as mt where m.type_id = mt.id";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("thumbnail"),
                        resultSet.getString("cast"),
                        resultSet.getInt("type_id"),
                        resultSet.getString("director"),
                        resultSet.getString("age"),
                        resultSet.getString("start_at"),
                        resultSet.getString("type_name")
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
        String sql = "insert into movie(name,thumbnail,start_at,description,type_id,director,cast,age) values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, movie.getName());
            statement.setString(2, movie.getImg());
            statement.setString(3, movie.getStart_at());
            statement.setString(4, movie.getDescription());
            statement.setInt(5, movie.getType_id());
            statement.setString(6, movie.getDirector());
            statement.setString(7, movie.getCast());
            statement.setString(8, movie.getAge());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConn();
    }

    public static void Update(Movie movie, Integer id) {
        openConn();
        String sql = "update movie set name = ?, thumbnail = ?, start_at = ?, description = ?, type_id = ?, director = ?, cast = ?, age = ? where id = " + id;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, movie.getName());
            statement.setString(2, movie.getImg());
            statement.setString(3, movie.getStart_at());
            statement.setString(4, movie.getDescription());
            statement.setInt(5, movie.getType_id());
            statement.setString(6, movie.getDirector());
            statement.setString(7, movie.getCast());
            statement.setString(8, movie.getAge());
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
        String sql = "select m.id, m.name,m.thumbnail,m.start_at,m.description, m.type_id,m.director,m.cast,m.age, mt.type_name from movie as m , movie_type as mt where m.type_id = mt.id and m.name like ?";;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("thumbnail"),
                        resultSet.getString("cast"),
                        resultSet.getInt("type_id"),
                        resultSet.getString("director"),
                        resultSet.getString("age"),
                        resultSet.getString("start_at"),
                        resultSet.getNString("type_name")
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
