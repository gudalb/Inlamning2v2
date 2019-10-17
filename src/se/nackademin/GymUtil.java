package se.nackademin;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GymUtil {

    public static void addAttendance () {
        System.out.println("-- Add attendance --");
        Customer tempC = getCustomerObj();

        if (tempC == null)
            System.out.println("Customer not found.");
        else if (!customerMembershipStatus(tempC))
            System.out.println("Member has not paid\nAttendance not added");
        else {
            Attendance tempA = new Attendance(tempC);
            System.out.println("Attendance added for " + tempC.getName());
            fileUtils.writeAttendance(tempA);
        }

    }

    public static boolean customerMembershipStatus() {
        System.out.println("-- Member? --");
        Customer tempC = getCustomerObj();

        if (tempC == null) {
            System.out.println("Member not found.");
            return false;
        }

        else {
            if (tempC.getPayDate().plusDays(365).isBefore(LocalDate.now())) {
                System.out.println("Membership expired for member at " + tempC.getPayDate().plusDays(365));
                return false;
            }
            else {
                System.out.println("Membership active. Expires at " + tempC.getPayDate().plusDays(365));
                return true;
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

    public static Customer getCustomerObj (String searchString) {

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

    public static boolean customerMembershipStatus(Customer c) {

        if (c.getPayDate().plusDays(365).isBefore(LocalDate.now())) {
            System.out.println("Membership expired for member at " + c.getPayDate().plusDays(365));
            return false;
        }
        else {
            System.out.println("Membership active. Expires at " + c.getPayDate().plusDays(365));
            return true;
        }
    }

    public static boolean validateSsNumber (String s) {
        boolean approved = false;

        try {
            if (s.length() != 10 && Integer.parseInt(s) > 0)
                throw new IncorrectSocialsecNumberException();
            else
                approved = true;

        } catch (IncorrectSocialsecNumberException e) {
            System.out.println("Personnummer måste innehålla 10 siffror.");
        } catch (NumberFormatException e) {
            System.out.println("Personnummer kan endast innehålla siffror.");
        }

        return approved;
    }

    public static void printMembers () {
        for (Customer c:Main.customers)
            System.out.println(c);
    }

    public static void printAttendances () {
        for (Attendance a:Main.attendanceAll)
            System.out.println(a);
    }
}
