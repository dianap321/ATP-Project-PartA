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

    protected void setVisitedNodes() {
        this.visitedNodes++;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return visitedNodes;
    }

    public Solution solutionPath(AState state){
        Solution solution = new Solution();
        while (state != null){
            solution.addToStart(state);
            state = state.getCameFrom();
        }
        return solution;
    }
}
