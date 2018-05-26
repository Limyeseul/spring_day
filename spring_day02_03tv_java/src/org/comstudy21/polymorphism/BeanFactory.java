package org.comstudy21.polymorphism;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
	
	private static BeanFactory instance;
	Map<String, Object> mapping = new HashMap<String, Object>();
	
	// 싱글턴은 생성자를 private으로 막아놔야함. 외부에서 생성 금지
	private BeanFactory() {
		// 생성이 되면 바로 TV인스턴스 준비
		mapping.put("samsung", new Samsung());
		mapping.put("lg", new Lg());
	}
	
	// 외부에서 접근할 수 있도록
	public static BeanFactory getInstance() {
		if(instance == null) {
			instance = new BeanFactory();
		}
		return instance;
	}
	
	public Object getBean(String key) {
		return mapping.get(key);
	}
}
