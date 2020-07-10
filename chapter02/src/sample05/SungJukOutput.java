package sample05;

import java.util.List;

public class SungJukOutput implements SungJuk {
	private List<SungJukDTO2> list;
	
	public SungJukOutput(List<SungJukDTO2> list) {
		this.list = list;
	}
	
	
	@Override
	public void execute() {
		for(SungJukDTO2 dto2 : list) {
			System.out.println(dto2);
		}
	}

}
