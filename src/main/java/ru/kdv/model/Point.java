package ru.kdv.model;

import lombok.Data;

@Data
public class Point {
    private final int x;
    private final int y;
    private CellState state;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
