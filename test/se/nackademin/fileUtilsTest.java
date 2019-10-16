package se.nackademin;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    public final void readCustomersTest () {
        assertTrue(fileUtils.readCustomers(Main.customers));
    }

}