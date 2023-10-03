package org.example.maze.generator;

import org.example.utils.Size;

public enum Generator {
    FUSION_RANG;

    public MazeGenerator getGenerator(Size size) throws IllegalAccessException {
        if (this == FUSION_RANG) {
            return new FusionRangGenerator(size);
        } else {
            throw new IllegalAccessException();
        }
    }
}
