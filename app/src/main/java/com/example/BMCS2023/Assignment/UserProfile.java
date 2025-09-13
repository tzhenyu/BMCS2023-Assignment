/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import java.awt.Point;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    
    // NEW: Constructor that accepts a User object
    public UserProfile(User user) {
        this.currentUser = user;
        initComponents();
        loadUserData();
        setTitle("User Profile - " + user.getUsername());
    }
    
    // Keep existing constructor
    private String currentRentalId;

    /**
     * Creates new form UserProfile
     */
    public UserProfile() {
        this.currentUser = SessionManager.getCurrentUser();
        initComponents();
        initializeRentalButton();
        
        if (currentUser != null) {
            loadUserData();
            IDdisplayText.setText(currentUser.getUserId());
            loadStatusButton1ForCurrentUser();
        } else {
            System.err.println("No user logged in");
            dispose();
            new UserLoginPage().setVisible(true);
        }
    }
    
    /**
     * Initializes the rental buttons in the UI
     * This method sets up the initial state of rental-related buttons
     */
    private void initializeRentalButton() {
        // Hide panels 2 and 3 initially as they're not used in the current implementation
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        
        // Initialize status buttons
        statusButton1.setVisible(false);
        statusButton2.setVisible(false);
        statusButton3.setVisible(false);
        
        // Clear initial text
        vehicleIDLabel1.setText("");
        vehicleIDLabel2.setText("");
        vehicleIDLabel3.setText("");
        dateLabel1.setText("");
        dateLabel2.setText("");
        dateLabel3.setText("");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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

    username.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 18)); // NOI18N
    username.setText("Username:");

    editInfoButton.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
    editInfoButton.setText("Edit Info");
    editInfoButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            editInfoButtonActionPerformed(evt);
        }
    });

    usernameDisplayText.setFont(new java.awt.Font("BIZ UDPMincho Medium", 0, 18)); // NOI18N
    usernameDisplayText.setText("username");

    backButton.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 18)); // NOI18N
    backButton.setText("< Back");
    backButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            backButtonActionPerformed(evt);
        }
    });

    ID.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 18)); // NOI18N
    ID.setText("ID:");

    IDdisplayText.setFont(new java.awt.Font("BIZ UDPMincho Medium", 0, 18)); // NOI18N
    IDdisplayText.setText("id");

    contactNumDisplayText.setFont(new java.awt.Font("BIZ UDPMincho Medium", 0, 14)); // NOI18N
    contactNumDisplayText.setText("contact num");

    emergencyContactNumDisplayText.setFont(new java.awt.Font("BIZ UDPMincho Medium", 0, 14)); // NOI18N
    emergencyContactNumDisplayText.setText("emergency contact num");

    contactNum.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 16)); // NOI18N
    contactNum.setText("CONTACT NUMBER:");

    emergencyContactNum.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 16)); // NOI18N
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

    email.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 16)); // NOI18N
    email.setText("EMAIL:");

    emailDisplayText.setFont(new java.awt.Font("BIZ UDPMincho Medium", 0, 14)); // NOI18N
    emailDisplayText.setText("email");

    jLabel1.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 20)); // NOI18N
    jLabel1.setText("ORDERS");

    jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jPanel1MouseClicked(evt);
        }
    });

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
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
            .addComponent(statusButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(vehicleIDLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(dateLabel1))
                .addComponent(statusButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jPanel2MouseClicked(evt);
        }
    });

    vehicleIDLabel2.setFont(new java.awt.Font("BIZ UDMincho Medium", 1, 14)); // NOI18N
    vehicleIDLabel2.setText("perodua kancil 2004");

    statusButton2.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
    statusButton2.setText("ongoing");
    statusButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            statusButton2ActionPerformed(evt);
        }
    });

    dateLabel2.setFont(new java.awt.Font("BIZ UDMincho Medium", 1, 14)); // NOI18N
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
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
            .addComponent(statusButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jPanel3MouseClicked(evt);
        }
    });

    vehicleIDLabel3.setFont(new java.awt.Font("BIZ UDMincho Medium", 1, 14)); // NOI18N
    vehicleIDLabel3.setText("perodua kancil 2004");

    statusButton3.setFont(new java.awt.Font("BIZ UDPMincho Medium", 1, 14)); // NOI18N
    statusButton3.setText("completed");
    statusButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            statusButton3ActionPerformed(evt);
        }
    });

    dateLabel3.setFont(new java.awt.Font("BIZ UDMincho Medium", 1, 14)); // NOI18N
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
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
            .addComponent(statusButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(usernameDisplayText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(IDdisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(editInfoButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(logoutButton)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(323, 323, 323))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(emergencyContactNum, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                    .addGap(67, 67, 67))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(contactNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(contactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(emergencyContactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(97, 97, 97))
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(emailDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(usernameDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, 0)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(IDdisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(70, 70, 70)
            .addComponent(jLabel1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(emailDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)
                    .addComponent(contactNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(contactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(emergencyContactNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(emergencyContactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 219, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
    
    CarMenu frame = new CarMenu(); 
    frame.setResizable(false); 
    frame.setLocation(this.getLocation()); 
    frame.setVisible(true); 
    this.dispose();
}//GEN-LAST:event_logoutButtonActionPerformed

private void statusButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusButton1ActionPerformed
    onStatusButton1Clicked();
}//GEN-LAST:event_statusButton1ActionPerformed

private void statusButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusButton2ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_statusButton2ActionPerformed

private void statusButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusButton3ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_statusButton3ActionPerformed

private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
    InvoicePage frame = new InvoicePage();
    GUIClient.switchPage(this, frame);
}//GEN-LAST:event_jPanel1MouseClicked

private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
    InvoicePage frame = new InvoicePage();
    GUIClient.switchPage(this, frame);
}//GEN-LAST:event_jPanel2MouseClicked

private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
    InvoicePage frame = new InvoicePage();
    GUIClient.switchPage(this, frame);
}//GEN-LAST:event_jPanel3MouseClicked

// ============ CUSTOM METHODS ============

private void onStatusButton1Clicked() {
    try {
        if (currentRentalId == null) {
            JOptionPane.showMessageDialog(this, "No active rental found");
            return;
        }

        String currentText = statusButton1.getText().toUpperCase();
        
        switch (currentText) {
            case "PICKUP":
               // handlePickupFlow();
                break;
                
            case "RETURN":
                handleReturnFlow();
                break;
                
            case "COMPLETED":
                handleCompletedFlow();
                break;
                
            default:
                System.out.println("Unexpected button state: " + currentText);
                break;
        }
    } catch (Exception e) {
        System.err.println("Error in status button action: " + e.getMessage());
        JOptionPane.showMessageDialog(this, 
            "Error processing request: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

// private void handlePickupFlow() {
//     try {
//         // Navigate to condition checklist first
//         ConditionChecklist conditionFrame = new ConditionChecklist(currentRentalId);
        
//         // Add a callback mechanism
//         conditionFrame.setOnConditionCompleteCallback(() -> {
//             try {
//                 // Update rental status to AVAILABLE (vehicle is now in use)
//                 updateRentalStatusInDatabase("AVAILABLE");
                
//                 // Also update the vehicle status to "rented"
//                 updateVehicleStatus("rented");
                
//                 // Update button text to RETURN
//                 statusButton1.setText("RETURN");
//                 statusButton1.setToolTipText("Vehicle in use - Click to return");
                
//                 // Show success message
//                 JOptionPane.showMessageDialog(UserProfile.this, 
//                     "Vehicle pickup completed successfully!", 
//                     "Pickup Complete", 
//                     JOptionPane.INFORMATION_MESSAGE);
                    
//             } catch (Exception e) {
//                 System.err.println("Error updating status after pickup: " + e.getMessage());
//                 JOptionPane.showMessageDialog(UserProfile.this, 
//                     "Error updating rental status: " + e.getMessage(),
//                     "Error",
//                     JOptionPane.ERROR_MESSAGE);
//             }
//         });
        
//         GUIClient.switchPage(this, conditionFrame);
        
//     } catch (Exception e) {
//         System.err.println("Error in pickup flow: " + e.getMessage());
//         JOptionPane.showMessageDialog(this, 
//             "Error processing pickup: " + e.getMessage(),
//             "Error",
//             JOptionPane.ERROR_MESSAGE);
//     }
// }

private void handleReturnFlow() {
    try {
        // Update status to PENDING (return process started)
        updateRentalStatusInDatabase("PENDING");
        
        // Navigate to return vehicle page
        ReturnVehicle returnFrame = new ReturnVehicle(currentRentalId);
        
        // Set callback for when return is completed
        returnFrame.setOnReturnCompleteCallback(() -> {
            try {
                // Update status to COMPLETED
                updateRentalStatusInDatabase("COMPLETED");
                
                // Also update the vehicle status back to "available"
                updateVehicleStatus("available");
                
                // Refresh the user profile to show updated status
                refreshUserProfile();
                
            } catch (Exception e) {
                System.err.println("Error completing return: " + e.getMessage());
                JOptionPane.showMessageDialog(UserProfile.this, 
                    "Error completing return process: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        
        GUIClient.switchPage(this, returnFrame);
        
    } catch (Exception e) {
        System.err.println("Error in return flow: " + e.getMessage());
        JOptionPane.showMessageDialog(this, 
            "Error processing return: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

private void handleCompletedFlow() {
    try {
        // Show rental details or invoice
        InvoicePage invoicePage = new InvoicePage();
        GUIClient.switchPage(this, invoicePage);
        
    } catch (Exception e) {
        System.err.println("Error viewing completed rental: " + e.getMessage());
        JOptionPane.showMessageDialog(this, 
            "Error accessing rental details: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

private void refreshUserProfile() {
    try {
        loadStatusButton1ForCurrentUser();
    } catch (Exception e) {
        System.err.println("Error refreshing user profile: " + e.getMessage());
    }
}

private void updateRentalStatusInDatabase(String newStatus) throws Exception {
    try {
        if (currentRentalId == null || currentRentalId.isEmpty()) {
            throw new Exception("No rental ID available for status update");
        }
        
        // Use DatabaseClient's dedicated method for status updates
        String result = DatabaseClient.updateRentalStatus(currentRentalId, newStatus);
        
        System.out.println("Rental status updated to: " + newStatus);
        System.out.println("Database response: " + result);
        
    } catch (Exception e) {
        System.err.println("Error updating rental status: " + e.getMessage());
        throw new Exception("Failed to update rental status: " + e.getMessage());
    }
}

private void updateVehicleStatus(String newStatus) throws Exception {
    try {
        // Get the current rental to find the vehicle ID
        Rental currentRental = DatabaseClient.getRecordById("rentals", currentRentalId, Rental.class);
        if (currentRental != null && currentRental.getVehicleId() != null) {
            // Update vehicle status in vehicles table using JsonObject
            JsonObject vehicleUpdate = new JsonObject();
            vehicleUpdate.addProperty("status", newStatus.toLowerCase());
            
            DatabaseClient.updateRecord("vehicles", currentRental.getVehicleId(), vehicleUpdate);
            System.out.println("Vehicle status updated to: " + newStatus);
        }
    } catch (Exception e) {
        System.err.println("Warning: Could not update vehicle status: " + e.getMessage());
        // Don't throw this error as it's secondary to the main rental status update
    }
}

public void loadStatusButton1ForCurrentUser() {
    try {
        System.out.println("Loading rentals for user: " + currentUser.getUserId());
        
        // Query rentals for current user, ordered by start time (most recent first)
        String query = "rentals?userId=eq." + currentUser.getUserId() + 
                      "&select=*&order=startTime.desc&limit=1";
        String result = DatabaseClient.readRecords(query);
        
        System.out.println("Database response: " + result);

        if (isEmptyResult(result)) {
            System.out.println("No rental records found");
            hideStatusButton1();
            return;
        }

        processRentalResponse(result);
        
    } catch (Exception e) {
        System.err.println("Error loading rental data: " + e.getMessage());
        e.printStackTrace();
        hideStatusButton1();
        JOptionPane.showMessageDialog(this, 
            "Error loading rental data. Please try again.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}

private boolean isEmptyResult(String result) {
    return result == null || result.trim().isEmpty() || result.equals("[]");
}

private void processRentalResponse(String result) {
    try {
        // Ensure proper JSON array format
        if (!result.startsWith("[")) {
            result = "[" + result + "]";
        }
        
        JsonArray rentalsArray = JsonParser.parseString(result).getAsJsonArray();
        
        if (rentalsArray.size() > 0) {
            JsonObject rental = rentalsArray.get(0).getAsJsonObject();
            processRentalData(rental);
        } else {
            hideStatusButton1();
        }
        
    } catch (Exception e) {
        System.err.println("JSON parsing error: " + e.getMessage());
        System.err.println("Problematic JSON: " + result);
        hideStatusButton1();
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
        hideStatusButton1();
    }
}

private void updateUIElements(String vehicleId, String startTime, String status) {
    vehicleIDLabel1.setText(vehicleId);
    dateLabel1.setText(formatDateForDisplay(startTime));

    // Make panel visible
    jPanel1.setVisible(true);
    
    // Add dynamic tooltip based on status
    String tooltipText = "";

    switch (status.toUpperCase()) {
        case "CONFIRMED":
            statusButton1.setText("PICKUP");
            statusButton1.setEnabled(true);
            tooltipText = "Rental confirmed - Click to proceed with pickup";
            jPanel1.setToolTipText("View rental details and proceed with pickup");
            break;
        case "AVAILABLE":
            statusButton1.setText("RETURN");
            statusButton1.setEnabled(true);
            tooltipText = "Vehicle in use - Click to return";
            jPanel1.setToolTipText("Vehicle is currently in use - Click to return");
            break;
        case "PENDING":
            statusButton1.setText("PENDING");
            statusButton1.setEnabled(false);
            tooltipText = "Return process in progress";
            jPanel1.setToolTipText("Return process is in progress");
            break;
        case "COMPLETED":
            statusButton1.setText("COMPLETED");
            statusButton1.setEnabled(true);
            tooltipText = "Rental completed - Click to view details";
            jPanel1.setToolTipText("Rental completed - View invoice and details");
            break;
        default:
            hideStatusButton1();
            return;
    }

    // Set tooltip for the status button
    statusButton1.setToolTipText(tooltipText);
    statusButton1.setVisible(true);
}

/**
 * Formats date string for display in the UI
 * Converts ISO datetime format to user-friendly display format
 * @param dateString The date string from database (ISO format)
 * @return Formatted date string for display (dd/MM/yyyy HH:mm)
 */
private String formatDateForDisplay(String dateString) {
    if (dateString == null || dateString.trim().isEmpty()) {
        return "N/A";
    }
    
    try {
        // Handle different possible input formats
        LocalDateTime dateTime;
        
        // Try parsing ISO format first (most common from database)
        if (dateString.contains("T")) {
            // Format: 2025-01-15T14:30:00 or 2025-01-15T14:30:00.123Z
            String cleanedDate = dateString.replace("Z", "").split("\\.")[0];
            dateTime = LocalDateTime.parse(cleanedDate);
        } else if (dateString.contains("-") && dateString.length() >= 19) {
            // Format: 2025-01-15 14:30:00
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            dateTime = LocalDateTime.parse(dateString, inputFormatter);
        } else {
            // Try other common formats
            DateTimeFormatter[] formatters = {
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"),
                DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")
            };
            
            dateTime = null;
            for (DateTimeFormatter formatter : formatters) {
                try {
                    dateTime = LocalDateTime.parse(dateString, formatter);
                    break;
                } catch (Exception ignored) {
                    // Try next formatter
                }
            }
            
            if (dateTime == null) {
                throw new Exception("Unable to parse date format: " + dateString);
            }
        }
        
        // Format for display: dd/MM/yyyy HH:mm
        DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dateTime.format(displayFormatter);
        
    } catch (Exception e) {
        System.err.println("Error formatting date '" + dateString + "': " + e.getMessage());
        // Return the original string if parsing fails
        return dateString;
    }
}

/**
 * Loads user data from the current user session into the UI display fields
 * Populates username, email, contact number, and emergency contact fields
 */
private void loadUserData() {
    try {
        if (currentUser == null) {
            System.err.println("No current user found in session");
            setDefaultUserDisplayValues();
            return;
        }
        
        // Load username
        String username = currentUser.getUsername();
        usernameDisplayText.setText(username != null && !username.trim().isEmpty() ? username : "N/A");
        
        // Load email
        String email = currentUser.getEmail();
        emailDisplayText.setText(email != null && !email.trim().isEmpty() ? email : "N/A");
        
        // Load contact number (phone)
        String contactNumber = currentUser.getPhone();
        contactNumDisplayText.setText(contactNumber != null && !contactNumber.trim().isEmpty() ? contactNumber : "N/A");
        
        // Load emergency contact number
        String emergencyContact = currentUser.getEmergencyContactNum();
        emergencyContactNumDisplayText.setText(emergencyContact != null && !emergencyContact.trim().isEmpty() ? emergencyContact : "N/A");
        
        // Log successful data loading for debugging
        System.out.println("User data loaded successfully for user: " + currentUser.getUserId());
        
    } catch (Exception e) {
        System.err.println("Error loading user data: " + e.getMessage());
        e.printStackTrace();
        
        // Set default values in case of error
        setDefaultUserDisplayValues();
        
        // Optionally show error message to user
        JOptionPane.showMessageDialog(this, 
            "Error loading user profile data. Some information may not be displayed correctly.",
            "Data Loading Error",
            JOptionPane.WARNING_MESSAGE);
    }
}

/**
 * Sets default display values when user data is not available
 */
private void setDefaultUserDisplayValues() {
    usernameDisplayText.setText("N/A");
    emailDisplayText.setText("N/A");
    contactNumDisplayText.setText("N/A");
    emergencyContactNumDisplayText.setText("N/A");
}

/**
 * Shows rental panels based on available rental data
 * This method can be used to selectively show panels when rental data is available
 */
private void showRentalPanels(int numberOfRentals) {
    // Always show panel 1 if there's at least one rental
    if (numberOfRentals >= 1) {
        jPanel1.setVisible(true);
        statusButton1.setVisible(true);
    }
    
    // Show panel 2 if there are at least 2 rentals
    if (numberOfRentals >= 2) {
        jPanel2.setVisible(true);
        statusButton2.setVisible(true);
    } else {
        jPanel2.setVisible(false);
        statusButton2.setVisible(false);
        vehicleIDLabel2.setText("");
        dateLabel2.setText("");
    }
    
    // Show panel 3 if there are 3 or more rentals
    if (numberOfRentals >= 3) {
        jPanel3.setVisible(true);
        statusButton3.setVisible(true);
    } else {
        jPanel3.setVisible(false);
        statusButton3.setVisible(false);
        vehicleIDLabel3.setText("");
        dateLabel3.setText("");
    }
    
    System.out.println("Showing " + numberOfRentals + " rental panel(s)");
}

/**
 * Hides all rental-related UI components when no rental data is available
 * This includes all panels, status buttons, vehicle ID labels, and date labels
 */
private void hideStatusButton1() {
    // Hide all panels
    jPanel1.setVisible(false);
    jPanel2.setVisible(false);
    jPanel3.setVisible(false);
    
    // Hide all status buttons
    statusButton1.setVisible(false);
    statusButton2.setVisible(false);
    statusButton3.setVisible(false);
    
    // Clear and hide vehicle ID labels
    vehicleIDLabel1.setText("");
    vehicleIDLabel2.setText("");
    vehicleIDLabel3.setText("");
    
    // Clear and hide date labels
    dateLabel1.setText("");
    dateLabel2.setText("");
    dateLabel3.setText("");
    
    // Optional: Log for debugging
    System.out.println("All rental UI components hidden - no active rentals found");
}

// ============ VARIABLES DECLARATION ============
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