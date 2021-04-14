package algorithms.Maze3D;

import algorithms.mazeGenerators.Position;

public class Maze3D {
    private Position3D StartPosition;
    private Position3D GoalPosition;
    private int[][][] maze;

    public Maze3D(Position3D startPosition, Position3D goalPosition, int[][][] maze) {
        StartPosition = startPosition;
        GoalPosition = goalPosition;
        this.maze = maze;
    }

    public int[][][] getMap() {
        return maze;
    }

    public Position3D getStartPosition() {
        return StartPosition;
    }

    public Position3D getGoalPosition() {
        return GoalPosition;
    }

    public void print(){
        System.out.println("{");
        for(int depth = 0; depth < maze.length; depth++){
            for(int row = 0; row < maze[0].length; row++) {
                System.out.print("{ ");
                for (int col = 0; col < maze[0][0].length; col++) {
                    if (depth == StartPosition.getDepthIndex() && row == StartPosition.getRowIndex() && col == StartPosition.getColumnIndex()) // if the position is the start - mark with S
                        System.out.print("S ");
                    else {
                        if (depth == GoalPosition.getDepthIndex() && row == GoalPosition.getRowIndex() && col == GoalPosition.getColumnIndex()) // if the position is the goal - mark with E
                            System.out.print("E ");
                        else
                            System.out.print(maze[depth][row][col] + " ");
                    }
                }
                System.out.println("}");
            }
            if(depth < maze.length - 1) {
                System.out.print("---");
                for (int i = 0; i < maze[0][0].length; i++)
                    System.out.print("--");
                System.out.println();
            }
        }
        System.out.println("}");
    }
}
