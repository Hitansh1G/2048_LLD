package org.example.Entity;
import java.util.Random;

public class Board {
    private final int SIZE = 4;
    private Tile[][] tiles;
    private Random random;

    public Board() {
        tiles = new Tile[SIZE][SIZE];
        random = new Random();
        // Initialize the board with empty tiles
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tiles[i][j] = new Tile(0);
            }
        }
        // Add initial tiles
        addNewTile();
        addNewTile();
    }

    public void addNewTile() {
        // Find a random empty tile and add either 2 or 4
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (tiles[x][y].getValue() != 0);
        int value = (random.nextInt(2) + 1) * 2; // either 2 or 4
        tiles[x][y].setValue(value);
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getSIZE() {
        return SIZE;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
