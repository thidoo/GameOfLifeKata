import Game.GameOfLife;
import Game.EvolutionRules;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EvolutionRulesTest {

    private EvolutionRules evolutionRules;

    @Before
    public void setUp(){
        evolutionRules = new EvolutionRules();
    }

    @Test
    public void underPopulationTest(){
        boolean newCellState = evolutionRules.apply(GameOfLife.ALIVE, 1);
        assertThat(newCellState, equalTo(GameOfLife.DEAD));
    }

    @Test
    public void overPopulationTest(){
        boolean newCellState = evolutionRules.apply(GameOfLife.ALIVE, 4);
        assertThat(newCellState, equalTo(GameOfLife.DEAD));
    }

    @Test
    public void continueToLiveTest(){
        boolean newCellState = evolutionRules.apply(GameOfLife.ALIVE, 2);
        assertThat(newCellState, equalTo(GameOfLife.ALIVE));
    }

    @Test
    public void reproductionTest(){
        boolean newCellState1 = evolutionRules.apply(GameOfLife.DEAD, 3);
        boolean newCellState2 = evolutionRules.apply(GameOfLife.DEAD, 2);
        boolean newCellState3 = evolutionRules.apply(GameOfLife.DEAD, 4);

        assertThat(newCellState1, equalTo(GameOfLife.ALIVE));
        assertThat(newCellState2, equalTo(GameOfLife.DEAD));
        assertThat(newCellState3, equalTo(GameOfLife.DEAD));

    }
}
