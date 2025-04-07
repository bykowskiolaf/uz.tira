import dev.bykowski.Board;
import dev.bykowski.Position;
import dev.bykowski.pieces.Bishop;
import dev.bykowski.pieces.Queen;
import dev.bykowski.pieces.Rook;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    void canAddAndRecognizeObstacle() {
        Board board = new Board(8, 8);
        Position pos = new Position(4, 4);
        board.addObstacle(pos);

        assertThat(board.isOccupied(pos)).isTrue();
    }

    @Test
    void canAddAndRecognizePiece() {
        Board board = new Board(8, 8);
        Rook rook = new Rook(new Position(2, 2));
        board.addPiece(rook);

        assertThat(board.isOccupied(rook.getPosition())).isTrue();
    }

    @Test
    void doesNotTreatEmptyPositionAsOccupied() {
        Board board = new Board(8, 8);
        assertThat(board.isOccupied(new Position(1, 1))).isFalse();
    }

    @Test
    void largeBoardScalabilityWithQueen() {
        Board board = new Board(100, 100);
        Queen queen = new Queen(new Position(0, 0));
        board.addPiece(queen);

        Set<Position> attacked = queen.getAttackedSquares(board);

        assertThat(attacked).contains(
                // Bottom right corner
                new Position(99, 0),

                // Top left corner
                new Position(0, 99),

                // Top right corner
                new Position(99, 99)
        );

        assertThat(attacked).doesNotContain(
                // Random positions that should not be attacked
                new Position(2, 1),
                new Position(1, 2)
        );
    }

    @Test
    void largeBoardScalabilityWithRook() {
        Board board = new Board(100, 100);
        Rook rook = new Rook(new Position(0, 0));
        board.addPiece(rook);

        Set<Position> attacked = rook.getAttackedSquares(board);


        assertThat(attacked).contains(
                // Horizontal and vertical attacks
                new Position(99, 0),
                new Position(0, 99)
        );
        assertThat(attacked).doesNotContain(new Position(2, 1), new Position(1, 2));
    }

    @Test
    void largeBoardScalabilityWithBishop() {
        Board board = new Board(100, 100);
        Bishop bishop = new Bishop(new Position(0, 0));
        board.addPiece(bishop);

        Set<Position> attacked = bishop.getAttackedSquares(board);

        // Check diagonal attacks
        assertThat(attacked).contains(new Position(99, 99));

        // Check that it does not attack non-diagonal positions
        assertThat(attacked).doesNotContain(new Position(2, 1), new Position(1, 2));
    }

    @Test
    void largeBoardScalabilityWithObstacleAndQueen() {
        Board board = new Board(100, 100);
        Queen queen = new Queen(new Position(0, 0));
        board.addPiece(queen);
        board.addObstacle(new Position(1, 1));

        Set<Position> attacked = queen.getAttackedSquares(board);

        // Check that the obstacle is included in the attacked squares
        assertThat(attacked).contains(new Position(99, 0), new Position(0, 99), new Position(1, 1));

        // Check that the queen does not attack positions beyond the obstacle
        assertThat(attacked).doesNotContain(new Position(50, 50), new Position(2, 2));
    }

}
