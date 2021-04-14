package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

//Our maze generator uses Prim's algorithm.
public class MyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns) throws Exception{
        if(rows<2 || columns<2)
            throw new Exception("Maze size can't be smaller than 2x2.");
        //we start by making a matrix of 1's of the wanted size
        int [][] m = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                    m[i][j] = 1;
            }
        }

        LinkedList<Position> list = new LinkedList<Position>();
        //choose a starting point (we chose to have a start point from the top row)
        int x = 0;
        int y = new Random().nextInt(columns);
        list.add(new Position(x, y));
        while (!list.isEmpty()){
            Position chosen = list.remove(new Random().nextInt(list.size())); //choose a cell at random so that we get an intricate maze
            LinkedList<Position> neighbors1 = new LinkedList<Position>(); //contains all neighboring walls.
            LinkedList<Position> neighbors0 = new LinkedList<Position>(); // Indicates how many neighboring passages there are so that it helps us decide whether the current cell should be a passage.

            if (chosen.getRowIndex()-1 >= 0) { //checking if in range.
                if (m[chosen.getRowIndex() - 1][chosen.getColumnIndex()] == 1)
                    neighbors1.add(new Position(chosen.getRowIndex() - 1, chosen.getColumnIndex()));
                else
                    neighbors0.add(new Position(chosen.getRowIndex() - 1, chosen.getColumnIndex()));
            }
            if (chosen.getRowIndex()+1 < rows) {
                if (m[chosen.getRowIndex() + 1][chosen.getColumnIndex()] == 1)
                    neighbors1.add(new Position(chosen.getRowIndex() + 1, chosen.getColumnIndex()));
                else
                    neighbors0.add(new Position(chosen.getRowIndex() + 1, chosen.getColumnIndex()));
            }
            if (chosen.getColumnIndex()+1 < columns) {
                if (m[chosen.getRowIndex()][chosen.getColumnIndex() + 1] == 1)
                    neighbors1.add(new Position(chosen.getRowIndex(), chosen.getColumnIndex() + 1));
                else
                    neighbors0.add(new Position(chosen.getRowIndex(), chosen.getColumnIndex() + 1));
            }
            if (chosen.getColumnIndex()-1 >= 0) {
                if (m[chosen.getRowIndex()][chosen.getColumnIndex() - 1] == 1)
                    neighbors1.add(new Position(chosen.getRowIndex(), chosen.getColumnIndex() - 1));
                else
                    neighbors0.add(new Position(chosen.getRowIndex(), chosen.getColumnIndex() - 1));
            }
            if (neighbors0.size() <= 1){ //if there is 1 neighbor or less we want the cell to be a passage according to the algorithm
                m[chosen.getRowIndex()][chosen.getColumnIndex()] = 0;
                list.addAll(neighbors1);
            }

        }
        int GoalInd = 0; //helper to decide the goal position's column (we decided it will be in the last row).
        for (int i = 0; i < columns; i++) {
            if (m[rows-1][i]==0){
                GoalInd = i;
                break;
            }
        }

        Maze ret = new Maze(new Position(x, y), new Position(rows-1, GoalInd), m);
        return ret;
    }
}
