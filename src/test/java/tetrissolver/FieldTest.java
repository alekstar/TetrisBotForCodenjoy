package tetrissolver;

import static org.junit.Assert.*;

import org.junit.Test;

public class FieldTest {

    private boolean isFieldEmptyAndItsSizeIs(Field field, int width, int height) {
        if (field == null) {
            throw new IllegalArgumentException("Argument field is null.");
        }
        if (field.getWidth() != width) {
            return false;
        }
        if (field.getHeight() != height) {
            return false;
        }
        for (int y = 0; y < field.getHeight(); y++) {
            for (int x = 0; x < field.getWidth(); x++) {
                if (field.isFilledCellAt(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void shouldCreateEmptyField10x20() {
        Field field = Field.createEmptyField(10, 20);
        assertTrue(isFieldEmptyAndItsSizeIs(field, 10, 20));
    }

    @Test
    public void shouldCreateEmptyStandartField() {
        Field field = Field.createStandartEmptyField();
        assertTrue(isFieldEmptyAndItsSizeIs(field,
                Field.defineDefaultFieldWidth(),
                Field.defineDefaultFieldHeight()));
    }

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
        Field field = Field.createStandartEmptyField();
        field.fillCellAt(4, 5);
        TetrisCoordinates[] filledCells =
                new TetrisCoordinates[] { new TetrisCoordinates(4, 5) };
        assertTrue(areFilledOnlySpecifiedCells(field, filledCells));
    }

    @Test
    public void shouldIsEmptyMethodReturnTrueForEmptyField() {
        Field field = Field.createStandartEmptyField();
        assertTrue(field.isEmpty());
    }

    @Test
    public void shouldIsEmptyMethodReturnFalseIfCellInLowerLeftCornerIsFilled() {
        Field field = Field.createStandartEmptyField();
        field.fillCellAt(0, 0);
        assertFalse(field.isEmpty());
    }

    @Test
    public void shouldIsEmptyMethodReturnFalseIfCellInLowerRightCornerIsFilled() {
        Field field = Field.createStandartEmptyField();
        field.fillCellAt(field.getWidth() - 1, 0);
        assertFalse(field.isEmpty());
    }

    @Test
    public void shouldIsEmptyMethodReturnFalseIfCellsInUpperRightUpperLeftAndInCenterAreFilled() {
        Field field = Field.createStandartEmptyField();
        field.fillCellAt(0, field.getHeight() - 1);
        field.fillCellAt(field.getWidth() - 1, field.getHeight() - 1);
        field.fillCellAt(field.getWidth() / 2, field.getHeight() / 2);
        assertFalse(field.isEmpty());

    }
}
