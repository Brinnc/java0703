package org.sp.app0703.color;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeftFrame extends JFrame{
	//현재프레임이 버튼을 보유하고 있음
	JButton bt_open;
	JButton bt_red;
	JButton bt_orange;
	JButton bt_yellow;
	JPanel p; //색상 적용하기 위함
	
	//has a 관계로 부품을 갖고 있ㄴ다는 것은 이 본체가 태업날때 부품들도 함꼐 생성되어야함
	//따라서 초기화할 이유가 있으며, 생성자 메서드를 적극 활용해야함
	public LeftFrame() {
		//부품들에 대한 생성
		bt_open=new JButton("열기");
		bt_red=new JButton("RED");
		bt_orange=new JButton("ORANGE");
		bt_yellow=new JButton("YELLOW");
		p=new JPanel();
		
		//버튼들의 배경색 설정
		//Color c=new Color(255, 0, 0); 세부적인 색상 필요시
		bt_red.setBackground(Color.RED);
		bt_orange.setBackground(Color.ORANGE);
		bt_yellow.setBackground(Color.YELLOW);
		p.setPreferredSize(new Dimension(280, 300));
		
		//배치관리자 변경 적용
		this.setLayout(new FlowLayout());
		
		add(bt_open);
		add(bt_red);
		add(bt_orange);
		add(bt_yellow);
		add(p);
		
		setVisible(true);
		//setSize(300, 400);
		//setSize() 기능에 윈도우의 위치까지 지정할 수 있는 메서드
		setBounds(100, 200, 300, 400); //x, y, 너비, 높이
		setDefaultCloseOperation(EXIT_ON_CLOSE); //JFrame 생략
		
		//버튼과 리스너 연결
		System.out.println("나의 주소값 "+this);
		MyListener listener=new MyListener(this);
		
		bt_open.addActionListener(listener);
		bt_red.addActionListener(listener);
		bt_orange.addActionListener(listener);
		bt_yellow.addActionListener(listener);
		
		
		
	}
	
	
	public static void main(String[] args) {
		new LeftFrame();
	}
}
