package opg3;

public class NameApp {
    public static void main(String[] args) {
        Name name = new Name("Mads", "Sønderstrup", "Jensen");
        System.out.println(name.getInit());
        System.out.println(name.getUsername());
    }
}
