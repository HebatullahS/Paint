/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author Dina Alaa
 */
public class triangle implements shape{
   private int x1,x4,y1,y4,x3,y3;
	//int[] xpoints= {x1,x2,x3};
	//int[] ypoints= {y1,y2,y3};
	Point2D.Float[]point;


	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX4() {
		return x4;
	}

	public void setX4(int x4) {
		this.x4 = x4;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY4() {
		return y4;
	}

	public void setY4(int y4) {
		this.y4 = y4;
	}

	public int getX3() {
		return x3;
	}

	public void setX3(int x3) {
		this.x3 = x3;
	}

	public int getY3() {
		return y3;
	}

	public void setY3(int y3) {
		this.y3 = y3;
	}

	public triangle(int x1, int x4, int y1, int y4, int x3, int y3) {
		super();
		this.x1 = x1;
		this.x4 = x4;
		this.y1 = y1;
		this.y4 = y4;
		this.x3 = x3;
		this.y3 = y3;
	}
	 
	/* public Shape drawTriangle(Graphics g){
		
		// g.drawLine(x1, y1, x2, y2);
		// g.drawLine(x2, y2, x3, y3);
		// g.drawLine(x3, y3, x1, y1);
		  return g.drawPolygon(new int[] {x1,x2,x3}, new int[] {y1,y2,y3}, 3);
		
	 }**/
	public Line2D.Float drawLine(){
			
			return new Line2D.Float(x1, y1, x4, y4);
			
		}
	 public Line2D.Float drawLine1(){
			
			return new Line2D.Float(x4, y4, x3, y3);
			
		}
	 public Line2D.Float drawLine3(){
			
			return new Line2D.Float(x3, y3, x1, y1);
			
		}


 
}
