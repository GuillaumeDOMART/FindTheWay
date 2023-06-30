package org.example.maze;

import org.example.maze.generator.Generator;
import org.example.utils.Size;

import java.util.Random;

public class BasicMazeFactory implements MazeFactories {
    private final Size size;

    public BasicMazeFactory(Size size) {
        this.size = size;
    }

    @Override
    public BasicMaze process(Generator generator) {
        try {
            var mazeGenerator = generator.getGenerator(size).generateMaze().prepareMaze(new Random(System.currentTimeMillis()));
            return new BasicMaze(mazeGenerator);
        } catch (IllegalAccessException e) {
            System.out.println("Wrong Generator chosen !");
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Array exception error !");
            return null;
        }
    }
}
