package shapes;

import java.awt.Shape;

public interface shape {
	
	public int getX1();
	public void setX1(int x1);
	public int getX2();
	public void setX2(int x2);
	public int getY1();
	public void setY1(int y1);
	public int getY2();
	public void setY2(int y2);
    public Shape draw();
	public String toString();
}
