/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;

/**
 *
 * @author Joel
 */

public class SessionManager {
    private static User currentUser;
    
    public static void setCurrentUser(User user) {
        currentUser = user;
    }
    
    public static User getCurrentUser() {
        return currentUser;
    }
    
    public static void logout() {
        currentUser = null;
    }
    
    public static boolean isLoggedIn() {
        return currentUser != null;
    }
    
    public static String getCurrentUserId() {
        return currentUser != null ? currentUser.getUserId() : null;
    }
    
    public static String getCurrentUsername() {
        return currentUser != null ? currentUser.getUsername() : null;
    }
    
    public static String getCurrentEmail() {
        return currentUser != null ? currentUser.getEmail() : null;
    }
    
    public static String getCurrentContactNumber() {
        return currentUser != null ? currentUser.getPhone() : null;
    }
    
    public static String getCurrentEmergencyContact() {
        return currentUser != null ? currentUser.getEmergencyContactNum() : null;
    }
}

