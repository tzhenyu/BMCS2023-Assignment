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
        AVAILABLE,
        RENTED,
        RETURNED,
        MAINTENANCE
    }
    public enum Type {
        SUV,
        HATCHBACK,
        SEDAN,
        COUPE
    }  
    public enum AddOn {
        CHILD_SEAT,
        WIFI
    }  
    public enum FuelType {
        PETROL,
        DIESEL,
        ELECTRIC,
        PICKUP
    }  
    private String id;
    private String brand;
    private String model;
    private String color;    
    private Status status;
    private Type type;
    private String location;
    private AddOn addOn;
    private FuelType fuelType;
    private double pricePerDay;
    
    // Constructors
    public Vehicle(String id, String brand, String model, String color, Status status, Type type, String location, AddOn addOn, FuelType fuelType, double pricePerDay) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.status = status;
        this.type = type;
        this.location = location;
        this.addOn = addOn;
        this.fuelType = fuelType;
        this.pricePerDay = pricePerDay;
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
        return addOn;
    }

    public void setAddOn(AddOn addOn) {
        this.addOn = addOn;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    
    

}
