package Game;

public class GameState{

    private static final String ALIVE_MARKER = "X";
    private static final String DEAD_MARKER = "-";

    private boolean[][] board;

    public GameState(boolean[][] board) {
        this.board = board;
    }

    public int getLiveCellCount() {
        int total = 0;
        for (int row=0; row < this.getHeight(); row++){
            for (int col=0; col < this.getWidth(); col++){
                if (this.board[row][col] == GameOfLife.ALIVE){
                    total++;
                }
            }
        }
        return total;
    }

    public boolean getLifeStatusOfCellAt(int row, int column) {
        return this.board[row][column];
    }

    public int getLiveNeighbourCountOfCellAt(int row, int column) {
        return checkNW(row, column)
                + checkN(row, column)
                + checkNE(row, column)
                + checkW(row, column)
                + checkE(row, column)
                + checkSW(row, column)
                + checkS(row, column)
                + checkSE(row, column);
    }

    private int getNorthRow(int row){
        if (row==0){
            return this.getHeight()-1;
        }
        return row-1;
    }

    private int getSouthRow(int row){
        if (row==this.getHeight()-1){
            return 0;
        }
        return row+1;
    }

    private int getWestColumn(int column){
        if (column == 0){
            return this.getWidth()-1;
        }
        return column-1;
    }

    private int getEastColumn(int column){
        if (column == this.getWidth()-1){
            return 0;
        }
        return column+1;
    }

    private int checkNW(int row, int column){
        if (this.board[getNorthRow(row)][getWestColumn(column)] == GameOfLife.ALIVE){
            return 1;
        }
        return 0;
    }

    private int checkN(int row, int column){
        if (this.board[getNorthRow(row)][column] == GameOfLife.ALIVE){
            return 1;
        }
        return 0;
    }

    private int checkNE(int row, int column){
        if (this.board[getNorthRow(row)][getEastColumn(column)] == GameOfLife.ALIVE){
            return 1;
        }
        return 0;
    }

    private int checkW(int row, int column){
        if (this.board[row][getWestColumn(column)] == GameOfLife.ALIVE){
            return 1;
        }
        return 0;
    }

    private int checkE(int row, int column){
        if (this.board[row][getEastColumn(column)] == GameOfLife.ALIVE){
            return 1;
        }
        return 0;
    }

    private int checkSW(int row, int column){
        if (this.board[getSouthRow(row)][getWestColumn(column)] == GameOfLife.ALIVE){
            return 1;
        }
        return 0;
    }

    private int checkS(int row, int column){
        if (this.board[getSouthRow(row)][column] == GameOfLife.ALIVE){
            return 1;
        }
        return 0;
    }

    private int checkSE(int row, int column){
        if (this.board[getSouthRow(row)][getEastColumn(column)] == GameOfLife.ALIVE){
            return 1;
        }
        return 0;
    }

    public int getWidth() {
        return this.board[0].length;
    }

    public int getHeight() {
        return this.board.length;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int row=0; row<this.getHeight(); row++){
            for (int col=0; col<this.getWidth(); col++){
                if (this.board[row][col] == GameOfLife.ALIVE){
                    stringBuilder.append(ALIVE_MARKER + " ");
                }
                else {
                    stringBuilder.append(DEAD_MARKER + " ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    
    public boolean equals(GameState otherGameState){
        return this.getWidth() == otherGameState.getWidth()
                && this.getHeight() == otherGameState.getHeight()
                && equalBoardConfiguration(otherGameState);
    }

    private boolean equalBoardConfiguration(GameState otherGameState){
        for (int row=0; row<this.getHeight(); row++){
            for (int col=0; col<this.getWidth(); col++){
                if (this.board[row][col] != otherGameState.getLifeStatusOfCellAt(row, col)){
                    return false;
                }
            }
        }
        return true;
    }
}
