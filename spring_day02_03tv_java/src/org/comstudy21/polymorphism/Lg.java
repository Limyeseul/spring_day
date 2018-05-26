package org.comstudy21.polymorphism;

public class Lg implements TV {
	private String name = "Lg TV";

	@Override
	public void powerOn() {
		System.out.println(name + "전원을 킨다.");
	}

	@Override
	public void powerOff() {
		System.out.println(name + "전원을 끈다.");		
	}

	@Override
	public void volumeUp() {
		System.out.println(name + "볼륨을 올린다.");		
	}

	@Override
	public void volumeDown() {
		System.out.println(name + "볼륨을 내린다.");		
	}
}
