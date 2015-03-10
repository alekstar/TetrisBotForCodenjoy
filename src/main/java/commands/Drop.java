package commands;

public class Drop extends AbstractCommand {

    protected Drop() {
        super();
    }

    public static Drop create() {
        return new Drop();
    }

    @Override
    public String defineCommandLine() {
        return defineCommandName();
    }

    @Override
    public String defineCommandName() {
        return "drop";
    }

}
