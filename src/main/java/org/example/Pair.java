package org.example;

public final class Pair<firstVariable, secondVariable> {
    private firstVariable first;
    private secondVariable second;

    public Pair(firstVariable first, secondVariable second) {
        this.first = first;
        this.second = second;
    }

    public firstVariable first() {
        return first;
    }

    public secondVariable second() {
        return second;
    }

    public void setFirst(firstVariable first) {
        this.first = first;
    }

    public void setSecond(secondVariable second) {
        this.second = second;
    }
}
