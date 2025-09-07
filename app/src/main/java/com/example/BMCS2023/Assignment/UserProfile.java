/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import java.awt.Point;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Joel
 */
public class UserProfile extends javax.swing.JFrame {
    private Rental currentUserRental;
    /**
     * Creates new form UserProfile
     */
    public UserProfile() {
        initComponents();
        loadUserData();
        initializeRentalButton();
    }
    
    private void initializeRentalButton() {
        checkUserRental();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new java.awt.Label();
        editInfoButton = new javax.swing.JButton();
        usernameDisplayText = new java.awt.Label();
        backButton = new javax.swing.JButton();
        ID = new java.awt.Label();
        IDdisplayText = new java.awt.Label();
        contactNumDisplayText = new java.awt.Label();
        emergencyContactNumDisplayText = new java.awt.Label();
        contactNum = new java.awt.Label();
        emergencyContactNum = new java.awt.Label();
        logoutButton = new javax.swing.JButton();
        email = new java.awt.Label();
        emailDisplayText = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        vehicleIDLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        vehicle1Button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        vehicleID2Label = new javax.swing.JLabel();
        vehicle2Button = new javax.swing.JButton();
        date2Label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        vehicleID3Label = new javax.swing.JLabel();
        vehicle3Button = new javax.swing.JButton();
        date3Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        username.setText("Username:");

        editInfoButton.setText("Edit Info");
        editInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editInfoButtonActionPerformed(evt);
            }
        });

        usernameDisplayText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernameDisplayText.setText("username");

        backButton.setFont(new java.awt.Font("BIZ UDPMincho Medium", 0, 14)); // NOI18N
        backButton.setText("< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        ID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ID.setText("ID:");

        IDdisplayText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        IDdisplayText.setText("id");

        contactNumDisplayText.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contactNumDisplayText.setText("contact num");

        emergencyContactNumDisplayText.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        emergencyContactNumDisplayText.setText("emergency contact num");

        contactNum.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contactNum.setText("CONTACT NUMBER:");

        emergencyContactNum.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        emergencyContactNum.setMinimumSize(new java.awt.Dimension(115, 10));
        emergencyContactNum.setPreferredSize(new java.awt.Dimension(157, 20));
        emergencyContactNum.setText("EMERGENCY CONTACT NUMBER:");

        logoutButton.setFont(new java.awt.Font("BIZ UDPMincho Medium", 0, 12)); // NOI18N
        logoutButton.setText("X Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        email.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        email.setText("EMAIL:");

        emailDisplayText.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        emailDisplayText.setText("email");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("ORDERS");

        vehicleIDLabel.setText("vehicle id");

        dateLabel.setText("dd/mm/yyyy time");

        vehicle1Button.setText("pick up");
        vehicle1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicle1ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vehicleIDLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vehicle1Button)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(vehicleIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLabel))
                    .addComponent(vehicle1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        vehicleID2Label.setText("perodua kancil 2004");

        vehicle2Button.setText("ongoing");
        vehicle2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicle2ButtonActionPerformed(evt);
            }
        });

        date2Label.setText("2/8/2025 18:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(date2Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vehicleID2Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(vehicle2Button)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(vehicleID2Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date2Label))
                    .addComponent(vehicle2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        vehicleID3Label.setText("perodua kancil 2004");

        vehicle3Button.setText("completed");
        vehicle3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicle3ButtonActionPerformed(evt);
            }
        });

        date3Label.setText("2/8/2025 18:00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(date3Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vehicleID3Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(vehicle3Button)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(vehicleID3Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date3Label))
                    .addComponent(vehicle3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(IDdisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(usernameDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editInfoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contactNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emergencyContactNum, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(emailDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(emergencyContactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(contactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 24, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDdisplayText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editInfoButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contactNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emergencyContactNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emergencyContactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editInfoButtonActionPerformed
        EditInfo frame = new EditInfo();    //create an instance
        GUIClient.switchPage(this, frame);
    }//GEN-LAST:event_editInfoButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        CarMenu frame = new CarMenu();    //create an instance
        GUIClient.switchPage(this, frame);
    }//GEN-LAST:event_backButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        SessionManager.logout();
    
        { CarMenu frame = new CarMenu(); frame.setResizable(false); frame.setLocation(this.getLocation()); frame.setVisible(true); this.dispose(); }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void vehicle1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle1ButtonActionPerformed
        if (vehicle1Button.getText().equals("Pickup") && 
            vehicle1Button.isVisible() && 
            currentUserRental != null) {
            navigateToConditionChecklist();
        }
    }//GEN-LAST:event_vehicle1ButtonActionPerformed
    
    private void navigateToConditionChecklist() {
        try {
            Point pos = this.getLocation();
        
            // Create ConditionChecklist frame and pass the rental info
            ConditionChecklist frame = new ConditionChecklist();
            frame.setResizable(false);
            frame.setLocation(pos);
            frame.setVisible(true);
            this.dispose();
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
            "Error opening condition checklist: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private Rental findUserActiveRental(Rental[] rentals, String userId) {
        for (Rental rental : rentals) {
            // Check if rental belongs to current user and is in "active" status
            if (userId.equals(rental.getUserId()) && 
                (rental.getStatus().equals("CONFIRMED") || 
                rental.getStatus().equals("ACTIVE") ||
                rental.getStatus().equals("PENDING"))) {
                return rental;
            }
        }
        return null;
    }
    
    private void checkUserRental() {
        try {
            String currentUserId = SessionManager.getCurrentUserId();
        
            if (currentUserId == null) {
                System.out.println("No user logged in");
                hideVehicleButton();
                return;
            }
        
            Rental[] allRentals = DatabaseClient.getRecords("rentals", Rental.class);
            currentUserRental = findUserActiveRental(allRentals, currentUserId);
        
            if (currentUserRental != null) {
                showPickupButton();
                System.out.println("Found rental for user: " + currentUserId);
            } else {
                hideVehicleButton();
                System.out.println("No active rental found for user: " + currentUserId);
            }
        
        } catch (Exception e) {
            System.err.println("Error checking user rental: " + e.getMessage());
            hideVehicleButton();
        }
    }

    private void showPickupButton() {
        vehicle1Button.setText("Pickup");
        vehicle1Button.setVisible(true);
    }

    private void hideVehicleButton() {
        vehicle1Button.setText("");
        vehicle1Button.setVisible(false);
    }
    
    public class RentalStatus {
        public static final String CONFIRMED = "CONFIRMED";
        public static final String ACTIVE = "ACTIVE";
        public static final String PENDING = "PENDING";
    }
    
    private void vehicle2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle2ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicle2ButtonActionPerformed

    private void vehicle3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle3ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicle3ButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label ID;
    private java.awt.Label IDdisplayText;
    private javax.swing.JButton backButton;
    private java.awt.Label contactNum;
    private java.awt.Label contactNumDisplayText;
    private javax.swing.JLabel date2Label;
    private javax.swing.JLabel date3Label;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton editInfoButton;
    private java.awt.Label email;
    private java.awt.Label emailDisplayText;
    private java.awt.Label emergencyContactNum;
    private java.awt.Label emergencyContactNumDisplayText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logoutButton;
    private java.awt.Label username;
    private java.awt.Label usernameDisplayText;
    private javax.swing.JButton vehicle1Button;
    private javax.swing.JButton vehicle2Button;
    private javax.swing.JButton vehicle3Button;
    private javax.swing.JLabel vehicleID2Label;
    private javax.swing.JLabel vehicleID3Label;
    private javax.swing.JLabel vehicleIDLabel;
    // End of variables declaration//GEN-END:variables

    private void loadUserData() {
        User currentUser = SessionManager.getCurrentUser();
        if (currentUser != null) {
            usernameDisplayText.setText(currentUser.getUsername());
            IDdisplayText.setText(currentUser.getUserId());
            emailDisplayText.setText(currentUser.getEmail());
            contactNumDisplayText.setText(currentUser.getPhone());
            emergencyContactNumDisplayText.setText(currentUser.getEmergencyContactNum());
        }
    }
}
