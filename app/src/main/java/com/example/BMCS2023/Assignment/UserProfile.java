/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import java.awt.Point;
import java.util.List;
import javax.swing.JOptionPane;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author Joel
 */
public class UserProfile extends javax.swing.JFrame {
    private User currentUser;
    private String currentRentalId;

    /**
     * Creates new form UserProfile
     */
    public UserProfile() {
        this.currentUser = SessionManager.getCurrentUser();
        initComponents();
        if (currentUser != null) {
            IDdisplayText.setText(currentUser.getUserId());
            loadStatusButton1ForCurrentUser();
        } else {
            System.err.println("No user logged in");
            dispose();
            // Replace Login with appropriate landing page
            new UserLoginPage().setVisible(true);
        }
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
        vehicleIDLabel1 = new javax.swing.JLabel();
        dateLabel1 = new javax.swing.JLabel();
        statusButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        vehicleIDLabel2 = new javax.swing.JLabel();
        statusButton2 = new javax.swing.JButton();
        dateLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        vehicleIDLabel3 = new javax.swing.JLabel();
        statusButton3 = new javax.swing.JButton();
        dateLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        username.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        username.setText("Username:");

        editInfoButton.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        editInfoButton.setText("Edit Info");
        editInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editInfoButtonActionPerformed(evt);
            }
        });

        usernameDisplayText.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        usernameDisplayText.setText("username");

        backButton.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 18)); // NOI18N
        backButton.setText("< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        ID.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        ID.setText("ID:");

        IDdisplayText.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        IDdisplayText.setText("id");

        contactNumDisplayText.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        contactNumDisplayText.setText("contact num");

        emergencyContactNumDisplayText.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        emergencyContactNumDisplayText.setText("emergency contact num");

        contactNum.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        contactNum.setText("CONTACT NUMBER:");

        emergencyContactNum.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        emergencyContactNum.setMinimumSize(new java.awt.Dimension(115, 10));
        emergencyContactNum.setPreferredSize(new java.awt.Dimension(157, 20));
        emergencyContactNum.setText("EMERGENCY CONTACT NUMBER:");

        logoutButton.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 18)); // NOI18N
        logoutButton.setText("X Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        email.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        email.setText("EMAIL:");

        emailDisplayText.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        emailDisplayText.setText("email");

        jLabel1.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 18)); // NOI18N
        jLabel1.setText("ORDERS");

        vehicleIDLabel1.setFont(new java.awt.Font("BIZ UDMincho Medium", 1, 14)); // NOI18N
        vehicleIDLabel1.setText("vehicle id");

        dateLabel1.setFont(new java.awt.Font("BIZ UDMincho Medium", 1, 14)); // NOI18N
        dateLabel1.setText("dd/mm/yyyy time");

        statusButton1.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        statusButton1.setText("status");
        statusButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vehicleIDLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(statusButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(vehicleIDLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLabel1))
                    .addComponent(statusButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        vehicleIDLabel2.setFont(new java.awt.Font("BIZ UDMincho Medium", 1, 14)); // NOI18N
        vehicleIDLabel2.setText("perodua kancil 2004");

        statusButton2.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        statusButton2.setText("ongoing");
        statusButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusButton2ActionPerformed(evt);
            }
        });

        dateLabel2.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        dateLabel2.setText("2/8/2025 18:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vehicleIDLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(statusButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(vehicleIDLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLabel2))
                    .addComponent(statusButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        vehicleIDLabel3.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        vehicleIDLabel3.setText("perodua kancil 2004");

        statusButton3.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        statusButton3.setText("completed");
        statusButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusButton3ActionPerformed(evt);
            }
        });

        dateLabel3.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
        dateLabel3.setText("2/8/2025 18:00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vehicleIDLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(statusButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(vehicleIDLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLabel3))
                    .addComponent(statusButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emergencyContactNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(121, 121, 121))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contactNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emergencyContactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE))
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
                        .addComponent(emergencyContactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void statusButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusButton1ActionPerformed
        onStatusButton1Clicked();
    }//GEN-LAST:event_statusButton1ActionPerformed
    
    private void onStatusButton1Clicked() {
    try {
        if (currentRentalId == null) {
            JOptionPane.showMessageDialog(this, "No active rental found");
            return;
        }

        String currentText = statusButton1.getText();
        switch (currentText.toUpperCase()) {
            case "PICKUP":
                new ConditionChecklist(currentRentalId).setVisible(true);
                this.dispose();
                break;
            case "RETURN":
                new ReturnVehicle(currentRentalId).setVisible(true);
                this.dispose();
                break;
            default:
                System.out.println("Unexpected button state: " + currentText);
                break;
        }
    } catch (Exception e) {
        System.err.println("Error in status button action: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Error processing request: " + e.getMessage());
    }
}
    
    public String formatDateForDisplay(String dateTime) {
    if (dateTime == null || dateTime.isEmpty()) {
        return "";
    }

    try {
        // If the string looks like an ISO date (e.g. 2024-01-15T10:30:00)
        if (dateTime.contains("T")) {
            String[] parts = dateTime.split("T");
            String date = parts[0];   // "2024-01-15"
            String time = parts[1];   // "10:30:00"

            // Take only the first 5 characters of the time → "10:30"
            if (time.length() >= 5) {
                time = time.substring(0, 5);
            }

            // If the date has dashes, split into yyyy-mm-dd
            if (date.contains("-")) {
                String[] dateParts = date.split("-");
                if (dateParts.length == 3) {
                    // Rearrange to dd/mm/yyyy HH:MM
                    return dateParts[2] + "/" + dateParts[1] + "/" + dateParts[0] + " " + time;
                }
            }

            return date + " " + time;
        }
        return dateTime; // if it's not ISO, just return as-is
    } catch (Exception e) {
        return dateTime;
    }
}

    public void loadStatusButton1ForCurrentUser() {
        try {
            // Add debug logging
            System.out.println("Current User ID: " + currentUser.getUserId());
            
            // Get rental records for current user
            String query = "rentals?userId=eq." + currentUser.getUserId() + "&select=*";
            String result = DatabaseClient.readRecords(query);
            
            // Debug the response
            System.out.println("Raw Database Response: " + result);

            // Check if response is empty
            if (result == null || result.trim().isEmpty() || result.equals("[]")) {
                System.out.println("No rental records found");
                hideVehicleButton();
                return;
            }

            // Safely parse JSON
            try {
                // Ensure we have array brackets
                if (!result.startsWith("[")) {
                    result = "[" + result + "]";
                }
                
                JsonArray rentalsArray = JsonParser.parseString(result).getAsJsonArray();
                
                if (rentalsArray.size() > 0) {
                    JsonObject rental = rentalsArray.get(0).getAsJsonObject();
                    processRentalData(rental);
                } else {
                    hideVehicleButton();
                }
            } catch (Exception e) {
                System.err.println("JSON Parsing Error: " + e.getMessage());
                System.err.println("Problematic JSON: " + result);
                hideVehicleButton();
            }
        } catch (Exception e) {
            System.err.println("Error in loadStatusButton1ForCurrentUser: " + e.getMessage());
            e.printStackTrace();
            hideVehicleButton();
            JOptionPane.showMessageDialog(this, 
                "Error loading rental data. Please try again.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processRentalData(JsonObject rental) {
        try {
            currentRentalId = rental.has("id") ? rental.get("id").getAsString() : null;
            String status = rental.has("status") ? rental.get("status").getAsString() : "";
            String vehicleId = rental.has("vehicleId") ? rental.get("vehicleId").getAsString() : "";
            String startTime = rental.has("startTime") ? rental.get("startTime").getAsString() : "";

            updateUIElements(vehicleId, startTime, status);
        } catch (Exception e) {
            System.err.println("Error processing rental data: " + e.getMessage());
            hideVehicleButton();
        }
    }

    private void updateUIElements(String vehicleId, String startTime, String status) {
        vehicleIDLabel1.setText(vehicleId);
        dateLabel1.setText(formatDateForDisplay(startTime));
        
        switch (status.toUpperCase()) {
            case "CONFIRMED":
                statusButton1.setText("PICKUP");
                statusButton1.setEnabled(true);
                break;
            case "ACTIVE":
                statusButton1.setText("RETURN");
                statusButton1.setEnabled(true);
                break;
            case "COMPLETED":
                statusButton1.setText("COMPLETED");
                statusButton1.setEnabled(false);
                break;
            default:
                hideVehicleButton();
                break;
        }
        statusButton1.setVisible(true);
    }

    private void checkUserRental() {
        try {
            String currentUserId = SessionManager.getCurrentUserId();
            
            if (currentUserId == null) {
                System.out.println("No user logged in");
                hideVehicleButton();
                return;
            }
            
            // Use DatabaseClient.readRecords with a specific query
            String query = "rentals?userId=eq." + currentUserId + "&order=created_at.desc";
            String result = DatabaseClient.readRecords(query);
            
            JsonArray rentalsArray = JsonParser.parseString(result).getAsJsonArray();
            
            if (rentalsArray.size() > 0) {
                JsonObject rental = rentalsArray.get(0).getAsJsonObject();
                currentRentalId = rental.get("id").getAsString();
                String status = rental.get("status").getAsString();
                
                // Update UI based on rental status
                updateRentalDisplay(rental);
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

    private void updateRentalDisplay(JsonObject rental) {
    try {
        String vehicleId = rental.get("vehicleId").getAsString();
        String startTime = rental.get("startTime").getAsString();
        String status = rental.get("status").getAsString();

        vehicleIDLabel1.setText(vehicleId);
        dateLabel1.setText(formatDateForDisplay(startTime));
        
        switch (status.toUpperCase()) {
            case "CONFIRMED":
                statusButton1.setText("PICKUP");
                statusButton1.setEnabled(true);
                break;
            case "ACTIVE":
                statusButton1.setText("RETURN");
                statusButton1.setEnabled(true);
                break;
            case "COMPLETED":
                statusButton1.setText("COMPLETED");
                statusButton1.setEnabled(false);
                break;
            default:
                hideVehicleButton();
                break;
        }
        statusButton1.setVisible(true);
        
    } catch (Exception e) {
        System.err.println("Error updating rental display: " + e.getMessage());
        hideVehicleButton();
    }
}
    
    private void showPickupButton() {
        vehicleIDLabel1.setText("VehicleID");
            dateLabel1.setText("Date & Time");
        statusButton1.setText("Pickup");
        statusButton1.setVisible(true);
    }

    private void hideVehicleButton() {
        statusButton1.setVisible(false);
        vehicleIDLabel1.setText("");
        dateLabel1.setText("");
    }
    
    public class RentalStatus {
        public static final String CONFIRMED = "CONFIRMED";
        public static final String ACTIVE = "ACTIVE";
        public static final String PENDING = "PENDING";
    }
    
    private void statusButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle2ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicle2ButtonActionPerformed

    private void statusButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle3ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicle3ButtonActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        System.out.println("whats up");
    }//GEN-LAST:event_jPanel1MouseClicked

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label ID;
    private java.awt.Label IDdisplayText;
    private javax.swing.JButton backButton;
    private java.awt.Label contactNum;
    private java.awt.Label contactNumDisplayText;
    private javax.swing.JLabel dateLabel1;
    private javax.swing.JLabel dateLabel2;
    private javax.swing.JLabel dateLabel3;
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
    private javax.swing.JButton statusButton1;
    private javax.swing.JButton statusButton2;
    private javax.swing.JButton statusButton3;
    private java.awt.Label username;
    private java.awt.Label usernameDisplayText;
    private javax.swing.JLabel vehicleIDLabel1;
    private javax.swing.JLabel vehicleIDLabel2;
    private javax.swing.JLabel vehicleIDLabel3;
    // End of variables declaration//GEN-END:variables

}