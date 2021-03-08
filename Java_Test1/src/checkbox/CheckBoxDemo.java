package checkbox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *     	이미지 출력시 글자 사라지게 수정.
 * 		체크박스 체크시 색상변경
 * 
 * */




public class CheckBoxDemo extends JPanel implements ItemListener{

   private JCheckBox[] checkBoxes = new JCheckBox[3];
   private String[] fruits = {"apple","grape","orange"};
   private JLabel[] labels = new JLabel[3];
   private ImageIcon[] icons = new ImageIcon[3];
   
   public CheckBoxDemo() {
   
      
      this.setLayout(new GridLayout(0,4));				 // ㅁㅁㅁㅁ 그리드 레이아웃
      for(int i = 0; i < checkBoxes.length; i++){
         checkBoxes[i]=new JCheckBox(fruits[i]);	//fruits이름 가진 체크박스
         checkBoxes[i].addItemListener(this);	
         labels[i]= new JLabel(fruits[i]);			//fruits이름 가진 라벨
         icons[i] = new ImageIcon(fruits[i]+".gif"); // 이미지경로
      }
      
      JPanel checkBoxPanel = new JPanel (new GridLayout(0,1));

      for(int i = 0 ; i< checkBoxes.length;i++)
      {
         checkBoxPanel.add(checkBoxes[i]);			// 체크박스 패널에 추가
         this.add(checkBoxPanel);				
      }
      
      for(int i = 0 ; i< labels.length;i++)
      {
         this.add(labels[i]);					// 그림용 라벨 추가
      }
   }
   
   @Override
   public void itemStateChanged(ItemEvent e) {
      // TODO Auto-generated method stub
      ImageIcon icon = null;
      Object source = e.getItemSelectable();
      for(int i = 0 ; i < checkBoxes.length;i++)
      {
         if(source == checkBoxes[i]) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
            
               checkBoxes[i].setForeground(Color.red);
               labels[i].setIcon(icons[i]); // 체크 되어잇다면 이미지 출력
               labels[i].setText(null); 
            }
            else {

                checkBoxes[i].setForeground(Color.black);
               labels[i].setIcon(null); //체크 안되있으면 이미지 안됨
               labels[i].setText(fruits[i]);
            }
            
         }
      }
      
   }
   
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("CheckBoxDemo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(new CheckBoxDemo());
      frame.setSize(1000,700);
      frame.setVisible(true);     
   }
   
   
}