package ImageLabel;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/*
 * 		이미지 안보기 기능 추가
 * 
 * 
 * */

public class ImageLabelTest extends JFrame implements ActionListener{
   private JPanel panel;
   private JLabel label;
   private JButton button;

   
   public ImageLabelTest() {
      this.setSize(500,500);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      panel= new JPanel();
      label = new JLabel("이미지를 보려면 버튼을 누르세요");
      button = new JButton("이미지 보기");
      //ImageIcon icon = new ImageIcon("image/icon.jpg");
      //button.setIcon(icon);    //이미지 아이콘
      
      button.addActionListener(this);
      panel.add(label);
      panel.add(button);
      this.add(panel);
      this.setVisible(true);   
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      
      ImageIcon dog = new ImageIcon("image/dog.jpg");
      if(button.getText()== "이미지 보기") {
    	  label.setIcon(dog);
    	  label.setText(null);
    	  button.setText("이미지 안보기");
      }
      else {
    	  label.setIcon(null);
    	  label.setText("이미지를 보려면 버튼을 누르세요");
    	  button.setText("이미지 보기");   
      }
   }
   public static void main(String[] args)
   {
      new ImageLabelTest();
      
   }
   
}