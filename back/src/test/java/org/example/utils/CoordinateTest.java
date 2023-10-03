package org.example.utils;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateTest {

    /*

    +---+---+---+---+---+
    | 0 | 1 | 2 | 3 | 4 |
    +---+---+---+---+---+
    | 5 | 6 | 7 | 8 | 9 |
    +---+---+---+---+---+
    | 10| 11| 12| 13| 14|
    +---+---+---+---+---+

    0 = (0, 0), 1 = (1, 0), 2 = (2, 0), 3 = (3, 0), 4 = (4, 0)
    5 = (0, 1), 6 = (1, 1), 7 = (2, 1), 8 = (3, 1), 9 = (4, 1)
    10 = (0, 2), 11 = (1, 2), 12 = (2, 2), 13 = (3, 2), 14 = (4, 2)

    */

    @Test
    void getPositionShouldReturnPositionFromGoodCoordinates() {
        Size size = new Size(5, 3);
        assertEquals(8, new Coordinate(3, 1).getPosition(size));

    }

    @Test
    void getPositionShouldThrowErrorFromNegativePositionX() {
        Size size = new Size(5, 3);
        assertThrows(IllegalStateException.class, () -> new Coordinate(-3, 1).getPosition(size));
    }

    @Test
    void getPositionShouldThrowErrorFromNegativePositionY() {
        Size size = new Size(5, 3);
        assertThrows(IllegalStateException.class, () -> new Coordinate(3, -1).getPosition(size));
    }

    @Test
    void getPositionShouldThrowErrorFromTooBigCoordinateX() {
        Size size = new Size(5, 3);
        assertThrows(IllegalArgumentException.class, () -> new Coordinate(3, 10).getPosition(size));
    }

    @Test
    void getPositionShouldThrowErrorFromTooBigCoordinateY() {
        Size size = new Size(5, 3);
        assertThrows(IllegalArgumentException.class, () -> new Coordinate(30, 1).getPosition(size));
    }

    @Test
    void getCoordinateShouldReturnCoordinatesFromGoodPosition() {
        Size size = new Size(5, 3);
        assertEquals(new Coordinate(2, 1), Coordinate.getCoordinate(7, size));
    }


    @Test
    void getCoordinateShouldThrowErrorFromNegativePosition() {
        Size size = new Size(5, 3);
        assertThrows(IllegalArgumentException.class, () -> Coordinate.getCoordinate(-1, size));
    }

    @Test
    void getCoordinateShouldThrowErrorFromTooBigPosition() {
        Size size = new Size(5, 3);
        assertThrows(IllegalArgumentException.class, () -> Coordinate.getCoordinate(15, size));
    }
}