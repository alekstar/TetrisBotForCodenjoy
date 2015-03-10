package commands;

public class Rotate extends AbstractTimesCommand {

    protected Rotate(int times) {
        super(times);
    }

    public static Rotate create(int times) {
        return new Rotate(times);
    }

    @Override
    public String defineCommandName() {
        return "rotate";
    }

}
