import Game.EvolutionRules;
import Game.GameOfLife;
import Game.GameState;
import Game.GameStateTransformer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeTest {

    private EvolutionRules evolutionRules;
    private GameStateTransformer gameStateTransformer;
    private GameOfLife gameOfLife;

    @Before
    public void setUp() {
        evolutionRules = new EvolutionRules();
        gameStateTransformer = new GameStateTransformer(evolutionRules);
        gameOfLife = new GameOfLife(gameStateTransformer);
    }

//    @Test
//    public void gameOfLifeTest(){
//        GameState initialState = new InitialTestState();
//        int maxEvolutionCount = 100;
//
//        GameState exitState = gameOfLife.evolves(initialState, maxEvolutionCount);
//        GameState expectedExitState = new ExitStateToInitialTestState();
//
//        assertThat(exitState, instanceOf(expectedExitState.getClass()));
//    }

    @Test
    public void gameOfLifeTest_ExitStateOfAllDeadCells(){
        boolean[][] initialBoard = new boolean[][]{{GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD}};
        GameState initialState = new GameState(initialBoard);

        boolean[][] exitBoard = new boolean[][]{{GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD}};
        GameState expectedExitState = new GameState(exitBoard);

        GameState exitState = gameOfLife.evolves(initialState, 100);
        assertThat(exitState.equals(expectedExitState), equalTo(true));
        assertThat(exitState.getLiveCellCount(), equalTo(0));
    }

    @Test
    public void gameOfLifeTest_StopAfterMaxEvolutions(){
        boolean[][] initialBoard = new boolean[][]{{GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.ALIVE},
                {GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD}};
        GameState initialState = new GameState(initialBoard);

        boolean[][] expectedExitBoard = new boolean[][]{{GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.ALIVE},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.ALIVE},
                {GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.ALIVE},
                {GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.ALIVE}};
        GameState expectedExitState = new GameState(expectedExitBoard);

        GameState exitState = gameOfLife.evolves(initialState, 5);
        assertThat(exitState.equals(expectedExitState), equalTo(true));
        assertThat(exitState.getLiveCellCount(), equalTo(16));
    }
}
