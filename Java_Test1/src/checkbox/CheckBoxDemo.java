package checkbox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *     	�̹��� ��½� ���� ������� ����.
 * 		üũ�ڽ� üũ�� ���󺯰�
 * 
 * */




public class CheckBoxDemo extends JPanel implements ItemListener{

   private JCheckBox[] checkBoxes = new JCheckBox[3];
   private String[] fruits = {"apple","grape","orange"};
   private JLabel[] labels = new JLabel[3];
   private ImageIcon[] icons = new ImageIcon[3];
   
   public CheckBoxDemo() {
   
      
      this.setLayout(new GridLayout(0,4));				 // �������� �׸��� ���̾ƿ�
      for(int i = 0; i < checkBoxes.length; i++){
         checkBoxes[i]=new JCheckBox(fruits[i]);	//fruits�̸� ���� üũ�ڽ�
         checkBoxes[i].addItemListener(this);	
         labels[i]= new JLabel(fruits[i]);			//fruits�̸� ���� ��
         icons[i] = new ImageIcon(fruits[i]+".gif"); // �̹������
      }
      
      JPanel checkBoxPanel = new JPanel (new GridLayout(0,1));

      for(int i = 0 ; i< checkBoxes.length;i++)
      {
         checkBoxPanel.add(checkBoxes[i]);			// üũ�ڽ� �гο� �߰�
         this.add(checkBoxPanel);				
      }
      
      for(int i = 0 ; i< labels.length;i++)
      {
         this.add(labels[i]);					// �׸��� �� �߰�
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
               labels[i].setIcon(icons[i]); // üũ �Ǿ��մٸ� �̹��� ���
               labels[i].setText(null); 
            }
            else {

                checkBoxes[i].setForeground(Color.black);
               labels[i].setIcon(null); //üũ �ȵ������� �̹��� �ȵ�
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