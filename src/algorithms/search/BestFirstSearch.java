package algorithms.search;

import java.util.*;

public class BestFirstSearch extends ASearchingAlgorithm {

//    public void setList(){
//        openList = new PriorityQueue<>(this::compare);
//    }

    public Solution solve(ISearchable problem) throws Exception{
        isValidInput(problem);
        Queue<AState> openList = new PriorityQueue<>(this::compare);
        openList.add(problem.getStartState());
        HashSet<AState> close = new HashSet<>();
        //Hashtable<AState, Integer> openCopy = new Hashtable<>();
        //openCopy.
        while (!openList.isEmpty()){
//            AState state = popOpenList();
            AState state = openList.poll();
            if (close.contains(state))
                continue;
            //openCopy.remove(state);
            setVisitedNodes();
            close.add(state);
            if (state.equals(problem.getGoalState())){
                Solution solution = solutionPath(state);
                return solution;
            }
            ArrayList<AState> neighbors = problem.getAllSuccessors(state);
            for (int i = 0; i < neighbors.size(); i++) {
                if (!close.contains(neighbors.get(i))) {
                    //if (openCopy.contains(neighbors.get(i))){
//                        openList.
//                    }
//                    else
                        openList.add(neighbors.get(i));
                }
            }
        }
        return null;
    }

    public int compare(AState s1, AState s2) {
        return s1.getCost() - s2.getCost();
    }


    @Override
    public String getName() {
        return "BestFirstSearch";
    }
}
