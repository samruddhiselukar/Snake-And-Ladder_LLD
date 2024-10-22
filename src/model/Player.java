package model;

public class Player {
    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;  // Players start at position 0 (outside the board)
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

