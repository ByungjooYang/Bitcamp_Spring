package sample05;

import lombok.Data;

@Data
public class SungJukDTO2 {
	private String name2;
	private int kor2;
	private int eng2;
	private int math2;
	private int tot2;
	private double avg2;

	@Override
	public String toString() {
		return name2 + "\t" + kor2  + "\t" +  eng2  + "\t" + math2  + "\t" + tot2  + "\t" +  avg2;
	}
	
	public void calcTot2() {
		tot2 = kor2 + eng2 + math2;
	}
	
	public void calcAvg2() {
		avg2 = Double.parseDouble(String.format("%.2f", tot2/3.0));
	}
}
