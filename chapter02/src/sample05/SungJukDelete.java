package sample05;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SungJukDelete implements SungJuk {
	private HelloSpring helloSpring;
	
	public SungJukDelete(HelloSpring helloSpring) {
		this.helloSpring = helloSpring;
	}
	@Override
	public void execute() {
		Scanner scanner = helloSpring.getScanner();
		System.out.print("삭제할 이름 입력 : ");
		String deleteName = scanner.next();
		int count = 0;
		
		/*for(SungJukDTO2 dto2 : helloSpring.getList()) {
			if(dto2.getName2().equals(deleteName)) {
				helloSpring.getList().remove(dto2);
				
				count++;
				System.out.println("삭제되었습니다.");
			}
		}*/
		
		
		/*
		Iterator<SungJukDTO2> iter = helloSpring.getLst().iterator();
		
		while(iter.hasNext()){
			if(sunJukDTO2.getName2().equals(deleteName)){
				iter.remove()
				count++;
			}
		}
		 */
		for(Iterator<SungJukDTO2> iter = helloSpring.getList().iterator(); iter.hasNext();) {
			SungJukDTO2 sungJukDTO2 = iter.next();
			
			if(sungJukDTO2.getName2().equals(deleteName)) {
				iter.remove();
				count++;
			}
		}
		
		if(count == 0) System.out.println("찾는 이름이 없습니다.");
		
	}
	

}
