package commands;

public class MoveRight extends AbstractTimesCommand implements Command {

    protected MoveRight(int times) {
        super(times);
    }

    public static MoveRight create(int times) {
        return new MoveRight(times);
    }

    @Override
    public String defineCommandName() {
        return "right";
    }

}
