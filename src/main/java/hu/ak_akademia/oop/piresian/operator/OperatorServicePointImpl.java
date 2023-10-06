package hu.ak_akademia.oop.piresian.operator;

import hu.ak_akademia.oop.piresian.OperatorServicePoint;
import hu.ak_akademia.oop.piresian.general.Duration;
import hu.ak_akademia.oop.piresian.general.InvalidCharacterException;

/**
 * <b>Exercise: Piresian Mobile Tariffs #1 (Piréz mobiltelefon-tarifák #1)</b>
 * <p>
 * Service/contact point of the package.<br>
 * Coming from its role, this is the only public class in the package.<br>
 * Singleton design pattern is applied.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
public class OperatorServicePointImpl  implements OperatorServicePoint {

    private static final OperatorServicePoint INSTANCE = new OperatorServicePointImpl();

    public static OperatorServicePoint getInstance() {
        return INSTANCE;
    }

    private final AbstractOperator[] operators = {new ChatterMobileLtd(), new QuillAerialsLtd(), new ReliantTelecomCo(), new VirtuComMobileCo()};

    private OperatorServicePointImpl() {
    }

    @Override
    public AbstractOperator[] getAvailableOperators() {
        return operators;
    }
}
