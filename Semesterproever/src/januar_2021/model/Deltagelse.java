package januar_2021.model;

public class Deltagelse {
    private boolean registreret;
    private DeltagerStatus status;
    private Studerende studerende;
    private Lektion lektion;

    // package visibility
    Deltagelse(Lektion lektion, Studerende studerende) {
        registreret = false;
        status = DeltagerStatus.TILSTEDE;
        this.lektion = lektion;
        this.studerende = studerende;
        studerende.addDeltagelse(this);
    }

    public boolean isRegistreret() {
        return registreret;
    }

    public DeltagerStatus getStatus() {
        return status;
    }

    public Studerende getStuderende() {
        return studerende;
    }

    public boolean erRegistreretFravær() {
        return status != DeltagerStatus.TILSTEDE && registreret;
    }
}
