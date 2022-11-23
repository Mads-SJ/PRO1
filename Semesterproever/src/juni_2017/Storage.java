package juni_2017;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Patient> patienter = new ArrayList<>();

    public static ArrayList<Patient> getPatienter() {
        return new ArrayList<>(patienter);
    }

    public static void addPatient(Patient patient) {
        patienter.add(patient);
    }
}
