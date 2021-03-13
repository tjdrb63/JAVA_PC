package pizzaorder_demo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

/*
 * 	 ���콺�� �ø��⸸�ص� changeListener�� �۵��Ͽ� temp���� �����
 * 	is Selected()�� ����Ͽ� Ŭ�� �Ͽ������� temp���� �ٲ����
 * 
 * 
 * 
 * 
 * */


public class PizzaOrderDemo extends JFrame implements ActionListener{
	private int sum, temp1,temp2,temp3;
	
	private JButton orderBtn,cancelBtn;
	private JPanel orderPanel;
	private JTextField priceField;
	
	JPanel welcomePanel = new WelcomePanel(); // Massage add
	JPanel typePanel = new TypePanel();	// typePanel add
	JPanel toppingPanel = new ToppingPanel();	// ToppingPanel add
	JPanel sizePanel = new SizePanel();	// SizePanle add
	
	
	public PizzaOrderDemo()
	{
		this.setSize(500,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		orderBtn = new JButton("�ֹ�");
		orderBtn.addActionListener(this);
		
		cancelBtn = new JButton("���");
		cancelBtn.addActionListener(this);
		
		priceField = new JTextField();  		//������ �ߴ°�
		priceField.setEditable(false);
		priceField.setColumns(6);
		
		orderPanel = new  JPanel();			//Button �� TextField orderPanel�� ��ġ
		orderPanel.add(orderBtn);
		orderPanel.add(cancelBtn);
		orderPanel.add(priceField);
		
		
		this.add(welcomePanel,BorderLayout.NORTH); 		
		this.add(orderPanel,BorderLayout.SOUTH);
		this.add(sizePanel,BorderLayout.EAST);
		this.add(typePanel,BorderLayout.WEST);
		this.add(toppingPanel,BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	class WelcomePanel extends JPanel{ // ȣ��� message Label�� add��
		private JLabel  message;
		
		public WelcomePanel()
		{
			message = new JLabel("�ڹ� ���ڿ� ���Ű��� ȯ���մϴ�.");
			this.add(message);
		}
	}
	
	class TypePanel extends JPanel implements ChangeListener 		//typePanel�� add
	{
		private JRadioButton combo,potato,bulgogi;
		private ButtonGroup BtnGroup;
		
		
		public TypePanel() {
			this.setLayout(new GridLayout(3,1));
			combo = new JRadioButton("�޺�",true);
			combo.addChangeListener(this);

			potato = new JRadioButton("��������");
			potato.addChangeListener(this);
			
			bulgogi = new JRadioButton("�Ұ��");
			bulgogi.addChangeListener(this);
			
			
			BtnGroup = new ButtonGroup();			// �׷����� ���� �ߺ� üũ ����
			BtnGroup.add(combo); 
			BtnGroup.add(potato);
			BtnGroup.add(bulgogi);
			this.setBorder(BorderFactory.createTitledBorder("����"));
			
			this.add(combo);
			this.add(potato);
			this.add(bulgogi);
			
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			if(e.getSource() == combo && combo.isSelected())           temp1 = 0;		//�޺��� 	1
			else if (e.getSource() == potato && potato.isSelected())   temp1 = 1;	 	//���ڸ� 2
			else if (e.getSource() == bulgogi &&  bulgogi.isSelected())temp1 = 2;		//�Ұ��� 3
		}
			
	}
	
	
	class ToppingPanel extends JPanel implements ChangeListener  //topplngPanel �� add
	{
		private JRadioButton pepper,cheese,peperoni,bacon;
		private ButtonGroup BtnGroup;
		
		
		public ToppingPanel() {
			this.setLayout(new GridLayout(4,1)); 
			pepper = new JRadioButton("�Ǹ�",true);
			pepper.addChangeListener(this);

			cheese = new JRadioButton("ġ��");
			cheese.addChangeListener(this);
			
			peperoni = new JRadioButton("����δ�");
			peperoni.addChangeListener(this);
			
			bacon = new JRadioButton("������");
			bacon.addChangeListener(this);
			
			
			BtnGroup = new ButtonGroup(); 	  // �׷����� ���� �ߺ� üũ ����
			BtnGroup.add(pepper); 
			BtnGroup.add(cheese);
			BtnGroup.add(peperoni);
			BtnGroup.add(bacon);
			
			this.setBorder(BorderFactory.createTitledBorder("�߰�����"));
			
			this.add(pepper); 
			this.add(cheese);
			this.add(peperoni);
			this.add(bacon);
			
			
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			if(e.getSource() == pepper && pepper.isSelected()) 			temp2 = 0; 		// �Ǹ� 0
			else if (e.getSource() == cheese && cheese.isSelected()) 	temp2 = 1;   	// ġ�� 1
			else if (e.getSource() == peperoni && peperoni.isSelected())temp2 = 2;		// ����δ� 2	
			else if(e.getSource()==bacon && bacon.isSelected())			temp2 = 3;		// ������ 3
		}
			
	}
	
	class SizePanel extends JPanel implements ChangeListener  //SizePanel JRadioButton add 
	{
		private JRadioButton small,medium,large;
		private ButtonGroup BtnGroup;
		
		
		public SizePanel() {
			this.setLayout(new GridLayout(3,1));
			small= new JRadioButton("����",true);
			small.addChangeListener(this);

			medium = new JRadioButton("�̵��");
			medium.addChangeListener(this);
			
			large = new JRadioButton("����");
			large.addChangeListener(this);
			
			
			BtnGroup = new ButtonGroup();  // �׷����� ���� �ߺ� üũ ����
			BtnGroup.add(small); 
			BtnGroup.add(medium);
			BtnGroup.add(large);
			
			this.setBorder(BorderFactory.createTitledBorder("������")); // �����ڽ�
			
			this.add(small);
			this.add(medium);
			this.add(large);
			
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			if(e.getSource()==small && small.isSelected()) 			temp3 = 0;		// �����̸� 1
			else if (e.getSource()== medium && medium.isSelected()) temp3 = 1;		// �̵���̸� 2
			else if(e.getSource()==large && large.isSelected()) 	temp3 = 2;		// ������ 3
		}
			
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==orderBtn) {
			sum += 10000 + temp1 * 1000; 			// combo = 10000�� , potato = 11000�� , bulgogi = 12000��
			sum += (temp2/2+1)*2000; 		// pepper = 2000�� , cheese = 2000�� , peperoni = 4000�� , bacon = 4000��
			sum += temp3 *2000; 			// small = 2000�� , medium = 4000�� , large = 6000��
			
			
			priceField.setText(String.valueOf(sum)+"��");
			sum=0;	
			System.out.printf("temp1 : %d / temp2 : %d / temp3 : %d\n",temp1,temp2,temp3);  // üũ ��ġ ���
		}
		else if(e.getSource() == cancelBtn) {
			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			sum=0;
			priceField.setText(String.valueOf(sum));	
			
		}
		
	}
	
	public static void main(String[] Args) {
		new PizzaOrderDemo();
			
	}

	
}
