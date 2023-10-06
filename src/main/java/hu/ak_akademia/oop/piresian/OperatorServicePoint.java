package hu.ak_akademia.oop.piresian;

import hu.ak_akademia.oop.piresian.operator.AbstractOperator;

/**
 * <b>Exercise: Piresian Mobile Tariffs #1 (Piréz mobiltelefon-tarifák #1)</b>
 * <p>
 * Interface for the service point of the package of mobile operators.<br>
 * Together with <code>Operator<code> interface, the two form the abstraction that both packages depend on - as it is suggested by Dependency
 * Inversion of SOLID principles.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
public interface OperatorServicePoint {

    AbstractOperator[] getAvailableOperators();
}
