package sample05;

import java.util.List;
import java.util.Scanner;

public class SungJukDelete implements SungJuk {
	private List<SungJukDTO2> list;
	
	public SungJukDelete(List<SungJukDTO2> list) {
		this.list = list;
	}
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 이름 입력 : ");
		String deleteName = scanner.next();
		int count = 0;
		
		for(SungJukDTO2 dto2 : list) {
			if(dto2.getName2().equals(deleteName)) {
				list.remove(dto2);
				
				count++;
				System.out.println("삭제되었습니다.");
			}
		}
		
		if(count != 0) System.out.println("찾는 이름이 없습니다.");
		
		
	}

}
