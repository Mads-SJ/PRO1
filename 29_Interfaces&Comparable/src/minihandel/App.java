package minihandel;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Customer c1 = new Customer("C1", LocalDate.of(1998, 8, 8));
        Customer c2 = new Customer("C2", LocalDate.of(2000, 8, 8));

        Product p1 = new Product(1, "P1", 100);
        Product p2 = new Product(2, "P1", 200);
        Product p3 = new Product(3, "P1", 300);
        Product p4 = new Product(4, "P1", 400);
        Product p5 = new Product(5, "P1", 500);

        Order o1 = new Order(0);
        o1.createOrderLine(1, p1);
        o1.createOrderLine(1, p2);

        Order o2 = new Order(1);
        o2.createOrderLine(2, p1);
        o2.createOrderLine(2, p2);

        Order o3 = new Order(2);
        o3.createOrderLine(3, p3);
        o3.createOrderLine(3, p4);

        Order o4 = new Order(3);
        o4.createOrderLine(4, p4);
        o4.createOrderLine(4, p5);

        Order o5 = new Order(4);
        o5.createOrderLine(5, p1);
        o5.createOrderLine(5, p5);

        Order o6 = new Order(5);
        o6.createOrderLine(6, p2);
        o6.createOrderLine(6, p4);

        c1.addOrder(o1);
        c1.addOrder(o2);

        c2.addOrder(o3);
        c2.addOrder(o4);
        c2.addOrder(o5);
        c2.addOrder(o6);

        PercentDiscount percentDiscount = new PercentDiscount(15);
        FixedDiscount fixedDiscount = new FixedDiscount(250, 1000);
        AgeDiscount ageDiscount = new AgeDiscount(c2.getBirthday().getYear());

        c1.setDiscount(percentDiscount);
        c2.setDiscount(fixedDiscount);

        System.out.println(c1.getName() + " køber for " + c1.totalBuy() + " kr. uden discount");
        System.out.println(c1.getName() + " køber for " + c1.totalBuyWithDiscount() + " kr. med procent discount");
        System.out.println();

        System.out.println(c2.getName() + " køber for " + c2.totalBuy() + " kr. uden discount");
        System.out.println(c2.getName() + " køber for " + c2.totalBuyWithDiscount() + " kr. med fixed discount");

        c2.setDiscount(ageDiscount);
        System.out.println(c2.getName() + " køber for " + c2.totalBuyWithDiscount() + " kr. med age discount");

    }
}
