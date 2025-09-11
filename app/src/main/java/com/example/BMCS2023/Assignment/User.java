/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import java.util.Arrays;
/**
 *
 * @author zhenyu
 */
public class User extends Person {
    
    public boolean verifyPin(String inputPin) {
        return false;
    }

    public void register(){
        
    }
    
    public void updateProfile() {
    
    }
    
    private String userId;
    private String emergencyContactNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmergencyContactNum() {
        return emergencyContactNum;
    }

    public void setEmergencyContactNum(String emergencyContactNum) {
        this.emergencyContactNum = emergencyContactNum;
    }
    
    @Override
    public User logIn(String username, String password) {
        try {
            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Please enter both username and password.");
            }
            
            User[] users = DatabaseClient.getRecords("users", User.class);
            return Arrays.stream(users)
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
        } catch (Exception ex) {
            System.out.println(ex.getMessage()); // Re-throw for UI handling
            return null;
        }
    }
    
    
}
