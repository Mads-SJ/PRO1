package opgave3Teater;

import java.util.Scanner;

public class TheaterFloorApp {

	public static void main(String[] args) {
		TheaterFloor theater = new TheaterFloor();
		Scanner scanner = new Scanner(System.in);
		theater.printTheaterFloor();
		System.out.println("Would you like to buy a seat with a specific price or seat? Type 'price' or 'seat'.");
		String response = scanner.nextLine();
		if (response.toLowerCase().equals("price")) {
			System.out.println("Please write a price");
			response = scanner.nextLine();
		}
	}
}
