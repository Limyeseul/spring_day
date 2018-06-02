package org.comstudy21.di.saram;

import javax.annotation.Resource;

import org.comstudy21.saram.weapon.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("bruceLee") // 이름 생략하면 클래스 이름(BruceLee)이 컴포넌트 이름이 된다.
public class BruceLee implements Saram {
	
//	@Autowired
//	@Qualifier(value="sword")
	private Weapon weapon;
	
	@Override
	public void say() {
		System.out.println("이소룡이 말한다.");
	}

	@Override
	public void work() {
		System.out.println("이소룡이 쌍절곤을 휘두른다.");
		weapon.play();
	}

}
