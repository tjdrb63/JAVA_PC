package filechooserdemo;

import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class FileChooserDemo extends JFrame implements ActionListener{
	private JButton openBtn,saveBtn;
	private JFileChooser fileChooser;
	
	public FileChooserDemo() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,200);
		
		fileChooser = new JFileChooser();
		JLabel label = new JLabel("파일 선택기 컴포넌트 테스트 입니다.");
		openBtn = new JButton("파일 오픈");
		openBtn.addActionListener(this);
		
		saveBtn = new JButton("파일 저장");
		saveBtn.addActionListener(this);
		
		
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(openBtn);
		panel.add(saveBtn);
		
		this.add(panel);
		this.setVisible(true);		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==openBtn) {  // 만약 파일열기 버튼 눌렀을시
			int returnVal = fileChooser.showOpenDialog(this); // 오픈창 띄우기
			if(returnVal == JFileChooser.APPROVE_OPTION) {  // 파일열기 할경우
				File file = fileChooser.getSelectedFile();	
				System.out.println("open File : " + file.getAbsolutePath()); // 누른 파일의 경로를 출력				
			}	
			else {												//누른 파일이 없다면.
				System.out.println("No File Selected");	
			}
		}
		else if (e.getSource() == saveBtn) {
			int returnVal = fileChooser.showSaveDialog(this);  // 세이브 창 띄우기
			if(returnVal==JFileChooser.APPROVE_OPTION) {		//파일 저장 할경우
				File file = fileChooser.getSelectedFile();
				System.out.println("Save To : " + file.getAbsolutePath());	 //누른 파일의 경로를 출력
				
			}
			else {												//누른 파일이 없다면
				System.out.println("Save Canceled..");
			}
			
		}
		
	}
	
	public static void main(String[] args)
	{
		new FileChooserDemo();
	}
	

}
