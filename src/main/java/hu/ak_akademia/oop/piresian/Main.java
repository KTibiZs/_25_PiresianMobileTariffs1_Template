package hu.ak_akademia.oop.piresian;

import hu.ak_akademia.oop.piresian.general.*;
import hu.ak_akademia.oop.piresian.operator.AbstractOperator;
import hu.ak_akademia.oop.piresian.operator.OperatorServicePointImpl;
import hu.ak_akademia.oop.piresian.operator.VirtuComMobileCo;

import java.util.Objects;


/**
 * <b>Exercise: Piresian Mobile Tariffs #1 (Piréz mobiltelefon-tarifák #1)</b>
 * <p>
 * The main program.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
public class Main {

    public static void main(String[] args) throws InvalidInput {
        new Main().run();
    }

    @SuppressWarnings("unused")
    private final Operator[] operators = OperatorServicePointImpl.getInstance().getAvailableOperators();

    private void run() throws InvalidInput {
        var th = new TextHolder();
        th.welcome();
        th.printUserInfo();
        try (var userInput = new UserInput()) {
            while (true) {
                try {
                    process(userInput);
                } catch (InvalidCharacterException | InvalidLengthOfPhoneNumber | AreaNumberStartWithZeroException |
                         InvalidLengthOfLocalComponent | WithoutPrefixException | NumberFormatException |
                         ArrayIndexOutOfBoundsException | NullPointerException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    @SuppressWarnings("unused")
    public void process(UserInput userInput) throws InvalidInput {
        PhoneNumber phoneNumber = userInput.askPhoneNumber("Add meg a hívószámot távhívás formátumban: ");
        AbstractOperator operator = (AbstractOperator) identifyOperator(phoneNumber);
        phoneNumber.makePosteriorCheck(operator);
        Duration duration = userInput.askCallDuration("Add meg a hívás időtartamát (<perc>:<mp>): ");
        AbstractOperator cheapestOperator = (AbstractOperator) identifyCheapestOperator(duration);
        printOperatorData(operator, duration);
        printCheapestOperatorData(cheapestOperator, duration, cheapestOperator);
    }

    private Operator identifyOperator(PhoneNumber phoneNumber) {
        Operator operator = null;
        for (AbstractOperator o : OperatorServicePointImpl.getInstance().getAvailableOperators()) {
            if (phoneNumber.getNormalForm().startsWith(o.getOperatorSpecifyNumber())) {
                operator = o;
                break;
            }
        }
        return operator;
    }

    private Operator identifyCheapestOperator(Duration duration) throws InvalidInput {
        double cheapestOperator = Double.MAX_VALUE;
        String operatorName = null;
        AbstractOperator operator = null;
        for (AbstractOperator o : OperatorServicePointImpl.getInstance().getAvailableOperators()) {
            if (o.getPrice(duration) < cheapestOperator) {
                cheapestOperator = o.getPrice(duration);
                operatorName = o.getOperatorName();
            }
        }
        for (AbstractOperator o : OperatorServicePointImpl.getInstance().getAvailableOperators()) {
            if (Objects.equals(operatorName, o.getOperatorName())) {
                operator = o;
            }
        }
        return operator;
    }

    void printOperatorData(AbstractOperator operator, Duration duration) throws InvalidCharacterException {
        System.out.println("A hívás szolgáltatója: " + operator.getOperatorName() + ", " + "díja: "
                + operator.getPrice(duration) + " peták" + " (díjazása: " + operator.getPricing() + ")");
    }

    void printCheapestOperatorData(AbstractOperator op, Duration dur, AbstractOperator chOp) throws InvalidCharacterException {
        if (op != chOp) {
            System.out.println("A megadott idejű hívásra a " + op.getOperatorName() + " a legolcsóbb szolgáltató.");
        } else {
            System.out.println("A megadott idejű hívásra a " + op.getOperatorName() + " lenne a legolcsóbb szolgáltató" +
                    ", a díjuk csak " + op.getPrice(dur) + " peták.");
        }
    }
}
