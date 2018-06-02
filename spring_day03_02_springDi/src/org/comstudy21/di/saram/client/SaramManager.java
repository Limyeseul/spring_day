package org.comstudy21.di.saram.client;

import org.comstudy21.di.saram.Saram;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SaramManager {

	public static void main(String[] args) {
		// lookup
		String resource = "applicationContext.xml";
		AbstractApplicationContext factory = new GenericXmlApplicationContext(resource);
		
		Saram saram = (Saram) factory.getBean("rambo");
		saram.say();
		saram.work();
	}

}
