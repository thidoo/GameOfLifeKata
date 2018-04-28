import Game.GameOfLife;
import Game.CellEvolutionRules;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CellEvolutionRulesTest {

    private CellEvolutionRules cellEvolutionRules;

    @Before
    public void setUp(){
        cellEvolutionRules = new CellEvolutionRules();
    }

    @Test
    public void underPopulationTest(){
        boolean newCellState = cellEvolutionRules.apply(GameOfLife.ALIVE, 1);
        assertThat(newCellState, equalTo(GameOfLife.DEAD));
    }

    @Test
    public void overPopulationTest(){
        boolean newCellState = cellEvolutionRules.apply(GameOfLife.ALIVE, 4);
        assertThat(newCellState, equalTo(GameOfLife.DEAD));
    }

    @Test
    public void continueToLiveTest(){
        boolean newCellState = cellEvolutionRules.apply(GameOfLife.ALIVE, 2);
        assertThat(newCellState, equalTo(GameOfLife.ALIVE));
    }

    @Test
    public void reproductionTest(){
        boolean newCellState1 = cellEvolutionRules.apply(GameOfLife.DEAD, 3);
        boolean newCellState2 = cellEvolutionRules.apply(GameOfLife.DEAD, 2);
        boolean newCellState3 = cellEvolutionRules.apply(GameOfLife.DEAD, 4);

        assertThat(newCellState1, equalTo(GameOfLife.ALIVE));
        assertThat(newCellState2, equalTo(GameOfLife.DEAD));
        assertThat(newCellState3, equalTo(GameOfLife.DEAD));

    }
}
