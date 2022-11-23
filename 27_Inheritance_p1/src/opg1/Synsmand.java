package opg1;

public class Synsmand extends Mekaniker {
    private int antalSynIUgen;

    public Synsmand(String navn, String adresse, int svendeprøve, double timeløn, int antalSynIUgen) {
        super(navn, adresse, svendeprøve, timeløn);
        this.antalSynIUgen = antalSynIUgen;
    }

    public int getAntalSynIUgen() {
        return antalSynIUgen;
    }

    @Override
    public double beregnLoen() {
        return super.beregnLoen() + antalSynIUgen * 29;
    }
}
