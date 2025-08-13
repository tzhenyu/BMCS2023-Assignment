package com.example.BMCS2023.Assignment;

import javax.swing.SwingUtilities; // or FlatDarkLaf
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class App {
    
    
    public static void main(String[] args) {
        try {
            // Read all records from "vehicles" table
            String readResult = DatabaseClient.readRecords("vehicles");

            // Parse JSON into List<Vehicle>
            Type listType = new TypeToken<List<Vehicle>>(){}.getType();
            List<Vehicle> cars = new Gson().fromJson(readResult, listType);

            // Loop through and print
            for (Vehicle car : cars) {
                System.out.println(car.getBrand() + " - " + car.getModel());
            }
                       

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

