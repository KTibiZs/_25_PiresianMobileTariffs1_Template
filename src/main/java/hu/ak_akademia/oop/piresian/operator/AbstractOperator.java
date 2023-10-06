package hu.ak_akademia.oop.piresian.operator;

import hu.ak_akademia.oop.piresian.Operator;

public abstract class AbstractOperator implements Operator {
    public abstract String getPricing();
    public abstract String getOperatorSpecifyNumber();

    public abstract String getOperatorName();
}
