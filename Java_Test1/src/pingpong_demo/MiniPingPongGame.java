package pingpong_demo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 *  W/S  and 방향키 위/아래로 조절
 *  PPT 와 다른 방식으로 시도.
 * 
 * 
 * */
public class MiniPingPongGame extends JFrame implements KeyListener{
   private JLabel rightSide, leftSide;
   private JPanel ball;
   private int ballX=350,ballY=200,speedX = 1,speedY = 1,scoreA=0,scoreB=0;
   private int leftbarY=250,rightbarY=250,leftSpeed=0,rightSpeed=0;
   public MiniPingPongGame()
   {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(700,500);
   
      ball =  new draw();

      
      this.addKeyListener(this);
      this.add(ball);
      this.setVisible(true);
      
      
      rightSide = new JLabel("0");
      leftSide = new JLabel("0 : ");
      
      rightSide.setFont(new Font(Font.SANS_SERIF,Font.BOLD,60)); // 스코어 폰트 지정
      leftSide.setFont(new Font(Font.SANS_SERIF,Font.BOLD,60));
      
      this.setFocusable(true);
      
      
      JPanel back = new JPanel();
      back.setBackground(Color.green);
      this.add(back);   
   
      
      JPanel scoreBoard = new JPanel();
      scoreBoard.setBackground(Color.black);
      scoreBoard.add(leftSide);
      scoreBoard.add(rightSide);
      this.setBackground(Color.green);
      this.add(scoreBoard);
      while(true) {
         move(ball);
         try {
            Thread.sleep(3);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   
   
   class draw extends JPanel{
    
      @Override
      public void paintComponent(Graphics g)
      {   
       g.setColor(Color.white);
         g.fillOval(ballX+=speedX, ballY+=speedY, 30, 30); 
        
         g.setColor(Color.red);    
         g.fillRect(3,leftbarY+=leftSpeed, 10,100);

        g.setColor(Color.BLUE);
         g.fillRect(673,rightbarY+=rightSpeed,10,100);
       
         if(!(leftbarY>0 && leftbarY<370)) leftSpeed=0;               // 위아래 벽넘기 방지
       if(!(rightbarY>0 && rightbarY<370)) rightSpeed=0;
      }   
   }
   
   public void move(JPanel o) {   
       
	      if(ballY > rightbarY-10 && ballY < rightbarY+100 && ballX > 650) {   //라켓범위안에 맞았는지 확인
	           speedX*=-1;
	      }
	      else if (ballX > 670){
	           scoreA++;
	           leftSide.setText(Integer.toString(+scoreA)+"  : ");  // 아닐경우 스코어 및 방향 바꿈
	           speedX=-2;
	        }
	  
         if(ballY > leftbarY-10 && ballY < leftbarY+100 && ballX < 10) {         // 라켓 범위 안에 맞았는지 여부 확인
              System.out.println("hit");
              speedX*=-1;
         }
         else if(ballX < 0){ 
               scoreB++;
               rightSide.setText(Integer.toString(scoreB));			//아닐경우 스코어 올리고 방향바꿈
               speedX=2;
          }
     
         if(ballY > 450 || ballY < 0) speedY*=-1;
        
      
         repaint();
      
   }
   
   @Override
   public void keyTyped(KeyEvent e) {    
   }

   @Override
   public void keyPressed(KeyEvent e) {
      if(e.getKeyCode()==KeyEvent.VK_W)      if(leftbarY>0) leftSpeed=-2;  	   // 키보드 누르기만 하면 움직임
      if (e.getKeyCode()== KeyEvent.VK_S)    if(leftbarY<370) leftSpeed=2;      
      if(e.getKeyCode()==KeyEvent.VK_UP)       if(rightbarY>0) rightSpeed=-2;
      if (e.getKeyCode()== KeyEvent.VK_DOWN) if(rightbarY<370) rightSpeed=2; 
   }
   @Override
   public void keyReleased(KeyEvent e) {
      if(e.getKeyCode()==KeyEvent.VK_W)   leftSpeed=0; 						//손가락 땟을 속도 0
      if (e.getKeyCode()== KeyEvent.VK_S) leftSpeed=0;
      if(e.getKeyCode()==KeyEvent.VK_UP)     rightSpeed=-0;
      if (e.getKeyCode()== KeyEvent.VK_DOWN)  rightSpeed=0; 
   }
   
   public static void main(String[] args)
   {
     new MiniPingPongGame();
     
   }

}
