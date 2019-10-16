package se.nackademin;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class GymUtil {

    public static void addAttendance () {
        Customer tempC = getCustomerObj();

        if (tempC == null)
            System.out.println("Customer not found.");
        else {
            Attendance tempA = new Attendance(tempC);
            System.out.println("Attendance added for " + tempC.getName());
            fileUtils.writeAttendance(tempA);
        }

    }

    public static void customerStillMember () {
        System.out.println("-- Member? --");
        Customer tempC = getCustomerObj();

        if (tempC == null)
            System.out.println("Member not found.");
        else {
            if (tempC.getPayDate().plusDays(365).isBefore(LocalDate.now()))
                System.out.println("Membership expired for member at " + tempC.getPayDate().plusDays(365));
            else {
                System.out.println("Membership active. Expires at " + tempC.getPayDate().plusDays(365));
            }
        }
    }

    public static Customer getCustomerObj () {
        System.out.println("Enter name or social security number of member:");
        String searchString = "";

        Scanner sc = new Scanner(System.in);
        searchString = sc.nextLine();

        for (Customer c:Main.customers) {
            if (c.getName().equalsIgnoreCase(searchString) || c.getssNumber().equalsIgnoreCase(searchString)) {
                return c;
            }
        }
        return null;
    }

    public static void getCustomerAttendance () {
        System.out.println("Search for member attendance");
        Customer tempC = getCustomerObj();
        boolean found = false;

        if (tempC == null)
            System.out.println("Customer not found.");
        else {
            for (Attendance a : Main.attendanceAll) {
                if (a.getCustomer() == tempC) {
                    System.out.println(a);
                    found = true;
                }
            }
        }

        if (!found)
            System.out.println("No attendance found for member.");
    }
}
