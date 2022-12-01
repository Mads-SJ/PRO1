package opg1;

public class Chili implements Measurable {
    private String name;
    private int styrke;

    public Chili(String name, int styrke) {
        this.name = name;
        this.styrke = styrke;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStyrke() {
        return styrke;
    }

    public void setStyrke(int styrke) {
        this.styrke = styrke;
    }

    @Override
    public double getMeasure() {
        return styrke;
    }

    @Override
    public String toString() {
        return "Chili{" +
                "name='" + name + '\'' +
                ", styrke=" + styrke +
                '}';
    }
}
