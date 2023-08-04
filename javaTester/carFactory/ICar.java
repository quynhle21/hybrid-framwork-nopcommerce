package carFactory;

public interface ICar {
	public  void viewCar();
	public abstract void driveCar();
	
	// trong interface ko đc có non-abstract method, nên nó sẽ coi mọi hàm là abstract
}
