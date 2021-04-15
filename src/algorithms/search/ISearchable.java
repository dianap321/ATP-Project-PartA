package algorithms.search;

import java.util.ArrayList;

//Interface for searchable problem.
public interface ISearchable {
    AState getStartState();
    AState getGoalState();
    ArrayList<AState> getAllSuccessors(AState s);
}
