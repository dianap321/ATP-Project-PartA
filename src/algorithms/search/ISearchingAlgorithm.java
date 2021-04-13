package algorithms.search;

public interface ISearchingAlgorithm {

    Solution solve(ISearchable s) throws Exception;
    String getName();
    int getNumberOfNodesEvaluated();

}
