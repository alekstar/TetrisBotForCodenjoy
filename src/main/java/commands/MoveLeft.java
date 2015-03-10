package commands;

public class MoveLeft extends AbstractTimesCommand {

    protected MoveLeft(int times) {
        super(times);
    }

    public static MoveLeft create(int times) {
        return new MoveLeft(times);
    }

    @Override
    public String defineCommandName() {
        return "left";
    }

}
