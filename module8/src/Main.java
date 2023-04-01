import java.util.Random;

public class Main {

    private static int threadSum = 0;
    private static int singleSum = 0;
    private static int arraySize = 200000000;
    private static int[] numberArray = new int[arraySize];

    private static synchronized void threadValue(int i) {
        threadSum += i;
    }

    public static void main(String[] args) throws InterruptedException {
        //Create Random Number
        Random randomNumber = new Random();

        //Load Values into the Array
        for (int i = 0; i < arraySize; i++) {
            numberArray[i] = randomNumber.nextInt(1, 10);
        }

        //Other Variables
        long nanoTimeStart;
        long nanoTimeEnd;
        long threadTotalTime;
        long singleTotalTime;


        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000000; i++) {
                    threadValue(numberArray[i]);
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 50000000; i < 100000000; i++) {
                    threadValue(numberArray[i]);
                }
            }
        });

        Thread threadThree = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 100000000; i < 150000000; i++) {
                    threadValue(numberArray[i]);
                }
            }
        });

        Thread threadFour = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 150000000; i < 200000000; i++) {
                    threadValue(numberArray[i]);
                }
            }
        });

        nanoTimeStart = System.nanoTime();
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();

        threadOne.join();
        threadTwo.join();
        threadThree.join();
        threadFour.join();
        nanoTimeEnd = System.nanoTime();

        //Calculate Multi-Thread Time
        threadTotalTime = nanoTimeEnd - nanoTimeStart;

        //Single Thread Sum
        Thread threadFive = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arraySize; i++) {
                    singleSum += numberArray[i];
                }
            }
        });
        nanoTimeStart = System.nanoTime();
        threadFive.start();
        threadFive.join();
        nanoTimeEnd = System.nanoTime();

        //Calculate Single Thread Time
        singleTotalTime = nanoTimeEnd - nanoTimeStart;

        System.out.println("<<----MULTI-THREAD RESULTS---->>>");
        System.out.println("Multi-Thread Sum: " + threadSum);
        System.out.println("Multi-Thread Nanoseconds: " + threadTotalTime);

        System.out.println("\n<<----SINGLE THREAD RESULTS---->>>");
        System.out.println("Single Thread Sum: " + singleSum);
        System.out.println("Single Thread Nanoseconds: " + singleTotalTime);


    }
}