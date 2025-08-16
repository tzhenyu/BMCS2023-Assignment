/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;
import java.time.LocalDateTime; // Import the LocalDateTime class
// https://www.w3schools.com/java/java_date.asp for datetimeformat
/**
 *
 * @author zhenyu
 */
public class Rental {
    
    
    public enum Status {
        AVAILABLE,
        PENDING,
        CONFIRME
    }
    
    private String id;
    private User user;
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String pickupLocation;
    private String returnLocation;
    private Status status;
    private boolean fuelStatusOnReturn;
    //no need testdrive as we abondon already
    //no need selectedaddons for now

    public Rental(String id, String userId, String vehicleId, LocalDateTime startTime, LocalDateTime endTime, String pickupLocation, String returnLocation, Status status, boolean fuelStatusOnReturn) {
        this.id = id;
        this.user = user;
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.pickupLocation = pickupLocation;
        this.returnLocation = returnLocation;
        this.status = status;
        this.fuelStatusOnReturn = fuelStatusOnReturn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUserId() {
        return user;
    }


    public Vehicle getVehicleId() {
        return vehicle;
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

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isFuelStatusOnReturn() {
        return fuelStatusOnReturn;
    }

    public void setFuelStatusOnReturn(boolean fuelStatusOnReturn) {
        this.fuelStatusOnReturn = fuelStatusOnReturn;
    }
    
    
    
}
