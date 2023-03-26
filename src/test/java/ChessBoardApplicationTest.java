import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ChessBoardApplicationTest {

    @Test
    public void testGetPossibleMoves() {
        Set<String> moves = ChessBoardApplication.getPossibleMoves(1, "D5");
        Assertions.assertNotNull(moves);
    }

    @Test
    public void testGetPossibleMoves_exception() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            ChessBoardApplication.getPossibleMoves(1, "I5");
        });

        Assertions.assertTrue(exception.getMessage().contains("Invalid Position!"));

    }
}
