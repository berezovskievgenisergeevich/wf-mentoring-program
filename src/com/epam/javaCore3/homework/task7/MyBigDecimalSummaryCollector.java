package com.epam.javaCore3.homework.task7;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.stream.Collector;

public class MyBigDecimalSummaryCollector implements Consumer<BigDecimal> {

    public static final int ROUND_HALF_UP = BigDecimal.ROUND_HALF_UP;

    public static final Integer TRANSACTIONS_SCALE = 2;

    private BigDecimal sum = BigDecimal.ZERO.setScale(TRANSACTIONS_SCALE, ROUND_HALF_UP);
    private BigDecimal minimum = BigDecimal.ZERO.setScale(TRANSACTIONS_SCALE, ROUND_HALF_UP);
    private BigDecimal maximum = BigDecimal.ZERO.setScale(TRANSACTIONS_SCALE, ROUND_HALF_UP);
    private int count;

    public static Collector<BigDecimal, ?, MyBigDecimalSummaryCollector> myBigDecimalSummaryStatistics() {

        return Collector.of(MyBigDecimalSummaryCollector::new, MyBigDecimalSummaryCollector::accept,
                MyBigDecimalSummaryCollector::merge);
    }

    @Override
    public void accept(BigDecimal t) {

        if (count == 0) {
            firstElementSetup(t);
        } else {
            sum = sum.add(t);
            minimum = minimum.min(t);
            maximum = maximum.max(t);
            count++;
        }
    }

    public MyBigDecimalSummaryCollector merge(MyBigDecimalSummaryCollector s) {
        if (s.count > 0) {
            if (count == 0) {
                setupFirstElement(s);
            } else {
                sum = sum.add(s.sum);
                minimum = minimum.min(s.minimum);
                maximum = maximum.max(s.maximum);
                count += s.count;
            }
        }
        return this;
    }

    private void setupFirstElement(MyBigDecimalSummaryCollector s) {
        count = s.count;
        sum = s.sum;
        minimum = s.minimum;
        maximum = s.maximum;
    }

    private void firstElementSetup(BigDecimal t) {
        count = 1;
        sum = t;
        minimum = t;
        maximum = t;
    }

    public BigDecimal getAverage() {
        if (count == 0) {
            return BigDecimal.ZERO.setScale(TRANSACTIONS_SCALE, ROUND_HALF_UP);
        }
        return sum.divide(BigDecimal.valueOf(count), TRANSACTIONS_SCALE,
                ROUND_HALF_UP);

    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getMinimum() {
        return minimum;
    }

    public void setMinimum(BigDecimal minimum) {
        this.minimum = minimum;
    }

    public BigDecimal getMaximum() {
        return maximum;
    }

    public void setMaximum(BigDecimal maximum) {
        this.maximum = maximum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MyBigDecimalSummaryCollector [sum=" + sum + ", minimum=" + minimum + ", maximum=" + maximum + ", count="
                + count + ", average=" + getAverage() + "]";
    }
}
