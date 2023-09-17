package org.example;

public final class Pair<firstVariable, secondVariable> {
    private final firstVariable FIRST;
    private final secondVariable SECOND;

    public Pair(firstVariable left, secondVariable right) {
        FIRST = left;
        SECOND = right;
    }

    public firstVariable First() {
        return FIRST;
    }

    public secondVariable Second() {
        return SECOND;
    }
}
