package se.nackademin;

import java.time.LocalDate;

public class Customer {
    private String ssNumber;
    private String name;
    private LocalDate payDate;

    Customer (String ssNumber, String name, LocalDate payDate) {
        this.ssNumber = ssNumber;
        this.name = name;
        this.payDate = payDate;
    }
}
