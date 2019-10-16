package se.nackademin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fileUtils {

    public static boolean readCustomers (List<Customer> customers) {
        List<String> tempList = new ArrayList<>();
        boolean fileRead = false;

        try (Scanner sc = new Scanner(new File("customers.txt"))) {
            while (sc.hasNextLine()) {
                tempList.add(sc.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
