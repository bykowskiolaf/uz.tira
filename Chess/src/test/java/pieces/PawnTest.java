package pieces;

import dev.bykowski.Board;
import dev.bykowski.Position;
import dev.bykowski.pieces.Pawn;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {

    @Test
    void attacksDiagonallyFromMiddle() {
        Board board = new Board(8, 8);
        Pawn pawn = new Pawn(new Position(3, 3)); // Assume white pawn moving upwards
        board.addPiece(pawn);

        Set<Position> attacked = pawn.getAttackedSquares(board);

        assertThat(attacked).containsExactlyInAnyOrder(
                // Top right
                new Position(4, 4),

                // Top left
                new Position(2, 4)
        );
    }

    @Test
    void attacksOnlyWithinBounds() {
        Board board = new Board(8, 8);
        Pawn pawn = new Pawn(new Position(0, 0));
        board.addPiece(pawn);

        Set<Position> attacked = pawn.getAttackedSquares(board);

        assertThat(attacked).containsExactlyInAnyOrder(
                // Only the positions within bounds, top right
                new Position(1, 1)
        );
    }
}
