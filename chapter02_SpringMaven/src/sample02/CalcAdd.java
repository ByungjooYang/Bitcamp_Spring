package sample02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("calcAdd") //"calcAdd"는 안해줘도 맨 앞 글자만 소문자로 다르면 자동으로 잡아준다.
public class CalcAdd implements Calc {
	private int x;	//0으로 초기화 한것.
	private int y;
	
	/*public CalcAdd(int x, int y) {
		this.x = x;
		this.y = y;
	}*/
	
	public CalcAdd(@Value("25")int x, @Value("36")int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void calculate() {
		System.out.println(x + " + " + y + " = " + (x+y));
	}

}
