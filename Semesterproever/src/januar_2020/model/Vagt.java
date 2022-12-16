package januar_2020.model;

public class Vagt {
    private int timer;
    private Job job;
    private Frivillig frivillig;

    Vagt(int timer, Job job, Frivillig frivillig) { // Package visibility
        this.timer = timer;
        this.job = job;
        this.frivillig = frivillig;
        frivillig.addVagt(this);
    }

    public int getTimer() {
        return timer;
    }

    public Job getJob() {
        return job;
    }

    public Frivillig getFrivillig() {
        return frivillig;
    }
}
