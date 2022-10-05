package personexample;

public class Person {
    private String name;
    private String address;
    private double monthlySalary;
    private int numberOfWorkplaces;

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getYearlySalary() {
        return monthlySalary * 12 * 1.025;
    }

    public void newEmployment() {
        numberOfWorkplaces++;
    }

    public int getNumberOfWorkplaces() {
        return numberOfWorkplaces;
    }

    public void printPerson() {
        System.out.println("==============");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println();
    }
}
