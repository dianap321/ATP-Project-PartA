package algorithms.search;

import java.util.*;

public class BestFirstSearch extends ASearchingAlgorithm {

    public Solution solve(ISearchable problem) throws Exception{
        isValidInput(problem);
        Queue<AState> openList = new PriorityQueue<>(this::compare);
        openList.add(problem.getStartState());
        HashSet<AState> close = new HashSet<>();
        while (!openList.isEmpty()){
            AState state = openList.poll();
            if (close.contains(state))
                continue;
            setVisitedNodes();
            close.add(state);
            if (state.equals(problem.getGoalState())){
                Solution solution = solutionPath(state);
                return solution;
            }
            ArrayList<AState> neighbors = problem.getAllSuccessors(state);
            for (int i = 0; i < neighbors.size(); i++) {
                if (!close.contains(neighbors.get(i))) {
                        openList.add(neighbors.get(i));
                }
            }
        }
        return null;
    }

    //Function that compares costs to use for the priority queue.
    public int compare(AState s1, AState s2) {
        return s1.getCost() - s2.getCost();
    }


    @Override
    public String getName() {
        return "BestFirstSearch";
    }
}
