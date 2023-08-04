package javaOOP;

public abstract class Computer {
	// Khi muốn 1 tính năng nào đó mà các thằng con nó ko viết lại thì sẽ define là Non-Abstract method
	// Non-Abstract
	public void clickToElement() {}
	
	
	// Khi muốn 1 tính năng nào đó mà các thằng con nó phải tự viết lại thì sẽ define là Abstract method
	// Abstract
	public abstract void selectToElement();
	
	
	// ko dùng abstract khi khai báo interface
}
