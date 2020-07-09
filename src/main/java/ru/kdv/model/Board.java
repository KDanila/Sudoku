package ru.kdv.model;

import static ru.kdv.util.BoardUtil.initBoard;

public class Board {
    private final Point[][] boardState;

    public Board() {
        boardState = initBoard();
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Point[] pointRow : boardState) {
            for (Point point : pointRow) {
                if (point.getState() == CellState.EMPTY) {
                    stringBuilder.append(" " + "X" + " ");
                } else {
                    stringBuilder.append(" " + point + " ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
