package pieces;

import dev.bykowski.Board;
import dev.bykowski.Position;
import dev.bykowski.pieces.Knight;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class KnightTest {

    @Test
    void attacksCorrectlyFromCenter() {
        Board board = new Board(8, 8);
        Knight knight = new Knight(new Position(3, 3));
        board.addPiece(knight);

        Set<Position> attacked = knight.getAttackedSquares(board);

        assertThat(attacked).containsExactlyInAnyOrder(
                // Moves to the top
                new Position(2, 5), new Position(4, 5),

                // Moves to top right and left
                new Position(1, 4), new Position(5, 4),

                // Moves to the bottom right and left
                new Position(1, 2), new Position(5, 2),

                // Moves to the bottom
                new Position(2, 1), new Position(4, 1)
        );
    }

    @Test
    void attacksCorrectlyFromCorner() {
        Board board = new Board(8, 8);
        Knight knight = new Knight(new Position(0, 0));
        board.addPiece(knight);

        Set<Position> attacked = knight.getAttackedSquares(board);

        assertThat(attacked).containsExactlyInAnyOrder(
                // Move to the top
                new Position(1, 2),

                // Move to the top right
                new Position(2, 1)
        );
    }
}
