package opg1;

public class Mekaniker extends Person {
    private int svendeprøve;
    private double timeløn;

    public Mekaniker(String navn, String adresse, int svendeprøve, double timeløn) {
        super(navn, adresse);
        this.svendeprøve = svendeprøve;
        this.timeløn = timeløn;
    }

    public int getSvendeprøve() {
        return svendeprøve;
    }

    public double getTimeløn() {
        return timeløn;
    }

    public double beregnLoen() {
        return timeløn * 37;
    }
}
