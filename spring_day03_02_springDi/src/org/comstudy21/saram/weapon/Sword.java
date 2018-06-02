package org.comstudy21.saram.weapon;

import org.springframework.stereotype.Component;

@Component("sword")
public class Sword implements Weapon {

	@Override
	public void play() {
		System.out.println("칼 슁슁");
	}

}
