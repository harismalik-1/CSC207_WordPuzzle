package PresentationLayer;

import InterfaceAdapterLayer.WordPuzzleGUI;
import UseCaseLayer.WordPuzzleInteractor;

public class WordPuzzlePresenter {
    private final WordPuzzleInteractor interactor;
    private final WordPuzzleGUI view;

    public WordPuzzlePresenter(WordPuzzleInteractor interactor, WordPuzzleGUI view) {
        this.interactor = interactor;
        this.view = view;
    }

    public void onTileClicked(int row, int col) {
        // Handle tile click interactions
    }

    public void onSolveButtonClicked() {
        // Handle solve button click interactions
    }

    // ... other event handling methods ...
}
