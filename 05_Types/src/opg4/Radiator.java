package opg4;

import java.util.ArrayList;

public class Radiator {
    private int temperature;

    public Radiator() {
        temperature = 20;
    }

    public Radiator(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void skruOp(int grader) {
        temperature += grader;
    }

    public void skruNed(int grader) {
        temperature -= grader;

        for (int i = 0; i < 10; i++) {
            // kode
        }

        int i = 0;
        while(i < 10) {
            // kode
            i++;
        }

    }
}
