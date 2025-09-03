/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;
import java.time.LocalDateTime; // Import the LocalDateTime class

import com.google.gson.annotations.SerializedName; // Import SerializedName for JSON mapping
/**
 *
 * @author zhenyu
 */
public class Rental {
    
    
    // Database fields only - matches PostgreSQL schema exactly
    @SerializedName("id")
    private String id;
    
    private String userId;  // Changed from User object to String
    
    @SerializedName("vehicle_id") 
    private String vehicleId;  // Changed from Vehicle object to String
    
    @SerializedName("start_time")
    private LocalDateTime startTime;
    
    @SerializedName("end_time")
    private LocalDateTime endTime;
    
    @SerializedName("status")
    private String status;  // Changed from Status enum to String to match DB

    @SerializedName("amount")
    private double amount;  // Added amount field to match new DB schema

    @SerializedName("method")
    private String method;  // Payment method field

    // For database serialization - uses IDs as strings
    public Rental(String id, String userId, String vehicleId, LocalDateTime startTime, LocalDateTime endTime, String status, String method) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.method = method;
    }

    // Constructor for database operations with string IDs
    public Rental(String id, String userId, String vehicleId, LocalDateTime startTime, LocalDateTime endTime, String status, double amount) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.amount = amount;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }


    public String getVehicleId() {
        return vehicleId;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
    // Calculate fare on demand (recommended approach)
    public double calculateFare() {
        // You'll need to get the vehicle and calculate based on duration
        // This is a simplified version - you might need to load the vehicle from DB
        return 0.0; // Placeholder - implement proper calculation
    }
    
}
