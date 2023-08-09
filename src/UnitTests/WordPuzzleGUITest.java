package UnitTests;

import EntityLayer.WordPuzzleTile;
import InterfaceAdapterLayer.WordPuzzleGUI;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class WordPuzzleGUITest {

    WordPuzzleGUI gui;

    @BeforeEach
    public void setUp() {
        gui = new WordPuzzleGUI();
        gui.setVisible(true);
    }

    @AfterEach
    public void tearDown() {
        gui.dispose();
    }

    @Test
    public void testInitialization() {
        WordPuzzleTile[][] grid = gui.game.getGrid();
        assertNotNull(grid);
        assertFalse(isInOriginalOrder(grid));
    }

    @Test
    public void testTileSwap() {
        gui.game.swapTiles(0, 0, 0, 1);
        WordPuzzleTile[][] grid = gui.game.getGrid();
        assertNotEquals("apple", grid[0][0].getWord());
        assertNotEquals("banana", grid[0][1].getWord());
    }

    @Test
    public void testGameCompletion() {
        WordPuzzleTile[][] grid = gui.game.getGrid();
        // Manually set the grid to the original order for testing
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new WordPuzzleTile(WordPuzzleGUI.originalOrder.get(index));
                index++;
            }
        }
        assertTrue(WordPuzzleGUI.isGameComplete(gui.game));
    }

    @Test
    public void testMoveCounterReset() {
        gui.moveCounter = 5;
        gui.resetGame();
        assertEquals(0, gui.moveCounter);
    }

    private boolean isInOriginalOrder(WordPuzzleTile[][] grid) {
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (!grid[i][j].getWord().equals(WordPuzzleGUI.originalOrder.get(index))) {
                    return false;
                }
                index++;
            }
        }
        return true;
    }
}

