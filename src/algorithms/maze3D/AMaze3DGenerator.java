package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMaze3DGenerator {

    @Override
    public long measureAlgorithmTimeMillis(int depth, int row, int column) throws Exception {
        long t1 = System.currentTimeMillis();
        generate(depth, row, column);
        long t2 = System.currentTimeMillis();
        return t2-t1;
    }
}
