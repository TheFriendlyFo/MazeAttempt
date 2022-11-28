import java.util.ArrayList;
import java.util.Stack;

public class Maze {
    private Cell[][] maze;
    private final int height, width;

    Maze(int height, int width) {
        this.height = height;
        this.width = width;
        maze = new Cell[height][width];
        setUpCells();
    }

    private void setUpCells() {
        for (int row = 0; row<height; row++) {
            for (int column=0; column<width; column++) {
                maze[row][column] = new Cell(column, row);
            }
        }
    }

    private boolean inBounds(int x, int y) {
        boolean xInBounds = (x >= 0 && x < width);
        boolean yInBounds = (y >= 0 && y < height);
        return xInBounds && yInBounds;
    }

    private void generateMaze() {
        int[][] directions = new int[][]{{0,1}, {-1,0}, {1,0}, {0,-1}};
        Stack<Cell> path = new Stack<>();
        int accessedCells = 0;
        int x = 0, y = 0;
        Cell currentCell = maze[y][x];
        ArrayList<Vertex> possibilities = new ArrayList<>();

        while (accessedCells < height * width) {
            possibilities.clear();
            for (int i=0; i<=3; i++) {
                int newX = x + directions[i][0];
                int newY = y + directions[i][1];
                if (inBounds(newX, newY)) {
                    possibilities.add(new Vertex(x, y, i, newX, newY, 3 - i));
                }
            }

            if (possibilities.size() > 0) {

            } else {
                currentCell = path.pop();
                x = currentCell.getX();
                y = currentCell.getY();
            }
        }
    }
}
