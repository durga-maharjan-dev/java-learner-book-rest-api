package javalearner.mockito;

public class BasicMathService {
	
	BasicMath basicMath = new BasicMath();
	
	public int relyOnDivide(int a, int b) {
		if (b == 0) {
			throw new DividerCannotBeZeroException("Divider Cannot Be Zero");
		}
		int result = basicMath.divide(a, b);
		return result+a+b;
	}

}
