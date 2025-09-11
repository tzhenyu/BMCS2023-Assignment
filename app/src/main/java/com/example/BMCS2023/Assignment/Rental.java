/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;
import java.time.LocalDateTime; // Import the LocalDateTime class
/**
 *
 * @author zhenyu
 */
public class Rental {
    
    
    public enum Status {
        AVAILABLE,
        PENDING,
        CONFIRMED
    }
    
    private String id;
    private String userId;  // Changed from User object to String
    private String vehicleId;  // Changed from Vehicle object to String
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;  // Changed from Status enum to String to match DB
    private double amount;  // Added amount field to match new DB schema
    private String method;  // Payment method field


    public Rental() {

    }
    
    public static final double BABY_SEAT_FEE = 20.0;

    public Rental(String id, String userId, String vehicleId, LocalDateTime startTime, LocalDateTime endTime, String status, String method) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.method = method;
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

    public static String createRental(Rental rental) throws Exception {
        Rental[] rentals = { rental };
        return DatabaseClient.insertRecords("rentals", rentals);
    }

    public static String updateVehicleStatus(String vehicleId, Vehicle.Status status) throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleId);
        vehicle.setStatus(status);
        return DatabaseClient.updateRecord("vehicles", vehicleId, vehicle);
    }
    
    public double calculateTotalFare(Vehicle vehicle, boolean includeBabySeat) {
        if (vehicle == null) {
            return 0.0;
        }
        
        try {
            int durationHours = (int) java.time.Duration.between(startTime, endTime).toHours();
            double dailyRate = vehicle.getPricePerDay();
            double totalFare = dailyRate * durationHours;
            
            if (includeBabySeat) {
                totalFare += BABY_SEAT_FEE;
            }
            
            return totalFare;
        } catch (Exception e) {
            System.err.println("Error calculating fare: " + e.getMessage());
            return 0.0;
        }
    }

}

