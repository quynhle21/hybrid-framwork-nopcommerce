package javaOOP;

public class Annimal {
public void eat() {}

public void run() {}

public static void main(String[] args) {
  // ko dùng trực tiếp class đc, phải tạo object đại diện cho class này
  // tạo đc n object
   Annimal dog = new Annimal();
       dog.eat();
       dog.run();
       
   Annimal pig = new Annimal();
       pig.eat();
       pig.run();
}


}
