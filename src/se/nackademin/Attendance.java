package se.nackademin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Attendance {
    private Customer customer;
    private LocalDateTime dateTime;

    Attendance (Customer c) {
        this.customer = c;
        this.dateTime = LocalDateTime.now();
        Main.attendanceAll.add(this);
    }

    public Customer getCustomer () {
        return customer;
    }

    public String getCustomerName () {
        return customer.getName();
    }
    @Override
    public String toString() {
        return customer.getName() + " " + this.dateTime.format(DateTimeFormatter.ofPattern("YYMMdd HH:mm"));
    }
}
