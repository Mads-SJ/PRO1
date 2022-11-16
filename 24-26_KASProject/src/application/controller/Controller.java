package application.controller;

import application.model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {
    public static Konference createKonference(
            String navn,
            LocalDate startDato,
            LocalDate slutDato,
            String lokation,
            double dagspris,
            LocalDate tilmeldingsfrist,
            ArrayList<Hotel> hoteller
    ) {
        Konference konference = new Konference(navn,
                startDato,
                slutDato,
                lokation,
                dagspris,
                tilmeldingsfrist,
                hoteller
        );
        Storage.addKonference(konference);
        return konference;
    }

    public static Udflugt createUdflugt(
            String navn,
            double pris,
            LocalDateTime dato,
            boolean inklFrokost,
            Konference konference
    ) {
        return konference.createUdflugt(navn, pris, dato, inklFrokost);
    }

    public static Hotel createHotel(
            String navn,
            double enkeltDagspris,
            double dobbeltDagspris,
            String lokation
    ) {
        Hotel hotel = new Hotel(navn, enkeltDagspris, dobbeltDagspris, lokation);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static Hotel createHotel(
            String navn,
            double enkeltDagspris,
            double dobbeltDagspris,
            String lokation,
            Konference konference
    ) {
        Hotel hotel = createHotel(navn, enkeltDagspris, dobbeltDagspris, lokation);
        konference.addHotel(hotel);
        return hotel;
    }

    public static Deltager createDeltager(
            String navn,
            String tlfNr,
            String land,
            String by,
            String firmaNavn,
            String firmaTlfNr
    ) {
        Deltager deltager = new Deltager(navn, tlfNr, land, by, firmaNavn, firmaTlfNr);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static Tilmelding createTilmelding(
            boolean erForedragsholder,
            LocalDate ankomstDato,
            LocalDate afrejseDato,
            Deltager deltager,
            Konference konference
    ) {
        Tilmelding tilmelding = new Tilmelding(erForedragsholder, ankomstDato, afrejseDato, deltager, konference);
        return tilmelding;
    }

    public static Service createService(String navn, double pris, Hotel hotel) {
        return hotel.createService(navn, pris);
    }

    public static Ledsager createLedsager(String navn, Tilmelding tilmelding) {
        return tilmelding.createLedsager(navn);
    }

    public static void addUdflugtToLedsager(Udflugt udflugt, Ledsager ledsager) {
        ledsager.addUdflugt(udflugt);
    }

    public static void setHotelForTilmelding(Hotel hotel, Tilmelding tilmelding) {
        tilmelding.setHotel(hotel);
    }

    public static void addServiceToTilmelding(Service service, Tilmelding tilmelding) {
        tilmelding.addService(service);
    }

    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    public static ArrayList<Hotel> getHoteller() {
        return Storage.getHoteller();
    }

    public static void initStorage() {
        Hotel h1 = Controller.createHotel("Den Hvide Svane", 1050, 1250, "Testvej 1234");
        Hotel h2 = Controller.createHotel("Høtel Phønix",700,800,"Jingleballs 13b");
        Hotel h3 = Controller.createHotel("Pension Tusindfryd",500,600,"Holdopenflotvejdenhervejdener 69f");

        ArrayList<Hotel> hoteller = new ArrayList<>();
        hoteller.add(h1);
        hoteller.add(h2);
        hoteller.add(h3);

        Konference konference = Controller.createKonference(
                "Hav og Himmel",
                LocalDate.of(2022,5,18),
                LocalDate.of(2022,5, 20),
                "Odense Universitet",
                1500,
                LocalDate.of(2022, 5, 15),
                hoteller
        );

        Udflugt u1 = Controller.createUdflugt("Byrundtur, Odense",125,
                LocalDateTime.of(2022,5,18,1,20),true, konference);

        Udflugt u2 = Controller.createUdflugt("Egeskov",75,
                LocalDateTime.of(2022,5,19,1,20),false, konference);

        Udflugt u3 = Controller.createUdflugt("Trapholt Museum, Kolding",200,
                LocalDateTime.of(2022,5,20,1,20),true, konference);


        Deltager d1 = Controller.createDeltager("Finn Madsen","12345678","Zimbabwe","Noget",
                "Ganjaman Enterprise","87654321");

        Deltager d2 = Controller.createDeltager("Niels Petersen","12568743","Danskerland",
                "Fredericia","Skeletfonden for Børn","98651232");

        Deltager d3 = Controller.createDeltager("Peter Sommer","12873465","Tyskland","Fürth",
                "DDR","42013373");

        Deltager d4 = Controller.createDeltager("Lone Jensen","99887766","Rusland","Moscow",
                "Vodka Enterprises","12344321");

        Tilmelding t1 = Controller.createTilmelding(
                false,
                LocalDate.of(2022,5,18),
                LocalDate.of(2022,5,20),
                d1,
                konference
        );

        Tilmelding t2 = Controller.createTilmelding(false, LocalDate.of(2022,5,18), LocalDate.of(2022,5,20),
                d2,konference);

        Tilmelding t3 = Controller.createTilmelding(false,LocalDate.of(2022,5,18),
                LocalDate.of(2022,5,20),d3,konference);

        Tilmelding t4 = Controller.createTilmelding(true,LocalDate.of(2022,5,18),
                LocalDate.of(2022,5,20),d4,konference);

        Ledsager l1 = Controller.createLedsager("Mie Sommer", t3);

        Ledsager l2 = Controller.createLedsager("Jan Madsen", t4);

        Controller.addUdflugtToLedsager(u2, l1);
        Controller.addUdflugtToLedsager(u3, l1);
        Controller.addUdflugtToLedsager(u1, l2);
        Controller.addUdflugtToLedsager(u2, l2);

        Controller.setHotelForTilmelding(h1, t2);
        Controller.setHotelForTilmelding(h1, t3);
        Controller.setHotelForTilmelding(h1, t4);

        Service wifi = Controller.createService("Wifi",50, h1);
        Controller.addServiceToTilmelding(wifi, t3);
        Controller.addServiceToTilmelding(wifi, t4);
    }

    public static void init() {
        initStorage();
    }
}
