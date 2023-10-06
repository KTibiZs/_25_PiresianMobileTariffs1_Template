package hu.ak_akademia.oop.piresian;

import hu.ak_akademia.oop.piresian.general.Duration;
import hu.ak_akademia.oop.piresian.general.InvalidCharacterException;

/**
 * <b>Exercise: Piresian Mobile Tariffs #1 (Piréz mobiltelefon-tarifák #1)</b>
 * <p>
 * Interface for mobile operators.<br>
 * Together with <code>OperatorServicePoint<code> interface, the two form the abstraction that both packages depend on - as it is suggested by
 * Dependency Inversion of SOLID principles.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
public interface Operator {
    //    String getOperatorSpecifyNumber();
//
//    String getPricing();
//    String getOperatorName();
    double getPrice(Duration duration) throws InvalidCharacterException;


}






