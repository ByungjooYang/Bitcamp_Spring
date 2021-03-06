package sample05;

import java.util.List;

public class SungJukOutput implements SungJuk {
	//private List<SungJukDTO2> list;
	private HelloSpring helloSpring;
	
	public SungJukOutput(HelloSpring helloSpring) {
		this.helloSpring = helloSpring;
	}
	
	
	@Override
	public void execute() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTO2 sungJukDTO2 : helloSpring.getList()) {
			System.out.println(sungJukDTO2);
			System.out.println(sungJukDTO2.hashCode());
		}
	}

}
