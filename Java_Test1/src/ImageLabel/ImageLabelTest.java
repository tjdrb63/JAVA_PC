package ImageLabel;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/*
 * 		�̹��� �Ⱥ��� ��� �߰�
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
      label = new JLabel("�̹����� ������ ��ư�� ��������");
      button = new JButton("�̹��� ����");
      //ImageIcon icon = new ImageIcon("image/icon.jpg");
      //button.setIcon(icon);    //�̹��� ������
      
      button.addActionListener(this);
      panel.add(label);
      panel.add(button);
      this.add(panel);
      this.setVisible(true);   
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      
      ImageIcon dog = new ImageIcon("image/dog.jpg");
      if(button.getText()== "�̹��� ����") {
    	  label.setIcon(dog);
    	  label.setText(null);
    	  button.setText("�̹��� �Ⱥ���");
      }
      else {
    	  label.setIcon(null);
    	  label.setText("�̹����� ������ ��ư�� ��������");
    	  button.setText("�̹��� ����");   
      }
   }
   public static void main(String[] args)
   {
      new ImageLabelTest();
      
   }
   
}