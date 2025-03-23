package dev.bykowski;

import dev.bykowski.pieces.Piece;

import java.util.*;

public class Board {
    private final int width;
    private final int height;
    private final Map<Position, Piece> pieces = new HashMap<>();
    private final Set<Position> obstacles = new HashSet<>();

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addPiece(Piece piece) {
        pieces.put(piece.getPosition(), piece);
    }

    public void addObstacle(Position position) {
        obstacles.add(position);
    }

    public boolean isOccupied(Position position) {
        return pieces.containsKey(position) || obstacles.contains(position);
    }

    public boolean isInside(Position pos) {
        return pos.isWithinBounds(width, height);
    }
}
