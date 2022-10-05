package book_examples;

public class App {
    public static void main(String[] args) {
        Counter counter = new Counter();

        System.out.println(counter.getCount());
        counter.click();
        counter.click();
        counter.click();
        counter.click();
        counter.click();
        System.out.println(counter.getCount());
        counter.reset();
        System.out.println(counter.getCount());
    }
}
