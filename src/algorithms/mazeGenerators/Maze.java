package algorithms.mazeGenerators;

public class Maze {

    private Position StartPosition;
    private Position GoalPosition;
    private int[][] maze;

    public Maze(Position startPosition, Position goalPosition, int[][] maze) {
        StartPosition = startPosition;
        GoalPosition = goalPosition;
        this.maze = maze;
    }

    public int[][] getMaze() {
        return maze;
    }

    public Position getStartPosition() {
        return StartPosition;
    }

    public Position getGoalPosition() {
        return GoalPosition;
    }

    public void print(){

        for (int i = 0; i < maze.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < maze[0].length; j++) {
                if (i==getStartPosition().getRowIndex() && j == getStartPosition().getColumnIndex()){
                    System.out.print("S ");
                }
                else if (i==getGoalPosition().getRowIndex() && j == getGoalPosition().getColumnIndex()){
                    System.out.print("E ");
                }
                else {
                    System.out.print(maze[i][j] + " ");
                }

            }
            System.out.println("}");
        }

    }
}
