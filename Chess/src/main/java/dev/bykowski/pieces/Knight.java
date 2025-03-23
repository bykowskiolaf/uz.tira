package dev.bykowski.pieces;

import dev.bykowski.Board;
import dev.bykowski.Position;

import java.util.*;

public class Knight extends Piece {
    public Knight(Position position) {
        super(position);
    }

    @Override
    public Set<Position> getAttackedSquares(Board board) {
        Set<Position> result = new HashSet<>();
        int[][] moves = {
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}, {2, -1}, {2, 1}
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
