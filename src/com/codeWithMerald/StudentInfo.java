package com.codeWithMerald;
/*
 (Sort students) Write a program that prompts the user to enter the number of  *
 students, the students’ names, and their scores, and prints student names in  *
 decreasing order of their scores.                                             *
 */
//import java.util.*;
//
//public class StudentInfo {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter the number of students: ");
//        int numofstudents = input.nextInt();
//        String[] names = new String[numofstudents];
//        int[] array = new int[numofstudents];
//        for (int i = 0; i < numofstudents; i++) {
//            System.out.print("Enter the student's name: ");
//            names[i] = input.next();
//            System.out.print("Enter the student's score: ");
//            array[i] = input.nextInt();
//        }
//        selectionSort(names, array);
//        System.out.println(Arrays.toString(names));
//    }
//
//    public static void selectionSort(String[] names, int[] array) {
//        for (int i = array.length - 1; i >= 1; i--) {
//            String temp;
//            int currentMax = array[0];
//            int currentMaxIndex = 0;
//            for (int j = 1; j <= i; j++) {
//                if (currentMax > array[j]) {
//                    currentMax = array[j];
//                    currentMaxIndex = j;
//                }
//            }
//            if (currentMaxIndex != i) {
//                temp = names[currentMaxIndex];
//                names[currentMaxIndex] = names[i];
//                names[i] = temp;
//                array[currentMaxIndex] = array[i];
//                array[i] = currentMax;
//            }
//        }
//    }
//}

import java.util.Scanner;

public class StudentInfo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number of students
        System.out.print("Enter the number of students: ");
        String[] students = new String[input.nextInt()];
        int[] scores = new int[students.length];

        // Prompt the user to enter each students' names and thier scores
        System.out.println("Enter the name and score for each student:");
        for (int i = 0; i < students.length; i++) {
            System.out.print("Student " + (i + 1) + ": " + "");
            students[i] = input.next();
            System.out.print("Score: ");
            scores[i] = input.nextInt();
        }

        // Sort student names in decreasing order of their scores
        sortDecreasing(students, scores);

        // Display student name in decreasing order of their scores
        System.out.printf("%-6s%-30s%s\n", "S/No","STUDENTS NAME", "SCORES");
        for(int j = 0, v = 0; j < scores.length; j++, v++) {
            System.out.printf("%-6d%-30s%d\n", j, students[j], scores[j]);
        }
    }

    /**
     * sorts a string and integer array in decreasing order
     */
    public static void sortDecreasing(String[] strs, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            int maxIndex = i;
            String temp;

            // Find the minimum in the list[i..nums.length - 1]
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                // Swap string array
                temp = strs[i];
                strs[i] = strs[maxIndex];
                strs[maxIndex] = temp;

                // Swap int array
                nums[maxIndex] = nums[i];
                nums[i] = max;
            }
        }
    }
}