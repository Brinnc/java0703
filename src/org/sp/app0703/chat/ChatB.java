package org.sp.app0703.chat;

import java.awt.BorderLayout;
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
	
	public ChatB(ChatA chatA) {
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p=new JPanel();
		t=new JTextField(16);
		this.chatA=chatA; //주입 injection
		
		add(scroll); //센터에 텍스트에리어 부착
		p.add(t);
		add(p, BorderLayout.SOUTH);//남쪽에 패널 부착
		
		setBounds(500, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//t와 리스너 연결
		t.addKeyListener(this);
		
	}

	public void keyTyped(KeyEvent e) {	
	}

	
	public void keyPressed(KeyEvent e) {
	}

	
	public void keyReleased(KeyEvent e) {
		//System.out.println("B에서 입력함");
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_ENTER) {
			//System.out.println("엔터 뿅");
			//1) 나의 area에 입력한 값 대입
			String msg=t.getText();
			area.append(msg+"\n");
			t.setText("");
			//2) A의 area에서 입력한 값 대입
			chatA.area.append(msg+"\n");
			
		}
		
	}
	
}
