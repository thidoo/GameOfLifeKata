import Game.GameOfLife;
import Game.GameState;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameStateTest {

    private GameState initialState1;
    private GameState initialState2;

    @Before
    public void setUp(){
        initialState1 = createInitialTestState1();
        initialState2 = createInitialTestState2();
    }

//    @Test
//    public void gameState_KeepsTrackOfTotalLiveCellCount(){
//        GameState gameState = new ExitStateToInitialTestState();
//        assertThat(gameState.getLiveCellCount(), equalTo(0));
//    }

//    @Test
//    public void gameState_CanInformLifeStatusOfAParticularCell(){
//        GameState gameState = new ExitStateToInitialTestState();
//        boolean cellState = gameState.getLifeStatusOfCellAt(2, 2);
//        assertThat(cellState, equalTo(GameOfLife.DEAD));
//    }

    @Test
    public void getTotalLiveCellCountTest(){
        assertThat(initialState1.getLiveCellCount(), equalTo(3));
        assertThat(initialState2.getLiveCellCount(), equalTo(5));
    }

    @Test
    public void getLifeStatusOfCellAtTest(){
        assertThat(initialState1.getLifeStatusOfCellAt(1, 0), equalTo(GameOfLife.ALIVE));
        assertThat(initialState1.getLifeStatusOfCellAt(2, 1), equalTo(GameOfLife.DEAD));
        assertThat(initialState2.getLifeStatusOfCellAt(1, 1), equalTo(GameOfLife.ALIVE));
        assertThat(initialState2.getLifeStatusOfCellAt(3, 0), equalTo(GameOfLife.DEAD));
    }

    @Test
    public void getLiveNeighbourCountOfCellAtTest(){
        assertThat(initialState1.getLiveNeighbourCountOfCellAt(0, 0), equalTo(2));
        assertThat(initialState1.getLiveNeighbourCountOfCellAt(0, 1), equalTo(2));
        assertThat(initialState1.getLiveNeighbourCountOfCellAt(0, 3), equalTo(1));
        assertThat(initialState1.getLiveNeighbourCountOfCellAt(1, 0), equalTo(1));
        assertThat(initialState1.getLiveNeighbourCountOfCellAt(1, 1), equalTo(2));
        assertThat(initialState1.getLiveNeighbourCountOfCellAt(1, 3), equalTo(2));
        assertThat(initialState1.getLiveNeighbourCountOfCellAt(3, 0), equalTo(0));
        assertThat(initialState1.getLiveNeighbourCountOfCellAt(3, 1), equalTo(1));
        assertThat(initialState1.getLiveNeighbourCountOfCellAt(3, 3), equalTo(1));

        assertThat(initialState2.getLiveNeighbourCountOfCellAt(0, 0), equalTo(2));
        assertThat(initialState2.getLiveNeighbourCountOfCellAt(0, 1), equalTo(2));
        assertThat(initialState2.getLiveNeighbourCountOfCellAt(0, 3), equalTo(0));
        assertThat(initialState2.getLiveNeighbourCountOfCellAt(1, 0), equalTo(2));
        assertThat(initialState2.getLiveNeighbourCountOfCellAt(1, 1), equalTo(2));
        assertThat(initialState2.getLiveNeighbourCountOfCellAt(1, 3), equalTo(2));
        assertThat(initialState2.getLiveNeighbourCountOfCellAt(4, 0), equalTo(2));
        assertThat(initialState2.getLiveNeighbourCountOfCellAt(4, 1), equalTo(0));
        assertThat(initialState2.getLiveNeighbourCountOfCellAt(4, 3), equalTo(1));
    }

    private GameState createInitialTestState1(){
        boolean[][] board = new boolean[][]{{GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                                            {GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD},
                                            {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD},
                                            {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD}};
        return new GameState(board);
    }

    private GameState createInitialTestState2(){
        boolean[][] board = new boolean[][]{{GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                                            {GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD},
                                            {GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD},
                                            {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.ALIVE},
                                            {GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD},};
        return new GameState(board);
    }


}
