package shapes;

import static org.junit.Assert.*;

import org.junit.Test;

import tetrissolver.Field;
import tetrissolver.FieldPrinter;

public class SolverForJTest {

    @Test
    public void shouldPutFigureAtRightCorner() {
        Field field = Field.createStandartEmptyField();
        for (int x = 0; x < field.getWidth() - 2; x++) {
            field.fillCellAt(x, 0);
        }
        FieldPrinter fieldPrinter = FieldPrinter.create(field);
        fieldPrinter.print();
        SolverForJ solver = SolverForJ.create(field);
        String expectedCommand = "right=5, drop";
        assertEquals(expectedCommand, solver.defineCommandLine());
    }
}
