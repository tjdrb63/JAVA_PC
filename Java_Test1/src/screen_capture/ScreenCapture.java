package screen_capture;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/*
 * 	+ button���� ȭ�� ĸ�� ��� 
 *  + ��ǥ ���� ����
 *  - ĸ�� ȭ�� ũ�� ���� ��� �߰� �ؾ���
 * 
 * */

public class ScreenCapture extends JFrame implements ActionListener{
	
	private JButton capBtn;
	private JFrame capture;
	private JPanel panel, inputPn;
	private Dimension d = new Dimension(500,500);
	private int i=0;
	private JLabel labelX,labelY;
	private JTextField areaX,areaY;
	public ScreenCapture()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(d);
		
		inputPn = new JPanel();
		capBtn = new JButton("ĸ���ϱ�");
		capBtn.addActionListener(this);	
		panel= new drawImg();	//drawImg ����
		
		labelX = new JLabel("X :");
		labelY = new JLabel("Y :");
		areaX = new JTextField(4);
		areaX.setText("0");
		areaY = new JTextField(4);
		areaY.setText("0");
		
		inputPn.add(labelX);
		inputPn.add(areaX);
		inputPn.add(labelY);
		inputPn.add(areaY);
		
		this.add(inputPn,BorderLayout.NORTH);		//��� XY ��ǥ �Է�â
		this.add(capBtn,BorderLayout.SOUTH);		//�ߴ� ��ũ���� ǥ��
		this.add(panel,BorderLayout.CENTER);		//�ϴ� ĸ�� ��ư
		this.setVisible(true);
		
	}
	
	class drawImg extends JPanel{			//�׸� ��¿� �г�
		@Override
		public void paintComponent(Graphics g) {	
				
			int x = Integer.parseInt(areaX.getText());			// X���� textField�� int�� �ٲ�
			int y = Integer.parseInt(areaY.getText());			// Y���� textField�� int�� �ٲ�
			
			Rectangle rect = new Rectangle(x,y,500,500);			//x,y ��ġ�� 500 500 ũ��
				try {
						//System.out.println("�׸����");
						Robot robot = new Robot();				
						BufferedImage image = robot.createScreenCapture(rect);  //rect ũ�� ��ŭ image �߶� �־���
						g.drawImage(image,0,0,d.width,d.height,this);			
					
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}	
	
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==capBtn) {
			//System.out.println("��ư ȣ��");	
			repaint();								//�ٽúθ�
		}
		
//		if(e.getSource()==capBtn)
//		{
//			System.out.println("��ư ȣ��");
//			
//			Rectangle rect = new Rectangle(d);	
//			try {
//				Robot robot = new Robot();
//			 
//				BufferedImage image = robot.createScreenCapture(rect);  //rect ũ�� ��ŭ image �߶� �־���
//				ImageIcon image2;
//				System.out.println(image.getSource());
//					panel = new JPanel() {
//					public void paintComponent(Graphics g) {
//						panel.setOpaque(false);
//						g.drawImage(image,i++,0,d.width,d.height,this);		
//						System.out.println("panel ȣ��");
//					}
//					
//				};
//				panel.prepareImage(image, panel);
//				
//			}catch(Exception e1) {
//				e1.printStackTrace();
//			}	
//			
//		}
		
	}
	public static void main(String[] args)
	{
		new ScreenCapture();
		
	}

}
