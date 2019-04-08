package com.fongheiser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessCardParserTest {

    @Test
    void getContactInfo() {
        String document1 = "ASYMMETRIK LTD\n" +
                "Mike Smith\n" +
                "Senior Software Engineer\n" +
                "(410)555-1234\n" +
                "msmith@asymmetrik.com";

        String document2 = "Foobar Technologies\n" +
                "Analytic Developer\n" +
                "Lisa Haung\n" +
                "1234 Sentry Road\n" +
                "Columbia, MD 12345\n" +
                "Phone: 410-555-1234\n" +
                "Fax: 410-555-4321\n" +
                "lisa.haung@foobartech.com";

        String document3 = "Arthur Wilson\n" +
                "Software Engineer\n" +
                "Decision & Security Technologies\n" +
                "ABC Technologies\n" +
                "123 North 11th Street\n" +
                "Suite 229\n" +
                "Arlington, VA 22209\n" +
                "Tel: +1 (703) 555-1259\n" +
                "Fax: +1 (703) 555-1200\n" +
                "awilson@abctech.com";

        IBusinessCardParser parser = new BusinessCardParser();

        IContactInfo info = parser.getContactInfo(document1);
        assertEquals("Mike Smith", info.getName());
        assertEquals("4105551234", info.getPhoneNumber());
        assertEquals("msmith@asymmetrik.com", info.getEmailAddress());

        info = parser.getContactInfo(document2);
        assertEquals("Lisa Haung", info.getName());
        assertEquals("4105551234", info.getPhoneNumber());
        assertEquals("lisa.haung@foobartech.com", info.getEmailAddress());

        info = parser.getContactInfo(document3);
        assertEquals("Arthur Wilson", info.getName());
        assertEquals("17035551259", info.getPhoneNumber());
        assertEquals("awilson@abctech.com", info.getEmailAddress());
    }
}