package application.model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private double enkeltDagspris;
    private double dobbeltDagspris;
    private String lokation;
    private ArrayList<Tilmelding> tilmeldinger;
    private ArrayList<Service> services;

    public Hotel(String navn, double enkeltDagspris, double dobbeltDagspris, String lokation) {
        this.navn = navn;
        this.enkeltDagspris = enkeltDagspris;
        this.dobbeltDagspris = dobbeltDagspris;
        this.lokation = lokation;
        tilmeldinger = new ArrayList<>();
        services = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public double getEnkeltDagspris() {
        return enkeltDagspris;
    }

    public double getDobbeltDagspris() {
        return dobbeltDagspris;
    }

    public String getLokation() {
        return lokation;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
        }
    }

    public ArrayList<Service> getServices() {
        return new ArrayList<>(services);
    }

    public Service createService(String navn, double pris) {
        Service service = new Service(navn, pris);
        services.add(service);
        return service;
    }

    public void addService(Service service) {
        if (!services.contains(service)) {
            services.add(service);
        }
    }

    @Override
    public String toString() {
        return navn;
    }
}
