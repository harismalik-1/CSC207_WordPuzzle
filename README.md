# Word Puzzle Game

Welcome to the Word Puzzle Game! This is a simple yet engaging game that challenges you to rearrange a grid of word tiles back to their original order. Test your word skills and strategic thinking as you swap tiles to solve the puzzle.

## How to Play

**Objective:** The goal of the game is to arrange the word tiles in their original order.

- **Game Grid:** The game grid consists of a 2x4 layout of word tiles, which are initially shuffled.
- **Tile Swap:** To swap tiles, click on any two adjacent tiles. They will exchange positions.
- **Limited Moves:** You have a maximum of 7 moves to solve the puzzle. Once you reach the maximum number of moves, the game will automatically reset.
- **Solve Button:** If you believe you've solved the puzzle, click the "Solve" button to check. If all tiles are in the correct order, you win!
- **Reset Button:** If you get stuck or want to try a new arrangement, click the "Reset" button to shuffle the tiles and start over.
- **Clear Selection:** To deselect tiles you've clicked on (before swapping), click the "Clear Selection" button.

## Why Play?

- **Brain Exercise:** The Word Puzzle Game exercises your brain by requiring you to think strategically and solve puzzles.
- **Word Skills:** Improve your word recognition and observation skills as you match tiles to their correct positions.
- **Limited Moves:** The game introduces a challenge with a limited number of moves, adding an extra layer of strategy to your gameplay.
- **Casual Fun:** Whether you have a few minutes to spare or want to take a break, the game offers casual entertainment.
- **Visual Puzzle:** The visually appealing grid of word tiles adds to the game's enjoyment and engages your spatial reasoning.

## How to Run

1. Ensure you have Java installed on your computer.
2. Compile and run the `WordPuzzleGUI` class, which launches the game interface.
3. Follow the instructions provided in the UI to play the game.

## Code Details

The Word Puzzle Game has been designed following Clean Architecture and adheres to SOLID principles, making the codebase modular and maintainable. The game's components are organized into distinct layers:

- **Entity Layer:** Contains the `WordPuzzleTile` class, representing the individual word tiles.
- **Use Case Layer:** Contains the `WordPuzzleInteractor` class, which handles the game's logic and interactions.
- **Interface Adapter Layer:** Includes the `WordPuzzleGUI` class, responsible for the game's graphical user interface.
- **Presentation Layer:** Houses the `WordPuzzlePresenter` class, connecting the use case with the GUI.
- **Framework and Driver Layer:** Contains the `WordPuzzleGame` class, responsible for the game's core mechanics.

The game's accessibility and ethical considerations have been taken into account to provide an inclusive and fair gaming experience for all users.

## Enjoy the Challenge!

We hope you enjoy playing the Word Puzzle Game. Exercise your brain, enhance your word skills, and have fun solving the puzzle. Good luck!
![Hello](/src/UI.png)
