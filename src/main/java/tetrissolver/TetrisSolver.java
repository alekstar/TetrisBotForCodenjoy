package tetrissolver;

import commands.Drop;
import commands.MoveLeft;
import commands.MoveRight;
import commands.Rotate;
import commands.Rotate.Angle;

public class TetrisSolver {

    private String moveLeft(int times) {
        MoveLeft moveLeft = MoveLeft.create(times);
        return moveLeft.defineCommandLine();
    }

    private String moveRight(int times) {
        MoveRight moveRight = MoveRight.create(times);
        return moveRight.defineCommandLine();
    }

    private String rotate(Angle angle) {
        Rotate rotate = Rotate.create(angle);
        return rotate.defineCommandLine();
    }

    private String drop() {
        Drop drop = Drop.create();
        return drop.defineCommandLine();
    }

    private TetrisCoordinates defineFreeCellCoordinatesForCube(Field field) {
        for (int y = 0; y < field.defineDefaultFieldHeight(); y++) {
            for (int x = 0; x < field.defineDefaultFieldWidth() - 1; x++) {
                if (!field.isFilledCellAt(x, y)
                        && !field.isFilledCellAt(x + 1, y)) {
                    return TetrisCoordinates.create(x, y);
                }
            }
        }
        throw new RuntimeException("Can't find free cell");
    }

    private String defineCommandForCube(Field field) {
        TetrisCoordinates coordinates = defineFreeCellCoordinatesForCube(field);
        if (coordinates.getX() < 5) {
            return moveLeft(4 - coordinates.getX()) + ", " + drop();
        } else /* if (coordinates.getX() >= 5) */{
            return moveRight(coordinates.getX() - 4) + ", " + drop();
        }
    }

    private TetrisCoordinates defineFreeCellCoordinatesForLine(Field field) {
        for (int y = 0; y < field.defineDefaultFieldHeight(); y++) {
            for (int x = 0; x < field.defineDefaultFieldWidth(); x++) {
                if (!field.isFilledCellAt(x, y)) {
                    return TetrisCoordinates.create(x, y);
                }
            }
        }
        throw new RuntimeException("Can't find free cell");
    }

    private String defineCommandForLine(Field field) {
        TetrisCoordinates coordinates = defineFreeCellCoordinatesForLine(field);
        if (coordinates.getX() < 5) {
            return moveLeft(4 - coordinates.getX()) + ", " + drop();
        } else {
            return moveRight(coordinates.getX() - 4) + ", " + drop();
        }
    }

    private String defineCommand(Field field, String figure) {
        if (figure.contentEquals("O")) {
            return defineCommandForCube(field);
        } else if (figure.contentEquals("I")) {
            return defineCommandForLine(field);
        } else {
            return drop();
        }
    }

    public String answer(String figure, int x, int y, String glass, String next) {
        // add "drop" to response when you need to drop a figure
        // for details please check http://codenjoy.com/portal/?p=170#commands
        // return "left=4, right=3, rotate=0, drop";

        Field field = Field.create(glass);
        return defineCommand(field, figure);
        // return "left=4, drop";
    }
}
