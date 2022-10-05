package modelchild;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy
	private double[] weight;

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
		weight = new double[]{4.2, 9.3, 12.4, 17.5, 23.2, 25.3, 28.6, 30.4, 33.9, 35.1, 37.3};
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

	public double getWeight(int age) {
		if(age < 0 || age > 10) { return 0.0; }
		return weight[age];
	}

	public double getBiggestWeightIncrease() {
		double biggestWeightIncrease = 0;

		for (int i = 0; i < weight.length - 1; i++) {
			double weightIncrease = weight[i + 1] - weight[i];

			if(weightIncrease > biggestWeightIncrease) {
				biggestWeightIncrease = weightIncrease;
			}
		}
		return biggestWeightIncrease;
	}
}
