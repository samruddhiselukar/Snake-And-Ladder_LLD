package service;

import model.Board;
import model.Dice;
import model.Player;

import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;
    private boolean isGameFinished;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.dice = new Dice();
        this.isGameFinished = false;
    }

    public void start() {
        int currentPlayerIndex = 0;

        while (!isGameFinished) {
            Player currentPlayer = players.get(currentPlayerIndex);
            playTurn(currentPlayer);

            if (currentPlayer.getPosition() == board.getSize()) {
                System.out.println(currentPlayer.getName() + " wins the game!");
                isGameFinished = true;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();  // Switch to next player
        }
    }

    private void playTurn(Player player) {
        int diceRoll = dice.roll();
        int initialPosition = player.getPosition();
        int finalPosition = initialPosition + diceRoll;

        if (finalPosition > board.getSize()) {
            finalPosition = initialPosition;  // Player cannot move past the final cell
        } else {
            finalPosition = board.checkForSnakesOrLadders(finalPosition);
        }

        player.setPosition(finalPosition);

        System.out.println(player.getName() + " rolled a " + diceRoll +
                " and moved from " + initialPosition + " to " + finalPosition);
    }
}
