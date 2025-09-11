/*
 * Enhanced ConditionChecklist.java with callback support
 */
package com.example.BMCS2023.Assignment;

import javax.swing.JOptionPane;

/**
 * Enhanced ConditionChecklist with callback mechanism for status updates
 * @author Joel
 */
public class ConditionChecklist extends javax.swing.JFrame {
    private String rentalId;
    private Runnable onConditionCompleteCallback;
    
    /**
     * Creates new form ConditionChecklist
     */
    public ConditionChecklist(String rentalId) {
        this.rentalId = rentalId;
        initComponents();
        setupUI();
    }
    
    /**
     * Sets callback to be executed when condition check is completed
     */
    public void setOnConditionCompleteCallback(Runnable callback) {
        this.onConditionCompleteCallback = callback;
    }
    
    /**
     * Sets up the UI components
     */
    private void setupUI() {
        setTitle("Vehicle Condition Checklist");
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
        // Add window closing listener to handle proper cleanup
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                handleBackToProfile();
            }
        });
    }
    
    // Generated UI code would go here
    @SuppressWarnings("unchecked")
    private void initComponents() {
        // UI component initialization
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        okButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel1.setText("Vehicle Condition Checklist");

        jCheckBox1.setText("Check fuel level");
        jCheckBox2.setText("Inspect exterior condition");
        jCheckBox3.setText("Verify interior cleanliness");
        jCheckBox4.setText("Test lights and signals");
        jCheckBox5.setText("Check tire condition");

        okButton.setText("Complete Pickup");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back to Profile");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        // Layout code would be here - simplified for brevity
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addGap(18, 18, 18)
                        .addComponent(backButton)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox5)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(backButton))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    /**
     * Handles OK button click - completes the pickup process
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Validate that all checks are completed
            if (!validateChecklist()) {
                JOptionPane.showMessageDialog(this,
                    "Please complete all condition checks before proceeding.",
                    "Incomplete Checklist",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Show confirmation dialog
            int result = JOptionPane.showConfirmDialog(this,
                "Confirm that all vehicle conditions have been checked and are satisfactory?",
                "Confirm Pickup",
                JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                // Execute callback to update rental status
                if (onConditionCompleteCallback != null) {
                    onConditionCompleteCallback.run();
                }
                
                // Show success message
                JOptionPane.showMessageDialog(this,
                    "Vehicle pickup completed successfully!\n" +
                    "The vehicle is now ready for use.",
                    "Pickup Complete",
                    JOptionPane.INFORMATION_MESSAGE);
                
                // Return to UserProfile
                handleBackToProfile();
            }
            
        } catch (Exception e) {
            System.err.println("Error completing pickup: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error completing pickup: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Handles back button click
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        handleBackToProfile();
    }
    
    /**
     * Validates that all checklist items are completed
     */
    private boolean validateChecklist() {
        return jCheckBox1.isSelected() && 
               jCheckBox2.isSelected() && 
               jCheckBox3.isSelected() && 
               jCheckBox4.isSelected() && 
               jCheckBox5.isSelected();
    }
    
    /**
     * Handles navigation back to UserProfile
     */
    private void handleBackToProfile() {
        try {
            UserProfile userProfile = new UserProfile();
            userProfile.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.err.println("Error returning to profile: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error returning to profile: " + e.getMessage(),
                "Navigation Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variable declarations
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JButton okButton;
    private javax.swing.JButton backButton;
}