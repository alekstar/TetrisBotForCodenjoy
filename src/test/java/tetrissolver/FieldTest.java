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

    }
}
