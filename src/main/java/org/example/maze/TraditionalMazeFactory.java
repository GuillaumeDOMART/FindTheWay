package org.example.maze;

import org.example.maze.components.Box;
import org.example.maze.components.Junction;
import org.example.utils.Coordinate;
import org.example.utils.Size;

import java.util.Random;

public class TraditionalMazeFactory implements MazeFactories {
    private double classes;
    private final Size size;

    public TraditionalMazeFactory(Size size) {
        this.classes = size.width() * size.height();
        this.size = size;
    }

    public TraditionalMaze createMaze() {
        Box[] map = generateMaze();
        Box[] finalMap = prepareMaze(new Random(System.currentTimeMillis()), map);
        return new TraditionalMaze(size, finalMap);
    }

    @Override
    public Box[] generateMaze() {
        return new Box[0];
    }

    private Coordinate findAncestor(Coordinate coordinate) {
        return null;
    }

    private void fusionRang(Junction junction) {

    }

    private Integer breakWall(Junction junction) {
        return null;
    }

    private Junction boxDraw(Random random) {
        return null;
    }

    private Integer sameRoot(Junction junction) {
        return null;
    }

    // Je renvoie un Box[] à la place de 1 pour pouvoir renvoyer la map pour le TraditionalMaze
    @Override
    public Box[] prepareMaze(Random random, Box[] map) {
        return null;
    }
}
