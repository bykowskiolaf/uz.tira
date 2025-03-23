package dev.bykowski.pieces;

import dev.bykowski.Board;
import dev.bykowski.Position;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {
    public King(Position position) {
        super(position);
    }

    @Override
    public Set<Position> getAttackedSquares(Board board) {
        Set<Position> result = new HashSet<>();
        int[][] moves = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] move : moves) {
            Position next = new Position(position.x() + move[0], position.y() + move[1]);
            if (board.isInside(next)) {
                result.add(next);
            }
        }
        return result;
    }
}

