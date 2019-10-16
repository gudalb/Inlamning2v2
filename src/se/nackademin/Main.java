package se.nackademin;

import java.util.*;

public class Main {

    public static List<Customer> customers = new ArrayList<>();
    public static List<Attendance> attendanceAll = new ArrayList<>();

    public static void main(String[] args) {

        fileUtils.readCustomers(customers);

        for (Customer c:customers) System.out.println(c);

        //GymUtil.addAttendance();
        GymUtil.addAttendance();
        GymUtil.addAttendance();
        GymUtil.customerStillMember();


        for (Attendance a:attendanceAll) System.out.println(a);

    }
}
