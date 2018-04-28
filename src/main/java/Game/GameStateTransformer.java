package Game;

public class GameStateTransformer {

    private EvolutionRules evolutionRules;

    public GameStateTransformer(EvolutionRules evolutionRules) {
        this.evolutionRules = evolutionRules;
    }

    public GameState transform(GameState initialState) {
        int width = initialState.getHeight();
        int height = initialState.getWidth();

        boolean[][] newState = new boolean[width][height];

        for (int row=0; row < width; row++){
            for (int column=0; column < height; column++){
                newState[row][column] = evolutionRules.apply(initialState.getLifeStatusOfCellAt(row, column),
                                                            initialState.getLiveNeighbourCountOfCellAt(row, column));
            }
        }

        return new GameState(newState);
    }
}
