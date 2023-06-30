package org.example.utils;

public record Coordinate(Integer x, Integer y) {
    public int getPosition(Size size) {
        if (y >= size.height() || x >= size.width())
            throw new IllegalArgumentException("Coordinates too big (out of the map)");
        if (y < 0 || x < 0)
            throw new IllegalStateException("Negative coordinates are not possible");
        return y * size.width() + x;
    }

    public static Coordinate getCoordinate(int position, Size size) {
        if (position < 0)
            throw new IllegalArgumentException("Negative position is not possible");

        int y = position / size.width();
        int x = position - size.width() * y;

        if (y >= size.height() || x >= size.width())
            throw new IllegalArgumentException("Position too big (out of the map)");

        return new Coordinate(x, y);
    }
}
