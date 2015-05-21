package tetrissolver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StandartFieldTests {
    private Field field = Field.createStandartEmptyField();

    private boolean haveToBeFilled(TetrisCoordinates checkedCell,
            TetrisCoordinates[] filledCells) {
        for (int i = 0; i < filledCells.length; i++) {
            if (filledCells[i].equals(checkedCell)) {
                return true;
            }
        }
        return false;
    }

    private boolean areFilledOnlySpecifiedCells(Field field,
            TetrisCoordinates[] filledCells) {
        for (int y = 0; y < field.getHeight(); y++) {
            for (int x = 0; x < field.getWidth(); x++) {
                if (haveToBeFilled(TetrisCoordinates.create(x, y), filledCells)
                        && !field.isFilledCellAt(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void shouldFillOnlyCellAt4x5AtField() {
        field.fillCellAt(4, 5);
        TetrisCoordinates[] filledCells =
                new TetrisCoordinates[] { new TetrisCoordinates(4, 5) };
        assertTrue(areFilledOnlySpecifiedCells(field, filledCells));
    }

    @Test
    public void shouldIsEmptyMethodReturnTrueForEmptyField() {
        assertTrue(field.isEmpty());
    }

    @Test
    public void shouldIsEmptyMethodReturnFalseIfCellInLowerLeftCornerIsFilled() {
        field.fillCellAt(0, 0);
        assertFalse(field.isEmpty());
    }

    @Test
    public void shouldIsEmptyMethodReturnFalseIfCellInLowerRightCornerIsFilled() {
        field.fillCellAt(field.getWidth() - 1, 0);
        assertFalse(field.isEmpty());
    }

    @Test
    public void shouldIsEmptyMethodReturnFalseIfCellsInUpperRightUpperLeftAndInCenterAreFilled() {
        field.fillCellAt(0, field.getHeight() - 1);
        field.fillCellAt(field.getWidth() - 1, field.getHeight() - 1);
        field.fillCellAt(field.getWidth() / 2, field.getHeight() / 2);
        assertFalse(field.isEmpty());
    }
}
