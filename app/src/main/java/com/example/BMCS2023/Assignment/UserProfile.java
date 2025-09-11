/*
 * Improved UserProfile.java with complete rental status flow
 */
package com.example.BMCS2023.Assignment;

import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * UserProfile class with improved rental status management flow
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
            loadUserData();
            IDdisplayText.setText(currentUser.getUserId());
            initializeRentalButton();
            loadStatusButton1ForCurrentUser();
        } else {
            handleNoUserSession();
        }
    }
    
    /**
     * Handles case when no user is logged in
     */
    private void handleNoUserSession() {
        System.err.println("No user logged in");
        JOptionPane.showMessageDialog(null, 
            "Session expired. Please login again.", 
            "Session Error", 
            JOptionPane.WARNING_MESSAGE);
        dispose();
        new UserLoginPage().setVisible(true);
    }
    
    /**
     * Initializes rental button states
     */
    private void initializeRentalButton() {
        // Hide unused panels
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        
        // Initialize status buttons as hidden
        statusButton1.setVisible(false);
        statusButton2.setVisible(false);
        statusButton3.setVisible(false);
        
        // Clear labels
        vehicleIDLabel1.setText("");
        vehicleIDLabel2.setText("");
        vehicleIDLabel3.setText("");
        dateLabel1.setText("");
        dateLabel2.setText("");
        dateLabel3.setText("");
    }
    
    // [Generated UI code would go here - keeping existing initComponents()]
    
    /**
     * Main status button click handler - implements complete rental flow
     */
    private void onStatusButton1Clicked() {
        try {
            if (currentRentalId == null) {
                JOptionPane.showMessageDialog(this, "No active rental found");
                return;
            }

            String currentText = statusButton1.getText().toUpperCase();
            
            switch (currentText) {
                case "PICKUP":
                    handlePickupFlow();
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
    
   // In UserProfile.java - Enhance the handlePickupFlow method
private void handlePickupFlow() {
    try {
        // Navigate to condition checklist first
        ConditionChecklist conditionFrame = new ConditionChecklist(currentRentalId);
        
        // Add a callback mechanism or override the condition checklist to handle status update
        conditionFrame.setOnConditionCompleteCallback(() -> {
            try {
                // Update rental status to AVAILABLE (vehicle is now in use)
                updateRentalStatusInDatabase("AVAILABLE");
                
                // Also update the vehicle status to "rented" in the vehicles table
                updateVehicleStatus("rented");
                
                // Update button text to RETURN
                SwingUtilities.invokeLater(() -> {
                    statusButton1.setText("RETURN");
                    statusButton1.setToolTipText("Vehicle in use - Click to return");
                });
                
                // Show success message
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(UserProfile.this, 
                        "Vehicle pickup completed successfully!", 
                        "Pickup Complete", 
                        JOptionPane.INFORMATION_MESSAGE);
                });
                    
            } catch (Exception e) {
                System.err.println("Error updating status after pickup: " + e.getMessage());
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(UserProfile.this, 
                        "Error updating rental status: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                });
            }
        });
        
        GUIClient.switchPage(this, conditionFrame);
        
    } catch (Exception e) {
        System.err.println("Error in pickup flow: " + e.getMessage());
        JOptionPane.showMessageDialog(this, 
            "Error processing pickup: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

// Add this helper method to update vehicle status
private void updateVehicleStatus(String newStatus) throws Exception {
    try {
        // Get the current rental to find the vehicle ID
        Rental currentRental = DatabaseClient.getRecordById("rentals", currentRentalId, Rental.class);
        if (currentRental != null && currentRental.getVehicleId() != null) {
            // Update vehicle status in vehicles table
            JsonObject vehicleUpdate = new JsonObject();
            vehicleUpdate.addProperty("status", newStatus.toLowerCase()); // vehicles use lowercase status
            
            DatabaseClient.updateRecord("vehicles", currentRental.getVehicleId(), vehicleUpdate);
            System.out.println("Vehicle status updated to: " + newStatus);
        }
    } catch (Exception e) {
        System.err.println("Warning: Could not update vehicle status: " + e.getMessage());
        // Don't throw this error as it's secondary to the main rental status update
    }
}
    
    /**
     * Handles return flow: AVAILABLE -> RETURN -> Navigate to ReturnVehicle
     */
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
                SwingUtilities.invokeLater(() -> {
                    refreshUserProfile();
                });
                
            } catch (Exception e) {
                System.err.println("Error completing return: " + e.getMessage());
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(UserProfile.this, 
                        "Error completing return process: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                });
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
    
    /**
     * Handles completed flow: Shows rental history
     */
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
    
    // In UserProfile.java - Replace the updateRentalStatusInDatabase method
/**
 * Updates rental status in database using DatabaseClient's updateRentalStatus method
 */
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
    
    
    /**
     * Loads rental data and configures status button for current user
     */
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
    
    /**
     * Checks if database result is empty
     */
    private boolean isEmptyResult(String result) {
        return result == null || result.trim().isEmpty() || result.equals("[]");
    }
    
    /**
     * Processes rental response from database
     */
    private void processRentalResponse(String result) {
        try {
            // Ensure proper JSON array format
            if (!result.startsWith("[")) {
                result = "[" + result + "]";
            }
            
            JsonArray rentalsArray = JsonParser.parseString(result).getAsJsonArray();
            
            if (rentalsArray.size() > 0) {
                JsonObject rental = rentalsArray.get(0).getAsJsonObject();
                displayRentalInUI(rental);
            } else {
                hideStatusButton1();
            }
            
        } catch (Exception e) {
            System.err.println("JSON parsing error: " + e.getMessage());
            System.err.println("Problematic JSON: " + result);
            hideStatusButton1();
            throw new RuntimeException("Failed to parse rental data", e);
        }
    }
    
    /**
     * Displays rental information in the UI
     */
    private void displayRentalInUI(JsonObject rental) {
        try {
            // Extract rental data
            currentRentalId = getJsonString(rental, "id");
            String status = getJsonString(rental, "status");
            String vehicleId = getJsonString(rental, "vehicleId");
            String startTime = getJsonString(rental, "startTime");
            
            // Only show if there's a valid vehicle ID
            if (vehicleId.isEmpty()) {
                hideStatusButton1();
                return;
            }
            
            // Update UI elements
            vehicleIDLabel1.setText(vehicleId);
            dateLabel1.setText(formatDateForDisplay(startTime));
            
            // Configure status button based on rental status
            configureStatusButtonByStatus(status);
            
            // Make panel visible
            jPanel1.setVisible(true);
            statusButton1.setVisible(true);
            
        } catch (Exception e) {
            System.err.println("Error displaying rental data: " + e.getMessage());
            hideStatusButton1();
        }
    }
    
    /**
     * Safely extracts string from JSON object
     */
    private String getJsonString(JsonObject json, String key) {
        return json.has(key) && !json.get(key).isJsonNull() ? 
               json.get(key).getAsString() : "";
    }
    
    /**
     * Configures status button based on current rental status
     */
    private void configureStatusButtonByStatus(String status) {
        switch (status.toUpperCase()) {
            case "CONFIRMED":
                statusButton1.setText("PICKUP");
                statusButton1.setEnabled(true);
                statusButton1.setToolTipText("Rental confirmed - Click to proceed with pickup");
                jPanel1.setToolTipText("View rental details and proceed with pickup");
                break;
                
            case "AVAILABLE":
                statusButton1.setText("RETURN");
                statusButton1.setEnabled(true);
                statusButton1.setToolTipText("Vehicle in use - Click to return");
                jPanel1.setToolTipText("Vehicle is currently in use - Click to return");
                break;
                
            case "PENDING":
                statusButton1.setText("PENDING");
                statusButton1.setEnabled(false);
                statusButton1.setToolTipText("Return process in progress");
                jPanel1.setToolTipText("Return process is in progress");
                break;
                
            case "COMPLETED":
                statusButton1.setText("COMPLETED");
                statusButton1.setEnabled(true);
                statusButton1.setToolTipText("Rental completed - Click to view details");
                jPanel1.setToolTipText("Rental completed - View invoice and details");
                break;
                
            default:
                hideStatusButton1();
                break;
        }
    }
    
    /**
     * Hides status button and clears related UI elements
     */
    private void hideStatusButton1() {
        statusButton1.setVisible(false);
        jPanel1.setVisible(false);
        vehicleIDLabel1.setText("");
        dateLabel1.setText("");
        currentRentalId = null;
    }
    
    /**
     * Refreshes the user profile to show updated status
     */
    private void refreshUserProfile() {
        try {
            loadStatusButton1ForCurrentUser();
        } catch (Exception e) {
            System.err.println("Error refreshing user profile: " + e.getMessage());
        }
    }
    
    /**
     * Formats date-time string for display
     */
    public String formatDateForDisplay(String dateTime) {
        if (dateTime == null || dateTime.isEmpty()) {
            return "";
        }

        try {
            if (dateTime.contains("T")) {
                String[] parts = dateTime.split("T");
                String date = parts[0];
                String time = parts[1];

                if (time.length() >= 5) {
                    time = time.substring(0, 5);
                }

                if (date.contains("-")) {
                    String[] dateParts = date.split("-");
                    if (dateParts.length == 3) {
                        return dateParts[2] + "/" + dateParts[1] + "/" + dateParts[0] + " " + time;
                    }
                }

                return date + " " + time;
            }
            return dateTime;
        } catch (Exception e) {
            return dateTime;
        }
    }
    
    /**
     * Loads user data into display fields
     */
    private void loadUserData() {
        try {
            if (currentUser == null) {
                System.err.println("Current user is null");
                return;
            }

            usernameDisplayText.setText(currentUser.username != null ? currentUser.username : "");
            emailDisplayText.setText(currentUser.email != null ? currentUser.email : "");
            contactNumDisplayText.setText(currentUser.phone != null ? currentUser.phone : "");
            emergencyContactNumDisplayText.setText(currentUser.getEmergencyContactNum() != null ? 
                currentUser.getEmergencyContactNum() : "");

            System.out.println("User data loaded successfully");

        } catch (Exception e) {
            System.err.println("Error loading user data: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Error loading user data: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Event handlers
    private void statusButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        onStatusButton1Clicked();
    }
    
    private void editInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        EditInfo frame = new EditInfo();
        GUIClient.switchPage(this, frame);
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CarMenu frame = new CarMenu();
        GUIClient.switchPage(this, frame);
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SessionManager.logout();
        CarMenu frame = new CarMenu(); 
        frame.setResizable(false); 
        frame.setLocation(this.getLocation()); 
        frame.setVisible(true); 
        this.dispose();
    }

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {
        // Navigate to invoice page when panel is clicked
        InvoicePage frame = new InvoicePage();
        GUIClient.switchPage(this, frame);
    }

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {
        InvoicePage frame = new InvoicePage();
        GUIClient.switchPage(this, frame);
    }

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {
        InvoicePage frame = new InvoicePage();
        GUIClient.switchPage(this, frame);
    }

    private void statusButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Not implemented - reserved for future use
    }

    private void statusButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Not implemented - reserved for future use
    }
    
    // [Variable declarations would remain the same]
}