package sample02;

public class CalcMul implements Calc {
	private int x;
	private int y;
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x*y));
	}

}
