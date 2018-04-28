package Game;

public class CellEvolutionRules {

    private static final int UNDER_POPULATION_BOUND = 2;
    private static final int OVER_POPULATION_BOUND = 3;
    private static final int REPRODUCTION_MATCH = 3;


    public boolean apply(boolean initialCellState, int numberOfLiveNeighbours) {
        if (initialCellState == GameOfLife.ALIVE){
            return evolveInitialLiveCell(numberOfLiveNeighbours);
        }
        return evolveInitialDeadCell(numberOfLiveNeighbours);
    }

    private boolean evolveInitialLiveCell(int numberOfLiveNeighbours){
        return !(isUnderPopulation(numberOfLiveNeighbours) || isOverPopulation(numberOfLiveNeighbours));
    }

    private boolean evolveInitialDeadCell(int numberOfLiveNeighbours){
        return isAbleToReproduce(numberOfLiveNeighbours);
    }

    private boolean isUnderPopulation(int numberOfLiveNeighbours){
        return numberOfLiveNeighbours < UNDER_POPULATION_BOUND;
    }

    private boolean isOverPopulation(int numberOfLiveNeighbours){
        return numberOfLiveNeighbours > OVER_POPULATION_BOUND;
    }

    private boolean isAbleToReproduce(int numberOfLiveNeighbours){
        return numberOfLiveNeighbours == REPRODUCTION_MATCH;
    }
}
