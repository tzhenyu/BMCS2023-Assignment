/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import java.time.LocalDateTime;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

import com.google.gson.JsonObject;

import static java.time.LocalDateTime.now;

/**
 *
 * @author zhenyu
 */
public class CarBooking extends javax.swing.JFrame {

    private Vehicle selectedVehicle;
    /**
     * Creates new form CarDetails
     */
    
    public CarBooking() {
        setTitle("Car Booking");
        initComponents();
        loadTimeComponents();

    }

    public CarBooking(Vehicle vehicle) {
        this.selectedVehicle = vehicle;
        initComponents();
        loadTimeComponents();
        populateVehicleData();
    }
    
    private String getSelectedPaymentMethod() {
        if (jRadioButton1.isSelected()) {
            return "E-Wallet";
        } else if (jRadioButton2.isSelected()) {
            return "Cash on Delivery";
        } else if (jRadioButton3.isSelected()) {
            return "FPX";
        }
        return "";
    }
    
    private void loadTimeComponents() {

        // Set year spinner with current year
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(now().getYear(), 2024, 2035, 1));

        // Set month spinner with current month
        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(now().getMonthValue(), 1, 12, 1));

        // Set day spinner with current day
        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(now().getDayOfMonth(), 1, 31, 1));

        // Set initial hour models and values based on whether it's today
        updateHourSpinners();
        
        // Add change listeners to automatically update fare when time changes
        returnHour.addChangeListener(e -> calculateFare());
        pickupHour.addChangeListener(e -> { updateReturnHourModel(); calculateFare(); });
        
        // Add listener to baby seat checkbox to update fare when checked/unchecked
        jCheckBox1.addActionListener(e -> calculateFare());
        
        // When date changes, update hour spinners and calculate fare
        jSpinner1.addChangeListener(e -> { updateHourSpinners(); calculateFare(); });
        jSpinner2.addChangeListener(e -> { updateHourSpinners(); calculateFare(); });
        jSpinner3.addChangeListener(e -> { updateHourSpinners(); calculateFare(); });
    }
    
    private void updateHourSpinners() {
        if (isToday()) {
            // For today: minimum pickup is current hour + 1
            int currentHour = now().getHour();
            int minPickupHour = Math.max(9, currentHour + 1);
            
            // If it's too late in the day, no bookings possible for today
            if (minPickupHour >= 23) {
                minPickupHour = 22; // Last possible pickup
            }
            
            int initialReturnHour = Math.min(minPickupHour + 1, 23);
            int minReturnHour = Math.min(minPickupHour + 1, 23);
            
            pickupHour.setModel(new javax.swing.SpinnerNumberModel(minPickupHour, minPickupHour, 22, 1));
            returnHour.setModel(new javax.swing.SpinnerNumberModel(initialReturnHour, minReturnHour, 23, 1));
        } else {
            // For future dates: allow any hour from 9 AM to 10 PM (pickup) and 10 AM to 11 PM (return)
            pickupHour.setModel(new javax.swing.SpinnerNumberModel(9, 9, 22, 1));
            returnHour.setModel(new javax.swing.SpinnerNumberModel(10, 10, 23, 1));
        }
    }
    
    private boolean isToday() {
        int year = (Integer) jSpinner1.getValue();
        int month = (Integer) jSpinner2.getValue();
        int day = (Integer) jSpinner3.getValue();
        
        LocalDateTime selectedDate = LocalDateTime.of(year, month, day, 0, 0);
        LocalDateTime today = now();
        
        return selectedDate.toLocalDate().equals(today.toLocalDate());
    }

    
    private void populateVehicleData() {
        if (selectedVehicle != null) {
            jLabel2.setText(selectedVehicle.getBrand() + " " + selectedVehicle.getModel());
            
            // Format the type nicely
            String type = selectedVehicle.getType().toString();
            type = type.charAt(0) + type.substring(1).toLowerCase();
            jLabel3.setText(type);
            
            jLabel4.setText(selectedVehicle.getLocation());
            
            // Format add-ons nicely - now handles multiple addons
            jLabel5.setText(selectedVehicle.getAddOnsAsString());
            if (selectedVehicle.getImageFileName() != null && !selectedVehicle.getImageFileName().isEmpty()) {
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + selectedVehicle.getImageFileName())));
            } else {
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png")));
            }
            
            // Show/hide baby seat checkbox based on vehicle's available add-ons
            boolean hasBabySeat = false;
            if (selectedVehicle.getAddOns() != null) {
                for (Vehicle.AddOn addon : selectedVehicle.getAddOns()) {
                    if (addon == Vehicle.AddOn.child_seat) {
                        hasBabySeat = true;
                        break;
                    }
                }
            }
            jCheckBox1.setVisible(hasBabySeat);
            
            // Calculate initial fare
            calculateFare();
        }
    }


    public void handleFormSubmission() {
        try {
            // Validate form inputs
            if (selectedVehicle == null) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "No vehicle selected. Please go back and select a vehicle.", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Get date and time components from spinners
            int year = (Integer) jSpinner1.getValue();
            int month = (Integer) jSpinner2.getValue();
            int day = (Integer) jSpinner3.getValue();
            int pickupH = (Integer) pickupHour.getValue();
            int returnH = (Integer) returnHour.getValue();
            
            // Validate date inputs
            LocalDateTime startTime = LocalDateTime.of(year, month, day, pickupH, 0);
            LocalDateTime endTime = LocalDateTime.of(year, month, day, returnH, 0);
            LocalDateTime now = LocalDateTime.now();
            
            // Check if booking is for today and enforce minimum pickup time
            if (startTime.toLocalDate().equals(now.toLocalDate())) {
                if (pickupH <= now.getHour()) {
                    javax.swing.JOptionPane.showMessageDialog(this, 
                        "For same-day bookings, pickup time must be at least " + (now.getHour() + 1) + ":00.", 
                        "Invalid Pickup Time", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            if (startTime.isBefore(now)) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Pickup time cannot be in the past.", 
                    "Invalid Date", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Generate UUIDs for rental and use existing user from database
            String rentalId = java.util.UUID.randomUUID().toString();
            
            // Get the current logged-in user ID from session
            User currentUser = GUIClient.getCurrentUser();
            if (currentUser == null) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "You must be logged in to rent a vehicle.", 
                    "Login Required", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            String userId = currentUser.getUserId();
            String vehicleId = selectedVehicle.getId();
            
            // Validate that vehicle ID is a proper UUID
            if (vehicleId == null || vehicleId.trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Invalid vehicle ID. Please select a valid vehicle.", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Validate payment method selection
            if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected() && !jRadioButton3.isSelected()) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Please select a payment method.", 
                    "Payment Method Required", 
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                
                return;
            }

            JOptionPane.showMessageDialog(
            null, // Parent component (null for a default frame)
            "You will be redirected to a payment webpage.", // The message to display
            "Payment", // The title of the dialog box
            JOptionPane.INFORMATION_MESSAGE 
        
            );            

            // Move browser-opening code here (after the dialog)
            String url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";  // Or a real payment URL
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    try {
                        URI uri = new URI(url);
                        desktop.browse(uri);
                    } catch (IOException | URISyntaxException e) {
                        System.err.println("Error opening browser: " + e.getMessage());
                    }
                } else {
                    System.out.println("BROWSE action not supported.");
                }
            } else {
                System.out.println("Desktop not supported.");
            }
            
           
            // Calculate the total fare (for display/logging only)
            double totalFare = calculateFare();
            
            // Get selected payment method
            String paymentMethod = getSelectedPaymentMethod();
            
            Rental rental = new Rental(
                rentalId,
                userId,
                vehicleId,
                startTime,
                endTime,
                "pickup",
                paymentMethod  // Add payment method parameter
            );
            
            // Set the calculated amount
            rental.setAmount(totalFare);

            String rentalResponse = Rental.createRental(rental);

            if (rentalResponse != null && !rentalResponse.isEmpty()) {
                JsonObject vehicle = DatabaseClient.getRecordByIdAsJson("vehicles", vehicleId);
                if (vehicle != null) {
                    vehicle.addProperty("status", "rented");
                    String updateStatus =  DatabaseClient.updateRecord("vehicles", vehicleId, vehicle);
                    
                if (updateStatus != null && !updateStatus.isEmpty()) {
                    System.out.println("Rental created successfully.");
                    System.out.println("Vehicle status updated. Response: " + updateStatus);
                    GUIClient.switchPage(this, new CarBookingSuccess());
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, 
                        "Failed to update vehicle status.", 
                        "Error", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Failed to create rental.", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }


            


        } catch (Exception e) {
            System.err.println("Error creating rental: " + e.getMessage());
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Error creating rental: " + e.getMessage(), 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
        

    
    public double calculateFare() {
        if (selectedVehicle == null) {
            jLabel10.setText("0.00");
            return 0.0;
        }
        
        try {
            int pickupH = (Integer) pickupHour.getValue();
            int returnH = (Integer) returnHour.getValue();
            
            LocalDateTime startTime = getSelectedDateTime(pickupH);
            LocalDateTime endTime = getSelectedDateTime(returnH);
            
            Rental tempRental = new Rental("", "", "", startTime, endTime, "", "");
            boolean includeBabySeat = jCheckBox1.isVisible() && jCheckBox1.isSelected();
            
            double totalFare = tempRental.calculateTotalFare(selectedVehicle, includeBabySeat);
            jLabel10.setText(String.format("RM %.2f", totalFare));
            
            return totalFare;
        } catch (Exception e) {
            jLabel10.setText("Error");
            System.err.println("Error calculating fare: " + e.getMessage());
            return 0.0;
        }
    }

    private LocalDateTime getSelectedDateTime(int hour) {
        int year = (Integer) jSpinner1.getValue();
        int month = (Integer) jSpinner2.getValue();
        int day = (Integer) jSpinner3.getValue();
        return LocalDateTime.of(year, month, day, hour, 0);
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pickupHour = new javax.swing.JSpinner();
        returnHour = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        rentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Car Rental System");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10628940.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Pickup Date");

        jLabel7.setText("Pickup Time");

        jCheckBox1.setText("Baby seat");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("E-Wallet");

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText(" Cash on Delivery");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("FPX");

        jLabel8.setText("Payment Method");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel9.setText("Return Time");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel10.setText("RM 0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel10)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(pickupHour, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(returnHour, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(48, 48, 48))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pickupHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(65, 65, 65)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel2.setText("2004 Perodua Kancil");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setText("Hatchback");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("Taman Bunga Raya");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setText("Baby seat");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(12, 12, 12))
        );

        backButton.setText("Back");
        backButton.setToolTipText("");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        rentButton.setText("Rent");
        rentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(rentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        GUIClient.switchPage(this, new CarMenu());
    }//GEN-LAST:event_backButtonActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void rentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentButtonActionPerformed
        handleFormSubmission();
    }//GEN-LAST:event_rentButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CarBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarBooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner pickupHour;
    private javax.swing.JButton rentButton;
    private javax.swing.JSpinner returnHour;
    // End of variables declaration//GEN-END:variables

    private void updateReturnHourModel() {
        int currentPickupHour = (Integer) pickupHour.getValue();
        int currentReturnHour = (Integer) returnHour.getValue();
        int minReturnHour = currentPickupHour + 1;
        
        // Only update if the new minimum is valid
        if (minReturnHour <= 23) {
            // Ensure current return hour is at least the minimum
            int newReturnHour = Math.max(currentReturnHour, minReturnHour);
            
            // Create new model with safe bounds
            returnHour.setModel(new javax.swing.SpinnerNumberModel(
                newReturnHour, 
                minReturnHour, 
                23, 
                1
            ));
        }
    }
}
