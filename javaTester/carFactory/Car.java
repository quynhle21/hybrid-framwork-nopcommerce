package carFactory;

public abstract class Car {
	// đây là hàm abstract
	public abstract void viewCar();
	public abstract void driveCar();
	
	// đây là hàm non-abstract
	
	public void bookCar(String carName) {
		System.out.println("Booking" + carName + "car");
	}
}
