package screen_capture;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/*
 * 	+ button으로 화면 캡쳐 기능 
 *  + 좌표 수정 가능
 *  - 캡쳐 화면 크기 조정 기능 추가 해야함
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
		capBtn = new JButton("캡쳐하기");
		capBtn.addActionListener(this);	
		panel= new drawImg();	//drawImg 넣음
		
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
		
		this.add(inputPn,BorderLayout.NORTH);		//상단 XY 좌표 입력창
		this.add(capBtn,BorderLayout.SOUTH);		//중단 스크린샷 표시
		this.add(panel,BorderLayout.CENTER);		//하단 캡쳐 버튼
		this.setVisible(true);
		
	}
	
	class drawImg extends JPanel{			//그림 출력용 패널
		@Override
		public void paintComponent(Graphics g) {	
				
			int x = Integer.parseInt(areaX.getText());			// X값을 textField의 int로 바꿈
			int y = Integer.parseInt(areaY.getText());			// Y값을 textField의 int로 바꿈
			
			Rectangle rect = new Rectangle(x,y,500,500);			//x,y 위치의 500 500 크기
				try {
						//System.out.println("그림출력");
						Robot robot = new Robot();				
						BufferedImage image = robot.createScreenCapture(rect);  //rect 크기 만큼 image 잘라서 넣어줌
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
			//System.out.println("버튼 호출");	
			repaint();								//다시부름
		}
		
//		if(e.getSource()==capBtn)
//		{
//			System.out.println("버튼 호출");
//			
//			Rectangle rect = new Rectangle(d);	
//			try {
//				Robot robot = new Robot();
//			 
//				BufferedImage image = robot.createScreenCapture(rect);  //rect 크기 만큼 image 잘라서 넣어줌
//				ImageIcon image2;
//				System.out.println(image.getSource());
//					panel = new JPanel() {
//					public void paintComponent(Graphics g) {
//						panel.setOpaque(false);
//						g.drawImage(image,i++,0,d.width,d.height,this);		
//						System.out.println("panel 호출");
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
