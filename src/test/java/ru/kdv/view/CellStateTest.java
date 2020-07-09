package ru.kdv.view;

import org.junit.jupiter.api.Test;
import ru.kdv.model.CellState;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellStateTest {

    @Test
    public void getState() {
        assertEquals(CellState.ONE.getState(), 1);
        assertEquals(CellState.TWO.getState(), 2);
        assertEquals(CellState.THREE.getState(), 3);
        assertEquals(CellState.FOUR.getState(), 4);
        assertEquals(CellState.FIVE.getState(), 5);
        assertEquals(CellState.SIX.getState(), 6);
        assertEquals(CellState.SEVEN.getState(), 7);
        assertEquals(CellState.EIGHT.getState(), 8);
        assertEquals(CellState.NINE.getState(), 9);
    }

}