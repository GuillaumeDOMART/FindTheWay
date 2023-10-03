package org.example.maze.generator;

import org.example.maze.components.Box;
import org.example.utils.Size;

import java.util.Random;

public interface MazeGenerator {
    MazeGenerator generateMaze();
    MazeGenerator prepareMaze(Random random);
    Box[] getMazeMap();
    Size getMazeSize();
    String toString();
}
