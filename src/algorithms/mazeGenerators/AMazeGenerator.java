package algorithms.mazeGenerators;

//Abstract maze generation class.
public abstract class AMazeGenerator implements IMazeGenerator {

    @Override
    public long measureAlgorithmTimeMillis(int rows, int columns) throws Exception {
        long t1 = System.currentTimeMillis();
        generate(rows, columns);
        long t2 = System.currentTimeMillis();
        return t2-t1;
    }
}
