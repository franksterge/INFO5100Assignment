package main;
import classes.Sum;

import java.util.Random;

public class SumValue {
    public static void main(String[] args) {
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        System.out.println(sum(arr));
    }

    public static void generateRandomArray(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }
    }

    public static long sum(int[] arr) {
        int stop1 = arr.length/4;
        int stop2 = stop1 * 2;
        int stop3 = stop1 * 3;
        Sum sum = new Sum();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < stop1; i++) {
                sum.add(arr[i]);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = stop1; i < stop2; i++) {
                sum.add(arr[i]);
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = stop2; i < stop3; i++) {
                sum.add(arr[i]);
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = stop3; i < arr.length; i++) {
                sum.add(arr[i]);
            }
        });
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
        return sum.getSum();
    }
}

