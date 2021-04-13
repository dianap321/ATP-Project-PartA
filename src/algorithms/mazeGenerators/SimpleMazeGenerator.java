package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int rows, int columns) {
        int [][] m = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 || j == columns-1) {
                    m[i][j] = 0;
                }
                else {m[i][j] = new Random().nextInt(2);}
            }
        }
        Position pStart = new Position(0,0);
        Position pGoal = new Position(rows-1,columns-1);
        Maze maze = new Maze(pStart, pGoal, m);
        return maze;
    }
}
