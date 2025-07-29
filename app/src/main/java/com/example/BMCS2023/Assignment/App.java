package com.example.BMCS2023.Assignment;

import javax.swing.SwingUtilities; // or FlatDarkLaf
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class App {
    
    public static void doSomethingCool() {
        System.out.println("App function is called!");
    }
    
    public static void main(String[] args) {
        try {
            // Set FlatLaf theme
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        // Launch the GUI
        SwingUtilities.invokeLater(() -> {
            new Frame().setVisible(true);  // <-- Launch your designed frame
        });
    }
}
