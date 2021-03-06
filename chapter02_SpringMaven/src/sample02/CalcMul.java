package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalcMul implements Calc {
	private int x;
	private int y;
	
	@Autowired //자동으로 맵핑해줌.
	public void setX(@Value("25")int x) { //@Autowired를 안쓰면 public void setX(@Value("25")int x) 를 호출한 적 없으니 그냥 0이 된다. add에서는 생성자가 자동으로 호출하니 되는것.
		this.x = x;
	}
	
	@Autowired
	public void setY(@Value("36")int y) {
		this.y = y;
	}
	
	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x*y));
	}

}
