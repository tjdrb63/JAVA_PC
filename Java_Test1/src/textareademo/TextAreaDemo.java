package textareademo;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TextAreaDemo extends JFrame implements ActionListener {
	
	private JTextField textField;
	private JTextArea textArea;
	
	
	public TextAreaDemo()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField(30);
		textField.addActionListener(this);
		
		textArea = new JTextArea(10,30);
		textArea.setEditable(false);
		
		this.add(textField,BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		this.add(scrollPane,BorderLayout.CENTER);
	
		this.pack();
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String text = textField.getText();
		textArea.append(text + "\n");
		textField.selectAll();
		textArea.setCaretPosition(textArea.getDocument().getLength()); // 스크롤 최하단
		
	}
	
	public static void main(String[] args) {
		new TextAreaDemo();
	}

}
