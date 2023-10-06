package hu.ak_akademia.oop.piresian.operator;

import hu.ak_akademia.oop.piresian.Operator;
import hu.ak_akademia.oop.piresian.general.Duration;
import hu.ak_akademia.oop.piresian.general.InvalidCharacterException;

import java.util.Objects;

public class VirtuComMobileCo extends AbstractOperator implements Operator {

    private static final String name = "VirtuCom Mobile Co.";
    private static final String specifyNumber = "83";
    private static final String pricing = "a többiek díjai közül a legalacsonyabb plusz 5,5%";
    private static final double increment = 1.055;

    @Override
    public String getOperatorSpecifyNumber() {
        return specifyNumber;
    }

    @Override
    public String getOperatorName() {
        return name;
    }

    @Override
    public double getPrice(Duration duration) throws InvalidCharacterException {
        double minPrice = Integer.MAX_VALUE;
        for (AbstractOperator o : OperatorServicePointImpl.getInstance().getAvailableOperators()) {
            if (!Objects.equals(o.getOperatorSpecifyNumber(), "83")) {
                if (o.getPrice(duration) < minPrice) {
                    minPrice = o.getPrice(duration);
                }
            } else {
                return Math.round(minPrice * increment);
            }
        }
        return 0;
    }

    @Override
    public String getPricing() {
        return pricing;
    }
}
