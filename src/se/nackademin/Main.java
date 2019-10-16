package se.nackademin;

import java.util.*;

public class Main {

    public static List<Customer> customers = new ArrayList<>();
    public static List<Attendance> attendanceAll = new ArrayList<>();

    public static void main(String[] args) {

        fileUtils.readCustomers(customers);

    }
}
