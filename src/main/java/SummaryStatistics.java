// вводим доменный объект, который будет хранить итоговую статистику о списке транзакций

public class SummaryStatistics {
    public final double sum;
    public final double max;
    public final double min;
    public final double average;

    public SummaryStatistics(final double sum, final double max, final double min, final double average) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
    }

    public double getSum() {
        return sum;
    }
    public double getMax() {
        return max;
    }
    public double getMin() {
        return min;
    }
    public double getAverage() {
        return average;
    }
}
