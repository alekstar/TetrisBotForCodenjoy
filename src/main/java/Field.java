import java.util.ArrayList;
import java.util.List;

public class Field {
    List<Boolean> fieldArray;

    protected Field(String fieldString) {
        initializeFieldArray();
        for (char currentChar : fieldString.toCharArray()) {
            if (currentChar == defineClearCellCharValue()) {
                add(false);
            } else if (currentChar == defineFilledCellCharValue()) {
                add(true);
            } else {
                throw new IllegalArgumentException(
                        "Field string have bad character: '" + currentChar
                                + "'");
            }
        }
    }

    public static Field create(String fieldString) {
        Field field = new Field(fieldString);
        return field;
    }

    private char defineFilledCellCharValue() {
        return '*';
    }

    private char defineClearCellCharValue() {
        return ' ';
    }

    private void initializeFieldArray() {
        this.fieldArray = new ArrayList<Boolean>();
    }

    private void add(boolean value) {
        if (this.fieldArray == null) {
            throw new IllegalStateException("Field array is not initialized.");
        }
        fieldArray.add(new Boolean(value));
    }

    public boolean isFilledCellAt(int x, int y) {
        checkX(x);
        checkY(y);
        return fieldArray.get(y * defineDefaultFieldWidth() + x);
    }

    public int defineDefaultFieldHeight() {
        return 20;
    }

    public int defineDefaultFieldWidth() {
        return 10;
    }

    private void checkX(int x) {
        if (x < 0 || defineDefaultFieldWidth() <= x) {
            throw new IllegalArgumentException("x: " + x);
        }
    }

    private void checkY(int y) {
        if (y < 0 || defineDefaultFieldHeight() <= y) {
            throw new IllegalArgumentException("y: " + y);
        }
    }
}
