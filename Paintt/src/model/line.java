package shapes;

import java.awt.Shape;
import java.awt.geom.Line2D;

public class line implements shape{
	private int x1,x2,y1,y2;

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public line(int x1, int x2, int y1, int y2) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	@Override
	public Shape draw() {
		return new Line2D.Float(x1, y1, x2, y2);
	
	}

	@Override
	public String toString() {
		return "line";
	}


}
