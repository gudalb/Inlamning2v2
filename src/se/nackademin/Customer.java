package se.nackademin;

import java.time.LocalDate;
import java.util.List;


public class Customer {
    private List<Attendance> attendance;
    private String ssNumber;
    private String name;
    private LocalDate payDate;

    Customer (String ssNumber, String name, LocalDate payDate) {
        this.ssNumber = ssNumber;
        this.name = name;
        this.payDate = payDate;
        Main.customers.add(this);
    }

    public void addAttendance (Attendance a) {
        this.attendance.add(a);
    }

    public String getName () {
        return this.name;
    }

    public String getssNumber () {
        return this.ssNumber;
    }

    public LocalDate getPayDate () {
        return this.payDate;
    }

    @Override
    public String toString() {
        return ssNumber + " " + name + " " + payDate;
    }
}
