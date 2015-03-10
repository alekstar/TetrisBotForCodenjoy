package tetrissolver;


public class TetrisCoordinates {
    private int x;
    private int y;
    
    protected TetrisCoordinates(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public static TetrisCoordinates create(int x, int y) {
        TetrisCoordinates tetrisCoordinates = new TetrisCoordinates(x, y);
        return tetrisCoordinates;
    }

    public int getX() {
        return x;
    }

    protected void setX(int x) {
        if(x < 0) {
            throw new IllegalArgumentException("x: " + x);
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        if(y < 0) {
            throw new IllegalArgumentException("y: " + y);
        }
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject)
            return true;
        if (anotherObject == null)
            return false;
        if (getClass() != anotherObject.getClass())
            return false;
        if (hashCode() != anotherObject.hashCode()) {
            return false;
        }
        TetrisCoordinates anotherCoordinates = 
                (TetrisCoordinates) anotherObject;
        if (x != anotherCoordinates.x)
            return false;
        if (y != anotherCoordinates.y)
            return false;
        return true;
    }
    
    
}
