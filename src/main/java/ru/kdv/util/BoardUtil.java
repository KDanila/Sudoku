package ru.kdv.util;

import ru.kdv.model.CellState;
import ru.kdv.model.Point;

import java.util.stream.IntStream;

import static ru.kdv.constant.ViewConstant.BOARD_SIZE;

public class BoardUtil {
    static public Point[][] initBoard() {
        Point[][] board = new Point[BOARD_SIZE][BOARD_SIZE];
        IntStream.range(0, BOARD_SIZE)
                .forEach(r -> IntStream.range(0, BOARD_SIZE)
                        .forEach(c -> {
                            board[r][c] = new Point(r,c);
                            board[r][c].setState(CellState.EMPTY);
                        }));
        return board;
    }

    static public Point[][] generateRandomStateInBoard(Point[][] board) {
       /* removePoosibleStateInHLine();
        removePoosibleStateInVLine();
        removePoosibleStateInSquare();
       */ return board;
    }

}
