package org.comstudy21.saram.weapon;

import org.springframework.stereotype.Component;

@Component("gun")
public class Gun implements Weapon {

	@Override
	public void play() {
		System.out.println("총발사 다다다");
	}

}
