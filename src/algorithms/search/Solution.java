package algorithms.search;

import java.util.ArrayList;

public class Solution {
    private ArrayList<AState> solutionPath;

    public ArrayList<AState> getSolutionPath() {
        return solutionPath;
    }

    public Solution() {
        this.solutionPath = new ArrayList<AState>();
    }

    public Solution(ArrayList<AState> sol){
        this.solutionPath = sol;
    }

    //We need this function because we develop the solution backwards from the end.
    public void addToStart(AState s){
        solutionPath.add(0, s);
    }
}
