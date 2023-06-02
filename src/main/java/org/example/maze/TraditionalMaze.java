package org.example.maze;

import org.example.maze.components.Box;
import org.example.utils.Size;

public class TraditionalMaze {
    private final Size size;

    private final Box[] map;

    TraditionalMaze(Size size, Box[] map) {
        this.size = size;
        this.map = map;
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
