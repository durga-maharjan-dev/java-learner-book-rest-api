package javalearner.mockito;

public class BasicMath {
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public int divide(int a, int b) {
		if (b == 0) {
			throw new DividerCannotBeZeroException("Divider Cannot Be Zero");
		}
		return a/b;
	}

}
