import model.Board;
import model.Player;
import service.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of snakes and snake positions
        int numSnakes = scanner.nextInt();
        Board board = new Board(100);  // Assuming board size of 100

        for (int i = 0; i < numSnakes; i++) {
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            board.addSnake(head, tail);
        }

        // Input number of ladders and ladder positions
        int numLadders = scanner.nextInt();
        for (int i = 0; i < numLadders; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            board.addLadder(start, end);
        }

        // Input number of players and player names
        int numPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            String playerName = scanner.next();
            players.add(new Player(playerName));
        }

        // Start the game
        Game game = new Game(board, players);
        game.start();

        scanner.close();
    }
}
