package dev.bykowski.pieces;

import dev.bykowski.Board;
import dev.bykowski.Position;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {
    public Pawn(Position position) {
        super(position);
    }

    @Override
    public Set<Position> getAttackedSquares(Board board) {
        Set<Position> result = new HashSet<>();
        int[][] attacks = {
                {1, 1}, {-1, 1}
        };

        for (int[] attack : attacks) {
            Position next = new Position(position.x() + attack[0], position.y() + attack[1]);
            if (board.isInside(next)) {
                result.add(next);
            }
        }
        return result;
    }
}