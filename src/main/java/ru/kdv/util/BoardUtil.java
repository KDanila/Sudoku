package ru.kdv.util;

import ru.kdv.model.CellState;
import ru.kdv.model.Point;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ru.kdv.constant.ViewConstant.BOARD_SIZE;

public class BoardUtil {
    static public Point[][] initBoard() {
        Point[][] board = new Point[BOARD_SIZE][BOARD_SIZE];
        IntStream.range(0, BOARD_SIZE)
                .forEach(r -> IntStream.range(0, BOARD_SIZE)
                        .forEach(c -> {
                            board[r][c] = new Point(r, c);
                            board[r][c].setState(CellState.EMPTY);
                        }));
        return board;
    }

    static public Point[][] generateRandomStateInBoard(Point[][] board) {
        Map<Point, List<CellState>> possibleState = new TreeMap<>();
        initPossibleState(possibleState);

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Point point = new Point(i, j);
                List<CellState> tempState = possibleState.get(point);
                if (tempState.size() == 1) {
                    point.setState(tempState.get(0));
                    continue;
                }
                CellState cellValue = setRandValueInPoints(possibleState, point);
                removePossibleStateInHLine(point, possibleState, cellValue);
                removePossibleStateInVLine(point, possibleState, cellValue);
            }
        }
        return board;
    }

    private static void removePossibleStateInVLine(Point temp, Map<Point, List<CellState>> possibleState, CellState cellValue) {
        int vIndex = temp.getY();
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i == temp.getX()) {
                continue;
            }
            possibleState.get(new Point(i, vIndex)).removeIf(cell -> cell == cellValue);
        }
    }

    private static void removePossibleStateInHLine(Point temp, Map<Point, List<CellState>> possibleState, CellState cellValue) {
        int hIndex = temp.getX();
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i == temp.getY()) {
                continue;
            }
            possibleState.get(new Point(hIndex, i)).removeIf(cell -> cell == cellValue);
        }
    }

    private static CellState setRandValueInPoints(Map<Point, List<CellState>> possibleState, Point point) {
        List<CellState> tempState = possibleState.get(point);
        int index = new Random().nextInt(tempState.size());
        CellState toReturn = tempState.get(index);
        tempState.removeIf(cell -> cell != toReturn);
        return toReturn;
    }

    private static void initPossibleState(Map<Point, List<CellState>> possibleState) {
        IntStream.range(0, BOARD_SIZE)
                .forEach(r -> IntStream.range(0, BOARD_SIZE)
                        .forEach(c -> {
                            possibleState.put(new Point(r, c),
                                    Arrays.stream(CellState.values())
                                            .filter(cellState -> cellState != CellState.EMPTY)
                                            .collect(Collectors.toList()));
                        }));
    }

}
