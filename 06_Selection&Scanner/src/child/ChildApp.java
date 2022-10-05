package child;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(4, true);// boy 4 years old
		Child c2 = new Child(2, false);// girl 2 years old
		Child c3 = new Child(16, false);// girl 17 years old

		System.out.println("Et barn på " + c1.getAge());

		// Opg 2
		System.out.println("A child of age " + c1.getAge() + " is in " + c1.institution());
		System.out.println("A child of age " + c2.getAge() + " is in " + c2.institution());
		System.out.println("A child of age " + c3.getAge() + " is in " + c3.institution());

		// Opg 3
		System.out.println(c1.gender());
		System.out.println(c2.gender());

		// Opg 4
		System.out.println(c1.team());
		System.out.println(c2.team());
		System.out.println(c3.team());
	}

}
