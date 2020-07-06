package ru.kdv.view;

import java.util.stream.IntStream;

public class Board {
    private final int BOARD_SIZE;
    private final CellState[][] boardState;

    public Board() {
        BOARD_SIZE = 9;
        boardState = new CellState[BOARD_SIZE][BOARD_SIZE];
        initBoard();
    }

    private void initBoard() {
        IntStream.range(0, BOARD_SIZE)
                .forEach(r -> IntStream.range(0, BOARD_SIZE)
                        .forEach(c -> boardState[r][c] = CellState.EMPTY));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (CellState[] cellStates : boardState) {
            for (CellState cellState : cellStates) {
                if (cellState == cellState.EMPTY) {
                    stringBuilder.append(" " + "X" + " ");
                } else {
                    stringBuilder.append(" " + cellState + " ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
