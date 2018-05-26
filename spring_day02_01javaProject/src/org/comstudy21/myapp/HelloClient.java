package org.comstudy21.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloClient {

	public static void main(String[] args) {
		 
		// java로 출력해보자.
		HelloWorld hello = new HelloWorld();
		hello.sayHello("홍길동");
		
		
		// spring으로 출력해보자.
		String resources = "applicationContext.xml";
		AbstractApplicationContext factory = new GenericXmlApplicationContext(resources);
		
		// applicationContext.xml에 정의되어있는 id=helloWorld의 bean(객체)를 갖고온다.
		// class=HelloWorld 타입이니까 캐스팅
		HelloWorld helloWorld = (HelloWorld) factory.getBean("helloWorld");
		helloWorld.sayHello("김길순");
	}

}
