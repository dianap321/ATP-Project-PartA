package test;
import algorithms.mazeGenerators.*;
import algorithms.search.*;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;

public class RunSearchOnMaze {
    public static void main(String[] args) {
        try {
            IMazeGenerator mg = new MyMazeGenerator();
            Maze maze = mg.generate(4, 5);
            maze.print();
            SearchableMaze searchableMaze = new SearchableMaze(maze);
            //solveProblem(searchableMaze, new BreadthFirstSearch());
            //solveProblem(searchableMaze, new DepthFirstSearch());
            solveProblem(searchableMaze, new BestFirstSearch());
        }
        catch (Exception e){
            System.out.println("Generate failed.");
        }

    }
    private static void solveProblem(ISearchable domain, ISearchingAlgorithm
            searcher) throws Exception {

//Solve a searching problem with a searcher
        Solution solution = searcher.solve(domain);
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));
//Printing Solution Path
                System.out.println("Solution path:");
        ArrayList<AState> solutionPath = solution.getSolutionPath();
//        for (int i = 0; i < solutionPath.size(); i++) {
//            System.out.println(String.format("%s. %s",i,solutionPath.get(i)));
//        }
//        long t1 = System.currentTimeMillis();
//        searcher.solve(domain);
//        long t2 = System.currentTimeMillis();
//        System.out.println(t2-t1);
        System.out.println(solutionPath);

    }
}