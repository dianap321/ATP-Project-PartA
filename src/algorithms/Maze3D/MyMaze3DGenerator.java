package algorithms.Maze3D;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.LinkedList;
import java.util.Random;

public class MyMaze3DGenerator extends AMaze3DGenerator {

    @Override
    public Maze3D generate(int depth, int row, int column) throws Exception {
        if(row < 2 || column < 2 || depth < 2)
            throw new Exception("Maze size can't be smaller than 2x2x2.");
        //we start by making a matrix of 1's of the wanted size
        int [][][] m = new int[depth][row][column];

        for (int k = 0; k < depth ; k++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    m[k][i][j] = 1;
                }
            }
        }

        LinkedList<Position3D> list = new LinkedList<Position3D>();
        //choose a starting point (we chose to have a start point from the top row)

        int d = 0;
        int r = new Random().nextInt(column);
        int c = new Random().nextInt(column);
        list.add(new Position3D(d, r, c));
        while (!list.isEmpty()){
            Position3D chosen = list.remove(new Random().nextInt(list.size()));
            LinkedList<Position3D> neighbors1 = new LinkedList<Position3D>();
            LinkedList<Position3D> neighbors0 = new LinkedList<Position3D>();
            if (chosen.getRowIndex()-1 >= 0) {
                if (m[chosen.getDepthIndex()][chosen.getRowIndex() - 1][chosen.getColumnIndex()] == 1)
                    neighbors1.add(new Position3D(chosen.getDepthIndex(),chosen.getRowIndex() - 1, chosen.getColumnIndex()));
                else
                    neighbors0.add(new Position3D(chosen.getDepthIndex(),chosen.getRowIndex() - 1, chosen.getColumnIndex()));
            }
            if (chosen.getRowIndex()+1 < row) {
                if (m[chosen.getDepthIndex()][chosen.getRowIndex() + 1][chosen.getColumnIndex()] == 1)
                    neighbors1.add(new Position3D(chosen.getDepthIndex(),chosen.getRowIndex() + 1, chosen.getColumnIndex()));
                else
                    neighbors0.add(new Position3D(chosen.getDepthIndex(),chosen.getRowIndex() + 1, chosen.getColumnIndex()));
            }
            if (chosen.getColumnIndex()+1 < column) {
                if (m[chosen.getDepthIndex()][chosen.getRowIndex()][chosen.getColumnIndex() + 1] == 1)
                    neighbors1.add(new Position3D(chosen.getDepthIndex(), chosen.getRowIndex(), chosen.getColumnIndex() + 1));
                else
                    neighbors0.add(new Position3D(chosen.getDepthIndex(), chosen.getRowIndex(), chosen.getColumnIndex() + 1));
            }
            if (chosen.getColumnIndex()-1 >= 0) {
                if (m[chosen.getDepthIndex()][chosen.getRowIndex()][chosen.getColumnIndex() - 1] == 1)
                    neighbors1.add(new Position3D(chosen.getDepthIndex(), chosen.getRowIndex(), chosen.getColumnIndex() - 1));
                else
                    neighbors0.add(new Position3D(chosen.getDepthIndex(), chosen.getRowIndex(), chosen.getColumnIndex() - 1));
            }
            if (chosen.getDepthIndex()-1 >= 0) {
                if (m[chosen.getDepthIndex() - 1][chosen.getRowIndex()][chosen.getColumnIndex()] == 1)
                    neighbors1.add(new Position3D(chosen.getDepthIndex() - 1,chosen.getRowIndex(), chosen.getColumnIndex()));
                else
                    neighbors0.add(new Position3D(chosen.getDepthIndex() - 1,chosen.getRowIndex(), chosen.getColumnIndex()));
            }
            if (chosen.getRowIndex()+1 < depth) {
                if (m[chosen.getDepthIndex() + 1][chosen.getRowIndex()][chosen.getColumnIndex()] == 1)
                    neighbors1.add(new Position3D(chosen.getDepthIndex() + 1, chosen.getRowIndex(), chosen.getColumnIndex()));
                else
                    neighbors0.add(new Position3D(chosen.getDepthIndex() + 1, chosen.getRowIndex(), chosen.getColumnIndex()));
            }
            if (neighbors0.size() <= 1){
                m[chosen.getDepthIndex()][chosen.getRowIndex()][chosen.getColumnIndex()] = 0;
                list.addAll(neighbors1);
            }

        }
        int GoalIndR = 0;
        int GoalIndC = 0;
        for (int j = 0; j < row; j++) {
            for (int i = 0; i < column; i++) {
                if (m[depth - 1][j][i]==0){
                    GoalIndR = j;
                    GoalIndC = i;
                    break;
                }
            }
        }

        Maze3D ret = new Maze3D(new Position3D(d, r, c), new Position3D(depth-1, GoalIndR, GoalIndC), m);
        return ret;

    }
}
