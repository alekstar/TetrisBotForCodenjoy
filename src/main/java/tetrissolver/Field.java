package tetrissolver;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Boolean> fieldArray;
    private int width;
    private int height;

    protected Field(String fieldString, int width, int height) {
        setWidth(width);
        setHeight(height);
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

    public static Field create(String fieldString, int width, int height) {
        return new Field(fieldString, width, height);
    }

    public static Field create(String fieldString) {
        return Field.create(fieldString, defineDefaultFieldWidth(),
                defineDefaultFieldHeight());
    }

    private static char defineFilledCellCharValue() {
        return '*';
    }

    private static char defineClearCellCharValue() {
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
        return fieldArray.get(y * getWidth() + x);
    }

    public static int defineDefaultFieldHeight() {
        return 20;
    }

    public static int defineDefaultFieldWidth() {
        return 10;
    }

    private void checkX(int x) {
        if (x < 0 || getWidth() <= x) {
            throw new IllegalArgumentException("x: " + x);
        }
    }

    private void checkY(int y) {
        if (y < 0 || getHeight() <= y) {
            throw new IllegalArgumentException("y: " + y);
        }
    }

    public int getWidth() {
        return width;
    }

    private void setWidth(int width) {
        if (width < 1) {
            throw new IllegalArgumentException(
                    "Width of the field is not right.");
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(
                    "Height of the field is not right.");
        }
        this.height = height;
    }
}
