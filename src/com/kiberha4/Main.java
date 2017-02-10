package com.kiberha4;

import com.kiberha4.calc.Cube;
import com.kiberha4.calc.Prost;
import com.kiberha4.calc.Sec;

/**
 * Created by root on 10.02.17.
 *
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Consumer consumer =  new Consumer();
        int[] ints = {1, 2, 3};
        Thread[] threads = new Thread[6];
        threads[0] = new Thread(new Cube(ints, consumer));
        threads[1] = new Thread(new Cube(ints, consumer));
        threads[2] = new Thread(new Sec(ints, consumer));
        threads[3] = new Thread(new Sec(ints, consumer));
        threads[4] = new Thread(new Prost(ints, consumer));
        threads[5] = new Thread(new Prost(ints, consumer));

        for (Thread th:threads) {
            th.start();
        }

        for (Thread th:threads) {
            th.join();
        }

        System.out.println("Result: " + consumer.getSum());
    }
}
