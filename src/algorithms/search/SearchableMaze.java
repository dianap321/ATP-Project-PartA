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
        MazeState MazeS = new MazeState(s.toString(), 0, null);
        return MazeS;
    }

    @Override
    public AState getGoalState() {
        Position g = m.getGoalPosition();
        MazeState MazeG = new MazeState(g.toString(), 0, null);
        return MazeG;
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        MazeState ms = (MazeState)s;
        int x = ms.getX();
        int y = ms.getY();
        ArrayList<AState> neighbors = new ArrayList<AState>();
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
