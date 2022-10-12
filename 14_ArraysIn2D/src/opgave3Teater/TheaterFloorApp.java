package opgave3Teater;

import java.util.Scanner;

public class TheaterFloorApp {

	public static void main(String[] args) {
		TheaterFloor theater = new TheaterFloor();
		Scanner scanner = new Scanner(System.in);
		boolean bought = false;
		theater.printTheaterFloor();
		System.out.println("Would you like to buy a seat with a specific price or seat? Type 'price' or 'seat'.");
		String response = scanner.nextLine();
		if (response.equalsIgnoreCase("price")) {
			System.out.println("Please write a price");
			response = scanner.nextLine();
			bought = theater.buySeat(Integer.parseInt(response));
		}
		else if (response.equalsIgnoreCase("seat")) {
			System.out.println("Please write a row and a seat number.");
			int row = scanner.nextInt();
			int seat = scanner.nextInt();
			bought = theater.buySeat(row, seat);
		}
		if (bought) {
			System.out.println("Seat bought.");
		} else {
			System.out.println("Something went wrong.");
		}
		theater.printTheaterFloor();
	}
}
