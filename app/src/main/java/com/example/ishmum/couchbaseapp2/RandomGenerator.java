package com.example.ishmum.couchbaseapp2;

import java.util.Random;

public class RandomGenerator {

    private final Random random;

    public RandomGenerator() {
        random = new Random();
    }

    public String getRandomNumberStr() {
        return String.valueOf(getRandomNumber());
    }

    public String getRandomNumberStr(int max) {
        return String.valueOf(getRandomNumber(max));
    }

    public String getRandomNumberStr(int max, int min) {
        return String.valueOf(getRandomNumber(max, min));
    }

    public int getRandomNumber() {
        return random.nextInt(1000);
    }

    public int getRandomNumber(int max) {
        return random.nextInt(max);
    }

    public int getRandomNumber(int max, int min) {
        return random.nextInt(max - min) + min;
    }
}
