package UseCaseLayer;

import FrameworkAndDriverLayer.WordPuzzleGame;
import EntityLayer.WordPuzzleTile;

import java.util.ArrayList;
import java.util.List;

public class WordPuzzleInteractor {
    private final WordPuzzleGame game;

    public WordPuzzleInteractor(List<String> words) {
        game = new WordPuzzleGame(new ArrayList<>(words));
    }

}
