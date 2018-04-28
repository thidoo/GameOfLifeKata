import Game.EvolutionRules;
import Game.GameOfLife;
import Game.GameState;
import Game.GameStateTransformer;

public class Main {

    public static void main(String[] args){
//        GameState initialState = new GameState(new boolean[][]{
//                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
//                {GameOfLife.ALIVE, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD},
//                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD},
//                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD}});

        GameState initialState = new GameState(new boolean[][]{{GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD},
                {GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD},
                {GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.DEAD, GameOfLife.ALIVE},
                {GameOfLife.DEAD, GameOfLife.ALIVE, GameOfLife.DEAD, GameOfLife.DEAD}});

        EvolutionRules evolutionRules = new EvolutionRules();
        GameStateTransformer gameStateTransformer = new GameStateTransformer(evolutionRules);
        GameOfLife gameOfLife = new GameOfLife(gameStateTransformer);

        gameOfLife.evolves(initialState, 10);
    }
}
