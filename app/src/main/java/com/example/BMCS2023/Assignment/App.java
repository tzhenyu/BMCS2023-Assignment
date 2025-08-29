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
<<<<<<< HEAD
            new Test().setVisible(true);  // <-- Launch your designed frame
        });
    }
}
=======
            CarMenu carMenu = new CarMenu();
            carMenu.setLocationRelativeTo(null);  // Centers on screen
            carMenu.setVisible(true);
        });   
 }

>>>>>>> 62439881294eddad987e7aaf7d811f8dca451acf
