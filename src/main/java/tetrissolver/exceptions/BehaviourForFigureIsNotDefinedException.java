package tetrissolver.exceptions;

public class BehaviourForFigureIsNotDefinedException extends
        IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public BehaviourForFigureIsNotDefinedException(String figure) {
        super(figure);
    }
}
