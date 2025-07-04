package com.aui.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate customParsedDate = LocalDate.parse("01/01/2025", formatter);

        String todaysDate = today.format(formatter);

        
        System.out.println("Current Date: " + todaysDate);
        
    }
}
