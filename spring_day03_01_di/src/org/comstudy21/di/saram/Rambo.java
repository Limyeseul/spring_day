package org.comstudy21.di.saram;

import org.comstudy21.saram.weapon.Weapon;

public class Rambo implements Saram {

	private Weapon weapon;
	@Override
	public void say() {
		System.out.println("람보가 말한다.");
	}

	@Override
	public void work() {
		System.out.println("람보가 총을 손다.");
		weapon.play();
	}

	@Override
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

}
