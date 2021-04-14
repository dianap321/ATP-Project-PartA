package algorithms.search;

//Interface of a searching algorithm.
public interface ISearchingAlgorithm {

    Solution solve(ISearchable s) throws Exception;
    String getName();
    int getNumberOfNodesEvaluated();

}
