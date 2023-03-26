package board;

import java.util.LinkedHashSet;
import java.util.Set;

public class MovesActions {

    private static char A_CHAR = 'A';
    private static char H_CHAR = 'H';

    public static boolean checkValidPosition(String position) {
        return isMoveValid(getRow(position), getColumn(position));
    }

    public static Set<String> getFuturePossibleMovesForPiece(int piece, String position) {
        Set<String> possibleMoves = new LinkedHashSet<>();

        switch (piece){
            case 1:
                getPossibleMovesForKing(position, possibleMoves);
                break;
            case 2:
                getPossibleMovesForQueen(position, possibleMoves);
                break;
            case 3:
                getPossibleMovesForPawn(position, possibleMoves);
                break;
            default:
                break;
        }
        return possibleMoves;
    }


    /**
     * Private Method
     */

    private static void getPossibleMovesForKing(String position, Set<String> possibleMoves) {
        char row = getRow(position);
        int column = getColumn(position);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;  // skip the case where both offsets are 0 (i.e. no movement)
                }
                calculateMovesAndAdd(row, column, i, j, possibleMoves, position);
            }
        }
    }

    private static void getPossibleMovesForQueen(String position, Set<String> possibleMoves) {
        char row = getRow(position);
        int column = getColumn(position);

//      for horizontal & vertical line
        for(int i = 0; i <= 8; i++) {
            calculateMovesAndAdd(row, 0, 0, i, possibleMoves, position);
            calculateMovesAndAdd(A_CHAR, column, i, 0, possibleMoves, position);

            //  for diagonal lines
            calculateMovesAndAdd(row, column, -i, i, possibleMoves, position);
            calculateMovesAndAdd(row, column, i, -i, possibleMoves, position);
        }

        //  for diagonal lines
        for(int i = 8; i >= 0; i--) {
            calculateMovesAndAdd(row, column, i, i, possibleMoves, position);
            calculateMovesAndAdd(row, column, -i, -i, possibleMoves, position);
        }
    }

    private static void getPossibleMovesForPawn(String position, Set<String> possibleMoves) {
        char row = getRow(position);
        int column = getColumn(position);
        calculateMovesAndAdd(row, column, -1, 0, possibleMoves, position);
    }

    private static void calculateMovesAndAdd(char row, int column, int rowOffset, int colOffset, Set<String> futureMoves, String position) {
        int newRow = row + rowOffset;
        int newCol = column + colOffset;
        String nextPossibleMove = (char)newRow + String.valueOf(newCol);
        if (isMoveValid(newRow, newCol) && !position.contentEquals(nextPossibleMove)) {
            addMoves(nextPossibleMove, futureMoves);
        }
    }

    private static void addMoves(String move, Set<String> futureMoves) {
        futureMoves.add(move);
    }

    private static char getRow(String position) {
        return position.charAt(0);
    }

    private static int getColumn(String position) {
        return Character.getNumericValue(position.charAt(1));
    }
    private static boolean isMoveValid(int row, int column) {
        return row >= A_CHAR && row <= H_CHAR && column >= 1 && column <= 8;
    }

}
