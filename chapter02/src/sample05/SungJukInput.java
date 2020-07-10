package sample05;

import java.util.List;
import java.util.Scanner;

public class SungJukInput implements SungJuk {
	List<SungJukDTO2> list;
	
	public SungJukInput(List<SungJukDTO2> list) {
		this.list = list;
	}
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		SungJukDTO2 sungJukDTO2 = new SungJukDTO2();
		System.out.print("이름 입력 : ");
		sungJukDTO2.setName2(scanner.next());
		System.out.print("국어 입력 : ");
		sungJukDTO2.setKor2(scanner.nextInt());
		System.out.print("영어 입력 : ");
		sungJukDTO2.setEng2(scanner.nextInt());
		System.out.print("수학 입력 : ");
		sungJukDTO2.setMath2(scanner.nextInt());
		
		sungJukDTO2.setTot2(sungJukDTO2.getKor2() + sungJukDTO2.getEng2() + sungJukDTO2.getMath2());
		sungJukDTO2.setAvg2(sungJukDTO2.getAvg2()/3.0);
		
		list.add(sungJukDTO2);
		System.out.println(list.size());
	}

}
