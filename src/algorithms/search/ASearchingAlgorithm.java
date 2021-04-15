package algorithms.search;

import java.util.Queue;

//Abstract class for searching algorithm.
public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {

    private int visitedNodes;

    public ASearchingAlgorithm() { //Some algorithms may need a priority queue so we don't initialize one here.
        this.visitedNodes = 0;
    }

    public void isValidInput(ISearchable problem) throws Exception{
        if (problem==null)
            throw new Exception("Can't solve an empty problem.");
    }
    //Every time we finish handling a cell we up the count.
    protected void setVisitedNodes() {
        this.visitedNodes++;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return visitedNodes;
    }

    //We call this method when we reach the goal state (with it as a parameter).
    public Solution solutionPath(AState state){
        Solution solution = new Solution();
        while (state != null){
            solution.addToStart(state); //We start from the end of the path so we add to the start.
            state = state.getCameFrom();//After we've added the current state we want to add the one that led us there.
        }
        return solution;
    }
}
