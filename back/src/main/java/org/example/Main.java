package org.example;

import org.example.maze.BasicMazeFactory;
import org.example.maze.Maze;
import org.example.maze.generator.Generator;
import org.example.utils.Size;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Maze maze = new BasicMazeFactory(new Size(4, 4)).process(Generator.FUSION_RANG);
        System.out.println(maze);
    }
}