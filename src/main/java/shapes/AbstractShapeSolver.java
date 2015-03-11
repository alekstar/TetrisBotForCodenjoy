package shapes;

import tetrissolver.Field;

import commands.Drop;
import commands.MoveLeft;
import commands.MoveRight;
import commands.Rotate;
import commands.Rotate.Angle;

public abstract class AbstractShapeSolver implements ShapeSolver {
    private Field field;

    protected AbstractShapeSolver(Field field) {
        setField(field);
    }

    protected Field getField() {
        return field;
    }

    private void setField(Field field) {
        if (field == null) {
            throw new IllegalArgumentException("Argument field is null.");
        }
        this.field = field;
    }

    protected String moveLeft(int times) {
        MoveLeft moveLeft = MoveLeft.create(times);
        return moveLeft.defineCommandLine();
    }

    protected String moveRight(int times) {
        MoveRight moveRight = MoveRight.create(times);
        return moveRight.defineCommandLine();
    }

    protected String rotate(Angle angle) {
        Rotate rotate = Rotate.create(angle);
        return rotate.defineCommandLine();
    }

    protected String drop() {
        Drop drop = Drop.create();
        return drop.defineCommandLine();
    }
}
