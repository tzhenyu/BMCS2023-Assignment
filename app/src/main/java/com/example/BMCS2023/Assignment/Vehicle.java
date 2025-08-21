/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;

/**
 *
 * @author zhenyu
 */


public class Vehicle {
    //Variables
    public enum Status {
        @com.google.gson.annotations.SerializedName("available")
        AVAILABLE,
        @com.google.gson.annotations.SerializedName("rented")
        RENTED,
        @com.google.gson.annotations.SerializedName("returned")
        RETURNED,
        @com.google.gson.annotations.SerializedName("maintenance")
        MAINTENANCE
    }
    public enum Type {
        @com.google.gson.annotations.SerializedName("suv")
        SUV,
        @com.google.gson.annotations.SerializedName("hatchback")
        HATCHBACK,
        @com.google.gson.annotations.SerializedName("sedan")
        SEDAN,
        @com.google.gson.annotations.SerializedName("coupe")
        COUPE
    }  
    public enum AddOn {
        @com.google.gson.annotations.SerializedName("child_seat")
        CHILD_SEAT,
        @com.google.gson.annotations.SerializedName("wifi")
        WIFI
    }  
    public enum FuelType {
        @com.google.gson.annotations.SerializedName("petrol")
        PETROL,
        @com.google.gson.annotations.SerializedName("diesel")
        DIESEL,
        @com.google.gson.annotations.SerializedName("electric")
        ELECTRIC,
        @com.google.gson.annotations.SerializedName("pickup")
        PICKUP
    }  

    // Vairable are declared in all small capital to match database column name
    private String id;
    private String brand;
    private String model;
    private String color;    
    private Status status;
    private Type type;
    private String location;
    private AddOn[] addon;
    private FuelType fueltype;
    private double priceperday;
    
    // Constructors
    public Vehicle(String id, String brand, String model, String color, Status status, Type type, String location, AddOn addOn, FuelType fuelType, double pricePerDay) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.status = status;
        this.type = type;
        this.location = location;
        this.addon = addOn != null ? new AddOn[]{addOn} : null;
        this.fueltype = fuelType;
        this.priceperday = pricePerDay;
    }
    
    public Vehicle(){
        
    }
    
    // Getter and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public AddOn getAddOn() {
        return addon != null && addon.length > 0 ? addon[0] : null;
    }

    public void setAddOn(AddOn addOn) {
        this.addon = addOn != null ? new AddOn[]{addOn} : null;
    }
    
    // New methods to handle multiple addons
    public AddOn[] getAddOns() {
        return addon;
    }
    
    public void setAddOns(AddOn[] addons) {
        this.addon = addons;
    }
    
    public String getAddOnsAsString() {
        if (addon == null || addon.length == 0) {
            return "No add-ons";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < addon.length; i++) {
            if (i > 0) sb.append(", ");
            String addonStr = addon[i].toString().replace("_", " ");
            addonStr = addonStr.charAt(0) + addonStr.substring(1).toLowerCase();
            sb.append(addonStr);
        }
        return sb.toString();
    }

    public FuelType getFuelType() {
        return fueltype;
    }

    public void setFuelType(FuelType fuelType) {
        this.fueltype = fuelType;
    }

    public double getPricePerDay() {
        return priceperday;
    }

    public void setPricePerDay(double pricePerDay) {
        this.priceperday = pricePerDay;
    }
    
    

}
