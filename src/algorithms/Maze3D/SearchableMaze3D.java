package algorithms.Maze3D;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import algorithms.search.AState;
import algorithms.search.ISearchable;
import algorithms.search.MazeState;

import java.util.ArrayList;

public class SearchableMaze3D implements ISearchable {
    Maze3D m;

    public SearchableMaze3D(Maze3D m) {
        this.m = m;
    }

    @Override
    public AState getStartState() {
        Position3D s = m.getStartPosition();
        Maze3DState MazeS = new Maze3DState(s.toString(), 0, null);
        return MazeS;
    }

    @Override
    public AState getGoalState() {
        Position3D g = m.getGoalPosition();
        Maze3DState MazeG = new Maze3DState(g.toString(), 0, null);
        return MazeG;
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        Maze3DState ms = (Maze3DState)s;
        int d = ms.getD();
        int r = ms.getR();
        int c = ms.getC();
        ArrayList<AState> neighbors = new ArrayList<AState>();
        //in
        checkPosition(neighbors, ms, d-1, r, c, 10);
        //out
        checkPosition(neighbors, ms, d+1, r, c, 10);
        //up
        checkPosition(neighbors, ms, d, r - 1, c, 10);
        //down
        checkPosition(neighbors, ms, d, r+1, c, 10);
        //right
        checkPosition(neighbors, ms, d, r, c+1, 10);
        //left

        checkPosition(neighbors, ms, d, r, c-1, 10);
        return neighbors;
    }

    public boolean checkPosition(ArrayList<AState> list, Maze3DState parent, int d, int r, int c, int cost){
        if (!(d<0 || r<0 || c<0 || d>m.getMap().length-1 || r>m.getMap()[0].length-1 || c>m.getMap()[0][0].length-1)){
            if (m.getMap()[d][r][c] == 0){
                Maze3DState position = new Maze3DState("{"+d+","+r+"," + c +"}",parent.getCost()+cost ,parent );
                list.add(position);
                return true;
            }
        }
        return false;
    }
}
