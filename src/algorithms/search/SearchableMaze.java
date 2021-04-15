package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {

    Maze m;

    public SearchableMaze(Maze m) {
        this.m = m;
    }

    @Override
    public AState getStartState() {
        Position s = m.getStartPosition();
        MazeState MazeS = new MazeState(s.toString(), 0, null); //reaching the start state didn't cost us anything.
        return MazeS;
    }

    @Override
    public AState getGoalState() {
        Position g = m.getGoalPosition();
        MazeState MazeG = new MazeState(g.toString(), 0, null); //When we just want the goal state for comparison we don't need it's cost or parent.
        return MazeG;
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        MazeState ms = (MazeState)s;
        int x = ms.getX();
        int y = ms.getY();
        ArrayList<AState> neighbors = new ArrayList<AState>();
        //In each of the following conditions we first check one of the four side, and if that side is accessible we check the diagonals.
        //We set the cost to be 10 for right, left, up, down and 15 for diagonals.
        //up
        if (checkPosition(neighbors, ms, x-1, y, 10)){
            checkPosition(neighbors, ms, x-1, y+1, 15);
            checkPosition(neighbors, ms, x-1, y-1, 15);
        }
        //down
        if (checkPosition(neighbors, ms, x+1, y, 10)){
            checkPosition(neighbors, ms, x+1, y+1, 15);
            checkPosition(neighbors, ms, x+1, y-1, 15);
        }
        //right
        if (checkPosition(neighbors, ms, x, y+1, 10)){
            checkPosition(neighbors, ms, x-1, y+1, 15);
            checkPosition(neighbors, ms, x+1, y+1, 15);
        }
        //left
        if (checkPosition(neighbors, ms, x, y-1, 10)){
            checkPosition(neighbors, ms, x-1, y-1, 15);
            checkPosition(neighbors, ms, x+1, y-1, 15);
        }
        return neighbors;
    }

    //This helper function helps us check if a position is in range and if there is a passage.
    //If so, we create a state out of this position and add it to the neighbors list.
    public boolean checkPosition(ArrayList<AState> list, MazeState parent, int x, int y, int cost){
        if (!(x<0 || y<0 || x>m.getMaze().length-1 || y>m.getMaze()[0].length-1)){
            if (m.getMaze()[x][y] == 0){
                MazeState position = new MazeState("{"+x+","+y+"}",parent.getCost()+cost ,parent );
                list.add(position);
                return true;
            }
        }
        return false;
    }
}
