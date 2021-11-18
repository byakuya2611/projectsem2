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
    private Integer id, movieId, roomId;
    private String chairId;
    private Integer price, discount;
    private Date createTicketDate, updateTicketDate;

    public Ticket(Integer id, Integer movieId, Integer roomId, String chairId, Integer price, Integer discount, Date createTicketDate, Date updateTicketDate) {
        this.id = id;
        this.movieId = movieId;
        this.roomId = roomId;
        this.chairId = chairId;
        this.price = price;
        this.discount = discount;
        this.createTicketDate = createTicketDate;
        this.updateTicketDate = updateTicketDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getChairId() {
        return chairId;
    }

    public void setChairId(String chairId) {
        this.chairId = chairId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Date getCreateTicketDate() {
        return createTicketDate;
    }

    public void setCreateTicketDate(Date createTicketDate) {
        this.createTicketDate = createTicketDate;
    }

    public Date getUpdateTicketDate() {
        return updateTicketDate;
    }

    public void setUpdateTicketDate(Date updateTicketDate) {
        this.updateTicketDate = updateTicketDate;
    }
    
    
}
