package org.comstudy21.saram.client;

import java.util.List;

import org.comstudy21.saram.di.CollectionBean;
import org.comstudy21.saram.model.Saram;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SaramManager2 {

	public static void main(String[] args) {
		String re = "applicationContext.xml";
		AbstractApplicationContext factory = new GenericXmlApplicationContext(re);
		
		CollectionBean b = (CollectionBean) factory.getBean("collectionBean");
		List<Saram> list = (List<Saram>)b.getSaramList();
		System.out.println(list);
	}

}
