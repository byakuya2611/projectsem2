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
public class Chair {
    private int id;
    private int column;
    private int row;
    private String chair_name;
    private int room_id;

    public Chair() {
    }

    public Chair(int id, int column, int row, String chair_name, int room_id) {
        this.id = id;
        this.column = column;
        this.row = row;
        this.chair_name = chair_name;
        this.room_id = room_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getChair_name() {
        return chair_name;
    }

    public void setChair_name(String chair_name) {
        this.chair_name = chair_name;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
    
    
}
