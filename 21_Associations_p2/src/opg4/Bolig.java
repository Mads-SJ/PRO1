package opg4;

import java.util.ArrayList;

public class Bolig {
    private int kvm;
    private String adresse;
    private int prisPrMaaned;
    private Kollegie kollegie;
    private ArrayList<Lejeaftale> lejeaftaler;

    public Bolig(int kvm, String adresse, int prisPrMaaned, Kollegie kollegie) {
        this.kvm = kvm;
        this.adresse = adresse;
        this.prisPrMaaned = prisPrMaaned;
        this.kollegie = kollegie;
        lejeaftaler = new ArrayList<>();
    }

    public int getKvm() {
        return kvm;
    }

    public void setKvm(int kvm) {
        this.kvm = kvm;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPrisPrMaaned() {
        return prisPrMaaned;
    }

    public void setPrisPrMaaned(int prisPrMaaned) {
        this.prisPrMaaned = prisPrMaaned;
    }

    public Kollegie getKollegie() {
        return kollegie;
    }

    public void setKollegie(Kollegie kollegie) {
          if(kollegie != this.kollegie) {
              Kollegie oldKollegie = this.kollegie;
              if (oldKollegie != null) {
                  oldKollegie.removeBolig(this);
              }
              this.kollegie = kollegie;
              if (kollegie != null) {
                  this.kollegie.addBolig(this);
              }
          }
    }

    public ArrayList<Lejeaftale> getLejeaftaler() {
        return new ArrayList<>(lejeaftaler);
    }

    public Lejeaftale createLejeaftale() {
        Lejeaftale lejeaftale = new Lejeaftale(this);
        lejeaftaler.add(lejeaftale);
        return lejeaftale;
    }

    public void removeLejeaftale(Lejeaftale lejeaftale) {
        if (lejeaftaler.contains(lejeaftale)) {
            lejeaftaler.remove(lejeaftale);
        }
    }
}
