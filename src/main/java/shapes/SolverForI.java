package shapes;

import tetrissolver.Field;
import tetrissolver.TetrisCoordinates;

public class SolverForI extends AbstractShapeSolver {

    protected SolverForI(Field field) {
        super(field);
    }

    public static SolverForI create(Field field) {
        return new SolverForI(field);
    }

    private TetrisCoordinates defineFreeCellCoordinates() {
        for (int y = 0; y < getField().getHeight(); y++) {
            for (int x = 0; x < getField().getWidth(); x++) {
                if (!getField().isFilledCellAt(x, y)) {
                    return TetrisCoordinates.create(x, y);
                }
            }
        }
        throw new RuntimeException("Can't find free cell");
    }

    private boolean isFieldEmpty() {
        return getField().isEmpty();
    }

    @Override
    public String defineCommandLine() {
        if (isFieldEmpty()) {
            return "rotate=1, left=2, drop";
        }
        TetrisCoordinates coordinates = defineFreeCellCoordinates();
        if (coordinates.getX() < 5) {
            return moveLeft(4 - coordinates.getX()) + ", " + drop();
        } else {
            return moveRight(coordinates.getX() - 4) + ", " + drop();
        }
    }
}
