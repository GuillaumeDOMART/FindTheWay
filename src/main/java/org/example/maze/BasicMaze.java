package org.example.maze;

import org.example.maze.components.Box;
import org.example.maze.generator.MazeGenerator;
import org.example.utils.Coordinate;
import org.example.utils.Size;

public class BasicMaze implements Maze{
    private final Size size;
    private final Box[] map;
    private final Coordinate start;
    private final Coordinate exit;

    BasicMaze(MazeGenerator generator) {
        this.size = generator.getMazeSize();
        this.map = generator.getMazeMap();
        this.start = new Coordinate(0, 0);
        this.exit = new Coordinate(size.width() - 1, size.height() - 1);
    }

//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Labyrinthe : ").append(size.width()).append("x").append(size.height()).append("\n");
//
//
//        stringBuilder.append("._".repeat(Math.max(0, size.width())));
//        stringBuilder.append(".\n");
//
//
//        for (List<Box> row : map) {
//            stringBuilder.append("|");
//            for (Box box : row) {
//                if (box.getMurSud() == 1)
//                    stringBuilder.append("_");
//                else
//                    stringBuilder.append(" ");
//                if (box.getMurEst() == 1)
//                    stringBuilder.append("|");
//                else
//                    stringBuilder.append(" ");
//            }
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();
//    }
}
