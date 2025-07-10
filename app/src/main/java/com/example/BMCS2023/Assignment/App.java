package com.example.BMCS2023.Assignment;

import com.formdev.flatlaf.FlatLightLaf; // or FlatDarkLaf
import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.*;

public class App {
    
    public static void doSomethingCool() {
        System.out.println("App function called!");
        // or anything else — e.g., start another process, save data, etc.
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
