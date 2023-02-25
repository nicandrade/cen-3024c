import java.util.Scanner;

/**
 * Module 5 Assignment to calculate Fibonacci number and time in nanoseconds
 * @author Nic Andrade
 */


public class Main {

    /**
     * Main method used to calculate a Fibonacci number recursivily and iteratively, and time to calculate.
     * @param args Strings passed to the main.
     */
    public static void main(String[] args) {
        int inputNumber;
        long outputNumber;
        long startTime;
        long totalTime;

        System.out.println("What number in sequence?");
        Scanner scannerInput = new Scanner(System.in);
        inputNumber = scannerInput.nextInt();

        startTime = System.nanoTime();
        outputNumber = fibonacciIterative(inputNumber);
        totalTime = timer(startTime);
        outputText("Iterative", outputNumber, totalTime);

        startTime = System.nanoTime();
        outputNumber = fibonacciRecursive(inputNumber);
        totalTime = timer(startTime);
        outputText("Recursive", outputNumber, totalTime);
    }

    /**
     * Utilized to calculate the Fibonacci sequence using a recursive method, and return time in nanoseconds to calculate.
     * @param sequenceSpot Value of what position in the Fibonacci sequence you want to know the value of.
     * @return Fibonacci value in the sequence spot requested
     */
    public static int fibonacciRecursive(Integer sequenceSpot) {
        if (sequenceSpot == 1 || sequenceSpot == 0) {
            return sequenceSpot;
        }
        return fibonacciIterative(sequenceSpot - 1) + fibonacciIterative(sequenceSpot - 2);
    }

    /**
     * Utilized to calculate the Fibonacci sequence using a iterative method, and return time in nanoseconds to calculate.
     * @param sequenceSpot Value of what position in the Fibonacci sequence you want to know the value of.
     * @return Fibonacci value in the sequence spot requested
     */
    public static int fibonacciIterative(Integer sequenceSpot) {
        int currentNumber = 1;
        int previousNumber = 0;
        int twoPreviousNumber;

        for (int i = 1; i < sequenceSpot; i++) {
            twoPreviousNumber = previousNumber;
            previousNumber = currentNumber;
            currentNumber = twoPreviousNumber + previousNumber;
        }
        return currentNumber;
    }


    /**
     * Used to calculate the time in nanoseconds between a passed start time and the time the method is called.
     * @param startTime Initial value of time to be used
     * @return Duration in nanoseconds the timer has been running.
     */
    public static long timer(long startTime) {
        long split = System.nanoTime();
        long elapsedTime = split - startTime;
        return elapsedTime;
    }

    /**
     * Generates text output of values from method calls
     * @param sequenceType String value used to identify call type
     * @param value Long value of number in Fibonacci sequence
     * @param totalTime Long value of total time in nanoseconds it took to calculate Fibonacci number
     */
    public static void outputText(String sequenceType, long value, long totalTime) {
        System.out.println("Fibonacci " + sequenceType + ":");
        System.out.println("Number: " + value);
        System.out.println("Time in nanoseconds: " + totalTime + "\n");
    }
}