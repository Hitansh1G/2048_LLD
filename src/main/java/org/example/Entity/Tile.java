package org.example.Entity;

public class Tile {
    private int value;

    public Tile(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void merge(Tile otherTile){
        this.value += otherTile.getValue();
    }
    public boolean equals(Tile otherTile){
        return this.value == otherTile.getValue();
    }
}
