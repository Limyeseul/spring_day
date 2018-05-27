package org.comstudy21.myapp.tv;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {
	
	public static void main(String[] args) {
		TV tv = new Samsung();		//new Samsung() = 의존성
		tv.powerOn();
		tv.volumeUp();
		
		//BeanFactory factory = BeanFactory.getInstance();
		//어플리케이션컨텍스트 형태로 만들기 (Lookup형태)
		String resource = "applicationContext.xml";
		AbstractApplicationContext factory = new GenericXmlApplicationContext(resource);
		
		// applicationContext.xml에서 정의한 id의 Bean(객체)를 가져오긔
		TV tv2 = (TV) factory.getBean("samsungTv");
		tv2.powerOff();
	}
}
