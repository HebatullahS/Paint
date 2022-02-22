/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.triangle;

import org.w3c.dom.events.MouseEvent;
import shapes.circle;
import shapes.ellipse;
import shapes.line;
import shapes.rectangle;
import shapes.square;

public class Canvas extends javax.swing.JPanel {

    Graphics2D g2;
    rectangle r;
    line l;
    ellipse o;
    square S;
    circle O;
    triangle t;
    int Action;
    int a = 0;
    Point drawStart = null, drawEnd = null;
    private int x1, x2, y1, y2, x3, y3, x4, y4;
    Shape selectedshape;
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    ArrayList<Shape> fillshapes = new ArrayList<Shape>();
    ArrayList<Color> fillcolors = new ArrayList<Color>();
    ArrayList<Color> Colors = new ArrayList<Color>();
    ArrayList<Shape> Redo = new ArrayList<Shape>();
    ArrayList<Color> Redocolor = new ArrayList<Color>();


    public Canvas() {

        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {

                // for delete button
                if (GUI.currentAction == 10) {
                    a = 1;
                } else {
                    a = 0;
                }

                //		UNDO && REDO Buttons
                if (GUI.currentAction == 12) {
                    if (shapes != null) {
                        int a = shapes.size() - 1;
                        int b = Colors.size() - 1;
                        Redo.add(shapes.get(a));
                        shapes.remove(a);
                        Redocolor.add(Colors.get(b));
                        Colors.remove(b);
                        repaint();
                    }
                }
                if (GUI.currentAction == 13) {
                    if (Redo != null) {
                        int a = Redo.size() - 1;
                        int b = Redocolor.size() - 1;
                        shapes.add(Redo.get(a));
                        Redo.remove(a);
                        Colors.add(Redocolor.get(b));
                        Redocolor.remove(b);
                        repaint();
                    }
                }

                x1 = e.getX();
                y1 = e.getY();

                x2 = x1;
                y1 = y1;

                repaint();
            }

            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (a == 1) {
                    if ((e.getClickCount() == 2)) {

                        for (Shape d : shapes) {
                            if (d.contains(getMousePosition())) {
                                selectedshape = d;
                            }
                        }

                        if (shapes != null) {
                            shapes.remove(selectedshape);
                        }

                        repaint();
                    }
                }

            }

