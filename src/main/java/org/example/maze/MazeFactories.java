package org.example.maze;

import org.example.maze.generator.Generator;

public interface MazeFactories {
    Maze process(Generator generator);
}
