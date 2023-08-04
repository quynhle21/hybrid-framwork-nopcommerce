package phuongHoaXuan;

// quán cafe nhà bà A
public class AZ_Cafe {
   // Property/ Field/ Variable
	public String espresso = "Espresso Coffe";
   
	// Function/ Method 
	
	public void shipEspresso() {
		System.out.println("ship:" + espresso);
	}
   
	protected String capuchino = "Capuchino Coffee";
	
	protected void shipCapuchino() {
		System.out.println("Ship:" + capuchino);
	}
	
	String hxCafe = "Hoa Xuan Cafe";
	
	void shipHX() {
		System.out.println("ship:" + hxCafe);
	}
	
	
	private String azCoffe = "AZ Coffee";
	
     
	// 1- Sử dụng trong chính class này
	
	public static void main(String[] args) {
		AZ_Cafe az = new AZ_Cafe();
		System.out.println(az.espresso);
		
		System.out.println(az.capuchino);
		System.out.println(az.hxCafe);
		az.shipHX();
		
		System.out.println(az.azCoffe);
	}
}
