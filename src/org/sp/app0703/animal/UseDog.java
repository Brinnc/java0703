package org.sp.app0703.animal;

public class UseDog {
	
	public void setAge(Dog d) {
		d.age=7; //주소값을 넘겨받으면 원본에 영향
		//System.out.println("넘어온 age "+age);
	}
	
	public static void main(String[] args) {
		UseDog ud= new UseDog();
		int x=8;
		Dog d=new Dog();
		System.out.println(d.age);
		//ud.setAge(x); //call by value
		ud.setAge(d); //call by reference
		System.out.println(d.age);
	}
}
