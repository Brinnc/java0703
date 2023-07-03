package org.sp.app0703.color;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//왼쪽 프레임에서 발생하는 액션 이벤트를 감지하는 리스너
public class MyListener implements ActionListener{
	LeftFrame leftFrame; //null
	RightFrame rightFrame; //null
	
	//마이리스너인 나를 new 연산자로 메모리에 올리는 者는 생성자의 매개변수로 LeftFrame의 인스턴스를 전달해야함
	//이 때 레프트프레임의 주소값을 넘겨받기 때문에 leftFrame의 변수로 원본 객체를 제어할 수 있음(call by reference)
	public MyListener(LeftFrame leftFrame) {
		System.out.println("넘겨받은 값 "+leftFrame);
		
		//아래처럼 새롭게 생성하지 말고, 기존의 좌측 창의 주소값을 얻어오자
		//leftFrame=new LeftFrame();
		this.leftFrame=leftFrame;
		//leftFrame.bt_open.setBackground(Color.BLACK);
	}
	
	//사용자들이 클릭을 누르면 아래의 메서드가 자동으로 호출됨(콜백-시스템에 의해 호출되는 것)
	public void actionPerformed(ActionEvent e) {
		//사용자가 발생시킨 액션 이벤트는 ActionEvent 객체의 인스턴스화되어 이 메서드로 전달됨
		//따라서 개발자는 이 액션이벤트의 인스턴스로부터 각종 이벤트 정보들을 얻어낼 수 있음
		System.out.println(e);
		Object obj=e.getSource(); //사용자가 틀릭한 컴포넌트를 반환함
		
		//사용자가 누른 버튼이 (기존)좌측 프레임이 보유한 bt_open이라면
		if(obj==leftFrame.bt_open) {
			//오른쪽에 친구창 띄우기
			//주소값을 변수에 보관하는 이유: 추후에 제어하기 위해
			rightFrame=new RightFrame(leftFrame);
		}else if(obj==leftFrame.bt_red) {
			System.out.println("빨간버튼");
			//이미 태어난 기존의 오른쪽 창의 색상을 변경해야함
			rightFrame.p.setBackground(Color.RED);
		}else if(obj==leftFrame.bt_orange) {
			System.out.println("주황버튼");
			rightFrame.p.setBackground(Color.ORANGE);
		}else if(obj==leftFrame.bt_yellow) {
			System.out.println("노란버튼");
			rightFrame.p.setBackground(Color.YELLOW);
		}
		
		
		
		
	}

}
