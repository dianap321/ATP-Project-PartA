package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm{
    @Override
    public Solution solve(ISearchable s) throws Exception{
        isValidInput(s);
        Stack<AState> open = new Stack();
        //ArrayList<AState> close = new ArrayList<>();
        HashSet<AState> close = new HashSet<>();
        open.push(s.getStartState());
        AState top = open.peek();
        while (!open.empty()){
            top = open.peek();
            if(top.equals(s.getGoalState())){
                Solution sol = solutionPath(top);
                return sol;
            }
            if(close.contains(top))
                open.pop();
            else{
                ArrayList<AState> neighbors = s.getAllSuccessors(top);
                boolean added = false;
                for (int i = 0; i < neighbors.size(); i++) {
                    if (!(open.contains(neighbors.get(i)) || close.contains(neighbors.get(i)))){
                        open.push(neighbors.get(i));
                        added = true;
                    }
                }
                if (!added){
                    close.add(open.pop());
                    setVisitedNodes();
                }
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return "DepthFirstSearch";
    }

}
