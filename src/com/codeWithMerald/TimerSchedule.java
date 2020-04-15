package com.codeWithMerald;
/*Write a program that prompts the user to enter the number of seconds, displays a message at every second, and terminates when the time expires. Here is a sample run:
 * */
import java.util.Timer; //import the Timer class
import java.util.TimerTask; //import the timertask class
import java.util.Scanner; //import the scanner class;

public class TimerSchedule {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in); //Scanner Method
        Timer times = new Timer(); //defines the timer method;
        System.out.print("How many Seconds: "); //This prompt the user to input how may seconds;
        TimerTask task = new TimerTask () {
            int seconds = input.nextInt(); //we get the seconds needed to start the timer;

            public void run() {		//This start the timer task
                if (seconds == 1) {
                    System.out.println("Stopped");
                    times.cancel(); //this stops the timer / cancels it
                } else if (seconds <= 2) {
                    System.out.println(--seconds + " second remaining");
                    //this helps moderates our output for seconds when its less than 2
                } else {
                    System.out.println(--seconds + " seconds remaining");
                }

            }
        };
        times.schedule(task, 0, 1000);
        //This starts the counter and the 1000 is the delay in milliseconds which equivalent is 1 seconds

    }

}