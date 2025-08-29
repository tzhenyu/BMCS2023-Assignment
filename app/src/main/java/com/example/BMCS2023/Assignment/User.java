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
    private String id;
    private String username;
    private String contactNum;
    private String emergencyContactNum;
    
    public User() {
    
    }
    
    public User(String id, String username, String contactNum, String emergencyContactNum) {
        this.id = id;
        this.username = username;
        this.contactNum = contactNum;
        this.emergencyContactNum = emergencyContactNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
