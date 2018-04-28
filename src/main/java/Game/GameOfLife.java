package Game;

public class GameOfLife {
    public static final boolean ALIVE = true;
    public static final boolean DEAD = false;

    private int maxEvolutionCount;
    private int currentEvolutionCount;

    private GameState currentGameState;
    private GameStateTransformer gameStateTransformer;

    public GameOfLife(GameStateTransformer gameStateTransformer) {
        this.gameStateTransformer = gameStateTransformer;
    }

    public GameState evolves(GameState initialState, int maxEvolutionCount) {
        setUpGame(initialState, maxEvolutionCount);

        while (gameCanContinue()){
            this.currentGameState = gameStateTransformer.transform(this.currentGameState);
            this.currentEvolutionCount++;
            printGameState();
        }

        return this.currentGameState;
    }

    private boolean gameCanContinue(){
        return this.currentGameState.getLiveCellCount() > 0
                && this.currentEvolutionCount < this.maxEvolutionCount;
    }

    private void setUpGame(GameState initialState, int maxEvolutionCount){
        this.maxEvolutionCount = maxEvolutionCount;
        this.currentEvolutionCount = 0;
        this.currentGameState = initialState;
        printGameState();
    }

    private void printGameState(){
        System.out.printf("Evolution: " + this.currentEvolutionCount + "\n\n");
        System.out.println(this.currentGameState.toString());
    }
}
