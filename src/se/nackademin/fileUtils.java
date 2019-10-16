package se.nackademin;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fileUtils {

    public static boolean readCustomers (List<Customer> customers) {
        List<String> tempList = new ArrayList<>();
        boolean fileRead = false;

        try (Scanner sc = new Scanner(new File("customers.txt"))) {
            while (sc.hasNextLine()) {
                String tempStr = sc.nextLine();
                if (tempStr.length() < 1)
                    break;
                if (tempStr.contains(",")) {
                    tempList.add(tempStr.substring(0, tempStr.indexOf(",")));
                    tempList.add(tempStr.substring(tempStr.indexOf(",") + 2));
                } else
                    tempList.add(tempStr);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


        for (int i = 0; i < tempList.size(); i++) {
            String tempssNumber = "";
            String tempName = "";
            LocalDate tempDate = LocalDate.now();

            for (int e = 0; e < 3; e++) {
                if (e == 0) {
                    tempssNumber = tempList.get(i);
                    i++;
                }
                if (e == 1) {
                    tempName = tempList.get(i);
                    i++;
                }
                if (e == 2) {
                    tempDate = LocalDate.parse(tempList.get(i));
                }
            }
            customers.add(new Customer(tempssNumber,tempName,tempDate));
        }

        fileRead = true;
        return fileRead;
    }
}
