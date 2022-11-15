package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding {
    private boolean erForedragsholder;
    private LocalDate ankomstDato;
    private LocalDate afrejseDato;
    private Deltager deltager;
    private ArrayList<Service> services;
    private Hotel hotel;
    private Konference konference;
    private Ledsager ledsager;

    public Tilmelding(
            boolean erForedragsholder,
            LocalDate ankomstDato,
            LocalDate afrejseDato,
            Deltager deltager,
            Konference konference
    ) {
        this.erForedragsholder = erForedragsholder;
        this.afrejseDato = afrejseDato;
        this.ankomstDato = ankomstDato;
        this.deltager = deltager;
        services = new ArrayList<>();
        this.konference = konference;
        konference.addTilmelding(this);
    }

    public boolean isForedragsholder() {
        return erForedragsholder;
    }

    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public ArrayList<Service> getServices() {
        return new ArrayList<>(services);
    }

    public void addService(Service service) {
        if (!services.contains(service)) {
            services.add(service);
        }
    }

    public void removeService(Service service) {
        if (services.contains(service)) {
            services.remove(service);
        }
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        if (this.hotel != hotel) {
            this.hotel = hotel;
            hotel.addTilmelding(this);
        }
    }

    public Konference getKonference() {
        return konference;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public void setLedsager(Ledsager ledsager) {
        if (this.ledsager != ledsager) {
            this.ledsager = ledsager;
        }
    }

    public Ledsager createLedsager(String navn) {
        ledsager = new Ledsager(navn);
        return ledsager;
    }

    public double samletPris() {
        double samletPris = 0.0;
        int dage = ankomstDato.until(afrejseDato).getDays() + 1;

        if (!erForedragsholder) {
            samletPris += konference.getDagspris() * dage;
        }

        if (ledsager != null) {
            for (Udflugt u : ledsager.getUdflugter()) {
                samletPris += u.getPris();
            }
        }

        if (hotel != null) {
            int dagsServicePris = 0;
            for (Service s : services) {
                dagsServicePris += s.getPris();
            }

            double hotelDagspris = hotel.getEnkeltDagspris();
            if (ledsager != null) {
                hotelDagspris = hotel.getDobbeltDagspris();
            }

            samletPris += (hotelDagspris + dagsServicePris) * (dage - 1);
        }

        return samletPris;
    }
}
