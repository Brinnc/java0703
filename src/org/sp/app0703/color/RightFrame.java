package org.sp.app0703.color;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RightFrame extends JFrame{
	//현재프레임이 버튼을 보유하고 있음
	
	JButton bt_green;
	JButton bt_blue;
	JButton bt_pink;
	JPanel p; //용도: 색상을 부여하기 위함
	LeftFrame leftFrame; //null이기때문에 기존에 생성되어있는 왼쪽프레임 주소값을 가져와야함
	
	//has a 관계로 부품을 갖고 있ㄴ다는 것은 이 본체가 태업날때 부품들도 함꼐 생성되어야함
	//따라서 초기화할 이유가 있으며, 생성자 메서드를 적극 활용해야함
	public RightFrame(LeftFrame leftFrame) {
		//부품들에 대한 생성
		
		bt_green=new JButton("GREEN");
		bt_blue=new JButton("BLUE");
		bt_pink=new JButton("PINK");
		p=new JPanel();
		this.leftFrame=leftFrame;
		
		//버튼들의 배경색 설정
		//Color c=new Color(255, 0, 0); 세부적인 색상 필요시
		bt_green.setBackground(Color.GREEN);
		bt_blue.setBackground(Color.BLUE);
		bt_pink.setBackground(Color.PINK);
		p.setPreferredSize(new Dimension(280, 300));
		
		//배치관리자 변경 적용
		this.setLayout(new FlowLayout());
		
		add(bt_green);
		add(bt_blue);
		add(bt_pink);
		add(p);
		
		setVisible(true);
		//setSize(300, 400);
		setBounds(400, 200, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //JFrame 생략
		
		//버튼들과 리스너와의 연결
		MyListener2 listener=new MyListener2(this);
		bt_green.addActionListener(listener);
		bt_blue.addActionListener(listener);
		bt_pink.addActionListener(listener);
		
		
	}
	
}
