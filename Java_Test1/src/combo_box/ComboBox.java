package combo_box;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/*	손으로 타이핑해도 사진이 바뀌도록 변경
 *  손으로 타이핑하고난후 ComboBox에 Item 추가함
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
      arr=new String[Foods.size()];     // Foods의 갯수만큼 arr 배열 생성
      Foods.toArray(arr);  //Foods의 값으로 arr에 배열값
 
      FoodList = new JComboBox(arr);   //FoodList 선언
      FoodList.setSelectedIndex(0); // 초기 기본 누름
      FoodList.addActionListener(this);
      FoodList.setEditable(true);
      
      label= new JLabel();
      label.setHorizontalAlignment(SwingConstants.CENTER);
      changePicture(arr[FoodList.getSelectedIndex()]); // 사진 바꾸기
      this.add(FoodList,BorderLayout.NORTH);
      this.add(label,BorderLayout.CENTER);
      this.setVisible(true);
      
   }

   public void changePicture(String name) {
	   
	  ImageIcon icon = new ImageIcon("image/"+name+".jpg"); // 이미지 불러오기
	  
	  int ch=0;
	  for(int i = 0 ; i< FoodList.getItemCount() ;i++) 	   // ComboBox에 추가 될떄 중복 여부 체크
    	 if(FoodList.getItemAt(i)==name) {
    		 System.out.println("막음"); 
    		 ch=1;
    		 break;
    	 }
      	
      if(ch == 0) FoodList.addItem(name);  // 중복이 없으면 ComboBox에 추가
      
      label.setIcon(icon);
      label.setText(null);
   
   }


   @Override
   public void actionPerformed(ActionEvent e) {
      String name = (String)FoodList.getSelectedItem(); //현재 눌러져있는 ComboBox의 Item 값을 name에 넣음
      changePicture(name);   //name이랑 같은이름의 사진으로 바꾸기
   }
   
   public static void main(String[] args) {
      new ComboBox();
   }



}