package org.example.maze.generator;

import org.example.maze.components.Box;
import org.example.maze.components.Junction;
import org.example.utils.Coordinate;
import org.example.utils.Size;

import java.util.Random;

public class FusionRangGenerator implements MazeGenerator {
    private double classes;
    private final Size size;
    private final Box[] map;

    private final Coordinate exit;

    public FusionRangGenerator(Size size) {
        this.classes = size.width() * size.height();
        this.size = size;
        this.map = new Box[size.height() * size.width()];
        this.exit = new Coordinate(size.width() - 1, size.height() - 1);
    }

    @Override
    public MazeGenerator generateMaze() {
        map[0] = new Box();
        return this;
    }

    private Coordinate findAncestor(Coordinate coordinate) {
        return null;
    }

    private void fusionRang(Junction junction) {

    }

    private Integer breakWall(Junction junction) {
        return 2;
    }

    private Junction boxDraw(Random random) {
        return null;
    }

    private Integer sameRoot(Junction junction) {
        return 1;
    }

    // Je renvoie un Box[] à la place de 1 pour pouvoir renvoyer la map pour le BasicMaze
    @Override
    public MazeGenerator prepareMaze(Random random) {
        Junction junction = boxDraw(random);

        while (true) {
            while (breakWall(junction) != 1) {
                junction = boxDraw(random);
            }

            if (sameRoot(new Junction(new Coordinate(0, 0), exit)) == 1) {
                if (classes == 1)
                    return this;
            }
        }
    }

    @Override
    public Box[] getMazeMap() {
        return map;
    }

    @Override
    public Size getMazeSize() {
        return size;
    }
}
