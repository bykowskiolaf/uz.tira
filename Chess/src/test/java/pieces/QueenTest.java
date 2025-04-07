package pieces;

import dev.bykowski.Board;
import dev.bykowski.Position;
import dev.bykowski.pieces.Queen;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class QueenTest {

    @Test
    void attacksCorrectlyFromCenter() {
        Board board = new Board(8, 8);
        Queen queen = new Queen(new Position(3, 3));
        board.addPiece(queen);

        Set<Position> attacked = queen.getAttackedSquares(board);

        assertThat(attacked).containsExactlyInAnyOrder(
                // Diagonal, bottom left to top right
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),

                // Diagonal, top left to bottom right
                new Position(0, 6),
                new Position(1, 5),
                new Position(2, 4),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0),

                // Horizontal
                new Position(0, 3),
                new Position(1, 3),
                new Position(2, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),

                // Vertical
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4),
                new Position(3, 5),
                new Position(3, 6),
                new Position(3, 7)
        );
        assertThat(attacked).doesNotContain(new Position(3, 3));
    }

    @Test
    void stopsAtObstacles() {
        Board board = new Board(8, 8);
        Queen queen = new Queen(new Position(3, 3));
        board.addPiece(queen);
        board.addObstacle(new Position(5, 3));
        board.addObstacle(new Position(1, 1));

        Set<Position> attacked = queen.getAttackedSquares(board);

        // Ensure attack stops at obstacle
        assertThat(attacked).contains(new Position(5, 3)); // included
        assertThat(attacked).doesNotContain(new Position(6, 3), new Position(7, 3));
        assertThat(attacked).contains(new Position(1, 1)); // included
        assertThat(attacked).doesNotContain(new Position(0, 0));
    }
}
