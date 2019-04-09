package com.fongheiser;

import com.fongheiser.interfaces.IBusinessCardParser;
import com.fongheiser.interfaces.IContactInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessCardParserTest {

    private static IBusinessCardParser parser;
    private IContactInfo info;

    /**
     * Initializes the parser
     */
    @BeforeAll
    static void setup() {
        parser = new BusinessCardParser();
    }


    /**
     * Testing the first sample input
     */
    @Test
    void getContactInfoTest1() {
        String document = "ASYMMETRIK LTD\n" +
                "Mike Smith\n" +
                "Senior Software Engineer\n" +
                "(410)555-1234\n" +
                "msmith@asymmetrik.com";

        info = parser.getContactInfo(document);
        assertEquals("Mike Smith", info.getName());
        assertEquals("4105551234", info.getPhoneNumber());
        assertEquals("msmith@asymmetrik.com", info.getEmailAddress());
    }

    /**
     * Testing the second sample input
     */
    @Test
    void getContactInfoTest2() {
        String document = "Foobar Technologies\n" +
                "Analytic Developer\n" +
                "Lisa Haung\n" +
                "1234 Sentry Road\n" +
                "Columbia, MD 12345\n" +
                "Phone: 410-555-1234\n" +
                "Fax: 410-555-4321\n" +
                "lisa.haung@foobartech.com";

        info = parser.getContactInfo(document);
        assertEquals("Lisa Haung", info.getName());
        assertEquals("4105551234", info.getPhoneNumber());
        assertEquals("lisa.haung@foobartech.com", info.getEmailAddress());
    }

    /**
     * Testing the third sample input
     */
    @Test
    void getContactInfoTest3() {
        String document = "Arthur Wilson\n" +
                "Software Engineer\n" +
                "Decision & Security Technologies\n" +
                "ABC Technologies\n" +
                "123 North 11th Street\n" +
                "Suite 229\n" +
                "Arlington, VA 22209\n" +
                "Tel: +1 (703) 555-1259\n" +
                "Fax: +1 (703) 555-1200\n" +
                "awilson@abctech.com";

        info = parser.getContactInfo(document);
        assertEquals("Arthur Wilson", info.getName());
        assertEquals("17035551259", info.getPhoneNumber());
        assertEquals("awilson@abctech.com", info.getEmailAddress());
    }
}