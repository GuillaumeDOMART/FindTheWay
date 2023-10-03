package org.example.maze.generator;

import org.example.utils.Size;

public enum Generator {
    FUSION_RANG;

    public MazeGenerator getGenerator(Size size) throws IllegalAccessException {
        switch (this) {
            case FUSION_RANG -> {
                return new FusionRangGenerator(size);
            }
            default -> throw new IllegalAccessException();
        }
    }
}
