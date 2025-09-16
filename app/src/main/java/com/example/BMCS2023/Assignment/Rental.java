/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;

/**
 *
 * @author zhenyu
 */
public class Rental {
    
    
    public enum Status {
        AVAILABLE,
        PENDING,
        PICKUP,
        RETURN,
        COMPLETED
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

    public static Rental[] getRentalsByUserId(String userId) throws Exception {
        Rental[] allRentals = DatabaseClient.getRecords("rentals", Rental.class);
        
        // Count matching rentals first
        int count = 0;
        for (Rental rental : allRentals) {
            if (rental.getUserId() != null && rental.getUserId().equals(userId)) {
                count++;
            }
        }
        
        // Create array with exact size
        Rental[] userRentals = new Rental[count];
        int index = 0;
        for (Rental rental : allRentals) {
            if (rental.getUserId() != null && rental.getUserId().equals(userId)) {
                userRentals[index++] = rental;
            }
        }
        
        return userRentals;
    }
    
    public static String getVehicleDisplayName(String vehicleId) {
        if (vehicleId == null || vehicleId.trim().isEmpty() || vehicleId.equals("N/A")) {
            return "Unknown Vehicle";
        }
        
        try {
            Vehicle vehicle = DatabaseClient.getRecordById("vehicles", vehicleId, Vehicle.class);
            if (vehicle != null) {
                String brand = vehicle.getBrand() != null ? vehicle.getBrand() : "";
                String model = vehicle.getModel() != null ? vehicle.getModel() : "";
                
                if (!brand.isEmpty() && !model.isEmpty()) {
                    return brand + " " + model;
                } else if (!model.isEmpty()) {
                    return model;
                } else if (!brand.isEmpty()) {
                    return brand;
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching vehicle details for ID: " + vehicleId + " - " + e.getMessage());
        }
        
        return vehicleId;
    }
    
    public String formatRentalTime() {
        if (startTime == null || endTime == null) {
            return "Time not available";
        }
        
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
            
            String startDate = startTime.format(dateFormatter);
            String startTimeFormatted = startTime.format(timeFormatter);
            String endDate = endTime.format(dateFormatter);
            String endTimeFormatted = endTime.format(timeFormatter);
            
            if (startTime.toLocalDate().equals(endTime.toLocalDate())) {
                return String.format("%s\n%s - %s", startDate, startTimeFormatted, endTimeFormatted);
            } else {
                return String.format("%s %s -\n%s %s", startDate, startTimeFormatted, endDate, endTimeFormatted);
            }
            
        } catch (Exception e) {
            System.err.println("Error formatting datetime: " + e.getMessage());
            return startTime.toString() + " - " + endTime.toString();
        }
    }
    
    public static boolean completeRental(String rentalId) throws Exception {
        try {
            // Update rental status to completed
            java.util.Map<String, Object> rentalUpdate = new java.util.HashMap<>();
            rentalUpdate.put("status", "completed");
            String updateResult = DatabaseClient.updateRecord("rentals", rentalId, rentalUpdate);
            
            return updateResult != null && !updateResult.isEmpty();
        } catch (Exception e) {
            System.err.println("Error completing rental: " + e.getMessage());
            throw e;
        }
    }
    
    public static boolean returnVehicleToAvailable(String vehicleId) throws Exception {
        try {
            Vehicle vehicle = DatabaseClient.getRecordById("vehicles", vehicleId, Vehicle.class);
            if (vehicle != null) {
                vehicle.setStatus(Vehicle.Status.available);
                String updateResult = DatabaseClient.updateRecord("vehicles", vehicleId, vehicle);
                return updateResult != null && !updateResult.isEmpty();
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error updating vehicle status: " + e.getMessage());
            throw e;
        }
    }
    
    public static String getVehicleIdFromRental(String rentalId) throws Exception {
        try {
            Rental rental = DatabaseClient.getRecordById("rentals", rentalId, Rental.class);
            return rental != null ? rental.getVehicleId() : null;
        } catch (Exception e) {
            System.err.println("Error getting vehicle ID from rental: " + e.getMessage());
            throw e;
        }
    }
    
    public static String getVehicleLocation(String vehicleId) {
        try {
            Vehicle vehicle = DatabaseClient.getRecordById("vehicles", vehicleId, Vehicle.class);
            return vehicle != null ? vehicle.getLocation() : "Location unavailable";
        } catch (Exception e) {
            System.err.println("Error getting vehicle location: " + e.getMessage());
            return "Location unavailable";
        }
    }
}

