package gradientpaint;

import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Float;
import java.util.*;
import javax.swing.*;

public class DrawGradientPaint extends JFrame{
	
	public DrawGradientPaint() {
		setSize(600,130);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new MyPanel();
		add(panel);
		setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		new DrawGradientPaint();
	}
	
	class MyPanel extends JPanel{
		ArrayList<Shape> ShapeArray = new ArrayList<Shape>();
	
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2 =(Graphics2D) g;	
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //¾ÈÆ¼¿¤¸®¾î½Ì	
			g2.setStroke(new BasicStroke(3)); //µÎ²²¼³Á¤
			GradientPaint gp = new GradientPaint(0,10,Color.white,0,70,Color.red);
			
			g2.setPaint(Color.red);
			g2.fill(new Rectangle2D.Float(10,10,70,80));	
			g2.fill(new Ellipse2D.Float(210,10,80,80));						
			g2.fill(new Arc2D.Float(410,10,80,80,0,180,Arc2D.CHORD));
			
			g2.setPaint(gp);
			g2.fill(new RoundRectangle2D.Float(110,10,70,80,20,20));
			g2.fill(new Arc2D.Float(310,10,80,80,90,90,Arc2D.OPEN));
			g2.fill(new Arc2D.Float(510,10,80,80,45,90,Arc2D.PIE));
			
			for(Shape s: ShapeArray)
				g2.draw(s);
			
	
			
		}
		

	
	
	}

	
}

