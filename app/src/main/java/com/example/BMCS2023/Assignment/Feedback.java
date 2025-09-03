/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author zhenyu
 */
public class Feedback {
    private String id; 
    @SerializedName("user_id")
    private String userId; 
    @SerializedName("vehicle_id")
    private String vehicleId;
    private int rating; 
    private String comment;
    
    // Default constructor for Gson
    public Feedback() {}
    
    public Feedback(String id, User user, Vehicle vehicle, int rating, String comment) {
        this.id = id;
        this.userId = user.getId();        
        this.vehicleId = vehicle.getId();  
        this.rating = rating;
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }
    
    public String getId() {
        return id;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    
}
