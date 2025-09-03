/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import java.awt.Point;


/**
 *
 * @author Joel
 */
public class UserProfile extends javax.swing.JFrame {

    /**
     * Creates new form UserProfile
     */
    public UserProfile() {
        initComponents();
        loadUserData();
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
        jButton2 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();

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

        jLabel1.setText("ORDERS");

        jButton2.setText("jButton2");

        jLabel2.setText("jLabel2");
        jScrollPane1.setViewportView(jLabel2);

        jSplitPane1.setLeftComponent(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emergencyContactNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(72, 72, 72))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(contactNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(emailDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(contactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(emergencyContactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(logoutButton))
                                .addGap(125, 125, 125)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editInfoButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IDdisplayText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contactNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emergencyContactNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emergencyContactNumDisplayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton2)))))
                .addGap(27, 27, 27)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editInfoButtonActionPerformed
        Point pos = this.getLocation();
        EditInfo frame = new EditInfo();    //create an instance
        frame.setResizable(false);          //lock resizing
        frame.setLocation(pos); 
        frame.setVisible(true);             //show the frame
        this.dispose();                     //close current frame
    }//GEN-LAST:event_editInfoButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Point pos = this.getLocation();
        CarMenu frame = new CarMenu();    //create an instance
        frame.setResizable(false);          //lock resizing
        frame.setLocation(pos); 
        frame.setVisible(true);             //show the frame
        this.dispose();                     //close current frame
    }//GEN-LAST:event_backButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        SessionManager.logout();
    
        Point pos = this.getLocation();
        CarMenu frame = new CarMenu();    //create an instance
        frame.setResizable(false);          //lock resizing
        frame.setLocation(pos); 
        frame.setVisible(true);             //show the frame
        this.dispose();  
    }//GEN-LAST:event_logoutButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label ID;
    private java.awt.Label IDdisplayText;
    private javax.swing.JButton backButton;
    private java.awt.Label contactNum;
    private java.awt.Label contactNumDisplayText;
    private javax.swing.JButton editInfoButton;
    private java.awt.Label email;
    private java.awt.Label emailDisplayText;
    private java.awt.Label emergencyContactNum;
    private java.awt.Label emergencyContactNumDisplayText;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton logoutButton;
    private java.awt.Label username;
    private java.awt.Label usernameDisplayText;
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
