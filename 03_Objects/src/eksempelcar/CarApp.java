package eksempelcar;

public class CarApp {

	public static void main(String[] args) {
		Car myCar = new Car("VW UP", "White");
		System.out.println(myCar.getBrand());
		myCar.setRegistrationNumber("AB 11 123");
		System.out.println(myCar.getRegistrationNumber());
		System.out.println(myCar.getKm());

		Car myCar1 = new Car("Audi R8", "Red");
		myCar1.setRegistrationNumber("OG 88888");
		System.out.println("*******************");
		System.out.println(myCar1.getBrand());
		System.out.println(myCar1.getRegistrationNumber() + " har kørt " + myCar1.getKm());
		System.out.println("*******************");
	}

}
