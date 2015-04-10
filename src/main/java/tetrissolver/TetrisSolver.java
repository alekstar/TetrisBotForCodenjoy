package tetrissolver;

import shapes.ShapeSolver;
import shapes.SolverForI;
import shapes.SolverForO;
import tetrissolver.exceptions.BehaviourForFigureIsNotDefinedException;
import commands.Drop;

public class TetrisSolver {

    private String drop() {
        Drop drop = Drop.create();
        return drop.defineCommandLine();
    }

    private ShapeSolver defineSolverForFigure(Field field, String figure) {
        if (figure.contentEquals("O")) {
            return SolverForO.create(field);
        } else if (figure.contentEquals("I")) {
            return SolverForI.create(field);
        } else {
            throw new BehaviourForFigureIsNotDefinedException(figure);
        }
    }

    private String defineCommand(Field field, String figure) {
        try {
            ShapeSolver solver = defineSolverForFigure(field, figure);
            return solver.defineCommandLine();
        } catch (BehaviourForFigureIsNotDefinedException e) {
            String message =
                    generateMessageForBehaviourForFigureIsNotDefinedException(e
                            .getMessage());
            System.err.println(message);
            return drop();
        }
    }

    private String generateMessageForBehaviourForFigureIsNotDefinedException(
            String figureFromException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Behaviour for figure \"");
        stringBuilder.append(figureFromException);
        stringBuilder.append("\" is not defined. Called command \"drop\".");
        return stringBuilder.toString();
    }

    public String answer(String figure, int x, int y, String glass, String next) {
        // add "drop" to response when you need to drop a figure
        // for details please check http://codenjoy.com/portal/?p=170#commands
        // return "left=4, right=3, rotate=0, drop";

        Field field = Field.createStandartFieldFromString(glass);
        FieldPrinter fieldPrinter = FieldPrinter.create(field);
        System.out.println("Field:");
        fieldPrinter.print();
        return defineCommand(field, figure);
        // return "left=4, drop";
    }
}
