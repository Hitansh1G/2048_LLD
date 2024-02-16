package org.example;

import org.example.Entity.Board;
import org.example.Entity.Tile;
import org.example.Service.BoardService;

import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        BoardService boardService = new BoardService();
        Scanner scanner = new Scanner(System.in);

        while (!boardService.isGameOver(board.getTiles())) {
            // Display the board
            displayBoard(board.getTiles());

            // Take input from the user for direction
            System.out.print("Enter direction (UP, DOWN, LEFT, RIGHT): ");
            String input = scanner.nextLine().toUpperCase();

            // Move tiles based on input
            if (input.equals("UP")) {
                boardService.moveTilesUp(board.getTiles());
            } else if (input.equals("DOWN")) {
                boardService.moveTilesDown(board.getTiles());
            } else if (input.equals("LEFT")) {
                boardService.moveTilesLeft(board.getTiles());
            } else if (input.equals("RIGHT")) {
                boardService.moveTilesRight(board.getTiles());
            } else {
                System.out.println("Invalid direction. Please enter UP, DOWN, LEFT, or RIGHT.");
                continue;
            }

            // Add a new tile after movement
            board.addNewTile();
        }

        // Display game over message
        System.out.println("Game Over!");
        scanner.close();
    }

    private static void displayBoard(Tile[][] tiles) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                System.out.print(tiles[i][j].getValue() + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
