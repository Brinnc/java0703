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

public class ChatA extends JFrame implements ActionListener, KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p;
	JTextField t;
	JButton bt;
	ChatB chatB;
	ChatC chatC;
	
	public ChatA() {
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p=new JPanel();
		t=new JTextField(15);
		bt=new JButton("OPEN");
		
		add(scroll);
		add(p, BorderLayout.SOUTH);
		p.add(t);
		p.add(bt);
		
		setBounds(200, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener(this);
		t.addKeyListener(this);
		
	}
	
	//버튼으로 B, C 채팅창 생성
	public void actionPerformed(ActionEvent e) {
		System.out.println("새창");
		
		chatB=new ChatB();
		chatB.setChatA(this);
		
		chatC=new ChatC();
		chatC.setChatA(this);
	}
	
	public void keyTyped(KeyEvent e) {		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		System.out.println("A가 메세지 입력");
		int key=e.getKeyCode();
		
		if(key==KeyEvent.VK_ENTER) {
			//1)나의 area에 입력한 값을 대입
			String msg=t.getText();
			area.append(msg+"\n");
			t.setText("");
			//2)B의 area에 입력한 값을 대입
			chatB.area.append(msg+"\n");
			//3)C의 area에 입력한 값을 대입
			chatC.area.append(msg+"\n");
		}
		
	}

	
	public static void main(String[] args) {
		new ChatA();
	}
	
}
