package hu.ak_akademia.oop.piresian.operator;

import hu.ak_akademia.oop.piresian.Operator;
import hu.ak_akademia.oop.piresian.general.Duration;

public class ChatterMobileLtd extends AbstractOperator implements Operator {
    private static final String specNumber = "61";
    private static final double fixTariff = 295;

    @Override
    public String getPricing() {
        return "295 peták/hívás";
    }

    @Override
    public String getOperatorName() {
        return "Chatter Mobile Ltd.";
    }

    @Override
    public String getOperatorSpecifyNumber() {
        return specNumber;
    }

    @Override
    public double getPrice(Duration duration) {
        return fixTariff;
    }
}
