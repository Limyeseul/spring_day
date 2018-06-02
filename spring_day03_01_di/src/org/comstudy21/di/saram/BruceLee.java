package org.comstudy21.di.saram;

import org.comstudy21.saram.weapon.Weapon;

public class BruceLee implements Saram {
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

	@Override
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
}
