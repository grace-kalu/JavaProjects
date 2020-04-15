package com.codeWithMerald;
/*
 (Random number chooser) Write a method that returns a random number between    *
 1 and 54, excluding the numbers passed in the argument. The method header is   *
 specified as follows:                                                          *
 public static int getRandom(int... numbers)                                    *
 */

import java.util.Scanner;

public class RandomNumber {

    static final int SIZE = 53;

    public static void main(String[] args) {

        int[] numbers = new int[SIZE];
        Scanner input = new Scanner(System.in);

        System.out.print("Enter numbers to exclude from random (1-54): ");
        for (int i = 0; i < numbers.length; i++) numbers[i] = input.nextInt();

        System.out.println("Number generated: " + getRandom(numbers));
    }

    public static int getRandom(int... numbers) {

        int num;    // Random number
        boolean isExcluded; // Is the number excluded
        do {
            isExcluded = false;
            num = 1 + (int) (Math.random() * 54);
            for (int e : numbers) {
                if (num == e) {
                    isExcluded = true;
                    break;
                }
            }
        } while (isExcluded); // Test if number is Excluded
        return num;
    }


}