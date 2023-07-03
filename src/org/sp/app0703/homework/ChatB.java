package org.sp.app0703.homework;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatB extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p;
	JTextField t;
	ChatA chatA;
	//ChatC chatC;
	
	public ChatB() {
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p=new JPanel();
		t=new JTextField(15);
		
		add(scroll);
		add(p, BorderLayout.SOUTH);
		p.add(t);
		
		setBounds(500, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		t.addKeyListener(this);
		
	}
	
	public void setChatA(ChatA chatA) {
		this.chatA = chatA;
	}
	
	//public void setChatC(ChatC chatC) {
	//	this.chatC = chatC;
	//}
	
	public void keyTyped(KeyEvent e) {		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		System.out.println("B가 메세지 입력");
		
		int key=e.getKeyCode();
		
		if(key==KeyEvent.VK_ENTER) {
			//1)나의 area에 입력한 값을 대입
			String msg=t.getText();
			area.append(msg+"\n");
			t.setText("");
			//2)A의 area에 입력한 값을 대입
			chatA.area.append(msg+"\n");
			//3)C의 area에 입력한 값을 대입
			chatA.chatC.area.append(msg+"\n");
		}
		
		
	}
	
}
