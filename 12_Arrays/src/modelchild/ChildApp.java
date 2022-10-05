package modelchild;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(0, true);// boy 4 years old
		Child c2 = new Child(2, false);// girl 2 years old
		Institution institution = new Institution("EAAA", "Sønderhøj 30");

		System.out.println("Et barn på " + c1.getAge());

		//OPG 4
		System.out.println(c1.getWeight(10));
		System.out.println(c1.getBiggestWeightIncrease());

		//OPG 5
		institution.addChild(c1);
		institution.addChild(c2);

		System.out.println("gennemsnitsalder er " + institution.averageAge());
		System.out.println("number of girls: " + institution.numberOfGirls());
	}

}
