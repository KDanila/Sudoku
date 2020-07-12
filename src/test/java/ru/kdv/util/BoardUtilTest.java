package ru.kdv.util;

import org.junit.jupiter.api.Test;
import ru.kdv.model.Board;
import ru.kdv.model.CellState;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BoardUtilTest {

    @Test
    void generateRandomStateInBoard() {
        BoardUtil.generateRandomStateInBoard(BoardUtil.initBoard());
    }

    @Test
    void testRemoveEnumInList() {
        List<CellState> list = Arrays.stream(CellState.values())
                .filter(cellState -> cellState != CellState.EMPTY)
                .collect(Collectors.toList());
        list.removeIf(c-> c == CellState.FIVE);
        assertFalse(list.contains(CellState.FIVE));
    }
}