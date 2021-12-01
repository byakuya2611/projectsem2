/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author ngomi
 */
public class User {
    private Integer id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String passWord;
    private Integer roleId;
    private String gender;
    private Date createAccountDate;
    private Date updateAccoutDate;
    private String address;

    public User(String fullName, String email, String phoneNumber, String passWord, Integer roleId, String gender, Date createAccountDate, Date updateAccoutDate, String address) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passWord = passWord;
        this.roleId = roleId;
        this.gender = gender;
        this.createAccountDate = createAccountDate;
        this.updateAccoutDate = updateAccoutDate;
        this.address = address;
    }
    public User(Integer id,String fullName, String email, String phoneNumber, Integer roleId, String gender, String createAccountDate, String updateAccoutDate, String address, String passWord) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roleId = roleId;
        this.gender = gender;
        this.createAccountDate = Utilities.Utility.ConvertStringToDate(createAccountDate);
        this.updateAccoutDate = Utilities.Utility.ConvertStringToDate(updateAccoutDate);
        this.address = address;
        this.passWord = passWord;
    }

    public User() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Date getCreateAccountDate() {
        return createAccountDate;
    }

    public void setCreateAccountDate(Date createAccountDate) {
        this.createAccountDate = createAccountDate;
    }

    public Date getUpdateAccoutDate() {
        return updateAccoutDate;
    }

    public void setUpdateAccoutDate(Date updateAccoutDate) {
        this.updateAccoutDate = updateAccoutDate;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    

}
