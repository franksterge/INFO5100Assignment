package classes;

import java.util.Random;
import java.util.Scanner;

public class GameBoard {
    private int[][] board;
    private static String[] playerMap = {" ", "X", "O"};
    private int dimension;
    private int count;
    private Scanner console;

    public GameBoard(int dimension) {
        this.board = new int[dimension][dimension];
        this.dimension = dimension;
        this.count = 0;
        this.console = new Scanner(System.in);
    }


    public boolean gameIsOver() {
        return isGameFinished() != 0 || (this.count == this.dimension * this.dimension);
    }

    private int isGameFinished() {
        int diagonalLeft = findWinner(0, 0, this.board[0][0], 1, 1, 0);
        if (diagonalLeft != 0) {
            return diagonalLeft;
        }
        int diagonalRight = findWinner(0, 2, this.board[0][2], -1, -1, 0);
        if (diagonalRight != 0) {
            return diagonalRight;
        }

        for (int i = 0; i < this.dimension; i++) {
            int vertical = findWinner(0, i, this.board[0][i], 1, 0, 0);
            if (vertical != 0) {
                return vertical;
            }
        }

        for (int i = 0; i < this.dimension; i++) {
            int horizontal = findWinner(i, 0, this.board[i][0], 0, 1, 0);
            if (horizontal != 0) {
                return horizontal;
            }
        }
        return 0;
    }

    public String checkWinner() {
        int winner = isGameFinished();
        if (winner == 1) {
            return "Congratulations you won!";
        } else if (winner == 2) {
            return "CPU wins! Sorry :(";
        }
        if (this.count == this.dimension * this.dimension) {
            return "CAT! (Draw)";
        }
        return "Game not over yet.";
    }

    private int findWinner(int row, int col, int prev, int deltaRow, int deltaCol, int position) {
        if (position == this.dimension) {
            return prev;
        }

        if (indexInbound(row, col)) {
            int current = this.board[row][col];
            if (current == prev) {
                return findWinner(row + deltaRow, col + deltaCol, current, deltaRow, deltaCol, position + 1);
            } else {
                return findWinner(row + deltaRow, col + deltaCol, current, deltaRow, deltaCol, 0);
            }
        }
        return 0;
    }

    public void placePiece(int pos, String user) {
        if (pos > this.dimension * this.dimension || pos < 1) {
            System.out.println("Illegal position, please try again.");
            return;
        }

        int player = 0;
        if (user.equals("player")) {
            player = 1;
        } else if (user.equals("cpu")) {
            player = 2;
        }
        int row = (pos - 1) / this.dimension;
        int col = (pos - 1) % this.dimension;
        boolean addResult = add(row, col, player);
        if (user.equals("player")) {
            if (addResult) {
                boolean addedForComputer = false;
                Random r = new Random();
                while (!addedForComputer && (this.count < this.dimension * this.dimension - 1)) {
                    addedForComputer = add(r.nextInt(3), r.nextInt(3), 2);
                }
            } else {
                askToAdd();
            }
        }

    }

    private void askToAdd() {
        System.out.print("Illegal position, please try again.");
        String consoleLine = console.nextLine();
        try {
            int pos = Integer.parseInt(consoleLine);
            placePiece(pos, "player");
        } catch (Exception e) {
            askToAdd();
        }
    }

    public boolean add(int row, int col, int player) {
        if (this.board[row][col] == 0) {
            this.board[row][col] = player;
            this.count += 1;
            return true;
        }
        return false;
    }

    private boolean indexInbound(int row, int col) {
        return (row < this.dimension && col < this.dimension) &&
                (row >= 0 && col >= 0);
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                result += playerMap[(this.board[i][j])];
                if (j == this.dimension - 1) {
                    result += "\n";
                    if (i != this.dimension - 1) {
                        char[] breakLine = {'-', '+', '-', '+', '-'};
                        result += new String(breakLine) + "\n";
                    }
                } else {
                    result += "|";
                }
            }
        }
        return result;
    }
}
