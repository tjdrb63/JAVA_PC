package silderdemo;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class SliderDemo extends JFrame implements ChangeListener{

	static final int INIT_VALUE = 15;
	
	private JButton Okbtn;
	private JSlider slider;
	private JButton btn;
	
	
	public SliderDemo()
	{
		JPanel panel;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel =new JPanel();
		JLabel label = new JLabel("슬라이더를 움직여보세요",SwingConstants.CENTER);
		panel.add(label);
		
		slider = new  JSlider(0,30,INIT_VALUE);
		slider.setMajorTickSpacing(5);  // 큰 눈금단위
		slider.setMinorTickSpacing(8);  // 작은눈금 단위
		slider.setPaintTicks(true);		//눈금의 색상여부
		slider.setPaintLabels(true);	//라벨의 색상여부
		slider.addChangeListener(this);
		panel.add(slider);
		
		btn = new JButton(" ");
		ImageIcon icon = new ImageIcon("image/dog.jpg");
		btn.setIcon(icon);
		btn.setSize(INIT_VALUE *10 , INIT_VALUE *10); //기본 사이즈
		panel.add(btn);
		
		this.add(panel);
		this.setSize(300,500);
		this.setVisible(true);
		
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource(); // 눈금의 값
		if(!source.getValueIsAdjusting()) {
			int value=source.getValue();
			btn.setSize(value*10,value*10);
		}
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SliderDemo();
	}


}
