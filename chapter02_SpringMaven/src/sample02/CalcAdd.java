package sample02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
public class CalcAdd implements Calc {
	private @Value("25") int x;
	private @Value("36") int y;

	@Override
	public void calculate() {
		System.out.println (x + " + " + y + " = " + (x+y));
	}
}