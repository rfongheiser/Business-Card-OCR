package com.fongheiser.view;

import com.fongheiser.BusinessCardParser;
import com.fongheiser.ContactInfo;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ContactViewController {
    @FXML
    private TextArea inputTextArea;
    @FXML
    private Label nameLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label emailLabel;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ContactViewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Clear person details.
        showContactDetails(null);
    }
    
    /**
     * Fills all text fields to show details about the contact.
     * If the specified contact is null, all text fields are cleared.
     * 
     * @param contactInfo the contact or null
     */
    private void showContactDetails(ContactInfo contactInfo) {
        if (contactInfo != null) {
            // Fill the labels with info from the person object
            nameLabel.setText(contactInfo.getName());
            phoneLabel.setText(contactInfo.getPhoneNumber());
            emailLabel.setText(contactInfo.getEmailAddress());
        } else {
            // Contact is null, remove all the text
            nameLabel.setText("");
            phoneLabel.setText("");
            emailLabel.setText("");
        }
    }

    @FXML
    private void handleGetContactInfo() {
        String businessCard = inputTextArea.getText();
        ContactInfo contactInfo = BusinessCardParser.getContactInfo(businessCard);
        showContactDetails(contactInfo);
    }
}