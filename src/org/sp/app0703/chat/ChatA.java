package org.sp.app0703.chat;

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
	
	public ChatA() {
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p=new JPanel();
		t=new JTextField(16);
		bt=new JButton("OPEN");
		
		add(scroll); //센터에 텍스트에리어 부착
		p.add(t);
		p.add(bt);
		add(p, BorderLayout.SOUTH);//남쪽에 패널 부착
		
		setBounds(200, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener(this); //버튼과 리스너와의 연결
		t.addKeyListener(this); //텍스트필드와 리스너와의 연결
		
	}

	public void actionPerformed(ActionEvent e) {
		//System.out.println("버튼 뿅뿅");
		chatB=new ChatB(this);
		
	}
	

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode(); //js_event.keyCode
		
		if(key==KeyEvent.VK_ENTER) {
			System.out.println("엔터뿅");
			
			//1) 나의 창의 area에 입력한 값을 대입
			String msg=t.getText();
			area.append(msg+"\n"); // \n 줄바꿈
			t.setText(""); //입력 후 초기화
			//2) ChatB창의 area에 입력한 값 대입
			chatB.area.append(msg+"\n"); // \n 줄바꿈
			chatB.t.setText(""); //입력 후 초기화
			
		}
		
		//System.out.println(key);
		
	}

	public static void main(String[] args) {
		new ChatA();
	}
}
