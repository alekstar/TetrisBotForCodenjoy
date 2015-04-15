package shapes;

import static org.junit.Assert.*;

import org.junit.Test;

import tetrissolver.Field;
import tetrissolver.FieldPrinter;

public class SolverForJTest {

    @Test
    public void shouldPutFigureAtRightCorner() {
        Field field =
                defineFieldWithFilledBottomLineExceptTwoCellsInTheLeftCorner();
        assertEquals("right=5, drop", SolverForJ.create(field)
                .defineCommandLine());
    }

    private Field defineFieldWithFilledBottomLineExceptTwoCellsInTheLeftCorner() {
        Field field = Field.createStandartEmptyField();
        for (int x = 0; x < field.getWidth() - 2; x++) {
            field.fillCellAt(x, 0);
        }
        return field;
    }
}
