import Game.EvolutionRules;
import Game.GameOfLife;
import Game.GameState;
import Game.GameStateTransformer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameStateTransformerTest {

    private EvolutionRules evolutionRules;
    private GameStateTransformer gameStateTransformer;

    @Before
    public void setUp() {
        evolutionRules = new EvolutionRules();
        gameStateTransformer = new GameStateTransformer(evolutionRules);
    }

//    @Test
//    public void stateTransformerTest(){
//        GameState initialState = new InitialTestState();
//        GameState expectedNewState = new NewStateToInitialTestStateAfter1Evolution();
//
//        GameState actualNewState = gameStateTransformer.transform(initialState);
//        assertThat(actualNewState, instanceOf(expectedNewState.getClass()));
//    }

    @Test
    public void gameStateTransformer_RealStateData1(){
        boolean[][] board = new boolean[][]{{GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD}};
        GameState initialState = new GameState(board);

        boolean[][] newBoard = new boolean[][]{{GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD}};
        GameState expectedNewState = new GameState(newBoard);

        GameState newState = gameStateTransformer.transform(initialState);
        assertThat(newState.equals(expectedNewState), equalTo(true));

    }

    @Test
    public void gameStateTransformer_RealStateData2(){
        boolean[][] board = new boolean[][]{{GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.ALIVE},
                {GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD}};
        GameState initialState = new GameState(board);

        boolean[][] newBoard = new boolean[][]{{GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.ALIVE},
                {GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.ALIVE},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD}};
        GameState expectedNewState = new GameState(newBoard);

        GameState newState = gameStateTransformer.transform(initialState);
        assertThat(newState.equals(expectedNewState), equalTo(true));

    }
}
