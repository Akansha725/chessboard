package board;

import java.util.Set;

public class ChessBoard implements Board {

    private static final int BOARD_SIZE = 8;
    private static final String EMPTY_SQUARE = "--";
    private static int HIGHEST_POSITION = 72;

    private String[][] board = new String[BOARD_SIZE][BOARD_SIZE];

    public ChessBoard() {
        setInitialBoard();
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void printFutureMoveBoard(Set<String> possibleMoves) {
        setMoveBoard(possibleMoves);
        printBoard();
    }

    /**
     *
     * Private Methods
     */

    private String getPosition(int i, int j) {
        return ((char)(HIGHEST_POSITION-i)) + "" +(j+1);
    }

    private void setInitialBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = getPosition(i, j);
            }
        }
    }

    private void setMoveBoard(Set<String> possibleMoves) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                String move = getPosition(i, j);
                board[i][j] = possibleMoves.contains(move) ? EMPTY_SQUARE: move;
            }
        }
    }
}
