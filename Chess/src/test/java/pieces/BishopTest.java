package pieces;

import dev.bykowski.Board;
import dev.bykowski.Position;
import dev.bykowski.pieces.Bishop;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BishopTest {

    @Test
    void attacksCorrectlyWithoutObstacles() {
        Board board = new Board(8, 8);
        Bishop bishop = new Bishop(new Position(3, 3));
        board.addPiece(bishop);

        Set<Position> attacked = bishop.getAttackedSquares(board);

        assertThat(attacked).containsExactlyInAnyOrder(
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(0, 6),
                new Position(1, 5),
                new Position(2, 4),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0)
        );
    }

    @Test
    void attackStopsAtObstacle() {
        Board board = new Board(8, 8);
        Bishop bishop = new Bishop(new Position(3, 3));
        board.addPiece(bishop);
        board.addObstacle(new Position(5, 5));

        Set<Position> attacked = bishop.getAttackedSquares(board);
        
        assertThat(attacked).containsExactlyInAnyOrder(
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(4, 4),
                new Position(5, 5),
                new Position(0, 6),
                new Position(1, 5),
                new Position(2, 4),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0)
        );

        assertThat(attacked).doesNotContain(new Position(6, 6));
    }
}