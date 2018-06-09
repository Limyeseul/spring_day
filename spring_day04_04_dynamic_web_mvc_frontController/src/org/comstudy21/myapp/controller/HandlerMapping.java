package org.comstudy21.myapp.controller;

import java.util.Hashtable;
import java.util.Map;

public class HandlerMapping {
	private Map<String, Controller> map = new Hashtable<>();
	
	public HandlerMapping() {
		map.put("/board", new BoardController());
		map.put("/user", new UserController());
	}
	
	public Controller getController(String path){
		String key = path.substring(0, path.lastIndexOf("/"));
		System.out.println("key => " + key);
		return map.get(key);
	}
}
