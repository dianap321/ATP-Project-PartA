package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm {

    public Solution solve(ISearchable problem) throws Exception{
        isValidInput(problem);
        Queue<AState> openList = new LinkedList<>();
        openList.add(problem.getStartState());
        HashSet<AState> close = new HashSet<>();
        while (!openList.isEmpty()){
            AState state = openList.poll();
            setVisitedNodes();
            close.add(state);
            if (state.equals(problem.getGoalState())){
                Solution solution = solutionPath(state);
                return solution;
            }
            ArrayList<AState> neighbors = problem.getAllSuccessors(state);
            for (int i = 0; i < neighbors.size(); i++) {
                if (!(close.contains(neighbors.get(i)) || openList.contains(neighbors.get(i)))){
                        openList.add(neighbors.get(i));
                }
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }
}
