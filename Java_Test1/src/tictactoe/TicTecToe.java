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
	private JLabel textLabel = new JLabel("O의 차례입니다");
	private String Player = "O";
	private int Count=0;
	
	private TicTecToe(){
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		
		
		touchPanel.setLayout(new GridLayout(3,3)); 		// 3x3 그리드 레이아웃
		for(int i = 0 ; i < touchBtn.length; i++) {
			touchBtn[i] = new JButton("Click Here!");   // 버튼 생성
			touchBtn[i].setFont(new Font(Font.SANS_SERIF,Font.BOLD,15)); // 버튼 Font 설정
			touchBtn[i].addActionListener(this);  // add이벤트 리스너
			touchPanel.add(touchBtn[i]); // 패널에 삽입
		}
		
		this.add(textLabel,BorderLayout.NORTH);  //텍스트 위쪽 출력
		this.add(touchPanel,BorderLayout.CENTER); // 빙고판 중앙
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
			if(touchBtn[i].hashCode() == ch && checkBox[i] != "O" && checkBox[i] != "X")   //누른 버튼 맞는지 체크와 이미 눌러져있는지 확인
			{
				Count++;  // 총 누른 횟수 
				touchBtn[i].setText(Player);
				checkBox[i] = Player; 
			    int isWin = checkWin(); // 이겼으면 isWIn 1 반환
			    if(isWin == 1) break;  // 1이면 탈출
			    if(Player == "O") Player = "X";
				else Player = "O";	
			    textLabel.setText(Player + "의 차례입니다.");	 
			    
			    
			}
			if(Count == touchBtn.length) textLabel.setText("무승부 입니다!");   // 만약 마지막 까지 눌렀는데 승패가 안날경우 무승부
		}
	}
	
	public int checkWin() {
		int isWin = 0;
			for(int i = 0 ; i <3 ; i++)
			{
					if(checkBox[i] == checkBox[i+3] && checkBox[i] == checkBox[i+6] && checkBox[i] != null) //빈공간인지 여부 세로체크
					{
						isWin=1;
						for(int j = 0 ;j <3 ;j++) touchBtn[i+j*3].setBackground(Color.yellow);
						textLabel.setText(Player + "가 이겼습니다!");				
						break;
					}
					if(checkBox[i*3] == checkBox[i*3+1] && checkBox[i*3] == checkBox[i*3+2] && checkBox[i*3] != null) //빈공간인지 여부 가로체크
					{
						isWin=1;
						for(int j = 0 ;j <3 ;j++) touchBtn[i*3+j].setBackground(Color.yellow);
						textLabel.setText(Player + "가 이겼습니다!");
						break;
					}
			}
			if(checkBox[0] == checkBox[4] && checkBox[0] == checkBox[8] & checkBox[0]!= null) {   // 하단 대각선
				isWin=1;
				for(int j = 0 ;j <3 ;j++) touchBtn[j*4].setBackground(Color.yellow);
				
				textLabel.setText(Player + "가 이겼습니다!");
			}
			if(checkBox[2] == checkBox[4] && checkBox[4] == checkBox[6] & checkBox[2]!= null) {    // 상단 대각선
				isWin=1;
				for(int j = 1 ;j <=3 ;j++) touchBtn[j*2].setBackground(Color.yellow);
				
				textLabel.setText(Player + "가 이겼습니다!");
			}
				return isWin;
	}
	
	

}
