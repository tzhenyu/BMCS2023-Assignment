package com.example.BMCS2023.Assignment;

import javax.swing.SwingUtilities; // or FlatDarkLaf
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UnsupportedLookAndFeelException;

import java.util.List;

public class App {
    
    
    public static void main(String[] args) {
        try {

            // Set FlatLaf theme
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }

        // Launch the GUI
        SwingUtilities.invokeLater(() -> {
            new CarMenu().setVisible(true);  // <-- Launch your designed frame
        });   
    }
}
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

