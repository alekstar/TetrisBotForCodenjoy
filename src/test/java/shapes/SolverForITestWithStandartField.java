package shapes;

import static org.junit.Assert.*;

import org.junit.Test;

import tetrissolver.Field;

public class SolverForITestWithStandartField {
    private Field field = Field.createStandartEmptyField();
    private ShapeSolver solver = SolverForI.create(field);

    private void assertCommandLine(String expected) {
        assertEquals(expected, solver.defineCommandLine());
    }

    @Test
    public void ifFieldIsEmptyShouldRotateOnceMoveLeftTwiceAndDrop() {
        assertCommandLine("rotate=1, left=2, drop");
    }

    @Test
    public void ifThereIs4FreeCellsInLowerLeftCornerShouldRotateOnceMoveLeftTwiceAndDrop() {
        for (int x = 4; x < field.getWidth(); x++) {
            field.fillCellAt(x, 0);
        }
        assertCommandLine("rotate=1, left=2, drop");
    }
}
