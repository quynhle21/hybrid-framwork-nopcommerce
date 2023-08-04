package phuongHoaXuan;

public class QuynhHouse {

	// 2- cùng package
	public static void main(String[] args) {
		AZ_Cafe az = new AZ_Cafe();
		System.out.println(az.espresso);
		az.shipEspresso();
		
		az.shipCapuchino();
		System.out.println(az.hxCafe);
		az.shipHX(); 
	}

	// ko dùng đc các hàm private ở class khác dù trong 1 package
}
