package com.kiberha4.calc;

import com.kiberha4.Consumer;

/**
 * Created by root on 10.02.17.
 */
public class Cube implements Runnable{
    private int[] ints;
    private Consumer consumer;

    public Cube(int[] ints, Consumer consumer) {
        this.ints = ints;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        for (int i : ints) {
            int cub = i * i * i;
            consumer.message(cub, 0, 0);
        }
    }
}
