package sample04;

import org.springframework.stereotype.Component;

@Component
public class CalcAdd implements Calc {

	@Override
	public void calculate(int x, int y) {
		int result = x + y;
		System.out.println(x + " + " + y + " = " + result);
	}

}
