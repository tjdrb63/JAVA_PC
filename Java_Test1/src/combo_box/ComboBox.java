package combo_box;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/*	������ Ÿ�����ص� ������ �ٲ�� ����
 *  ������ Ÿ�����ϰ��� ComboBox�� Item �߰���
 * 
 * */

public class ComboBox extends JFrame implements ActionListener {
   
   private JLabel label;
   private JComboBox FoodList;
   private ArrayList<String> Foods = new ArrayList<String>(); 
   private String[] arr;
   
   public ComboBox() {
	   
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(500,400);
      
      Foods.add("apple");
      Foods.add("grape");
      Foods.add("orange");
      arr=new String[Foods.size()];     // Foods�� ������ŭ arr �迭 ����
      Foods.toArray(arr);  //Foods�� ������ arr�� �迭��
 
      FoodList = new JComboBox(arr);   //FoodList ����
      FoodList.setSelectedIndex(0); // �ʱ� �⺻ ����
      FoodList.addActionListener(this);
      FoodList.setEditable(true);
      
      label= new JLabel();
      label.setHorizontalAlignment(SwingConstants.CENTER);
      changePicture(arr[FoodList.getSelectedIndex()]); // ���� �ٲٱ�
      this.add(FoodList,BorderLayout.NORTH);
      this.add(label,BorderLayout.CENTER);
      this.setVisible(true);
      
   }

   public void changePicture(String name) {
	   
	  ImageIcon icon = new ImageIcon("image/"+name+".jpg"); // �̹��� �ҷ�����
	  
	  int ch=0;
	  for(int i = 0 ; i< FoodList.getItemCount() ;i++) 	   // ComboBox�� �߰� �ɋ� �ߺ� ���� üũ
    	 if(FoodList.getItemAt(i)==name) {
    		 System.out.println("����"); 
    		 ch=1;
    		 break;
    	 }
      	
      if(ch == 0) FoodList.addItem(name);  // �ߺ��� ������ ComboBox�� �߰�
      
      label.setIcon(icon);
      label.setText(null);
   
   }


   @Override
   public void actionPerformed(ActionEvent e) {
      String name = (String)FoodList.getSelectedItem(); //���� �������ִ� ComboBox�� Item ���� name�� ����
      changePicture(name);   //name�̶� �����̸��� �������� �ٲٱ�
   }
   
   public static void main(String[] args) {
      new ComboBox();
   }



}