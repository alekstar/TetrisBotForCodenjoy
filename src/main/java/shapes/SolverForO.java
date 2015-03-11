package shapes;

import tetrissolver.Field;
import tetrissolver.TetrisCoordinates;

public class SolverForO extends AbstractShapeSolver {

    protected SolverForO(Field field) {
        super(field);
    }

    public static SolverForO create(Field field) {
        return new SolverForO(field);
    }

    private TetrisCoordinates defineFreeCellCoordinates() {
        for (int y = 0; y < getField().defineDefaultFieldHeight(); y++) {
            for (int x = 0; x < getField().defineDefaultFieldWidth() - 1; x++) {
                if (!getField().isFilledCellAt(x, y)
                        && !getField().isFilledCellAt(x + 1, y)) {
                    return TetrisCoordinates.create(x, y);
                }
            }
        }
        throw new RuntimeException("Can't find free cell");
    }

    @Override
    public String defineCommandLine() {
        TetrisCoordinates coordinates = defineFreeCellCoordinates();
        if (coordinates.getX() < 5) {
            return moveLeft(4 - coordinates.getX()) + ", " + drop();
        } else {
            return moveRight(coordinates.getX() - 4) + ", " + drop();
        }
    }

}
