package soegningelevopgaver;

import java.util.ArrayList;

public class SoegningApp {

	 
	
	public static void main(String[] args) {
		Soegning s = new Soegning();
		
		// Kode til afprøvning af opgave 1
		int[] talArray = {2,4,8,2};
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		System.out.println();

		// opg 2
		int[] talArray1 = {1, 2, 16, 9, 10};
		System.out.println("find tal imellem [10, 15]: " + s.findFirstInInterval(talArray1));
		talArray1[4] = 20;
		System.out.println("find tal imellem [10, 15]: " + s.findFirstInInterval(talArray1));
		System.out.println();

		// opg 3
		System.out.println("Er der to ens tal ved siden af hinanden i talArray1 ? " + s.isTwoSameNumbersNextToEachOther(talArray1));
		talArray1[1] = 1;
		System.out.println("Er der to ens tal ved siden af hinanden i talArray1 ? " + s.isTwoSameNumbersNextToEachOther(talArray1));

		// opg 5 lin
		System.out.println("sqrt(111): " + s.findIntSqrtLinear(111));
		System.out.println("sqrt(10): " + s.findIntSqrtLinear(10));
		System.out.println("sqrt(9): " + s.findIntSqrtLinear(9));
		System.out.println("sqrt(0): " + s.findIntSqrtLinear(0));
		System.out.println();

		// opg 5 bin
		System.out.println("sqrt(111): " + s.findIntSqrtBinary(111));
		System.out.println("sqrt(10): " + s.findIntSqrtBinary(10));
		System.out.println("sqrt(9): " + s.findIntSqrtBinary(9));
		System.out.println("sqrt(0): " + s.findIntSqrtBinary(0));
		System.out.println();

		// opg 6
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println("find og byt 3: " + s.find(list, 3));
		System.out.println("find og byt 10: " + s.find(list, 10));
		System.out.println("find og byt 1: " + s.find(list, 1));
		System.out.println("find og byt 2: " + s.find(list, 5));

		// Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7
	}

}
