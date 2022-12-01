package opg1;

public class FilterMeasurable implements Filter<Measurable> {
    private int threshold;

    public FilterMeasurable(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean accept(Measurable m) {
        return m.getMeasure() > threshold;
    }
}
