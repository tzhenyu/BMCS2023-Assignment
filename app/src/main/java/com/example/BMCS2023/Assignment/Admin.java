/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;

/**
 *
 * @author zhenyu
 */
public class Admin extends Person {
    private String adminId;
    
    public Admin() {
        super();
    }
    
    public Admin(String username, String email, String phone, String password) {
        super(username, email, phone, password);
        this.adminId = java.util.UUID.randomUUID().toString();
    }
    
    public String getAdminId() {
        return adminId;
    }
    
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    
    public boolean addCar(String brand, String model, String location, String carPlate) {
        try {
            Vehicle v = new Vehicle();
            v.setId(java.util.UUID.randomUUID().toString());
            v.setBrand(brand.trim());
            v.setModel(model.trim());
            v.setLocation(location.trim());
            v.setCarPlate(carPlate.trim());
            v.setStatus(Vehicle.Status.available);
            
            String response = DatabaseClient.insertRecords("vehicles", new Vehicle[] { v });
            return response != null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteCar(String carPlate) {
        try {
            int status = DatabaseClient.deleteById("vehicles", carPlate);
            return status == 204 || status == 200;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public Vehicle[] loadCarData() {
        try {
            return DatabaseClient.getRecords("vehicles", Vehicle.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Vehicle[0];
        }
    }
    
    public boolean updateCarStatus(String vehicleId, Vehicle.Status newStatus) {
        try {
            Vehicle[] vehicles = DatabaseClient.getRecords("vehicles", Vehicle.class);
            for (Vehicle v : vehicles) {
                if (v.getId().equals(vehicleId)) {
                    v.setStatus(newStatus);
                    String response = DatabaseClient.updateRecord("vehicles", vehicleId, v);
                    return response != null;
                }
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean addUser(String username, String password, String email, String phone, String emergencyContact) {
        try {
            User u = new User();
            u.setUserId(java.util.UUID.randomUUID().toString());
            u.setUsername(username.trim());
            u.setPassword(password.trim());
            u.setEmail(email.trim());
            u.setPhone(phone.trim());
            u.setEmergencyContactNum(emergencyContact.trim());
            
            String response = DatabaseClient.insertRecords("users", new User[] { u });
            return response != null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteUser(String userId) {
        try {
            int status = DatabaseClient.deleteById("users", userId);
            return status == 204 || status == 200;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public User[] loadUserData() {
        try {
            return DatabaseClient.getRecords("users", User.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new User[0];
        }
    }
    
    public User viewUserDetails(String userId) {
        try {
            User[] users = DatabaseClient.getRecords("users", User.class);
            for (User u : users) {
                if (u.getUserId().equals(userId)) {
                    return u;
                }
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public double viewRevenue(String carId) {
        try {
            // This would require rental data - placeholder implementation
            return 0.0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0.0;
        }
    }
    
}
