package org.example.maze.generator;

import org.example.maze.components.Box;
import org.example.maze.components.FusionRangBox;
import org.example.maze.components.Junction;
import org.example.utils.Coordinate;
import org.example.utils.Size;

import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class FusionRangGenerator implements MazeGenerator {
    private double classes;
    private final Size size;
    private final FusionRangBox[] map;

    private final Coordinate exit;

    public FusionRangGenerator(Size size) {
        this.classes = size.width() * size.height();
        this.size = size;
        this.map = new FusionRangBox[size.height() * size.width()];
        this.exit = new Coordinate(size.width() - 1, size.height() - 1);
    }

    @Override
    public MazeGenerator generateMaze() {
        for (int i = 0; i < map.length; i++)
            map[i] = new FusionRangBox(Coordinate.getCoordinate(i, size));
        map[0].setPresence(1);

//        for (int i = 0; i < map.length; i++) {
//            System.out.println(Coordinate.getCoordinate(i, size));
//        }

        return this;
    }

    private Coordinate findAncestor(Coordinate coordinate) {
        FusionRangBox position = map[coordinate.getPosition(size)];
        if (Objects.equals(position.getPere().x(), coordinate.x()) && Objects.equals(position.getPere().y(), coordinate.y()))
            return position.getPere();

        var racine = findAncestor(position.getPere());
        position.setPere(racine);

        return racine;
    }

    private void fusionRang(Junction junction) {
        Coordinate firstRacine = findAncestor(junction.firstBox());
        Coordinate secondRacine = findAncestor(junction.secondBox());

        if ((!Objects.equals(firstRacine.x(), secondRacine.x())) || (!Objects.equals(firstRacine.y(), secondRacine.y()))) {
            if (map[firstRacine.getPosition(size)].getRang() < map[secondRacine.getPosition(size)].getRang())
                map[firstRacine.getPosition(size)].setPere(secondRacine);
            else if (map[firstRacine.getPosition(size)].getRang() > map[secondRacine.getPosition(size)].getRang())
                map[secondRacine.getPosition(size)].setPere(firstRacine);
            else {
                map[firstRacine.getPosition(size)].setPere(secondRacine);
                map[secondRacine.getPosition(size)].setRang(map[secondRacine.getPosition(size)].getRang() + 1);
            }
        }
    }

    private Integer breakWall(Junction junction) {
        Coordinate firstBox = junction.firstBox();
        Coordinate secondBox = junction.secondBox();
        Coordinate firstRacine = findAncestor(firstBox);
        Coordinate secondRacine = findAncestor(secondBox);

        if (!Objects.equals(firstRacine.x(), secondRacine.x()) || !Objects.equals(firstRacine.y(), secondRacine.y())) {
            classes--;
            fusionRang(junction);
            if (Objects.equals(firstBox.y(), secondBox.y())) {
                if (firstBox.x() > secondBox.x())
                    map[secondBox.getPosition(size)].setMurEst(0);
                else
                    map[firstBox.getPosition(size)].setMurEst(0);
            } else if (Objects.equals(firstBox.x(), secondBox.x())) {
                if (firstBox.y() > secondBox.y())
                    map[secondBox.getPosition(size)].setMurSud(0);
                else
                    map[firstBox.getPosition(size)].setMurSud(0);
            }
            return 1;
        }
        return 0;
    }

    private Junction boxDraw(Random random) {
        while (true) {
            Coordinate coordinate = new Coordinate(
                    random.nextInt(size.width()),
                    random.nextInt(size.height())
            );
            int wall = random.nextInt(2);

            if (wall == 0 && coordinate.x() + 1 < size.width() && map[coordinate.getPosition(size)].getMurEst() == 1)
                return new Junction(
                        coordinate,
                        new Coordinate(coordinate.x() + 1, coordinate.y())
                );
            if (wall == 1 && coordinate.y() + 1 < size.height() && map[coordinate.getPosition(size)].getMurSud() == 1)
                return new Junction(
                        coordinate,
                        new Coordinate(coordinate.x(), coordinate.y() + 1)
                );
        }
    }

    private Integer sameRoot(Junction junction) {
        Coordinate coordinate1 = findAncestor(junction.firstBox());
        Coordinate coordinate2 = findAncestor(junction.secondBox());

        if ((Objects.equals(coordinate1.x(), coordinate2.x())) && (Objects.equals(coordinate1.y(), coordinate2.y()))) {
            return 1;
        }
        return 0;
    }

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("_");

        IntStream.range(0, size.width()).forEach(value -> stringBuilder.append("__"));

        for (int i = 0; i < map.length; i++) {
            if (i % size.width() == 0)
                stringBuilder.append("\n|");
            if (map[i].getMurSud() == 1)
                stringBuilder.append("_");
            else
                stringBuilder.append(" ");
            if (map[i].getMurEst() == 1)
                stringBuilder.append("|");
            else stringBuilder.append(" ");
//            stringBuilder.append("Mur sud : ").append(map[i].getMurSud()).append("Mur est : ").append(map[i].getMurEst()).append("\n");
        }

        return stringBuilder.toString();
    }
}
