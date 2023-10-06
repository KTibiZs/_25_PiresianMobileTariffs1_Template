package hu.ak_akademia.oop.piresian.operator;

import hu.ak_akademia.oop.piresian.Operator;
import hu.ak_akademia.oop.piresian.general.Duration;
import hu.ak_akademia.oop.piresian.general.InvalidCharacterException;
import hu.ak_akademia.oop.piresian.general.InvalidInput;

import java.util.InputMismatchException;

public class ReliantTelecomCo extends AbstractOperator implements Operator {
    private static final String specNumber = "711";
    private static final double pricePerMinute = 67;
    private static final double minuteInSec = 60;
    private static final int starter = 1;

    @Override
    public String getPricing() {
        return "megkezdett percenként 67 peták/perc";
    }

    @Override
    public String getOperatorName() {
        return "Reliant Telecom Co.";
    }

    @Override
    public double getPrice(Duration duration) throws InvalidCharacterException {
        return (starter + Math.floor(duration.rawDurationToSec(duration.getRawDuration()) / minuteInSec)) * pricePerMinute;
    }

    @Override
    public String getOperatorSpecifyNumber() {
        return specNumber;
    }
}
