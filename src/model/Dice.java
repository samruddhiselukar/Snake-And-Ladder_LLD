package model;

import java.util.Random;

public class Dice {
    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1;  // Dice value between 1 and 6
    }
}

