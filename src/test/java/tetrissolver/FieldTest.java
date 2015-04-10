package tetrissolver;

import static org.junit.Assert.*;

import org.junit.Test;

public class FieldTest {

    private boolean isFieldEmpty(Field field) {
        if (field == null) {
            throw new IllegalArgumentException("Argument field is null.");
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
    public void ShouldCreateEmptyField10x20() {
        Field field = Field.createEmptyField(10, 20);
        assertTrue(isFieldEmpty(field));
    }
}
