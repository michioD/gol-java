package GameOfLife;
import static GameOfLife.CellState.ALIVE;
import static GameOfLife.CellState.DEAD;
public class Model {
    private Cell[][] grid;
    private int rows;
    private int cols;
    public Model(int rows, int cols){
        grid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                grid[i][j] = new Cell();
            }
        }
    }
    // A live cell dies if it has fewer than two live neighbors.
    // A live cell with two or three live neighbors lives on to the next generation.
    // A live cell with more than three live neighbors dies.
    // A dead cell will be brought back to live if it has exactly three live neighbors.
    public void update(){
        Cell currentCell;
        Cell currentCellState; 
        int liveNeighborCount;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                currentCell = grid[i][j];
                currentCellState = currentCell.getCellState(); 
                liveNeighborCount = 0;
                if (i+1 != rows){
                    if (grid[i+1][j].getCellState() == ALIVE){
                        liveNeighborCount += 1;
                    }
                }
                if (j+1 != cols){
                    if (grid[i][j+1].getCellState() == ALIVE){
                        liveNeighborCount += 1;
                    }
                }
                if (i != 0){
                    if (grid[i-1][j].getCellState() == ALIVE){
                        liveNeighborCount += 1;
                    }
                }
                if (j != 0){
                    if (grid[i][j-1].getCellState() == ALIVE){
                        liveNeighborCount += 1;
                    }
                }
                if (currentCellState == ALIVE){
                    if (liveNeighborCount < 2 || 3 < liveNeighborCount){
                        currentCell.setNextState(DEAD);
                    }
                    if (1 < liveNeighborCount < 4){
                        currentCell.setNextState(ALIVE);
                    }
                } 
                else if (currentCellState == DEAD){
                    if (liveNeighborCount == 3){
                        currentCell.setNextState(ALIVE);
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                currentCell.evolve();
            }
        }
    }

    public void clearGrid(){
    }
}