            public void mouseReleased(java.awt.event.MouseEvent e) {

                x2 = e.getX();
                y2 = e.getY();

                if (GUI.currentAction != 10) {   //Delete button
                    Shape Rshape;
                    // copy button
                    if (GUI.currentAction == 11) {
                        if (e.getClickCount() == 2) {
                            selectedshape = getSelectedShape();
                        }
                        int h = (int) selectedshape.getBounds2D().getHeight();
                        int w = (int) selectedshape.getBounds2D().getWidth();

                        r = new rectangle(x1, x1 + w, y1, y1 + h);
                        Rshape = r.draw();
                        shapes.add(Rshape);

                    }
                    if (GUI.currentAction == 8) {
                        int X = 0, Y = 0;
                        if (e.getClickCount() == 2) {
                            selectedshape = getSelectedShape();
                            X = (int) selectedshape.getBounds2D().getX();
                            Y = (int) selectedshape.getBounds2D().getY();
                        }

                        //Resize R=new Resize();
                        //R.Resize();
                        shapes.remove(selectedshape);
                        r = new rectangle(X, 5, 5, Y);
                        Rshape = r.draw();
                        shapes.add(Rshape);

                    }
                    if (GUI.currentAction == 2) {
                        r = new rectangle(x1, x2, y1, y2);
                        Rshape = r.draw();
                        shapes.add(Rshape);
                    }
                    if (GUI.currentAction == 3) {
                        l = new line(x1, x2, y1, y2);
                        Rshape = l.draw();
                        shapes.add(Rshape);

                    }
                    if (GUI.currentAction == 4) {
                        o = new ellipse(x1, x2, y1, y2);
                        Rshape = o.draw();
                        shapes.add(Rshape);

                    }

                    if (GUI.currentAction == 5) {
                        S = new square(x1, x2, y1, y2);
                        Rshape = S.draw();
                        shapes.add(Rshape);

                    }
                    if (GUI.currentAction == 6) {
                        O = new circle(x1, x2, y1, y2);
                        Rshape = O.draw();
                        shapes.add(Rshape);

                    }
                    if (GUI.currentAction == 15) {
                        t = new triangle(x1, y1, x2, y2, x3, y3);
                        Rshape = t.drawLine();
                        shapes.add(Rshape);
                        Rshape = t.drawLine1();
                        shapes.add(Rshape);
                        Rshape = t.drawLine3();
                        shapes.add(Rshape);

                    }

                    Colors.add(GUI.c);
                    //    fillcolors.add(GUI.c);
                    if (GUI.currentAction == 9) {
                        shapes.removeAll(shapes);
                        Colors.removeAll(Colors);
                        fillshapes.removeAll(fillshapes);
                        repaint();
                    }

                    // fill button
                    if (GUI.currentAction == 14) {

                        fillshapes.add(getSelectedShape());
                        shapes.remove(getSelectedShape());

                    }

                    x1 = x2 = y1 = y2 = 0;
                    repaint();
                }

            }
        }); //END OF MOUSE LISTENER;

        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent e) {

                x1 = e.getX();
                y1 = e.getY();

            }

            public void mouseDragged(java.awt.event.MouseEvent e) {
                
                
                x2 = e.getX();
                y2 = e.getY();
                if (GUI.currentAction == 11) {
                    x1 = e.getX();
                    y1 = e.getY();
                }

                if (GUI.currentAction == 7) {
                    x2 = e.getX();
                    y2 = e.getY();
                    l = new line(x1, x2, y1, y2);
                    Shape Rshape;
                    Rshape = l.draw();
                    x1 = x2;
                    y1 = y2;
                    shapes.add(Rshape);
                    Colors.add(GUI.c);
              
                }
                 
                repaint();
            }
        });   

    }

    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // To prevent transparent 
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        //to get a large font 
        g2.setStroke(new BasicStroke(4));
         g2.clearRect(0, 0, this.getWidth(), this.getHeight());
        //To paint shapes with selected colors when choosing a color !!
        Iterator<Color> colorCounter = Colors.iterator();  //using it in order to use next() Fn . 
        Iterator<Color> colorCounter2 = Colors.iterator();
        //	Iterator<Color> colorfill = fillcolors.iterator();
        //	Iterator<Shape> shapeCounter = shapes.iterator();

        if (shapes != null) {
            for (Shape s : shapes) {

                g2.setPaint(colorCounter.next());
                g2.draw(s);

            }
        }

        for (Shape s : fillshapes) {

            g2.setPaint(GUI.c);
            g2.fill(s);

        }

        // Guide shape used for drawing 
        boolean startpoint, endpoint;
        startpoint = (x1 != 0) && (y1 != 0);
        endpoint = (x2 != 0) && (y2 != 0);
        if (startpoint && endpoint) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
            if (GUI.currentAction == 2) {
                r = new rectangle(x1, x2, y1, y2);
                g2.setPaint(Color.BLACK);
                Shape r1 = r.draw();
                g2.draw(r1);
                g2.setPaint(Color.BLACK);
                Shape r2 = r.draw();
                g2.draw(r2);
                g2.setPaint(Color.BLACK);
                Shape r3 = r.draw();
                g2.draw(r3);
               
            }
            if (GUI.currentAction == 3) {
                l = new line(x1, x2, y1, y2);
                g2.setPaint(Color.lightGray);
                Shape r1 = l.draw();
                g2.draw(r1);
            }
            if (GUI.currentAction == 4) {
                o = new ellipse(x1, x2, y1, y2);
                g2.setPaint(Color.lightGray);
                Shape r1 = o.draw();
                g2.draw(r1);
            }
            if (GUI.currentAction == 5) {
                S = new square(x1, x2, y1, y2);
                g2.setPaint(Color.lightGray);
                Shape r1 = S.draw();
                g2.draw(r1);
            }

            if (GUI.currentAction == 6) {
                O = new circle(x1, x2, y1, y2);
                g2.setPaint(Color.lightGray);
                Shape r1 = O.draw();
                g2.draw(r1);
            }
            if (GUI.currentAction == 15) {

                t = new triangle(x1, y1, x4, y4, x3, y3);
                g2.setPaint(Color.lightGray);
                Shape r1 = t.drawLine();
                g2.draw(r1);
                g2.setPaint(Color.lightGray);
                Shape r2 = t.drawLine1();
                g2.draw(r2);
                g2.setPaint(Color.lightGray);
                Shape r3 = t.drawLine3();
                g2.draw(r3);

            }

        }
        if (GUI.currentAction == 8) {

            System.out.println(GUI.width + "  ," + GUI.height);
        }

    }

    public Shape getSelectedShape() {

        for (Shape d : fillshapes) {

            if (d.contains(getMousePosition())) {
                selectedshape = d;
            }
        }
        for (Shape d : shapes) {
            if (d.contains(getMousePosition())) {
                selectedshape = d;
            }
        }
        if (selectedshape == null) {
            JOptionPane.showMessageDialog(null, "please select a shape !");

        }
        return selectedshape;
    }

    /*public void resize(){
	  
	  if (getSelectedShape()!=null){
	//  Resize R = new Resize();
	   Scanner in=new Scanner(System.in);
	  System.out.println();
	    int w=in.nextInt();
	    int h=in.nextInt();
	    int x1=(int) getSelectedShape().getBounds2D().getX();
		int y1=(int) getSelectedShape().getBounds2D().getY();
		r=new rectangle(x1,x1+w,y1,y1+h);
	    shapes.add(r.draw());
	    Colors.add(GUI.c);
		int a=shapes.indexOf(getSelectedShape());
		shapes.remove (a);
		repaint();
	  }
	  
		  
	  
  }*/

   }
