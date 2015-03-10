package commands;

public class Rotate extends AbstractCommand {
    public static enum Angle {
        DEGREES_0, DEGREES_90, DEGREES_180, DEGREES_270
    }

    private Angle angle;

    protected Rotate(Angle angle) {
        super();
        setAngle(angle);
    }

    public static Rotate create(Angle angle) {
        return new Rotate(angle);
    }

    protected Angle getAngle() {
        return angle;
    }

    private void setAngle(Angle angle) {
        this.angle = angle;
    }

    @Override
    public String defineCommandLine() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(defineCommandLine());
        stringBuilder.append('=');
        stringBuilder.append(defineAngleConstant());
        return null;
    }

    private int defineAngleConstant() {
        switch (getAngle()) {
        case DEGREES_0:
            return defineConstantFor0DegreesAngle();
        case DEGREES_90:
            return defineConstantFor90DegreesAngle();
        case DEGREES_180:
            return defineConstantFor180DegreesAngle();
        case DEGREES_270:
            return defineConstantFor270DegreesAngle();
        default:
            throw new IllegalStateException("Behaviour for angle " + getAngle()
                    + " is undefined.");
        }
    }

    private int defineConstantFor270DegreesAngle() {
        return 3;
    }

    private int defineConstantFor180DegreesAngle() {
        return 2;
    }

    private int defineConstantFor90DegreesAngle() {
        return 1;
    }

    private int defineConstantFor0DegreesAngle() {
        return 0;
    }

    @Override
    public String defineCommandName() {
        return "rotate";
    }

}
