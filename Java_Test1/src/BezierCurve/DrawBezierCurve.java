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
	         //xs ,ys 배열 이용해서 베지어곡선 그리기
	      }
	      
	      
	   }  
	   @Override
	   public void mouseDragged(MouseEvent e) {
	      //dragindex -1 여부판단 후 선택된점 의 위치를 바꿈
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
	      // 4개점 선택됬는지 체크
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
