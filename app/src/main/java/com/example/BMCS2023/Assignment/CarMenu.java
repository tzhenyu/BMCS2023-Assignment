/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import javax.swing.JLabel;
/**
 *
 * @author zhenyu
 */
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class CarMenu extends javax.swing.JFrame {

    /**
     * Creates new form CarMenu
     */
    public CarMenu() {
        initComponents();
        updateUIBasedOnLogin();
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
        initializeArrays();
        loadVehicleData();
    }
    
    private void initializeArrays() {
        carDetailPanelButtons = new JPanel[]{
            carDetailPanelButton1, carDetailPanelButton2, carDetailPanelButton3, carDetailPanelButton4,
            carDetailPanelButton5, carDetailPanelButton6, carDetailPanelButton7, carDetailPanelButton8
        };
        
        carLabels = new JLabel[]{
            carLabel1, carLabel2, carLabel3, carLabel4,
            carLabel5, carLabel6, carLabel7, carLabel8
        };
        
        priceLabels = new JLabel[]{
            priceLabel1, priceLabel2, priceLabel3, priceLabel4,
            priceLabel5, priceLabel6, priceLabel7, priceLabel8
        };
        
        ratingLabels = new JLabel[]{
            ratingLabel1, ratingLabel2, ratingLabel3, ratingLabel4,
            ratingLabel5, ratingLabel6, ratingLabel7, ratingLabel8
        };
        
        imageLabels = new JLabel[]{
            imageLabel1, imageLabel2, imageLabel3, imageLabel4,
            imageLabel5, imageLabel6, imageLabel7, imageLabel8
        };
    }
    
    // Store vehicles for click handlers
    private Vehicle[] availableVehicles;
    
    // Arrays for UI components
    private JPanel[] carDetailPanelButtons;
    private JLabel[] carLabels;
    private JLabel[] priceLabels;
    private JLabel[] ratingLabels;
    private JLabel[] imageLabels;
    
    private void loadVehicleData() {
        try {
            Vehicle[] vehicles = DatabaseClient.getRecords("vehicles", Vehicle.class);
            if (vehicles != null && vehicles.length > 0) {
                // Filter only available vehicles using traditional approach
                // First count available vehicles
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
                    populateCarPanel(availableVehicles, i, carDetailPanelButtons[i], carLabels[i], priceLabels[i], ratingLabels[i]);
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
                                 javax.swing.JPanel panel, 
                                 javax.swing.JLabel nameLabel, 
                                 javax.swing.JLabel priceLabel, 
                                 javax.swing.JLabel ratingLabel) {
        if (vehicles != null && index < vehicles.length) {
            Vehicle v = vehicles[index];
            nameLabel.setText(v.getBrand() + " " + v.getModel());
            priceLabel.setText("RM" + v.getPricePerDay() + "/hour");
            ratingLabel.setText("4.5/5"); // Default rating
            panel.setVisible(true);
        } else {
            panel.setVisible(false);
        }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        priceLabel1 = new javax.swing.JLabel();
        carLabel1 = new javax.swing.JLabel();
        ratingLabel1 = new javax.swing.JLabel();
        imageLabel1 = new javax.swing.JLabel();
        carDetailPanelButton2 = new javax.swing.JPanel();
        priceLabel2 = new javax.swing.JLabel();
        carLabel2 = new javax.swing.JLabel();
        ratingLabel2 = new javax.swing.JLabel();
        imageLabel2 = new javax.swing.JLabel();
        carDetailPanelButton3 = new javax.swing.JPanel();
        priceLabel3 = new javax.swing.JLabel();
        carLabel3 = new javax.swing.JLabel();
        ratingLabel3 = new javax.swing.JLabel();
        imageLabel3 = new javax.swing.JLabel();
        carDetailPanelButton4 = new javax.swing.JPanel();
        priceLabel4 = new javax.swing.JLabel();
        carLabel4 = new javax.swing.JLabel();
        ratingLabel4 = new javax.swing.JLabel();
        imageLabel4 = new javax.swing.JLabel();
        carDetailPanelButton5 = new javax.swing.JPanel();
        priceLabel5 = new javax.swing.JLabel();
        carLabel5 = new javax.swing.JLabel();
        ratingLabel5 = new javax.swing.JLabel();
        imageLabel5 = new javax.swing.JLabel();
        carDetailPanelButton6 = new javax.swing.JPanel();
        priceLabel6 = new javax.swing.JLabel();
        carLabel6 = new javax.swing.JLabel();
        ratingLabel6 = new javax.swing.JLabel();
        imageLabel6 = new javax.swing.JLabel();
        carDetailPanelButton7 = new javax.swing.JPanel();
        priceLabel7 = new javax.swing.JLabel();
        carLabel7 = new javax.swing.JLabel();
        ratingLabel7 = new javax.swing.JLabel();
        imageLabel7 = new javax.swing.JLabel();
        carDetailPanelButton8 = new javax.swing.JPanel();
        priceLabel8 = new javax.swing.JLabel();
        carLabel8 = new javax.swing.JLabel();
        ratingLabel8 = new javax.swing.JLabel();
        imageLabel8 = new javax.swing.JLabel();
        loggedInLabel = new java.awt.Label();

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

        priceLabel1.setText("RM10/hour");

        carLabel1.setText("2004 Perodua Kancil");

        ratingLabel1.setText("4.5/5");

        imageLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        imageLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout carDetailPanelButton1Layout = new javax.swing.GroupLayout(carDetailPanelButton1);
        carDetailPanelButton1.setLayout(carDetailPanelButton1Layout);
        carDetailPanelButton1Layout.setHorizontalGroup(
            carDetailPanelButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carDetailPanelButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carDetailPanelButton1Layout.createSequentialGroup()
                        .addComponent(imageLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(carDetailPanelButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton1Layout.createSequentialGroup()
                                .addComponent(priceLabel1)
                                .addGap(39, 39, 39)
                                .addComponent(ratingLabel1))
                            .addComponent(carLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        carDetailPanelButton1Layout.setVerticalGroup(
            carDetailPanelButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel1)
                .addGap(12, 12, 12)
                .addComponent(carLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(carDetailPanelButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel1)
                    .addComponent(ratingLabel1))
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

        priceLabel2.setText("RM10/hour");

        carLabel2.setText("2004 Perodua Kancil");

        ratingLabel2.setText("4.5/5");

        imageLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        imageLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout carDetailPanelButton2Layout = new javax.swing.GroupLayout(carDetailPanelButton2);
        carDetailPanelButton2.setLayout(carDetailPanelButton2Layout);
        carDetailPanelButton2Layout.setHorizontalGroup(
            carDetailPanelButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carDetailPanelButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carDetailPanelButton2Layout.createSequentialGroup()
                        .addComponent(imageLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(carDetailPanelButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton2Layout.createSequentialGroup()
                                .addComponent(priceLabel2)
                                .addGap(39, 39, 39)
                                .addComponent(ratingLabel2))
                            .addComponent(carLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        carDetailPanelButton2Layout.setVerticalGroup(
            carDetailPanelButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel2)
                .addGap(12, 12, 12)
                .addComponent(carLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(carDetailPanelButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel2)
                    .addComponent(ratingLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        carDetailPanelButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carDetailPanelButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        carDetailPanelButton3.setName(""); // NOI18N
        carDetailPanelButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carDetailPanelButton3MouseClicked(evt);
            }
        });

        priceLabel3.setText("RM10/hour");

        carLabel3.setText("2004 Perodua Kancil");

        ratingLabel3.setText("4.5/5");

        imageLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        imageLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout carDetailPanelButton3Layout = new javax.swing.GroupLayout(carDetailPanelButton3);
        carDetailPanelButton3.setLayout(carDetailPanelButton3Layout);
        carDetailPanelButton3Layout.setHorizontalGroup(
            carDetailPanelButton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carDetailPanelButton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carDetailPanelButton3Layout.createSequentialGroup()
                        .addComponent(imageLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(carDetailPanelButton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton3Layout.createSequentialGroup()
                                .addComponent(priceLabel3)
                                .addGap(39, 39, 39)
                                .addComponent(ratingLabel3))
                            .addComponent(carLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        carDetailPanelButton3Layout.setVerticalGroup(
            carDetailPanelButton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel3)
                .addGap(12, 12, 12)
                .addComponent(carLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(carDetailPanelButton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel3)
                    .addComponent(ratingLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        carDetailPanelButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carDetailPanelButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        carDetailPanelButton4.setName(""); // NOI18N
        carDetailPanelButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carDetailPanelButton4MouseClicked(evt);
            }
        });

        priceLabel4.setText("RM10/hour");

        carLabel4.setText("2004 Perodua Kancil");

        ratingLabel4.setText("4.5/5");

        imageLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        imageLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout carDetailPanelButton4Layout = new javax.swing.GroupLayout(carDetailPanelButton4);
        carDetailPanelButton4.setLayout(carDetailPanelButton4Layout);
        carDetailPanelButton4Layout.setHorizontalGroup(
            carDetailPanelButton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carDetailPanelButton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carDetailPanelButton4Layout.createSequentialGroup()
                        .addComponent(imageLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(carDetailPanelButton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton4Layout.createSequentialGroup()
                                .addComponent(priceLabel4)
                                .addGap(39, 39, 39)
                                .addComponent(ratingLabel4))
                            .addComponent(carLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        carDetailPanelButton4Layout.setVerticalGroup(
            carDetailPanelButton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel4)
                .addGap(12, 12, 12)
                .addComponent(carLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(carDetailPanelButton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel4)
                    .addComponent(ratingLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        carDetailPanelButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carDetailPanelButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        carDetailPanelButton5.setName(""); // NOI18N
        carDetailPanelButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carDetailPanelButton5MouseClicked(evt);
            }
        });

        priceLabel5.setText("RM10/hour");

        carLabel5.setText("2004 Perodua Kancil");

        ratingLabel5.setText("4.5/5");

        imageLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        imageLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout carDetailPanelButton5Layout = new javax.swing.GroupLayout(carDetailPanelButton5);
        carDetailPanelButton5.setLayout(carDetailPanelButton5Layout);
        carDetailPanelButton5Layout.setHorizontalGroup(
            carDetailPanelButton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carDetailPanelButton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carDetailPanelButton5Layout.createSequentialGroup()
                        .addComponent(imageLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(carDetailPanelButton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton5Layout.createSequentialGroup()
                                .addComponent(priceLabel5)
                                .addGap(39, 39, 39)
                                .addComponent(ratingLabel5))
                            .addComponent(carLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        carDetailPanelButton5Layout.setVerticalGroup(
            carDetailPanelButton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel5)
                .addGap(12, 12, 12)
                .addComponent(carLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(carDetailPanelButton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel5)
                    .addComponent(ratingLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        carDetailPanelButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carDetailPanelButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        carDetailPanelButton6.setName(""); // NOI18N
        carDetailPanelButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carDetailPanelButton6MouseClicked(evt);
            }
        });

        priceLabel6.setText("RM10/hour");

        carLabel6.setText("2004 Perodua Kancil");

        ratingLabel6.setText("4.5/5");

        imageLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        imageLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout carDetailPanelButton6Layout = new javax.swing.GroupLayout(carDetailPanelButton6);
        carDetailPanelButton6.setLayout(carDetailPanelButton6Layout);
        carDetailPanelButton6Layout.setHorizontalGroup(
            carDetailPanelButton6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carDetailPanelButton6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carDetailPanelButton6Layout.createSequentialGroup()
                        .addComponent(imageLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(carDetailPanelButton6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton6Layout.createSequentialGroup()
                                .addComponent(priceLabel6)
                                .addGap(39, 39, 39)
                                .addComponent(ratingLabel6))
                            .addComponent(carLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        carDetailPanelButton6Layout.setVerticalGroup(
            carDetailPanelButton6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel6)
                .addGap(12, 12, 12)
                .addComponent(carLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(carDetailPanelButton6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel6)
                    .addComponent(ratingLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        carDetailPanelButton7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carDetailPanelButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        carDetailPanelButton7.setName(""); // NOI18N
        carDetailPanelButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carDetailPanelButton7MouseClicked(evt);
            }
        });

        priceLabel7.setText("RM10/hour");

        carLabel7.setText("2004 Perodua Kancil");

        ratingLabel7.setText("4.5/5");

        imageLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        imageLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout carDetailPanelButton7Layout = new javax.swing.GroupLayout(carDetailPanelButton7);
        carDetailPanelButton7.setLayout(carDetailPanelButton7Layout);
        carDetailPanelButton7Layout.setHorizontalGroup(
            carDetailPanelButton7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carDetailPanelButton7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carDetailPanelButton7Layout.createSequentialGroup()
                        .addComponent(imageLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(carDetailPanelButton7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton7Layout.createSequentialGroup()
                                .addComponent(priceLabel7)
                                .addGap(39, 39, 39)
                                .addComponent(ratingLabel7))
                            .addComponent(carLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        carDetailPanelButton7Layout.setVerticalGroup(
            carDetailPanelButton7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel7)
                .addGap(12, 12, 12)
                .addComponent(carLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(carDetailPanelButton7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel7)
                    .addComponent(ratingLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        carDetailPanelButton8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carDetailPanelButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        carDetailPanelButton8.setName(""); // NOI18N
        carDetailPanelButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carDetailPanelButton8MouseClicked(evt);
            }
        });

        priceLabel8.setText("RM10/hour");

        carLabel8.setText("2004 Perodua Kancil");

        ratingLabel8.setText("4.5/5");

        imageLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        imageLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout carDetailPanelButton8Layout = new javax.swing.GroupLayout(carDetailPanelButton8);
        carDetailPanelButton8.setLayout(carDetailPanelButton8Layout);
        carDetailPanelButton8Layout.setHorizontalGroup(
            carDetailPanelButton8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carDetailPanelButton8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carDetailPanelButton8Layout.createSequentialGroup()
                        .addComponent(imageLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(carDetailPanelButton8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carDetailPanelButton8Layout.createSequentialGroup()
                                .addComponent(priceLabel8)
                                .addGap(39, 39, 39)
                                .addComponent(ratingLabel8))
                            .addComponent(carLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        carDetailPanelButton8Layout.setVerticalGroup(
            carDetailPanelButton8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carDetailPanelButton8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel8)
                .addGap(12, 12, 12)
                .addComponent(carLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(carDetailPanelButton8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel8)
                    .addComponent(ratingLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        loggedInLabel.setText("Hi, ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(loginButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profileButton)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carDetailPanelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carDetailPanelButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carDetailPanelButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carDetailPanelButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carDetailPanelButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carDetailPanelButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carDetailPanelButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carDetailPanelButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))))
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carDetailPanelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carDetailPanelButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carDetailPanelButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carDetailPanelButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(carDetailPanelButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(carDetailPanelButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(carDetailPanelButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(carDetailPanelButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        GUIClient.switchPage(this, new UserLoginPage());
    }//GEN-LAST:event_loginButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed

        GUIClient.switchPage(this, new UserProfile());
    }//GEN-LAST:event_profileButtonActionPerformed

    private void carDetailPanelButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carDetailPanelButton1MouseClicked
        navigateToCarDetails(0);
    }//GEN-LAST:event_carDetailPanelButton1MouseClicked

    private void carDetailPanelButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carDetailPanelButton2MouseClicked
        navigateToCarDetails(1);
    }//GEN-LAST:event_carDetailPanelButton2MouseClicked

    private void carDetailPanelButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carDetailPanelButton3MouseClicked
        navigateToCarDetails(2);
    }//GEN-LAST:event_carDetailPanelButton3MouseClicked

    private void carDetailPanelButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carDetailPanelButton4MouseClicked
        navigateToCarDetails(3);
    }//GEN-LAST:event_carDetailPanelButton4MouseClicked

    private void carDetailPanelButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carDetailPanelButton5MouseClicked
        navigateToCarDetails(4);
    }//GEN-LAST:event_carDetailPanelButton5MouseClicked

    private void carDetailPanelButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carDetailPanelButton6MouseClicked
        navigateToCarDetails(5);
    }//GEN-LAST:event_carDetailPanelButton6MouseClicked

    private void carDetailPanelButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carDetailPanelButton7MouseClicked
        navigateToCarDetails(6);
    }//GEN-LAST:event_carDetailPanelButton7MouseClicked

    private void carDetailPanelButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carDetailPanelButton8MouseClicked
        navigateToCarDetails(7);
    }//GEN-LAST:event_carDetailPanelButton8MouseClicked
    
    private void navigateToCarDetails(int vehicleIndex) {
        if (availableVehicles != null && vehicleIndex < availableVehicles.length) {
            Vehicle selectedVehicle = availableVehicles[vehicleIndex];
            CarDetails frame = new CarDetails(selectedVehicle);
            GUIClient.switchPage(this, frame);
        }
    }
    
    public void refreshVehicleDisplay() {
        loadVehicleData();
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
    private javax.swing.JPanel carDetailPanelButton3;
    private javax.swing.JPanel carDetailPanelButton4;
    private javax.swing.JPanel carDetailPanelButton5;
    private javax.swing.JPanel carDetailPanelButton6;
    private javax.swing.JPanel carDetailPanelButton7;
    private javax.swing.JPanel carDetailPanelButton8;
    private javax.swing.JLabel carLabel1;
    private javax.swing.JLabel carLabel2;
    private javax.swing.JLabel carLabel3;
    private javax.swing.JLabel carLabel4;
    private javax.swing.JLabel carLabel5;
    private javax.swing.JLabel carLabel6;
    private javax.swing.JLabel carLabel7;
    private javax.swing.JLabel carLabel8;
    private javax.swing.JLabel imageLabel1;
    private javax.swing.JLabel imageLabel2;
    private javax.swing.JLabel imageLabel3;
    private javax.swing.JLabel imageLabel4;
    private javax.swing.JLabel imageLabel5;
    private javax.swing.JLabel imageLabel6;
    private javax.swing.JLabel imageLabel7;
    private javax.swing.JLabel imageLabel8;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label loggedInLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel priceLabel1;
    private javax.swing.JLabel priceLabel2;
    private javax.swing.JLabel priceLabel3;
    private javax.swing.JLabel priceLabel4;
    private javax.swing.JLabel priceLabel5;
    private javax.swing.JLabel priceLabel6;
    private javax.swing.JLabel priceLabel7;
    private javax.swing.JLabel priceLabel8;
    private javax.swing.JButton profileButton;
    private javax.swing.JLabel ratingLabel1;
    private javax.swing.JLabel ratingLabel2;
    private javax.swing.JLabel ratingLabel3;
    private javax.swing.JLabel ratingLabel4;
    private javax.swing.JLabel ratingLabel5;
    private javax.swing.JLabel ratingLabel6;
    private javax.swing.JLabel ratingLabel7;
    private javax.swing.JLabel ratingLabel8;
    // End of variables declaration//GEN-END:variables
}