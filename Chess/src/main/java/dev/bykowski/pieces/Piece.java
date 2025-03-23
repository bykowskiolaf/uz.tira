package dev.bykowski.pieces;

import dev.bykowski.Board;
import dev.bykowski.Position;

import java.util.*;

public abstract class Piece {
    protected final Position position;

    public Piece(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract Set<Position> getAttackedSquares(Board board);
}