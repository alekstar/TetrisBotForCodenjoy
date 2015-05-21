package shapes;

import static org.junit.Assert.*;

import org.junit.Test;

import tetrissolver.Field;

public class SolverForITest {

    @Test
    public void ifFieldIsEmptyShouldRotateOnceMoveLeftTwiceAndDrop() {
        Field emptyField = Field.createStandartEmptyField();
        ShapeSolver solver = SolverForI.create(emptyField);
        String actualCommandLine = solver.defineCommandLine();
        String expectedCommandLine = "rotate=1, left=2, drop";
        assertEquals(expectedCommandLine, actualCommandLine);
    }

    @Test
    public void ifThereIs4FreeCellsInLowerLeftCornerShouldRotateOnceMoveLeftTwiceAndDrop() {
        Field field = Field.createStandartEmptyField();
        for (int x = 4; x < field.getWidth(); x++) {
            field.fillCellAt(x, 0);
        }
        ShapeSolver solver = SolverForI.create(field);
        String actualCommandLine = solver.defineCommandLine();
        String expectedCommandLine = "rotate=1, left=2, drop";
        assertEquals(expectedCommandLine, actualCommandLine);
    }
}
