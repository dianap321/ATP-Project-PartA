package algorithms.maze3D;

import algorithms.search.AState;

public class Maze3DState extends AState {
    public Maze3DState(String state, int cost, AState cameFrom) {
        super(state, cost, cameFrom);
    }

    public int getD(){
        int d = Integer.parseInt(getNums()[0]);
        return d;
    }
    public int getR(){
        int y = Integer.parseInt(getNums()[1]);
        return y;
    }
    public int getC(){
        int z = Integer.parseInt(getNums()[2]);
        return z;
    }

    //Helper function; strips the String representation of State, returns an array: [depth, row, column].
    private String[] getNums(){
        String stateNums = this.getState().substring(1, this.getState().length() - 1);
        String[] Nums = stateNums.split(",");
        return Nums;
    }
}
