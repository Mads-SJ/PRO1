package child;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public String institution() {
		String institution;

		if(age < 0) { institution = "Not born yet ;)"; }
		else if(age == 0) { institution = "Home"; }
		else if (age < 3) { institution = "Nursery"; }
		else if (age < 6) { institution = "Kindergarten"; }
		else if (age < 17) { institution = "School"; }
		else { institution = "Out of school"; }

		return institution;
	}

	public String gender() {
		String gender;

		if(boy) { gender = "Boy"; }
		else { gender = "Girl"; }

		return gender;
	}

	public String team() {
		String team;

		if(boy) {
			if(age < 8) { team = "Young cubs"; }
			else { team = "Cool boys"; }
		}
		else {
			if(age < 8) { team = "Tumbling girls"; }
			else { team = "Springy Girls"; }
		}

		return team;
	}

}
