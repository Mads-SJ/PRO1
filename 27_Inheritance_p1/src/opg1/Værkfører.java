package opg1;

public class Værkfører extends Mekaniker {
    private int værkførerUdnævnelse;
    private double tillæg;

    public Værkfører(String navn, String adresse, int svendeprøve, double timeløn, int værkførerUdnævnelse, double tillæg) {
        super(navn, adresse, svendeprøve, timeløn);
        this.værkførerUdnævnelse = værkførerUdnævnelse;
        this.tillæg = tillæg;
    }

    public int getVærkførerUdnævnelse() {
        return værkførerUdnævnelse;
    }

    public double getTillæg() {
        return tillæg;
    }

    @Override
    public double beregnLoen() {
        return super.beregnLoen() + tillæg;
    }
}
