package juni_2017;

public class Indtag {
    private int vejetFørIndtagelse;
    private int vejetEfterIndtagelse;
    private String beskrivelse;
    private int anslåetAntalKalorier;
    private PersonligMåltid personligMåltid;

    public Indtag(int vejetFørIndtagelse, int vejetEfterIndtagelse, String beskrivelse, int anslåetAntalKalorier, PersonligMåltid personligMåltid) {
        this.vejetFørIndtagelse = vejetFørIndtagelse;
        this.vejetEfterIndtagelse = vejetEfterIndtagelse;
        this.beskrivelse = beskrivelse;
        this.anslåetAntalKalorier = anslåetAntalKalorier;
        this.personligMåltid = personligMåltid;
        personligMåltid.addIndtag(this);
    }

    public int getVejetFørIndtagelse() {
        return vejetFørIndtagelse;
    }

    public int getVejetEfterIndtagelse() {
        return vejetEfterIndtagelse;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getAnslåetAntalKalorier() {
        return anslåetAntalKalorier;
    }

    public PersonligMåltid getPersonligMåltid() {
        return personligMåltid;
    }

    public void setPersonligMåltid(PersonligMåltid personligMåltid) {
        if (this.personligMåltid != personligMåltid) {
            PersonligMåltid oldPersonligMåltid = this.personligMåltid;
            if (oldPersonligMåltid != null) {
                oldPersonligMåltid.removeIndtag(this);
            }
            this.personligMåltid = personligMåltid;
            if (personligMåltid != null) {
                personligMåltid.addIndtag(this);
            }
        }
    }
}
