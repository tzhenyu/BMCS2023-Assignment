/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;

/**
 *
 * @author zhenyu
 */
public class User {
    
    private String userId;
    private String username;
    private String password;
    private String email;
    private String contactNum;
    private String emergencyContactNum;

    public User(String userId, String username, String password, String email, String contactNum, String emergencyContactNum) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.contactNum = contactNum;
        this.emergencyContactNum = emergencyContactNum;
    }

    User() {
        
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getEmergencyContactNum() {
        return emergencyContactNum;
    }

    public void setEmergencyContactNum(String emergencyContactNum) {
        this.emergencyContactNum = emergencyContactNum;
    }
    
    
    
}
