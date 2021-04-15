package algorithms.maze3D;

import java.util.*;

//Our maze generator uses Prim's algorithm.
public class MyMaze3DGenerator extends AMaze3DGenerator {

    @Override
    public Maze3D generate(int depth, int row, int column) throws Exception {
        if (row < 2 || column < 2 || depth < 2)
            throw new Exception("Maze size can't be smaller than 2x2x2.");
        //we start by making a matrix of 1's of the wanted size
        int[][][] m = new int[depth][row][column];

        for (int k = 0; k < depth; k++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    m[k][i][j] = 1;
                }
            }
        }
        ArrayList<Position3D> list = new ArrayList<>();
        //choose a starting point (we chose to have a start point from the "top floor")

        int d = 0;
        int r = new Random().nextInt(column);
        int c = new Random().nextInt(column);
        list.add(new Position3D(d, r, c));
        while (!list.isEmpty()) {
            Position3D chosen = list.remove(new Random().nextInt(list.size())); //choose a cell at random so that we get an intricate maze
            HashSet<Position3D> neighbors1 = new HashSet<Position3D>(); //contains all neighboring walls.
            int neighbors0 = 0; //Counter for neighboring passages.
            Position3D check = new Position3D(0, 0, 0);

            if (chosen.getRowIndex() - 1 >= 0) {//checking if in range.
                if (m[chosen.getDepthIndex()][chosen.getRowIndex() - 1][chosen.getColumnIndex()] == 1) {
                    if (!neighbors1.contains(check = new Position3D(chosen.getDepthIndex(), chosen.getRowIndex() - 1, chosen.getColumnIndex()))) {
                        neighbors1.add(check);
                    }
                }
                else
                    neighbors0++;
            }

            if (chosen.getRowIndex() + 1 < row) {
                if (m[chosen.getDepthIndex()][chosen.getRowIndex() + 1][chosen.getColumnIndex()] == 1) {
                    if (!neighbors1.contains(check = new Position3D(chosen.getDepthIndex(), chosen.getRowIndex() + 1, chosen.getColumnIndex()))) {
                        neighbors1.add(check);
                    }
                }
                else
                    neighbors0++;
            }

            if (chosen.getColumnIndex() + 1 < column) {
                if (m[chosen.getDepthIndex()][chosen.getRowIndex()][chosen.getColumnIndex() + 1] == 1) {
                    if (!neighbors1.contains(check = new Position3D(chosen.getDepthIndex(), chosen.getRowIndex(), chosen.getColumnIndex() + 1))) {
                        neighbors1.add(check);
                    }
                }
                else
                    neighbors0++;
            }

            if (chosen.getColumnIndex() - 1 >= 0) {
                if (m[chosen.getDepthIndex()][chosen.getRowIndex()][chosen.getColumnIndex() - 1] == 1) {
                    if (!neighbors1.contains(check = new Position3D(chosen.getDepthIndex(), chosen.getRowIndex(), chosen.getColumnIndex() - 1))) {
                        neighbors1.add(check);
                    }
                }
                else
                    neighbors0++;
            }

            if (chosen.getDepthIndex() - 1 >= 0) {
                if (m[chosen.getDepthIndex() - 1][chosen.getRowIndex()][chosen.getColumnIndex()] == 1) {
                    if (!neighbors1.contains(check = new Position3D(chosen.getDepthIndex() - 1, chosen.getRowIndex(), chosen.getColumnIndex()))) {
                        neighbors1.add(check);
                    }
                }
                else
                    neighbors0++;
            }

            if (chosen.getDepthIndex() + 1 < depth) {
                if (m[chosen.getDepthIndex() + 1][chosen.getRowIndex()][chosen.getColumnIndex()] == 1) {
                    if (!neighbors1.contains(check = new Position3D(chosen.getDepthIndex() + 1, chosen.getRowIndex(), chosen.getColumnIndex()))) {
                        neighbors1.add(check);
                    }
                }
                else
                    neighbors0++;
            }

            if (neighbors0 <= 1) { //if there is 1 neighbor or less we want the cell to be a passage according to the algorithm
                m[chosen.getDepthIndex()][chosen.getRowIndex()][chosen.getColumnIndex()] = 0;
                list.addAll(neighbors1);
            }
        }
        //Helper to decide the goal position.
        int GoalIndR = 0;
        int GoalIndC = 0;
        for (int j = 0; j < row; j++) {
            for (int i = 0; i < column; i++) {
                if (m[depth - 1][j][i] == 0) {
                    GoalIndR = j;
                    GoalIndC = i;
                    break;
                }
            }
        }

        Maze3D ret = new Maze3D(new Position3D(d, r, c), new Position3D(depth - 1, GoalIndR, GoalIndC), m);
        return ret;
    }
}