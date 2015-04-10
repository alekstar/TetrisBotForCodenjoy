package shapes;

import tetrissolver.Field;
import tetrissolver.TetrisCoordinates;

public class SolverForJ extends AbstractShapeSolver {

    protected SolverForJ(Field field) {
        super(field);
    }

    public static SolverForJ create(Field field) {
        return new SolverForJ(field);
    }

    private boolean areCellsAboveAreFree(TetrisCoordinates coordinates) {
        for (int y = coordinates.getY(); y < getField()
                .defineDefaultFieldHeight(); y++) {
            if (getField().isFilledCellAt(coordinates.getX(), y)) {
                return false;
            }
        }
        return true;
    }

    private TetrisCoordinates defineFreeCellCoordinates() {
        for (int y = 0; y < getField().defineDefaultFieldHeight(); y++) {
            for (int x = 0; x < getField().defineDefaultFieldWidth() - 1; x++) {
                if (!getField().isFilledCellAt(x, y)
                        && !getField().isFilledCellAt(x + 1, y)
                        && areCellsAboveAreFree(TetrisCoordinates.create(x, y))
                        && areCellsAboveAreFree(TetrisCoordinates.create(x + 1,
                                y))) {
                    return TetrisCoordinates.create(x, y);
                }
            }
        }
        throw new RuntimeException("Can't find free cell");
    }

    @Override
    public String defineCommandLine() {
        TetrisCoordinates coordinates = defineFreeCellCoordinates();
        if (coordinates.getX() == 3) {
            return drop();
        } else if (coordinates.getX() < 3) {
            return moveLeft(3 - coordinates.getX()) + ", " + drop();
        } else {
            return moveRight(coordinates.getX() - 3) + ", " + drop();
        }
    }

}
