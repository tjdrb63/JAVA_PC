package BezierCurve;

	import java.awt.event.*;
	import java.awt.*;
	import javax.swing.*;


	public class DrawBezierCurve extends JFrame implements MouseListener,MouseMotionListener{

	   private int[] xs= {50,150,400,450};
	   private int[] ys= {200,50,300,200};
	   private int dragIndex = -1;
	   
	   class BezierPanel extends JPanel{
	      @Override
	      public void paintComponent(Graphics g) {
	         //xs ,ys �迭 �̿��ؼ� ������ �׸���
	      }
	      
	      
	   }  
	   @Override
	   public void mouseDragged(MouseEvent e) {
	      //dragindex -1 �����Ǵ� �� ���õ��� �� ��ġ�� �ٲ�
	      repaint();
	   }

	   @Override
	   public void mouseMoved(MouseEvent e) {
	      // TODO Auto-generated method stub
	      
	   }

	   @Override
	   public void mouseClicked(MouseEvent e) {
	      // TODO Auto-generated method stub
	      
	   }

	   @Override
	   public void mousePressed(MouseEvent e) {
	      // 4���� ���É���� üũ
	      dragIndex =0;// 1,2,3,4
	   
	   }

	   @Override
	   public void mouseReleased(MouseEvent e) {
	      dragIndex=-1;
	      repaint();
	   }

	   @Override
	   public void mouseEntered(MouseEvent e) {}
	   @Override
	   public void mouseExited(MouseEvent e) {}

	   
	   
	   
	   
	   
	   
	}
	
	
	
	
	

}
