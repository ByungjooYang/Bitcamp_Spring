package sample03;

import java.util.Scanner;

public class SungJukImpl implements SungJuk {
	SungJukDTO sungJukDTO;
	
	public SungJukImpl(SungJukDTO sungJukDTO) {
		this.sungJukDTO = sungJukDTO;
	}
	
	@Override
	public void calcTot() {
		sungJukDTO.setTot(sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath());
	}

	@Override
	public void calcAvg() {
		sungJukDTO.setAvg((double)sungJukDTO.getTot()/3);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(sungJukDTO);
		
	}

	@Override
	public void modify() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		sungJukDTO.setName(scanner.next());
		System.out.print("국어 입력 : ");
		sungJukDTO.setKor(scanner.nextInt());
		System.out.print("영어 입력 : ");
		sungJukDTO.setEng(scanner.nextInt());
		System.out.print("수학 입력 : ");
		sungJukDTO.setMath(scanner.nextInt());
		
	}

}
