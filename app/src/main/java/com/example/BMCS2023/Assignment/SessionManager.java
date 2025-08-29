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
    private static String currentUserId;
    
    public static void setCurrentUserId(String userId) {
        currentUserId = userId;
    }
    
    public static String getCurrentUserId() {
        return currentUserId;
    }
    
    public static void clearSession() {
        currentUserId = null;
    }
}
