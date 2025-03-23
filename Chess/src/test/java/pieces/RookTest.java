package pieces;

import dev.bykowski.Board;
import dev.bykowski.Position;
import dev.bykowski.pieces.Rook;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RookTest {

    @Test
    void attacksCorrectlyWithoutObstacles() {
        Board board = new Board(8, 8);
        Rook rook = new Rook(new Position(3, 3));
        board.addPiece(rook);

        Set<Position> attacked = rook.getAttackedSquares(board);

        assertThat(attacked).containsExactlyInAnyOrder(
                new Position(0, 3),
                new Position(1, 3),
                new Position(2, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4),
                new Position(3, 5),
                new Position(3, 6),
                new Position(3, 7)
        );
    }

    @Test
    void attackStopsAtObstacle() {
        Board board = new Board(8, 8);
        Rook rook = new Rook(new Position(3, 3));
        board.addPiece(rook);
        board.addObstacle(
                new Position(3, 5)
        );

        Set<Position> attacked = rook.getAttackedSquares(board);

        assertThat(attacked).containsExactlyInAnyOrder(
                new Position(0, 3),
                new Position(1, 3),
                new Position(2, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4),
                new Position(3, 5)
        );

        assertThat(attacked).doesNotContain(new Position(3, 6));
    }
}