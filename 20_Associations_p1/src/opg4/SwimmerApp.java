package opg4;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {
        TrainingPlan trainingPlan = new TrainingPlan('A', 10, 5);

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer s1 = trainingPlan.createSwimmer("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        trainingPlan.createSwimmer("Bo", 1995, lapTimes, "Lyseng");

        ArrayList<Swimmer> swimmers = trainingPlan.getSwimmers();

        for (Swimmer s : swimmers) {
            System.out.println(s.getName() + " " + s.getClub() + " " + s.getYearGroup());
        }

        trainingPlan.removeSwimmer(s1);

        ArrayList<Swimmer> swimmers1 = trainingPlan.getSwimmers();

        for (Swimmer s : swimmers1) {
            System.out.println(s.getName() + " " + s.getClub() + " " + s.getYearGroup());
        }
    }
    
}
