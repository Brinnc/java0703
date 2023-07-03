package org.sp.app0703.color;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//오른쪽 프레임에서 발생하는 액션 이벤트를 감지하기 위한 리스너 정의
public class MyListener2 implements ActionListener{
	RightFrame rightFrame;
	LeftFrame leftFrame;
	
	public MyListener2(RightFrame rightFrame) {
		this.rightFrame=rightFrame;
		this.leftFrame=rightFrame.leftFrame;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("오른쪽 창 버튼 뿅뿅");
		
		Object obj=e.getSource(); //이벤트를 일으킨 컴포넌트를 반환함
		
		if(obj==rightFrame.bt_green) {
			leftFrame.p.setBackground(Color.GREEN);
		}else if(obj==rightFrame.bt_blue) {
			leftFrame.p.setBackground(Color.BLUE);
		}else if(obj==rightFrame.bt_pink) {
			leftFrame.p.setBackground(Color.PINK);
		}
		
	}

}
