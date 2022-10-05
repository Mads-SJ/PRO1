package modelemployee;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", "Nielsen", 30);
		e1.printEmployee();
		e1.setFirstName("Viggo");
		e1.setLastName("Mortensen");
		e1.printEmployee();
		e1.setAge(32);
		System.out.println(e1.getAge());
		e1.birthday();
		System.out.println(e1.getAge());

	}

}
