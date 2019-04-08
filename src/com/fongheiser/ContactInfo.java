package com.fongheiser;

public class ContactInfo {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    /**
     * Contact info constructor
     * @param name
     * @param phoneNumber
     * @param emailAddress
     */
    public ContactInfo(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    /**
     * Returns the name of the contact
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the phone number of the contact
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the email address of the contact
     * @return
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * toString() that includes all private variables
     * @return
     */
    @Override
    public String toString() {
        return "ContactInfo{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
