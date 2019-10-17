package se.nackademin;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GymUtilTest {

    @Test
    void getCustomerObjTest() {

        Customer c1 = new Customer("1234567890", "Ida Idylle", LocalDate.parse("2019-02-25"));
        Customer c2 = new Customer("9999999999", "klas bern", LocalDate.parse("2015-02-25"));

        assertNull(GymUtil.getCustomerObj("apa"));
        assertNotNull(GymUtil.getCustomerObj("klas bern"));
    }

    @Test
    void customerMembershipStatusTest() {
        Customer c1 = new Customer("1234567890", "Ida Idylle", LocalDate.parse("2019-02-25"));
        Customer c2 = new Customer("9999999999", "klas bern", LocalDate.parse("2015-02-25"));

        assertTrue(GymUtil.customerMembershipStatus(c1));
        assertFalse(GymUtil.customerMembershipStatus(c2));
    }

    @Test
    void validatePersonnummerTest() {
        TestCase.assertFalse(GymUtil.validateSsNumber("awdawd"));
        TestCase.assertFalse(GymUtil.validateSsNumber("123"));
        TestCase.assertFalse(GymUtil.validateSsNumber("12345678910"));
        TestCase.assertTrue(GymUtil.validateSsNumber("1234567890"));
    }
}