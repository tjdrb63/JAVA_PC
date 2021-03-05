package AnimationBasic_; // ��������� ȸ�� ����

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class AnimationBasic extends JPanel implements ActionListener{

   private final int WIDTH = 500, HEIGHT=250;
   private BufferedImage image;
   private Timer timer;
   private int x,y;
   private final int START_X=0,START_Y=200;
   private int turn=0;
   
   public AnimationBasic() {
      //Image���� �о image��ü�� ����
      //20ms���� �̺�Ʈ �߻� timer��ü ���� timer start ��Ŵ
      File file=new File("image/spaceship.jpg");
      try {
         image = ImageIO.read(file);
      }
      catch(IOException e)
      {
         e.printStackTrace();
         System.exit(1);
      }
      x=START_X;
      y=START_Y;
      
      timer = new Timer(20,this);
      timer.start();
   }
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      //x,y��ǥ�� �̹����� �׸���.
      g.drawImage(image,x,y,this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      // x,y��ǥ ����
   
      if(turn==0)
      {
         x += 1;
         y -= 1;
      }
      else if(turn==1)
      {
         x += 1;
         y += 1;
      }
      else if(turn==2)
      {
         x -= 1;
         y += 1;
      }
      else if(turn==3)
      {
         x -= 1;
         y -= 1;
      }
      if(y==0) turn ++;
      if(x>350) turn++;
      if(y>350) turn++;
      if(x==0) turn =0;
      
      repaint();
      
   }
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      frame.add(new AnimationBasic());
      frame.setTitle("�ִϸ��̼� �׽�Ʈ");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(470,490);
      frame.setVisible(true);
      
   }
   

}