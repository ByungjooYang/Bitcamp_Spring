package sample05;

import java.util.List;
import java.util.Scanner;

public class SungJukModify implements SungJuk {
	private List<SungJukDTO2> list;
	
	public SungJukModify(List<SungJukDTO2> list) {
		this.list = list;
	}
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 이름 입력 : ");
		String searchName = scanner.next();
		int count = 0;
		
		for(SungJukDTO2 dto2 : list) {
			if(dto2.getName2().equals(searchName)) {
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(searchName);
				System.out.print("국어 입력 : ");
				dto2.setKor2(scanner.nextInt());
				System.out.print("영어 입력 : ");
				dto2.setEng2(scanner.nextInt());
				System.out.print("수학 입력 : ");
				dto2.setMath2(scanner.nextInt());
				
				dto2.setTot2(dto2.getKor2() + dto2.getEng2() + dto2.getMath2());
				dto2.setAvg2(dto2.getAvg2()/3.0);
				
				System.out.println("수정되었습니다.");
				count++;
			}
		}
		
		if(count != 0) System.out.println("찾는 이름이 없습니다.");
	}

}
