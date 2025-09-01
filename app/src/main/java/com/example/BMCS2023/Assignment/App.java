package com.example.BMCS2023.Assignment;

import javax.swing.SwingUtilities; // or FlatDarkLaf

public class App {
    
    
    public static void main(String[] args) {
        // Launch the GUI
        SwingUtilities.invokeLater(() -> {
            
            CarMenu frame = new CarMenu();  
            frame.setSize(800,600);
            frame.setResizable(false);          
            frame.setVisible(true);            
        });   
    }
}
