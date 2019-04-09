package com.fongheiser;

import com.fongheiser.interfaces.IBusinessCardParser;
import com.fongheiser.interfaces.IContactInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class BusinessCardParser implements IBusinessCardParser {

    private final String PHONE_REGEX = "(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}";
    private final String EMAIL_REGEX = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)";
    private static String nameRegex = "^.*\\b(";

    public BusinessCardParser() {
        createNameRegex();
    }

    /**
     * Returns ContactInfo given a document string
     * @param document
     * @return
     */
    public IContactInfo getContactInfo(String document) {
        IContactInfo contactInfo = parseDocument(document);
        return contactInfo;
    }

    /**
     * Creates the name regex from a pre-compiled list of first names
     * This is called when the application first loads
     */
    private void createNameRegex() {
        try (Stream<String> stream = Files.lines(Paths.get("src/names.txt"))) {

            for(String string : stream.toArray(String[]::new)) {
                nameRegex +=  (string + "|");
            }

            nameRegex = nameRegex.substring(0, nameRegex.length() - 1);
            nameRegex += ")\\b.*$";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses the business card document and returns
     * a ContactInfo object with name, phone number,
     * and email address
     * @param document
     * @return
     */
    private ContactInfo parseDocument(String document) {
        String name = "";
        String phoneNumber = "";
        String emailAddress = "";

        Matcher m = Pattern.compile(nameRegex, Pattern.MULTILINE).matcher(document);

        if (m.find()) {
            name = m.group(0);
        } else {
            System.out.println("NO NAME MATCH");
        }

        m = Pattern.compile(PHONE_REGEX, Pattern.MULTILINE).matcher(document);
        if (m.find( )) {
            phoneNumber = m.group(0).replaceAll("[+()\\s-]+", "");
        } else {
            System.out.println("NO PHONE MATCH");
        }

        m = Pattern.compile(EMAIL_REGEX, Pattern.MULTILINE).matcher(document);
        if (m.find()) {
            emailAddress = m.group(0);
        } else {
            System.out.println("NO EMAIL MATCH");
        }

        return new ContactInfo(name, phoneNumber, emailAddress);
    }
}
