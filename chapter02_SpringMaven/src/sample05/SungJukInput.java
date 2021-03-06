package sample05;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {
	@Autowired
	private SungJukDTO2 sungJukDTO2;
	
	//List가 부모이므로 여러개의 클래스가 생성될 수 있다
	//그러므로 반드시 @Qualifier를 사용해서 Bean id를 등록해야 한다
	@Qualifier("list")
	@Autowired
	private List<SungJukDTO2> list;
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scanner.next();
		System.out.print("국어점수 입력 : ");
		int kor = scanner.nextInt();
		System.out.print("영어점수 입력 : ");
		int eng = scanner.nextInt();
		System.out.print("수학점수 입력 : ");
		int math = scanner.nextInt();
			
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(sungJukDTO2.getKor() + sungJukDTO2.getEng() + sungJukDTO2.getMath());
		sungJukDTO2.setAvg(sungJukDTO2.getTot() / 3.0);
		
		list.add(sungJukDTO2);
		   
		System.out.println(name + "님의 데이터를 입력 하였습니다.");
	}

}