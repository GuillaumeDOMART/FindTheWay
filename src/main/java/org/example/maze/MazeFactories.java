package org.example.maze;

import org.example.maze.components.Box;

import java.util.Random;

public interface MazeFactories {

    Box[] generateMaze();
    Box[] prepareMaze(Random random, Box[] map);
}
