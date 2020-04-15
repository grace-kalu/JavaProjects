package com.codeWithMerald;

import java.util.Scanner;

/*
(Science: day of the week) Zeller’s congruence is an algorithm developed by
Christian Zeller to calculate the day of the week.
*/

public class ZellerAlgorithm {
    public static void main(String[] args) {
        int h; //day of the week;
        int q; //day of the month;
        int m; //month of the year;
        int year;//this get the year
        int j; //century;
        int k; //yearOfCentury;

        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a year, month, and day of the month.
        System.out.print("Enter year: (e.g., 2012): ");
        year = input.nextInt();
        System.out.print("Enter month: 1-12: ");
         m = input.nextInt();

         do {
             System.out.print("Enter the day of the month: 1-31: ");
             q = input.nextInt();
         }
         //check for 28 days, 30days and 31days constraints
         while(((m == 4 || m == 6 || m == 9 || m== 11) && q > 30) || (m == 2 && q > 28) || q >31);
        // Convert January and February to months 13 and 14 of the previous year
        if (m == 1 || m == 2) {
            m = (m == 1) ? 13 : 14;
            year--;
        }

        j = year / 100; //we store the value of the century (every 100 years) with this variable j
        k = year % 100; //we store the year of the century
        h = (q + (26 * (m + 1) / 10) + k + (k/4) + (j/4) + (5 *j)) % 7;//calculate the day of the week using zeller's algorithm.

        // Display result
        System.out.print("Day of the week is ");
        switch (h) {
            case 0:
                System.out.println("Saturday");
                break;
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
        }
    }
}
