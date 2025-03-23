package dev.bykowski.pieces;

import dev.bykowski.Board;
import dev.bykowski.Position;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {
    public Bishop(Position position) {
        super(position);
    }

    @Override
    public Set<Position> getAttackedSquares(Board board) {
        Set<Position> result = new HashSet<>();
        int[][] directions = {
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        for (int[] dir : directions) {
            int x = position.x();
            int y = position.y();

            while (true) {
                x += dir[0];
                y += dir[1];
                Position next = new Position(x, y);

                if (!board.isInside(next)) break;

                result.add(next);
                if (board.isOccupied(next)) break;
            }
        }

        return result;
    }
}

