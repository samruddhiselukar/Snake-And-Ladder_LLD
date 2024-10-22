package model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int size;
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board(int size) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public void addSnake(int head, int tail) {
        snakes.put(head, tail);
    }

    public void addLadder(int start, int end) {
        ladders.put(start, end);
    }

    public int getSize() {
        return size;
    }

    public int checkForSnakesOrLadders(int position) {
        if (snakes.containsKey(position)) {
            return snakes.get(position);  // Return tail of the snake
        } else if (ladders.containsKey(position)) {
            return ladders.get(position);  // Return end of the ladder
        }
        return position;
    }
}

