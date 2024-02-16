package org.example.Service;

import org.example.Entity.Tile;

import java.util.ArrayList;
import java.util.List;

public class BoardService {
    private final int SIZE = 4;

    public void moveTilesUp(Tile[][] tiles) {
        for (int j = 0; j < SIZE; j++) {
            List<Tile> mergedTiles = new ArrayList<>();
            for (int i = 1; i < SIZE; i++) {
                if (tiles[i][j].getValue() != 0) {
                    int row = i;
                    while (row > 0 && (tiles[row - 1][j].getValue() == 0 ||
                            (tiles[row - 1][j].getValue() == tiles[row][j].getValue() && !mergedTiles.contains(tiles[row - 1][j])))) {
                        if (tiles[row - 1][j].getValue() == tiles[row][j].getValue()) {
                            tiles[row - 1][j].merge(tiles[row][j]);
                            mergedTiles.add(tiles[row - 1][j]);
                        } else {
                            tiles[row - 1][j].setValue(tiles[row][j].getValue());
                        }
                        tiles[row][j].setValue(0);
                        row--;
                    }
                }
            }
        }
    }

    public void moveTilesDown(Tile[][] tiles) {
        for (int j = 0; j < SIZE; j++) {
            List<Tile> mergedTiles = new ArrayList<>();
            for (int i = SIZE - 2; i >= 0; i--) {
                if (tiles[i][j].getValue() != 0) {
                    int row = i;
                    while (row < SIZE - 1 && (tiles[row + 1][j].getValue() == 0 ||
                            (tiles[row + 1][j].getValue() == tiles[row][j].getValue() && !mergedTiles.contains(tiles[row + 1][j])))) {
                        if (tiles[row + 1][j].getValue() == tiles[row][j].getValue()) {
                            tiles[row + 1][j].merge(tiles[row][j]);
                            mergedTiles.add(tiles[row + 1][j]);
                        } else {
                            tiles[row + 1][j].setValue(tiles[row][j].getValue());
                        }
                        tiles[row][j].setValue(0);
                        row++;
                    }
                }
            }
        }
    }

    public void moveTilesLeft(Tile[][] tiles) {
        for (int i = 0; i < SIZE; i++) {
            List<Tile> mergedTiles = new ArrayList<>();
            for (int j = 1; j < SIZE; j++) {
                if (tiles[i][j].getValue() != 0) {
                    int col = j;
                    while (col > 0 && (tiles[i][col - 1].getValue() == 0 ||
                            (tiles[i][col - 1].getValue() == tiles[i][col].getValue() && !mergedTiles.contains(tiles[i][col - 1])))) {
                        if (tiles[i][col - 1].getValue() == tiles[i][col].getValue()) {
                            tiles[i][col - 1].merge(tiles[i][col]);
                            mergedTiles.add(tiles[i][col - 1]);
                        } else {
                            tiles[i][col - 1].setValue(tiles[i][col].getValue());
                        }
                        tiles[i][col].setValue(0);
                        col--;
                    }
                }
            }
        }
    }

    public void moveTilesRight(Tile[][] tiles) {
        for (int i = 0; i < SIZE; i++) {
            List<Tile> mergedTiles = new ArrayList<>();
            for (int j = SIZE - 2; j >= 0; j--) {
                if (tiles[i][j].getValue() != 0) {
                    int col = j;
                    while (col < SIZE - 1 && (tiles[i][col + 1].getValue() == 0 ||
                            (tiles[i][col + 1].getValue() == tiles[i][col].getValue() && !mergedTiles.contains(tiles[i][col + 1])))) {
                        if (tiles[i][col + 1].getValue() == tiles[i][col].getValue()) {
                            tiles[i][col + 1].merge(tiles[i][col]);
                            mergedTiles.add(tiles[i][col + 1]);
                        } else {
                            tiles[i][col + 1].setValue(tiles[i][col].getValue());
                        }
                        tiles[i][col].setValue(0);
                        col++;
                    }
                }
            }
        }
    }
    public boolean isGameOver(Tile[][] tiles) {
        // Check if the player has reached the 2048 tile
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (tiles[i][j].getValue() == 2048) {
                    return true; // Player has won
                }
            }
        }

        // Check if there are any empty tiles
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (tiles[i][j].getValue() == 0) {
                    return false; // Game is not over as there are empty tiles
                }
            }
        }

        // Check if there are any adjacent tiles with the same value
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((i < SIZE - 1 && tiles[i][j].equals(tiles[i + 1][j])) ||
                        (j < SIZE - 1 && tiles[i][j].equals(tiles[i][j + 1]))) {
                    return false; // Game is not over as there are adjacent tiles with the same value
                }
            }
        }

        return true; // Game is over as there are no empty tiles and no adjacent tiles with the same value
    }
}
