import java.util.ArrayList;
import java.util.Stack;

public class Maze {
    private final Cell[][] maze;
    private final int height, width;

    Maze(int height, int width) {
        this.height = height;
        this.width = width;
        maze = new Cell[height][width];
        setUpCells();
        generateMaze();
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
        Stack<Cell> path = new Stack<>();
        int accessedCells = 1;
        Cell currentCell = maze[0][0];
        ArrayList<Vertex> possibilities = new ArrayList<>();

        while (accessedCells < height * width) {
            possibilities.clear();
            for (int[] direction : new int[][]{{0,1,0}, {-1,0,1}, {1,0,2}, {0,-1,3}}) {
                // Gets the coordinates of the new cell:
                int newX = currentCell.getX() + direction[0];
                int newY = currentCell.getY() + direction[1];
                // Checks if the cell is in bounds and hasn't been visited:
                if (inBounds(newX, newY) && !maze[newY][newX].isAccessed()) {
                    // Adds the new cell to the list of possibilities for this iteration:
                    possibilities.add(new Vertex(newX, newY, 3 - direction[2], direction[2]));
                }
            }
            // If there's at least one valid unvisited cell:
            if (possibilities.size() > 0) {
                // Selects a new cell randomly from the ones found
                Vertex vertex = possibilities.get((int) (Math.random() * possibilities.size()));
                currentCell.lowerWall(vertex.getOutWall());
                currentCell = maze[vertex.getInY()][vertex.getInX()];
                currentCell.lowerWall(vertex.getInWall());
                path.push(currentCell);
                accessedCells++;
            } else {
                currentCell = path.pop();
            }
        }
    }

    public void displayMaze() {
        for (Cell[] row : maze) {
            for (Cell column : row) {
                System.out.print(column.getTop());
            }
            System.out.println();
            for (Cell column : row) {
                System.out.print(column.getMid());
            }
            System.out.println();
            for (Cell column : row) {
                System.out.print(column.getBottom());
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
