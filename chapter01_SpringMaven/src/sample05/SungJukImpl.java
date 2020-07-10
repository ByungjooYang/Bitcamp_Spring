package sample05;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component("sungJukImpl")
public class SungJukImpl implements SungJuk {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	public SungJukImpl() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름을 입력해주세요 : ");
		name = scanner.next();
		System.out.print("국어 점수를 입력해주세요 : ");
		kor = scanner.nextInt();
		System.out.print("영어 점수를 입력해주세요 : ");
		eng = scanner.nextInt();
		System.out.print("수학 점수를 입력해주세요 : ");
		math = scanner.nextInt();
		
		
	}
	
	@Override
	public void calc() {
		tot = kor + eng + math;
		avg = (double)tot/3;
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.2f" , avg));
	}

}
