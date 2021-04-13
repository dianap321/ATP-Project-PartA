package algorithms.search;

import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {

    BestFirstSearch BFS = new BestFirstSearch();

    @Test
    void testName() {
        assertEquals("BestFirstSearch", BFS.getName());
    }

    @Test
    void inputIsNull() {
        boolean isNull = false;
        try {
            BFS.solve(null);
        }
        catch (Exception e) {
            isNull = true;
        }
        assertTrue(isNull);
    }

    @Test
    void noSolution() throws Exception {
        int [][] matrix = {{0,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,0}};
        Maze m = new Maze(new Position(0, 0), new Position(4,4), matrix);
        SearchableMaze searchableMaze = new SearchableMaze(m);
        assertNull(BFS.solve(searchableMaze));
    }

    @Test
    void isCorrectSol() throws Exception { //From the forum example
        int [][] m = new int[4][5];

        m[0][0]=0; m[0][1]=0; m[0][2]=0; m[0][3]=0; m[0][4]=0;
        m[1][0]=0; m[1][1]=0; m[1][2]=1; m[1][3]=1; m[1][4]=0;
        m[2][0]=1; m[2][1]=0; m[2][2]=0; m[2][3]=1; m[2][4]=0;
        m[3][0]=1; m[3][1]=1; m[3][2]=0; m[3][3]=0; m[3][4]=0;


        Position pStart = new Position(0,0);
        Position pGoal = new Position(2,4);
        Maze maze = new Maze(pStart, pGoal, m);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        String Expected ="[{0,0}, {0,1}, {0,2}, {0,3}, {1,4}, {2,4}]";
        Solution sol = BFS.solve(searchableMaze);
        assertEquals(Expected, sol.getSolutionPath().toString());
    }
}