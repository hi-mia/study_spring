package sample04;

public class CalcMul implements Calc {

	@Override
	public void calculate(int x, int y) {
		int result = x * y;
		System.out.println(x + " * " + y + " = " + result);
	}

}
