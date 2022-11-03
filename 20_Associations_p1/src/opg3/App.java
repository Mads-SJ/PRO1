package opg3;

public class App {
    public static void main(String[] args) {
        Car c1 = new Car("i2342342", 2000);
        Car c2 = new Car("jkdlkg345", 2001);
        Car c3 = new Car("j5345sdffrertklb", 2002);
        Car c4 = new Car("9803490ljdf", 2003);
        Car c5 = new Car("jk2kj34312234", 2004);

        c1.setDayPrice(10.5);
        c2.setDayPrice(11.5);
        c3.setDayPrice(12.5);
        c4.setDayPrice(13.5);
        c5.setDayPrice(14.5);

        Rental r1 = new Rental(1, 30, "17-10-2022");
        Rental r2 = new Rental(2, 30, "02-11-2022");

        r1.addCar(c1);
        r1.addCar(c2);
        r1.addCar(c3);

        r2.addCar(c4);
        r2.addCar(c5);

        System.out.println(r1.getPrice());
        System.out.println(r2.getPrice());
    }
}
