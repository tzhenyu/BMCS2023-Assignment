/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author zhenyu
 */
public class CarMenu extends javax.swing.JFrame {

    // Store vehicles for click handlers
    private Vehicle[] availableVehicles;
    
    // Arrays for UI components
    private JPanel[] carDetailPanelButtons;
    private JLabel[] carLabels;
    private JLabel[] priceLabels;
    private JLabel[] ratingLabels;
    private JLabel[] imageLabels;

    /**
     * Creates new form CarMenu
     */
    public CarMenu() {
        setTitle("Car Rental App");
        initComponents();
        initializeArrays();
        updateUIBasedOnLogin();
        loadVehicleData();
    }
    
    private void initializeArrays() {
        carDetailPanelButtons = new JPanel[]{
            carDetailPanelButton1, jPanel2, jPanel3, jPanel5, carDetailPanelButton2, jPanel8, jPanel6, jPanel7
        };
        
        carLabels = new JLabel[]{
            name1, name2, name3, name4, name5, name6, name7, name8
        };
        
        priceLabels = new JLabel[]{
            rate1, rate2, rate3, rate4, rate5, rate6,rate7,rate8
        };
        
        ratingLabels = new JLabel[]{
            rating1, rating2, rating3, rating4, rating5, rating6, rating7, rating8
        };
        
        imageLabels = new JLabel[]{
            image1, image2, jLabel10, image4, image5, image6, image7, image8
        };
    }
    
