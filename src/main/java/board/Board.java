package board;

import java.util.Set;

public interface Board {

    void printBoard();

    void printFutureMoveBoard(Set<String> possibleMoves);
}
