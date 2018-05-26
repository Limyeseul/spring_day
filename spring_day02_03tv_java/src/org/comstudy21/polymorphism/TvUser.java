package org.comstudy21.polymorphism;

public class TvUser {
	
	public static void main(String[] args) {
		TV tv = new Samsung();		//new Samsung() = 의존성
		tv.powerOn();
		tv.volumeUp();
		
		
		BeanFactory factory = BeanFactory.getInstance();
		
		// 런 컨피규어에서 프로그램 아귀먼트에서 samsung 넣긔
		TV tv2 = (TV) factory.getBean(args[0]);
		tv2.powerOff();
	}
}
