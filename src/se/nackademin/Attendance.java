package se.nackademin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Attendance {
    private Customer customer;
    private String ssNumber;
    private LocalDateTime dateTime;

    private Attendance (Customer c) {
        this.customer = c;
        this.ssNumber = c.getssNumber();
        this.dateTime = LocalDateTime.now();

        c.addAttendance(this);
        Main.attendanceAll.add(this);
    }

    @Override
    public String toString() {
        return customer.getName() + " " + this.dateTime.format(DateTimeFormatter.ofPattern("YYMMdd HH:mm"));
    }
}
