package org.comstudy21.myapp.users.client;

import java.util.List;

import org.comstudy21.myapp.users.service.UserService;
import org.comstudy21.myapp.users.vo.UserVo;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		String resources = "applicationContext.xml";
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext(resources);
		
		UserService userService = (UserService)factory.getBean("userService");
		List<UserVo> list = userService.getUserList(null);
		System.out.println(list);
		
		UserVo vo = new UserVo("HONG", "1234", null, null);
		UserVo user = userService.getUser(vo);
		System.out.println(user);
		if(user != null) {
			System.out.println(user.getName() + "님 안녕하세요!");
		} else {
			System.out.println("로그인 실패!");
		}
		
		factory.close();
	}

}
