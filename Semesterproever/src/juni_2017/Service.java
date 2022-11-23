package juni_2017;

import java.util.ArrayList;

public class Service {

    public static Patient createPatient(String navn, double vægt, int vægtFaktor) {
        Patient patient = new Patient(navn, vægt, vægtFaktor);
        Storage.addPatient(patient);
        return patient;
    }

    public static PersonligMåltid createPersonligMåltid(String navn, String anretterNavn, Patient patient) {
        PersonligMåltid personligMåltid = new PersonligMåltid(navn, anretterNavn, patient);
        return personligMåltid;
    }

    public static Indtag createIndtag(int vejetFørIndtagelse, int vejetEfterIndtagelse, String beskrivelse, int anslåetAntalKalorier, PersonligMåltid personligMåltid) {
        Indtag indtag = new Indtag(vejetFørIndtagelse, vejetEfterIndtagelse, beskrivelse, anslåetAntalKalorier, personligMåltid);
        return indtag;
    }

    public static ArrayList<Indtag> findIndtagMedKalorier(ArrayList<Indtag> indtagelser, int mål) {
        ArrayList<Indtag> result = new ArrayList<>();

        for (Indtag i : indtagelser) {
            if (i.getAnslåetAntalKalorier() >= mål) {
                result.add(i);
            }
        }

        return result;
    }

    public static void indsætMåltid(ArrayList<PersonligMåltid> personligMåltider, PersonligMåltid personligMåltid) {
//        personligMåltider.add(personligMåltid);
//        personligMåltider.sort(PersonligMåltid::compareTo);

        for (int i = 0; i < personligMåltider.size(); i++) {

        }
    }

    public static void initStorage() {
        Patient p1 = createPatient("Jens Jensen", 98.9, 26);
        Patient p2 = createPatient("Jens Hansen", 56.5, 38);

        PersonligMåltid pm1 = createPersonligMåltid("Morgenmad", "Katrine", p1);
        PersonligMåltid pm2 = createPersonligMåltid("Middagsmad", "Karen", p2);
        PersonligMåltid pm3 = createPersonligMåltid("Aftensmad", "Simon", p2);

        createIndtag(290, 0, "Cornflakes", 850, pm1);
        createIndtag(100, 0, "AppelsinJuice", 250, pm1);
        createIndtag(350, 100, "Leverpostej", 1200, pm2);
        createIndtag(150, 0, "Bacon", 600, pm2);
        createIndtag(450, 150, "Forloren hare", 1500, pm3);
        createIndtag(100, 0, "Flødesovs", 300, pm3);
    }
}
