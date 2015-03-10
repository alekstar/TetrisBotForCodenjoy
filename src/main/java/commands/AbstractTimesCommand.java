package commands;

public abstract class AbstractTimesCommand extends AbstractCommand {
    private int times;

    protected AbstractTimesCommand(int times) {
        setTimes(times);
    }

    protected void checkTimes(int times) {
        if (times < 0) {
            throw new IllegalArgumentException("Argument times is less zero.");
        }
    }

    protected int getTimes() {
        return times;
    }

    private void setTimes(int times) {
        checkTimes(times);
        this.times = times;
    }

    @Override
    public String defineCommandLine() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(defineCommandName());
        stringBuilder.append('=');
        stringBuilder.append(times);
        return stringBuilder.toString();
    }
}
