package com.fongheiser.view;

import com.fongheiser.BusinessCardParser;
import com.fongheiser.interfaces.IBusinessCardParser;
import com.fongheiser.interfaces.IContactInfo;
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

    private IBusinessCardParser parser;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ContactViewController() {
        parser = new BusinessCardParser();
    }

    /**
     * Sets the input text area text
     * @param input
     */
    public void setInputTextArea(String input) {
        inputTextArea.setText(input);
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
    private void showContactDetails(IContactInfo contactInfo) {
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
        IContactInfo contactInfo = parser.getContactInfo(businessCard);
        showContactDetails(contactInfo);
    }
}