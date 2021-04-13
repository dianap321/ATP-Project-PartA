package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {
    /**
     * @param rows
     * @param columns
     * @return
     */

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
            Position chosen = list.remove(new Random().nextInt(list.size()));
            LinkedList<Position> neighbors1 = new LinkedList<Position>();
            LinkedList<Position> neighbors0 = new LinkedList<Position>();
            if (chosen.getRowIndex()-1 >= 0) {
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
            if (neighbors0.size() <= 1){
                m[chosen.getRowIndex()][chosen.getColumnIndex()] = 0;
                list.addAll(neighbors1);
            }

        }
        int GoalInd = 0;
        for (int i = 0; i < columns; i++) {
            if (m[rows-1][i]==0){
                GoalInd = i;
                break;
            }
        }

        Maze ret = new Maze(new Position(x, y), new Position(rows-1, GoalInd), m);
        return ret;
    }

//    public Maze generate(int rows, int columns) {
//        int [][] m = new int[rows][columns];
//
//        m[0][0]=0; m[0][1]=0; m[0][2]=0; m[0][3]=0; m[0][4]=0;
//        m[1][0]=0; m[1][1]=0; m[1][2]=1; m[1][3]=1; m[1][4]=0;
//        m[2][0]=1; m[2][1]=0; m[2][2]=0; m[2][3]=1; m[2][4]=0;
//        m[3][0]=1; m[3][1]=1; m[3][2]=0; m[3][3]=0; m[3][4]=0;
//
//
//        Position pStart = new Position(0,0);
//        Position pGoal = new Position(2,4);
//        Maze maze = new Maze(pStart, pGoal, m);
//        return maze;
//    }
}
