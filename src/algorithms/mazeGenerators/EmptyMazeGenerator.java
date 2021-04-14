package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    //Initiating all cells to 0 (passage).
    @Override
    public Maze generate(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        Position Start = new Position(0,0);
        Position Goal = new Position(rows-1,columns-1);
        Maze maze = new Maze(Start, Goal, matrix);
        return maze;
    }
}
