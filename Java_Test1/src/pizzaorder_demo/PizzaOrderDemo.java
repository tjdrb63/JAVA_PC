package pizzaorder_demo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

/*
 * 	 마우스를 올리기만해도 changeListener이 작동하여 temp값이 변경됨
 * 	is Selected()를 사용하여 클릭 하였을떄만 temp값이 바뀌도록함
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

		orderBtn = new JButton("주문");
		orderBtn.addActionListener(this);
		
		cancelBtn = new JButton("취소");
		cancelBtn.addActionListener(this);
		
		priceField = new JTextField();  		//가격이 뜨는곳
		priceField.setEditable(false);
		priceField.setColumns(6);
		
		orderPanel = new  JPanel();			//Button 과 TextField orderPanel에 배치
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
	class WelcomePanel extends JPanel{ // 호출시 message Label을 add함
		private JLabel  message;
		
		public WelcomePanel()
		{
			message = new JLabel("자바 피자에 오신것을 환영합니다.");
			this.add(message);
		}
	}
	
	class TypePanel extends JPanel implements ChangeListener 		//typePanel에 add
	{
		private JRadioButton combo,potato,bulgogi;
		private ButtonGroup BtnGroup;
		
		
		public TypePanel() {
			this.setLayout(new GridLayout(3,1));
			combo = new JRadioButton("콤보",true);
			combo.addChangeListener(this);

			potato = new JRadioButton("포테이토");
			potato.addChangeListener(this);
			
			bulgogi = new JRadioButton("불고기");
			bulgogi.addChangeListener(this);
			
			
			BtnGroup = new ButtonGroup();			// 그룹으로 묶어 중복 체크 방지
			BtnGroup.add(combo); 
			BtnGroup.add(potato);
			BtnGroup.add(bulgogi);
			this.setBorder(BorderFactory.createTitledBorder("종류"));
			
			this.add(combo);
			this.add(potato);
			this.add(bulgogi);
			
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			if(e.getSource() == combo && combo.isSelected())           temp1 = 0;		//콤보면 	1
			else if (e.getSource() == potato && potato.isSelected())   temp1 = 1;	 	//감자면 2
			else if (e.getSource() == bulgogi &&  bulgogi.isSelected())temp1 = 2;		//불고기면 3
		}
			
	}
	
	
	class ToppingPanel extends JPanel implements ChangeListener  //topplngPanel 에 add
	{
		private JRadioButton pepper,cheese,peperoni,bacon;
		private ButtonGroup BtnGroup;
		
		
		public ToppingPanel() {
			this.setLayout(new GridLayout(4,1)); 
			pepper = new JRadioButton("피망",true);
			pepper.addChangeListener(this);

			cheese = new JRadioButton("치즈");
			cheese.addChangeListener(this);
			
			peperoni = new JRadioButton("페페로니");
			peperoni.addChangeListener(this);
			
			bacon = new JRadioButton("베이컨");
			bacon.addChangeListener(this);
			
			
			BtnGroup = new ButtonGroup(); 	  // 그룹으로 묶어 중복 체크 방지
			BtnGroup.add(pepper); 
			BtnGroup.add(cheese);
			BtnGroup.add(peperoni);
			BtnGroup.add(bacon);
			
			this.setBorder(BorderFactory.createTitledBorder("추가토핑"));
			
			this.add(pepper); 
			this.add(cheese);
			this.add(peperoni);
			this.add(bacon);
			
			
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			if(e.getSource() == pepper && pepper.isSelected()) 			temp2 = 0; 		// 피망 0
			else if (e.getSource() == cheese && cheese.isSelected()) 	temp2 = 1;   	// 치즈 1
			else if (e.getSource() == peperoni && peperoni.isSelected())temp2 = 2;		// 페페로니 2	
			else if(e.getSource()==bacon && bacon.isSelected())			temp2 = 3;		// 베이컨 3
		}
			
	}
	
	class SizePanel extends JPanel implements ChangeListener  //SizePanel JRadioButton add 
	{
		private JRadioButton small,medium,large;
		private ButtonGroup BtnGroup;
		
		
		public SizePanel() {
			this.setLayout(new GridLayout(3,1));
			small= new JRadioButton("스몰",true);
			small.addChangeListener(this);

			medium = new JRadioButton("미디움");
			medium.addChangeListener(this);
			
			large = new JRadioButton("라지");
			large.addChangeListener(this);
			
			
			BtnGroup = new ButtonGroup();  // 그룹으로 묶어 중복 체크 방지
			BtnGroup.add(small); 
			BtnGroup.add(medium);
			BtnGroup.add(large);
			
			this.setBorder(BorderFactory.createTitledBorder("사이즈")); // 보더박스
			
			this.add(small);
			this.add(medium);
			this.add(large);
			
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			if(e.getSource()==small && small.isSelected()) 			temp3 = 0;		// 스몰이면 1
			else if (e.getSource()== medium && medium.isSelected()) temp3 = 1;		// 미디움이면 2
			else if(e.getSource()==large && large.isSelected()) 	temp3 = 2;		// 라지면 3
		}
			
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==orderBtn) {
			sum += 10000 + temp1 * 1000; 			// combo = 10000원 , potato = 11000원 , bulgogi = 12000원
			sum += (temp2/2+1)*2000; 		// pepper = 2000원 , cheese = 2000원 , peperoni = 4000원 , bacon = 4000원
			sum += temp3 *2000; 			// small = 2000원 , medium = 4000원 , large = 6000원
			
			
			priceField.setText(String.valueOf(sum)+"원");
			sum=0;	
			System.out.printf("temp1 : %d / temp2 : %d / temp3 : %d\n",temp1,temp2,temp3);  // 체크 위치 출력
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
