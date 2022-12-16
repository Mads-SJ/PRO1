package januar_2020.controller;

import januar_2020.model.Festival;
import januar_2020.model.Frivillig;
import januar_2020.model.Job;

public class App {
    public static void main(String[] args) {
        Controller.initStorage();
        Festival festival = Controller.getFestivaller().get(0);
        Job job = festival.getJobs().get(0);
        Frivillig frivillig = Controller.getFrivillige().get(0);
        System.out.println(frivillig);
        Controller.tagVagt(job, frivillig, 2);
        System.out.println(Controller.findFrivillig(festival, "Jane"));

        System.out.println("Budgetteret udgift: " + festival.budgetteretJobUdgift());
        System.out.println("Realiseret udgift: " + festival.realiseretJobUdgift());

        System.out.println(festival.gaverTilFrivillige());
    }
}
