package se.nackademin;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GymUtilTest {

    @Test
    void getCustomerObjTest() {
        List<Customer> customers = new ArrayList<>();
        Customer c1 = new Customer("1234567890", "Ida Idylle", LocalDate.parse("2019-02-25"));
        Customer c2 = new Customer("9999999999", "klas bern", LocalDate.parse("2015-02-25"));
        customers.add(c1);
        customers.add(c2);

        assertNull(GymUtil.getCustomerObj("apa", customers));
        assertNotNull(GymUtil.getCustomerObj("Ida Idylle", customers));
    }

    @Test
    void customerMembershipStatusTest() {
        Customer c1 = new Customer("1234567890", "Ida Idylle", LocalDate.parse("2019-02-25"));
        Customer c2 = new Customer("9999999999", "klas bern", LocalDate.parse("2015-02-25"));
        assertFalse(GymUtil.customerMembershipStatus(c2));
        assertTrue(GymUtil.customerMembershipStatus(c1));
    }
}