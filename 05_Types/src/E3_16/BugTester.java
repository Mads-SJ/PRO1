package E3_16;

public class BugTester {
    public static void main(String[] args) {
        Bug bugsy = new Bug();
        System.out.println(bugsy.getPosition());
        bugsy.move();
        System.out.println(bugsy.getPosition());
        bugsy.turn();
        bugsy.move();
        bugsy.move();
        System.out.println(bugsy.getPosition());
    }
}
