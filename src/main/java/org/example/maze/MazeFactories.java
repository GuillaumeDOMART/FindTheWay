package org.example.maze;

import org.example.maze.components.Box;

import java.util.Random;

public interface MazeFactories {

    void generateMaze();
    void prepareMaze(Random random);
}
