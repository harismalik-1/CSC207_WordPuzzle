package InterfaceAdapterLayer;

import FrameworkAndDriverLayer.WordPuzzleGame;
import EntityLayer.WordPuzzleTile;
import UseCaseLayer.GameCompleteListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordPuzzleGUI extends JFrame implements GameCompleteListener{
    // ... existing GUI code ...
    private boolean firstTileSelected = false;
    private JButton firstSelectedButton = null;
    private JButton secondSelectedButton = null;

    public static List<String> words = Arrays.asList("apple", "banana", "cherry", "grape", "orange", "pear", "strawberry", "watermelon");
    public static List<String> originalOrder = new ArrayList<>(words);

    public WordPuzzleGame game;
    private final JPanel gridPanel;
    public int moveCounter = 0;  // Counter for moves
    private final JLabel counterLabel;  // Label to display the move counter

    public WordPuzzleGUI() {
        game = new WordPuzzleGame(new ArrayList<>(words));
        gridPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        counterLabel = new JLabel("Moves: 0");  // Initialize the label with 0 moves

        initializeUI();
    }

    @Override
    public boolean isGameComplete() {
        return WordPuzzleGUI.isGameComplete(game);
    }

    private void initializeUI() {
        setTitle("Word Puzzle Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JLabel instructionsLabel = new JLabel(
                "<html>Welcome to the Word Puzzle Game!<br/>"
                        + "The aim is to arrange the words in their original order by swapping tiles.<br/>"
                        + "Select two tiles to swap them. You have a limit of 7 moves to complete the puzzle.<br/>"
                        + "Click 'Solve' after selecting two tiles to swap them. Use 'Reset' to shuffle and restart.</html>");
        instructionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        instructionsLabel.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));  // Some padding

        updateGridPanel();


        updateGridPanel();

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetGame());

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(e -> solvePuzzle());

        JButton clearButton = new JButton("Clear Selection");
        clearButton.addActionListener(e -> {
            if (firstSelectedButton != null) {
                firstSelectedButton.setBackground(null);
                firstTileSelected = false;
                firstSelectedButton = null;
            }
            if (secondSelectedButton != null) {
                secondSelectedButton.setBackground(null);
                secondSelectedButton = null;
            }
            for (Component component : gridPanel.getComponents()) {
                JButton button = (JButton) component;
                button.setEnabled(true);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(solveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(counterLabel);  // Add the counter label to the buttonPanel


        add(instructionsLabel, BorderLayout.NORTH);  // Add instructions label at the top
        add(gridPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }



    private class TileActionListener implements ActionListener {
        // ... existing TileActionListener code ...
        private final int row;
        private final int col;

        public TileActionListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!firstTileSelected) {
                firstSelectedButton = (JButton) e.getSource();
                firstSelectedButton.setBackground(Color.LIGHT_GRAY);
                firstTileSelected = true;
            } else {
                secondSelectedButton = (JButton) e.getSource();
                secondSelectedButton.setBackground(Color.LIGHT_GRAY);

                for (Component component : gridPanel.getComponents()) {
                    JButton button = (JButton) component;
                    if (button != firstSelectedButton && button != secondSelectedButton) {
                        button.setEnabled(false);
                    }
                }
            }
        }
    }
    private void updateGridPanel() {
        gridPanel.removeAll();

        WordPuzzleTile[][] grid = game.getGrid();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                JButton button = new JButton(grid[i][j].getWord());
                button.setPreferredSize(new Dimension(120, 60));
                button.addActionListener(new TileActionListener(i, j));
                gridPanel.add(button);
            }
        }

        gridPanel.revalidate();
        gridPanel.repaint();
    }

    private void solvePuzzle() {
        // ... existing solvePuzzle code ...
        if (firstSelectedButton != null && secondSelectedButton != null) {
            moveCounter++;
            counterLabel.setText("Moves: " + moveCounter);  // Update the displayed counter

            int selectedRow1 = ((TileActionListener) firstSelectedButton.getActionListeners()[0]).row;
            int selectedCol1 = ((TileActionListener) firstSelectedButton.getActionListeners()[0]).col;
            int selectedRow2 = ((TileActionListener) secondSelectedButton.getActionListeners()[0]).row;
            int selectedCol2 = ((TileActionListener) secondSelectedButton.getActionListeners()[0]).col;

            game.swapTiles(selectedRow1, selectedCol1, selectedRow2, selectedCol2);
            updateGridPanel();

            firstSelectedButton = null;
            secondSelectedButton = null;
            firstTileSelected = false;
            if (moveCounter >= 7 && !isGameComplete(game)) {
                JOptionPane.showMessageDialog(WordPuzzleGUI.this, "Game Over! You exceeded 7 moves.");
                resetGame();
            }

            if (isGameComplete(game)) {
                JOptionPane.showMessageDialog(WordPuzzleGUI.this, "Congratulations! All tiles are solved.");
            }
        }
    }

    public static boolean isGameComplete(WordPuzzleGame game) {
        // ... existing isGameComplete code ...
        WordPuzzleTile[][] grid = game.getGrid();

        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (!grid[i][j].getWord().equals(originalOrder.get(index))) {  // Compare against originalOrder
                    return false;
                }
                index++;
            }
        }
        return true;
    }

    public void resetGame() {
        game = new WordPuzzleGame(new ArrayList<>(words));
        moveCounter = 0;  // Reset the move counter
        counterLabel.setText("Moves: 0");  // Reset the displayed counter
        counterLabel.setText("Moves: 0");  // Reset the displayed counter
        updateGridPanel();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordPuzzleGUI().setVisible(true));
    }
}
