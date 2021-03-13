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
		JLabel label = new JLabel("�����̴��� ������������",SwingConstants.CENTER);
		panel.add(label);
		
		slider = new  JSlider(0,30,INIT_VALUE);
		slider.setMajorTickSpacing(5);  // ū ���ݴ���
		slider.setMinorTickSpacing(8);  // �������� ����
		slider.setPaintTicks(true);		//������ ���󿩺�
		slider.setPaintLabels(true);	//���� ���󿩺�
		slider.addChangeListener(this);
		panel.add(slider);
		
		btn = new JButton(" ");
		ImageIcon icon = new ImageIcon("image/dog.jpg");
		btn.setIcon(icon);
		btn.setSize(INIT_VALUE *10 , INIT_VALUE *10); //�⺻ ������
		panel.add(btn);
		
		this.add(panel);
		this.setSize(300,500);
		this.setVisible(true);
		
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource(); // ������ ��
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
