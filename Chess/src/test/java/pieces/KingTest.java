package pieces;

import dev.bykowski.Board;
import dev.bykowski.Position;
import dev.bykowski.pieces.King;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class KingTest {

    @Test
    void attacksCorrectlyFromCenter() {
        Board board = new Board(8, 8);
        King king = new King(new Position(3, 3));
        board.addPiece(king);

        Set<Position> attacked = king.getAttackedSquares(board);

        assertThat(attacked).containsExactlyInAnyOrder(
                new Position(2, 4), new Position(3, 4), new Position(4, 4),
                new Position(2, 3), new Position(4, 3),
                new Position(2, 2), new Position(3, 2), new Position(4, 2)
        );
    }

    @Test
    void doesNotAttackOutOfBounds() {
        Board board = new Board(8, 8);
        King king = new King(new Position(0, 0));
        board.addPiece(king);

        Set<Position> attacked = king.getAttackedSquares(board);

        assertThat(attacked).containsExactlyInAnyOrder(
                new Position(0, 1),
                new Position(1, 0),
                new Position(1, 1)
        );
    }

}
