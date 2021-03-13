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
		JLabel label = new JLabel("���� ���ñ� ������Ʈ �׽�Ʈ �Դϴ�.");
		openBtn = new JButton("���� ����");
		openBtn.addActionListener(this);
		
		saveBtn = new JButton("���� ����");
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
		if(e.getSource()==openBtn) {  // ���� ���Ͽ��� ��ư ��������
			int returnVal = fileChooser.showOpenDialog(this); // ����â ����
			if(returnVal == JFileChooser.APPROVE_OPTION) {  // ���Ͽ��� �Ұ��
				File file = fileChooser.getSelectedFile();	
				System.out.println("open File : " + file.getAbsolutePath()); // ���� ������ ��θ� ���				
			}	
			else {												//���� ������ ���ٸ�.
				System.out.println("No File Selected");	
			}
		}
		else if (e.getSource() == saveBtn) {
			int returnVal = fileChooser.showSaveDialog(this);  // ���̺� â ����
			if(returnVal==JFileChooser.APPROVE_OPTION) {		//���� ���� �Ұ��
				File file = fileChooser.getSelectedFile();
				System.out.println("Save To : " + file.getAbsolutePath());	 //���� ������ ��θ� ���
				
			}
			else {												//���� ������ ���ٸ�
				System.out.println("Save Canceled..");
			}
			
		}
		
	}
	
	public static void main(String[] args)
	{
		new FileChooserDemo();
	}
	

}
