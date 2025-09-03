/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;

/**
 *
 * @author zhenyu
 */
public class User extends Person {
    private String emergencyContact;
    private String pendingVerificationPin;
    
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
    
    
    
}
