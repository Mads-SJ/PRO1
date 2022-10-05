package personexample;

public class PersonApp {
    public static void main(String[] args) {
        Person p1 = new Person("Viggo Mortensen");
        p1.setName("Viggo");
        p1.setAddress("Kløvedal");
        p1.setMonthlySalary(0);
        System.out.println(p1.getName() + " " + p1.getAddress() + " " + p1.getMonthlySalary());
        p1.printPerson();
    }
}
