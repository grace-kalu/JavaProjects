package com.codeWithMerald;

import java.util.Scanner;

public class LuhnsAlgorithm {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long num = 0; //declares and initialize the credit card numbers.
        long number = 	getCardNumber(num); //the method is use to get the number and perform the operations

    }

    public static long getCardNumber (long number) { //method to get the card number and performs the required check we need to do
        System.out.println("Enter a credit card number as a long integer: ");//Prompt the user to enter the credit card number
        Scanner input = new Scanner(System.in);//Scanner Method
        number = input.nextLong(); //This gets the credit card number;
        int len = getSize(number); //this get the length of the number.
        if(getSize(number) == 13 || getSize(number) == 16) { //if the length of the credit card is 13 or 16, we can continue, else we get the credit card number again
            if(prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number, 6)) {
                //if the prefix matches any of the following number described above, we start manipulation.
                int evenSum = sumOfDoubleEvenPlace(number);//the sum of the even places of the card
                int oddSum = sumOfOddPlace(number); //the sum of the odd places of the card
                long summation = evenSum + oddSum; //total sum of both even and odd places.
                if(isValid(summation)) { //we pass the value of the summation of even and odd together to check if its valid
                    System.out.println(number + " is valid"); //if return true,  its valid
                } else { //if it return false
                    System.out.println(number + " is invalid"); //it is invalid
                }
            } else {
                System.out.println("This card is cannot be classified as 'Visa', 'Master Cards', 'American Express Cards' or 'Discover Card'");
                //this is when the card prefix number don't match
                getCardNumber(number); //restart the getting card method process again.
            }

        } else {
            System.out.println("Credit card number length Mismatch "); // if the number of digit don't match;
            getCardNumber(number); //restart the process
        }


        return number;
    }

    public static int getSize(long d) { //this return the length of the number passed to it
        String card = d + ""; //it convert the credit card number into a string

        return card.length(); //this return the length as an integer.

    }

    public static boolean isValid(long number) { //check if the card is valid (divisible by 10).
        return (number % 10) == 0; //return validity;
    }

    public static int sumOfDoubleEvenPlace (long number) { //this is used to add up all the even number
        String card = number + ""; //we convert it to string to get each number to manipulate by multiplying by 2
        int sum = 0; //initialize the sum value;
        for(int i = 0; i < card.length() ; i += 2) {//iteration
            sum += getDigit(Integer.parseInt(card.charAt(i) + "") * 2);//we pass each of the numbers after converting it to a method of getDigit and sum it up to sum
        }
        return sum; //return sum
    }

    public static int getDigit(int number) {//this check if the digit passed is less than 10 or greater
        if(number <= 9) { // if number is less than 10, return it
            return number;
        } else {
            return (number % 10) + (number / 10); // if it is up to ten or more ass it up
        }
    }

    public static int sumOfOddPlace (long number) { //this method add up all the odd place number
        String card = number + ""; // convert it to string first
        int sum = 0; //initialize the sum variable
        for(int i = 0; i < card.length() ; i++) { //iteration to get all the odd number and add them together
            if((i % 2) != 0 ) { //get the odd place integers
                sum += Integer.parseInt(card.charAt(i) + "");
            }
        }
        return sum; // return sum
    }

    public static boolean prefixMatched (long number, int d) {//this check the prefix of the card number with the given integer d
        return getPrefix(number, getSize(d)) == d; // we return the prefix after comparison.
    }

    public static long getPrefix (long number, int k) { //this get the prefix of the number with regards to the length gotten with the getSize method
        if (getSize(number) > k)  { //if the length of the number is greater than the length of the prefix.
            String num = number + ""; //we convert it to string and use the substring method to get the new number and parse it to long value
            return  Long.parseLong(num.substring(0, k)); //return the long.
        }
        return number; // if not return number
    }
}

