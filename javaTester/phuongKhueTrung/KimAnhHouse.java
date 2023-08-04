package phuongKhueTrung;

import phuongHoaXuan.AZ_Cafe;

public class KimAnhHouse {

	public static void main(String[] args) {
		AZ_Cafe az = new AZ_Cafe();
		System.out.println(az.espresso);
		az.shipEspresso();

	}
// ko dùng được những hàm protected ở khác package khi chưa extends
// ko dùng đc những hàm void của package khác
// ko dùng đc hàm private của class ở package khác

}
