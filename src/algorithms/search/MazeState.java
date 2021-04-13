package algorithms.search;

public class MazeState extends AState {

    public MazeState(String state, int cost, AState cameFrom) {
        super(state, cost, cameFrom);
    }

    int getX(){
        int x = Integer.parseInt(this.getState().substring(this.getState().indexOf("{")+1,this.getState().indexOf(",")));
        return x;
    }
    int getY(){
        int y = Integer.parseInt(this.getState().substring(this.getState().indexOf(",")+1,this.getState().indexOf("}")));
        return y;
    }
}
