package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;




public class TicTecToe extends JFrame implements ActionListener{
	private JButton[] touchBtn =new JButton[9];
	private String[] checkBox = new String[9];
	private JPanel touchPanel = new JPanel();	
	private JLabel textLabel = new JLabel("O�� �����Դϴ�");
	private String Player = "O";
	private int Count=0;
	
	private TicTecToe(){
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		
		
		touchPanel.setLayout(new GridLayout(3,3)); 		// 3x3 �׸��� ���̾ƿ�
		for(int i = 0 ; i < touchBtn.length; i++) {
			touchBtn[i] = new JButton("Click Here!");   // ��ư ����
			touchBtn[i].setFont(new Font(Font.SANS_SERIF,Font.BOLD,15)); // ��ư Font ����
			touchBtn[i].addActionListener(this);  // add�̺�Ʈ ������
			touchPanel.add(touchBtn[i]); // �гο� ����
		}
		
		this.add(textLabel,BorderLayout.NORTH);  //�ؽ�Ʈ ���� ���
		this.add(touchPanel,BorderLayout.CENTER); // ������ �߾�
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new TicTecToe();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int ch = e.getSource().hashCode();
		for(int i = 0 ;i < touchBtn.length; i++)
		{
			if(touchBtn[i].hashCode() == ch && checkBox[i] != "O" && checkBox[i] != "X")   //���� ��ư �´��� üũ�� �̹� �������ִ��� Ȯ��
			{
				Count++;  // �� ���� Ƚ�� 
				touchBtn[i].setText(Player);
				checkBox[i] = Player; 
			    int isWin = checkWin(); // �̰����� isWIn 1 ��ȯ
			    if(isWin == 1) break;  // 1�̸� Ż��
			    if(Player == "O") Player = "X";
				else Player = "O";	
			    textLabel.setText(Player + "�� �����Դϴ�.");	 
			    
			    
			}
			if(Count == touchBtn.length) textLabel.setText("���º� �Դϴ�!");   // ���� ������ ���� �����µ� ���а� �ȳ���� ���º�
		}
	}
	
	public int checkWin() {
		int isWin = 0;
			for(int i = 0 ; i <3 ; i++)
			{
					if(checkBox[i] == checkBox[i+3] && checkBox[i] == checkBox[i+6] && checkBox[i] != null) //��������� ���� ����üũ
					{
						isWin=1;
						for(int j = 0 ;j <3 ;j++) touchBtn[i+j*3].setBackground(Color.yellow);
						textLabel.setText(Player + "�� �̰���ϴ�!");				
						break;
					}
					if(checkBox[i*3] == checkBox[i*3+1] && checkBox[i*3] == checkBox[i*3+2] && checkBox[i*3] != null) //��������� ���� ����üũ
					{
						isWin=1;
						for(int j = 0 ;j <3 ;j++) touchBtn[i*3+j].setBackground(Color.yellow);
						textLabel.setText(Player + "�� �̰���ϴ�!");
						break;
					}
			}
			if(checkBox[0] == checkBox[4] && checkBox[0] == checkBox[8] & checkBox[0]!= null) {   // �ϴ� �밢��
				isWin=1;
				for(int j = 0 ;j <3 ;j++) touchBtn[j*4].setBackground(Color.yellow);
				
				textLabel.setText(Player + "�� �̰���ϴ�!");
			}
			if(checkBox[2] == checkBox[4] && checkBox[4] == checkBox[6] & checkBox[2]!= null) {    // ��� �밢��
				isWin=1;
				for(int j = 1 ;j <=3 ;j++) touchBtn[j*2].setBackground(Color.yellow);
				
				textLabel.setText(Player + "�� �̰���ϴ�!");
			}
				return isWin;
	}
	
	

}
