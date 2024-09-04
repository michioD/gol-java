package GameOfLife;
import lombok.Data;

@Data
public class Cell{
    private CellState cellState;
    private int x;
    private int y;        
}
