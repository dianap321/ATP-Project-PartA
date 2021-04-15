package algorithms.search;

import java.util.Objects;

public abstract class AState {
    private String state;
    private int cost;
    private AState cameFrom; //To help recreate the path

    public AState(String state, int cost, AState cameFrom) {
        this.state = state;
        this.cost = cost;
        this.cameFrom = cameFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AState aState = (AState) o;
        return state.equals(aState.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }

    public String getState() {
        return state;
    }

    public int getCost() {
        return cost;
    }


    public AState getCameFrom() {
        return cameFrom;
    }


    @Override
    public String toString() {
        return state;
    }
}
