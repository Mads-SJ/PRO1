package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

    public class App {
        public static void main(String[] args) {
            Hotel h1 = new Hotel("Den Hvide Svane", 1050, 1250, "Testvej 1234");
            Hotel h2 = new Hotel("Høtel Phønix",700,800,"Jingleballs 13b");
            Hotel h3 = new Hotel("Pension Tusindfryd",500,600,"Holdopenflotvejdenhervejdener 69f");

            ArrayList<Hotel> hoteller = new ArrayList<>();
            hoteller.add(h1);
            hoteller.add(h2);
            hoteller.add(h3);

            Udflugt u1 = new Udflugt("Byrundtur, Odense",125,
                    LocalDateTime.of(2022,5,18,1,20),true);

            Udflugt u2 = new Udflugt("Egeskov",75,
                    LocalDateTime.of(2022,5,19,1,20),false);

            Udflugt u3 = new Udflugt("Trapholt Museum, Kolding",200,
                    LocalDateTime.of(2022,5,20,1,20),true);

            Konference konference = new Konference(
                    "Hav og Himmel",
                    LocalDate.of(2022,5,18),
                    LocalDate.of(2022,5, 20),
                    "Odense Universitet",
                    1500,
                    LocalDate.of(2022, 5, 15),
                    hoteller
            );

            konference.addUdflugt(u1);
            konference.addUdflugt(u2);
            konference.addUdflugt(u3);

            Deltager d1 = new Deltager("Finn Madsen","12345678","Zimbabwe","Noget",
                    "Ganjaman Enterprise","87654321");

            Deltager d2 = new Deltager("Niels Petersen","12568743","Danskerland",
                    "Fredericia","Skeletfonden for Børn","98651232");

            Deltager d3 = new Deltager("Peter Sommer","12873465","Tyskland","Fürth",
                    "DDR","42013373");

            Deltager d4 = new Deltager("Lone Jensen","99887766","Rusland","Moscow",
                    "Vodka Enterprises","12344321");

            Tilmelding t1 = new Tilmelding(
                    false,
                    LocalDate.of(2022,5,18),
                    LocalDate.of(2022,5,20),
                    d1,
                    konference
            );

            Tilmelding t2 = new Tilmelding(false, LocalDate.of(2022,5,18), LocalDate.of(2022,5,20),
                    d2,konference);

            Tilmelding t3 = new Tilmelding(false,LocalDate.of(2022,5,18),
                    LocalDate.of(2022,5,20),d3,konference);

            Tilmelding t4 = new Tilmelding(true,LocalDate.of(2022,5,18),
                    LocalDate.of(2022,5,20),d4,konference);

            Ledsager l1 = new Ledsager("Jan Madsen");

            Ledsager l2 = new Ledsager("Mie Sommer");

            Service wifi = new Service("Wifi",50);

            h1.addService(wifi);

            t2.setHotel(h1);

            t3.addService(wifi);
            t3.setLedsager(l2);
            l2.addUdflugt(u2);
            l2.addUdflugt(u3);
            t3.setHotel(h1);

            t4.addService(wifi);
            l1.addUdflugt(u1);
            l1.addUdflugt(u2);
            t4.setLedsager(l1);
            t4.setHotel(h1);

            System.out.println("Finn Madsens totalpris er: " + t1.samletPris());

            System.out.println("Niels Petersens totalpris er: " + t2.samletPris());

            System.out.println("Peter Sommers totalpris er: " + t3.samletPris());

            System.out.println("Lone Jensens totalpris er: " + t4.samletPris());
        }
    }
