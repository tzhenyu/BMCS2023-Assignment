package com.example.BMCS2023.Assignment;

import javax.swing.SwingUtilities; // or FlatDarkLaf

public class App {

    
    public static void main(String[] args) {
        // Launch the GUI
        SwingUtilities.invokeLater(() -> {
            CarMenu carMenu = new CarMenu();
            carMenu.setLocationRelativeTo(null);  // Centers on screen
            carMenu.setVisible(true);
        });   
 }
}
