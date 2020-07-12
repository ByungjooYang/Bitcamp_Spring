package sample05;

import java.util.List;
import java.util.Scanner;

public class SungJukModify implements SungJuk {
	private HelloSpring helloSpring;
	
	public SungJukModify(HelloSpring helloSpring) {
		this.helloSpring = helloSpring;
	}
	
	@Override
	public void execute() {
		Scanner scanner = helloSpring.getScanner();
		System.out.print("수정할 이름 입력 : ");
		String searchName = scanner.next();
		int count = 0;
		System.out.println(helloSpring.getList().size());
		for(SungJukDTO2 sungJukDTO2 : helloSpring.getList()) {
			if(sungJukDTO2.getName2().equals(searchName)) {
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(searchName);
				System.out.print("국어 입력 : ");
				sungJukDTO2.setKor2(scanner.nextInt());
				System.out.print("영어 입력 : ");
				sungJukDTO2.setEng2(scanner.nextInt());
				System.out.print("수학 입력 : ");
				sungJukDTO2.setMath2(scanner.nextInt());
				
				sungJukDTO2.setTot2(sungJukDTO2.getKor2() + sungJukDTO2.getEng2() + sungJukDTO2.getMath2());
				sungJukDTO2.setAvg2(Double.parseDouble(String.format("%.2f", sungJukDTO2.getTot2()/3.0)));
				
				System.out.println("수정되었습니다.");
				count++;
			}
		}
		
		if(count == 0) System.out.println("찾는 이름이 없습니다.");
	}

}
