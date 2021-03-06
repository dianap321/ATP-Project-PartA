package algorithms.maze3D;

//Interface for 3D Maze generation.
public interface IMaze3DGenerator {
    Maze3D generate(int depth, int row, int column) throws Exception;
    long measureAlgorithmTimeMillis(int depth, int row, int column) throws Exception;
}
