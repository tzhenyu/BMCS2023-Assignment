package com.example.BMCS2023.Assignment;

import javax.swing.SwingUtilities; // or FlatDarkLaf
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class App {
    
    public static void main(String[] args) {
        try {
            // Set FlatLaf theme
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        // Launch the GUI
        SwingUtilities.invokeLater(() -> {
            CarMenu frame = new CarMenu();       // instantiate it
            frame.setResizable(false);
            frame.setVisible(true);              // now show it
        });
    }
}
