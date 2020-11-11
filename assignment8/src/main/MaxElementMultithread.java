package main;

import java.util.Random;

public class MaxElementMultithread {
    public static void main(String[] args) {
        int[] arr = new int[4000000];
        createLargeArray(arr);

        int stop1 = arr.length/4;
        int stop2 = stop1 * 2;
        int stop3 = stop1 * 3;

        CustomThread t1 = new CustomThread(arr, 0, stop1);
        CustomThread t2 = new CustomThread(arr, stop1, stop2);
        CustomThread t3 = new CustomThread(arr, stop2, stop3);
        CustomThread t4 = new CustomThread(arr, stop3, arr.length);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int max1 = t1.getLocalMax();
        System.out.println("max 1 is " + max1);
        int max2 = t2.getLocalMax();
        System.out.println("max 2 is " + max2);
        int max3 = t3.getLocalMax();
        System.out.println("max 3 is " + max3);
        int max4 = t4.getLocalMax();
        System.out.println("max 4 is " + max4);

        int globalMax = Math.max(Math.max(max1, max2), Math.max(max3, max4));
        System.out.println("Global max is " + globalMax);
    }

    public static void createLargeArray(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
    }


}

class CustomThread extends Thread {
    int localMax;
    int[] arrToProcess;
    int minBound;
    int maxBound;

    public CustomThread(int[]arr, int minBound, int maxBound) {
        this.localMax = Integer.MIN_VALUE;
        this.arrToProcess = arr;
        this.minBound = minBound;
        this.maxBound = maxBound;
    }
    @Override
    public void run() {
        for (int i = minBound; i < maxBound; i++) {
            int current = this.arrToProcess[i];
            if (current > this.localMax) {
                this.localMax = current;
            }
        }
    }

    public int getLocalMax() {
        return this.localMax;
    }
}
