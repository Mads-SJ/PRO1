package comarableeksempel;

public class Person implements Comparable<Person> {
	private String name;

	private int monthlySalary;
	private int antalVikrsomheder;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public double yearsSalary() {
		return (12.0 * monthlySalary) * 1.025;
	}

	public int getAntalVikrsomheder() {
		return antalVikrsomheder;
	}

	public void setAntalVikrsomheder(int antalVikrsomheder) {
		this.antalVikrsomheder = antalVikrsomheder;
	}

	public void incAntalVirksomheder() {
		antalVikrsomheder++;
	}

	
	
	@Override
	public int compareTo(Person p) {
//		int comp = this.name.compareTo(p.getName());
//		return comp;
		int comp = this.monthlySalary - p.getMonthlySalary();
		return comp;
	}

}
