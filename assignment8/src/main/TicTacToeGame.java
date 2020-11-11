package main;

import classes.GameBoard;

import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        GameBoard board = new GameBoard(3);


        printGameBoard(board);
        Scanner console = new Scanner(System.in);
        while (!board.gameIsOver()) {
            System.out.println("Enter your placement (1 -9): ");
            try {
                String consoleLine = console.nextLine();
                int playerPos = Integer.parseInt(consoleLine);
                placePiece(board, playerPos, "player");
            } catch (NumberFormatException e) {
                System.out.println("Illegal input, please try again.");
                continue;
            }
            printGameBoard(board);
        }

        System.out.println(checkWinner(board));

        System.out.println(board);

    }

    public static void printGameBoard(GameBoard board) {
        System.out.println(board);
    }

    public static void placePiece(GameBoard board, int pos, String user) {
        board.placePiece(pos, user);
    }

    public static String checkWinner(GameBoard board) {
        return board.checkWinner();
    }
}
