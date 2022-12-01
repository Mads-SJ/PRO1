package opg1;

public class App {
    public static void main(String[] args) {
        Measurable[] measurables = new Measurable[4];
        measurables[0] = new Chili("C1", 1);
        measurables[1] = new Chili("C2", 2);
        measurables[2] = new Chili("C3", 3);
        measurables[3] = new Chili("C4", 4);

        System.out.println("Max: " + max(measurables));
        System.out.println();
        System.out.println("Avg: " + avg(measurables));
        System.out.println("Avg w. filter: " + avg(measurables, new FilterMeasurable(2)));
    }

    public static Measurable max(Measurable[] objects) {
        Measurable max = objects[0];

        for (Measurable m : objects) {
            if (m.getMeasure() > max.getMeasure()) {
                max = m;
            }
        }

        return max;
    }

    public static double avg(Measurable[] objects) {
        int total = 0;

        for (Measurable m : objects) {
            total += m.getMeasure();
        }

        return (double) total / objects.length;
    }

    public static double avg(Measurable[] objects, Filter<Measurable> filter) {
        int total = 0;
        int filteredObjects = 0;

        for (Measurable m : objects) {
            if (filter.accept(m)) {
                total += m.getMeasure();
                filteredObjects++;
            }
        }

        return (double) total / filteredObjects;
    }
}
