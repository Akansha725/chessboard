package board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

public class MovesActionsTest {

    @Test
    public void testGetFuturePossibleMovesForKing() {
        Set<String> moves = MovesActions.getFuturePossibleMovesForPiece(1, "D5");
        Assertions.assertIterableEquals(moves, Arrays.asList("C4", "C5", "C6", "D4", "D6", "E4", "E5", "E6"));
    }

    @Test
    public void testGetFuturePossibleMovesForQueen() {
        Set<String> moves = MovesActions.getFuturePossibleMovesForPiece(2, "E4");
        Assertions.assertIterableEquals(moves,
                Arrays.asList("A4", "E1", "B4", "D5", "F3", "E2", "C4", "C6", "G2", "E3", "D4", "B7", "H1", "A8", "E5", "F4", "E6", "G4", "E7", "H4", "E8", "H7", "B1", "G6", "C2", "F5", "D3"));
    }

    @Test
    public void testGetFuturePossibleMovesForPawn() {
        Set<String> moves = MovesActions.getFuturePossibleMovesForPiece(3, "G1");
        Assertions.assertIterableEquals(moves, Arrays.asList("F1"));
    }

    @Test
    public void testGetFuturePossibleMovesForInvalid() {
        Set<String> moves = MovesActions.getFuturePossibleMovesForPiece(3, "D%");
        Assertions.assertIterableEquals(moves, Arrays.asList());
    }

    @Test
    public void testCheckValidPosition_true() {
        Assertions.assertTrue(MovesActions.checkValidPosition("D5"));
    }

    @Test
    public void testCheckValidPosition_false() {
        Assertions.assertFalse(MovesActions.checkValidPosition("D%"));
    }
}
