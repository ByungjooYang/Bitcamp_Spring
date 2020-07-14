package sample01;

//핵심 관심 사항
//Target
public class MessageBeanImpl implements MessageBean {
	private String str;

	public void setStr(String str) {
		this.str = str;
	}


	@Override
	public void showPrintBefore() {
		System.out.println("showPrintBefore 메시지 = " + str);
		
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		System.out.println("viewPrintBefore = " + str);	
		
	}

	@Override
	public void display() {
		System.out.println("display 메시지 = " + str);
		
	}


	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter = " + str);
	}


	@Override
	public void viewPrintAfter() {
		System.out.println("viewPrintAfter = " + str);
		
	}


	@Override
	public String showPrint() {
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		System.out.println("showPrint = " + str);
		
		return "띠용";
	}


	@Override
	public void viewPrint() {
		System.out.println("viewPrint = " + str);
	}
	



}
