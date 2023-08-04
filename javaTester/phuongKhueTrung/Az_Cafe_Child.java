package phuongKhueTrung;

import phuongHoaXuan.AZ_Cafe;

// Quán cả phê của nhà cô B - con Của chủ AZ-cafe
// Dùng các thuộc tính và phương thức bởi lớp cha chia sẻ
public class Az_Cafe_Child extends AZ_Cafe {


	// Khác package nhưng lại là lớp con
	public static void main(String[] args) {
    	Az_Cafe_Child az = new Az_Cafe_Child();
    	System.out.println(az.espresso);
    	az.shipEspresso();
    	
    	System.out.println(az.capuchino);
    	az.shipCapuchino();
	} 

	// ko dùng đc những hàm void (default) của các package
	// ko dùng đc hàm private của class ở package khác
}
