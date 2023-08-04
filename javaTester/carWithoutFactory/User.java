package carWithoutFactory;

public class User {

	public static void main(String[] args) {
    // Sang
		Honda hon = new Honda();
		hon.viewCar();
		hon.driverCar();
		
	// Chieu
		Toyota toy = new Toyota();
		toy.viewCar();
		toy.driverCar();
		
	// Sang t2
		Huyndai huyn = new Huyndai();
		huyn.viewCar();
		huyn.driverCar();
	// Chieu T2
		Ford ford = new Ford();
		ford.viewCar();
		ford.driverCar();
	
	}

}