    private void loadVehicleData() {
        try {
            Vehicle[] vehicles = DatabaseClient.getRecords("vehicles", Vehicle.class);
            if (vehicles != null && vehicles.length > 0) {
                // Filter only available vehicles
                int count = 0;
                for (Vehicle v : vehicles) {
                    if (v.getStatus() == Vehicle.Status.available) {
                        count++;
                    }
                }
                
                // Create array and populate with available vehicles
                availableVehicles = new Vehicle[count];
                int index = 0;
                for (Vehicle v : vehicles) {
                    if (v.getStatus() == Vehicle.Status.available) {
                        availableVehicles[index++] = v;
                    }
                }
                
                // Populate each panel with vehicle data
                for (int i = 0; i < carDetailPanelButtons.length; i++) {
                    populateCarPanel(availableVehicles, i, carDetailPanelButtons[i], carLabels[i], priceLabels[i], ratingLabels[i], imageLabels[i]);
                }
                
            } else {
                // Show default message on first panel
                carLabels[0].setText("No vehicles available");
                priceLabels[0].setText("at the moment");
                ratingLabels[0].setText("");
                carDetailPanelButtons[0].setVisible(true);
                
                // Hide other panels
                for (int i = 1; i < carDetailPanelButtons.length; i++) {
                    carDetailPanelButtons[i].setVisible(false);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load vehicle data: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void populateCarPanel(Vehicle[] vehicles, int index, 
                                 JPanel panel, 
                                 JLabel nameLabel, 
                                 JLabel priceLabel, 
                                 JLabel ratingLabel,
                                 JLabel imageLabel) {
        if (vehicles != null && index < vehicles.length) {
            Vehicle v = vehicles[index];
            nameLabel.setText(v.getBrand() + " " + v.getModel());
            priceLabel.setText("RM" + v.getPricePerDay() + "/day");
            ratingLabel.setText("★4.5/5"); // Default rating
            if (v.getImageFileName() != null && !v.getImageFileName().isEmpty()) {
                imageLabel.setIcon(new ImageIcon(getClass().getResource("/" + v.getImageFileName())));
            } else {
                imageLabel.setIcon(new ImageIcon(getClass().getResource("/10628940.png"))); // Default image
            }
            panel.setVisible(true);
        } else {
            panel.setVisible(false);
        }
    }
    
    private void navigateToCarDetails(int vehicleIndex) {
        if (availableVehicles != null && vehicleIndex < availableVehicles.length) {
            Vehicle selectedVehicle = availableVehicles[vehicleIndex];
            GUIClient.switchPage(this, new CarDetails(selectedVehicle));
        }
    }
    
    public void refreshVehicleDisplay() {
        loadVehicleData();
    }
    
    private void updateUIBasedOnLogin() {
    if (SessionManager.isLoggedIn()) {
        User u = SessionManager.getCurrentUser();
        loginButton.setVisible(false);
        profileButton.setVisible(true);
        loggedInLabel.setVisible(true);
        loggedInLabel.setText("Hi, " + u.getUsername());
    } else {
        loginButton.setVisible(true);
        profileButton.setVisible(false);
        loggedInLabel.setVisible(false);
    }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        loginButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        carDetailPanelButton1 = new javax.swing.JPanel();
        rate1 = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        rating1 = new javax.swing.JLabel();
        image1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        image2 = new javax.swing.JLabel();
        rate2 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        rating2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        rate3 = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        rating3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        image4 = new javax.swing.JLabel();
        rate4 = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        rating4 = new javax.swing.JLabel();
        loggedInLabel = new java.awt.Label();
        jPanel6 = new javax.swing.JPanel();
        image7 = new javax.swing.JLabel();
        rate7 = new javax.swing.JLabel();
        name7 = new javax.swing.JLabel();
        rating7 = new javax.swing.JLabel();
        carDetailPanelButton2 = new javax.swing.JPanel();
        rate5 = new javax.swing.JLabel();
        name5 = new javax.swing.JLabel();
        rating5 = new javax.swing.JLabel();
        image5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        image8 = new javax.swing.JLabel();
        rate8 = new javax.swing.JLabel();
        name8 = new javax.swing.JLabel();
        rating8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        image6 = new javax.swing.JLabel();
        rate6 = new javax.swing.JLabel();
        name6 = new javax.swing.JLabel();
        rating6 = new javax.swing.JLabel();

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setName(""); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel15.setText("RM10/hour");

        jLabel16.setText("2004 Perodua Kancil");

        jLabel17.setText("4.5/5");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17))
                    .addComponent(jLabel16))
                .addGap(23, 23, 23))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Car Rental System");
        setLocation(new java.awt.Point(550, 350));

        loginButton.setText("Log In");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        profileButton.setText("Profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        carDetailPanelButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carDetailPanelButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        carDetailPanelButton1.setName(""); // NOI18N
        carDetailPanelButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carDetailPanelButton1MouseClicked(evt);
            }
        });

        rate1.setText("RM10/hour");

        name1.setText("2004 Perodua Kancil");

        rating1.setText("4.5/5");

        image1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        image1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout carDetailPanelButton1Layout = new javax.swing.GroupLayout(carDetailPanelButton1);
        carDetailPanelButton1.setLayout(carDetailPanelButton1Layout);
        carDetailPanelButton1Layout.setHorizontalGroup(
            carDetailPanelButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rate1)
                .addGap(39, 39, 39)
                .addComponent(rating1)
                .addContainerGap())
            .addGroup(carDetailPanelButton1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carDetailPanelButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image1)
                    .addComponent(name1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        carDetailPanelButton1Layout.setVerticalGroup(
            carDetailPanelButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image1)
                .addGap(12, 12, 12)
                .addComponent(name1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(carDetailPanelButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rate1)
                    .addComponent(rating1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setName(""); // NOI18N
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        image2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        image2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rate2.setText("RM10/hour");

        name2.setText("2004 Perodua Kancil");

        rating2.setText("4.5/5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rate2)
                .addGap(39, 39, 39)
                .addComponent(rating2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image2)
                    .addComponent(name2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rate2)
                    .addComponent(rating2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.setName(""); // NOI18N
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rate3.setText("RM10/hour");

        name3.setText("2004 Perodua Kancil");

        rating3.setText("4.5/5");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rate3)
                .addGap(39, 39, 39)
                .addComponent(rating3)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(name3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rate3)
                    .addComponent(rating3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.setName(""); // NOI18N
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        image4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        image4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rate4.setText("RM10/hour");

        name4.setText("2004 Perodua Kancil");

        rating4.setText("4.5/5");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rate4)
                .addGap(39, 39, 39)
                .addComponent(rating4)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image4)
                    .addComponent(name4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rate4)
                    .addComponent(rating4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        loggedInLabel.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        loggedInLabel.setText("Hi, ");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.setName(""); // NOI18N
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        image7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        image7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rate7.setText("RM10/hour");

        name7.setText("2004 Perodua Kancil");

        rating7.setText("4.5/5");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rate7)
                .addGap(39, 39, 39)
                .addComponent(rating7)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image7)
                    .addComponent(name7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rate7)
                    .addComponent(rating7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        carDetailPanelButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carDetailPanelButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        carDetailPanelButton2.setName(""); // NOI18N
        carDetailPanelButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carDetailPanelButton2MouseClicked(evt);
            }
        });

        rate5.setText("RM10/hour");

        name5.setText("2004 Perodua Kancil");

        rating5.setText("4.5/5");

        image5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        image5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout carDetailPanelButton2Layout = new javax.swing.GroupLayout(carDetailPanelButton2);
        carDetailPanelButton2.setLayout(carDetailPanelButton2Layout);
        carDetailPanelButton2Layout.setHorizontalGroup(
            carDetailPanelButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rate5)
                .addGap(39, 39, 39)
                .addComponent(rating5)
                .addContainerGap())
            .addGroup(carDetailPanelButton2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carDetailPanelButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image5)
                    .addComponent(name5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        carDetailPanelButton2Layout.setVerticalGroup(
            carDetailPanelButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image5)
                .addGap(12, 12, 12)
                .addComponent(name5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(carDetailPanelButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rate5)
                    .addComponent(rating5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.setName(""); // NOI18N
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        image8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        image8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rate8.setText("RM10/hour");

        name8.setText("2004 Perodua Kancil");

        rating8.setText("4.5/5");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rate8)
                .addGap(39, 39, 39)
                .addComponent(rating8)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image8)
                    .addComponent(name8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rate8)
                    .addComponent(rating8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.setName(""); // NOI18N
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        image6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        image6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rate6.setText("RM10/hour");

        name6.setText("2004 Perodua Kancil");

        rating6.setText("4.5/5");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rate6)
                        .addGap(39, 39, 39)
                        .addComponent(rating6))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(image6)
                            .addComponent(name6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rate6)
                    .addComponent(rating6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileButton)
                .addGap(10, 10, 10))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carDetailPanelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carDetailPanelButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loggedInLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(loginButton)
                        .addComponent(profileButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carDetailPanelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carDetailPanelButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        Point pos = this.getLocation();
        UserLoginPage frame = new UserLoginPage();    //create an instance
        frame.setResizable(false);          //lock resizing
        frame.setLocation(pos); 
        frame.setVisible(true);             //show the frame
        this.dispose();                     //close current frame
    }//GEN-LAST:event_loginButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        UserProfile frame = new UserProfile();
        GUIClient.switchPage(this, frame);
    }//GEN-LAST:event_profileButtonActionPerformed

    private void carDetailPanelButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carDetailPanelButton1MouseClicked
        navigateToCarDetails(0);
    }//GEN-LAST:event_carDetailPanelButton1MouseClicked

    private void carDetailPanelButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carDetailPanelButton2MouseClicked
        navigateToCarDetails(4);
    }//GEN-LAST:event_carDetailPanelButton2MouseClicked
    
    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {
        navigateToCarDetails(1);
    }
    
    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {
        navigateToCarDetails(2);
    }
    
    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {
        navigateToCarDetails(3);
    }
    
    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {
        navigateToCarDetails(5);
    }
    
    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {
        navigateToCarDetails(6);
    }
    
    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {
        navigateToCarDetails(7);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel carDetailPanelButton1;
    private javax.swing.JPanel carDetailPanelButton2;
    private javax.swing.JLabel image1;
    private javax.swing.JLabel image2;
    private javax.swing.JLabel image4;
    private javax.swing.JLabel image5;
    private javax.swing.JLabel image6;
    private javax.swing.JLabel image7;
    private javax.swing.JLabel image8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label loggedInLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name5;
    private javax.swing.JLabel name6;
    private javax.swing.JLabel name7;
    private javax.swing.JLabel name8;
    private javax.swing.JButton profileButton;
    private javax.swing.JLabel rate1;
    private javax.swing.JLabel rate2;
    private javax.swing.JLabel rate3;
    private javax.swing.JLabel rate4;
    private javax.swing.JLabel rate5;
    private javax.swing.JLabel rate6;
    private javax.swing.JLabel rate7;
    private javax.swing.JLabel rate8;
    private javax.swing.JLabel rating1;
    private javax.swing.JLabel rating2;
    private javax.swing.JLabel rating3;
    private javax.swing.JLabel rating4;
    private javax.swing.JLabel rating5;
    private javax.swing.JLabel rating6;
    private javax.swing.JLabel rating7;
    private javax.swing.JLabel rating8;
    // End of variables declaration//GEN-END:variables
}