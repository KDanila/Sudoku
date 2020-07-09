package ru.kdv.view;

import org.junit.jupiter.api.Test;
import ru.kdv.model.Board;


class BoardTest {
    @Test
    public void toStringTest() {
        Board board = new Board();
        System.out.println(board.toString());
    }
}