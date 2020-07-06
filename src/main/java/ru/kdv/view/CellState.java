package ru.kdv.view;

import lombok.Getter;

@Getter
public enum CellState {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), EMPTY(-1);

    private final int state;

    CellState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.valueOf(state);
    }
}
