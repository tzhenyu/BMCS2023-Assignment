package com.example.BMCS2023.Assignment;

import javax.swing.SwingUtilities; // or FlatDarkLaf
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.List;

public class App {
    
    
    public static void main(String[] args) {
        try {
            List<Vehicle> cars = DatabaseClient.getRecords("vehicles", Vehicle.class);
            
            // Loop through and print
            for (Vehicle car : cars) {
                System.out.println(car.getBrand() + " - " + car.getModel() + " - " + car.getPricePerDay());
            }
                       

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

