package FrameworkAndDriverLayer;

import EntityLayer.WordPuzzleTile;

import java.util.Collections;
import java.util.List;


public class WordPuzzleGame {
    protected WordPuzzleTile[][] grid;

    public WordPuzzleGame(List<String> words) {
        // Shuffle the words before creating the grid
        Collections.shuffle(words);

        grid = new WordPuzzleTile[2][4];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new WordPuzzleTile(words.get((i * 4) + j));
            }
        }
    }

    public WordPuzzleTile[][] getGrid() {
        return grid;
    }

    public void swapTiles(int r1, int c1, int r2, int c2) {
        WordPuzzleTile temp = grid[r1][c1];
        grid[r1][c1] = grid[r2][c2];
        grid[r2][c2] = temp;
    }
}
