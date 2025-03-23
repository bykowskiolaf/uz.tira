package dev.bykowski;

public record Position(int x, int y) {
    public boolean isWithinBounds(int width, int height) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}