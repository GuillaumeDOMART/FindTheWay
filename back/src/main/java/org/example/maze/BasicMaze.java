package org.example.maze;

import org.example.maze.generator.MazeGenerator;
import org.example.utils.Coordinate;

public class BasicMaze implements Maze {
    private final MazeGenerator generator;
    private final Coordinate start;
    private final Coordinate exit;

    BasicMaze(MazeGenerator generator) {
        this.generator = generator;
        this.start = new Coordinate(0, 0);
        this.exit = new Coordinate(generator.getMazeSize().width() - 1, generator.getMazeSize().height() - 1);
    }

    @Override
    public String toString() {
        return generator.toString();
    }
}
