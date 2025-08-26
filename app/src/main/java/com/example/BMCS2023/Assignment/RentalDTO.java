/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import java.time.LocalDateTime;

import com.google.gson.annotations.SerializedName;

/**
 * Data Transfer Object for Rental - matches database schema exactly
 * Database table: rentals
 * @author zhenyu
 */
public class RentalDTO {
    
    @SerializedName("id")
    private String id;
    
    @SerializedName("user_id")
    private String userId;
    
    @SerializedName("vehicle_id") 
    private String vehicleId;
    
    @SerializedName("start_time")
    private LocalDateTime startTime;
    
    @SerializedName("end_time")
    private LocalDateTime endTime;
    
    @SerializedName("status")
    private String status;
    
    // Constructor
    public RentalDTO(String id, String userId, String vehicleId, LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }
    
    // Getters and setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getVehicleId() {
        return vehicleId;
    }
    
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
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
}
