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
        this.userId = user.getUserId();        
        this.vehicleId = vehicle.getId();  
        this.rating = rating;
        this.comment = comment;
    }
    
    public Feedback(String userId, String vehicleId, int rating, String comment) {
        this.id = java.util.UUID.randomUUID().toString();
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.rating = Math.max(1, Math.min(5, rating)); // Ensure rating is between 1-5
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
    
    public static boolean createFeedback(String userId, String vehicleId, String ratingText, String comment) throws Exception {
        try {
            // Check if feedback already exists for this user-vehicle combination
            if (feedbackExists(userId, vehicleId)) {
                System.out.println("Feedback already exists for user " + userId + " and vehicle " + vehicleId);
                return true; // Return true since feedback exists (not an error)
            }
            
            int rating = 5; // Default rating
            try {
                rating = Integer.parseInt(ratingText.trim());
            } catch (NumberFormatException ex) {
                // Keep default rating of 5 if parsing fails
            }
            
            Feedback feedback = new Feedback(userId, vehicleId, rating, comment);
            Feedback[] feedbacks = {feedback};
            String result = DatabaseClient.insertRecords("feedback", feedbacks);
            
            return result != null && !result.isEmpty();
        } catch (Exception e) {
            System.err.println("Error creating feedback: " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Checks if feedback already exists for a user-vehicle combination
     * @param userId The user ID
     * @param vehicleId The vehicle ID
     * @return true if feedback exists, false otherwise
     */
    public static boolean feedbackExists(String userId, String vehicleId) throws Exception {
        try {
            String encodedUserId = java.net.URLEncoder.encode(userId, "UTF-8");
            String encodedVehicleId = java.net.URLEncoder.encode(vehicleId, "UTF-8");
            
            String query = "feedback?user_id=eq." + encodedUserId + "&vehicle_id=eq." + encodedVehicleId;
            String result = DatabaseClient.readRecords(query);
            
            // Parse result to check if any records exist
            com.google.gson.JsonArray jsonArray = com.google.gson.JsonParser.parseString(result).getAsJsonArray();
            return jsonArray.size() > 0;
        } catch (Exception e) {
            System.err.println("Error checking if feedback exists: " + e.getMessage());
            // Return false on error to allow feedback creation attempt
            return false;
        }
    }
    
    
    
}
