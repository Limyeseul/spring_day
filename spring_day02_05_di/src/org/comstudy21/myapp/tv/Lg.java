package org.comstudy21.myapp.tv;

import org.comstudy21.myapp.speaker.Speaker;

public class Lg implements TV {
	private String name = "Lg TV";
	private Speaker speaker;

	public Lg() {
		System.out.println("Lg 생성자");
	}
	
	public Lg(Speaker speaker) {
		System.out.println("Lg 생성자 (speaker)");
		this.speaker = speaker;
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void initMethod() {
		// 어플리케이션 컨텍스트에 정의되어있는대로 초기화메소드 입력
		System.out.println("lg tv의 init-method");
	}
	
	public void close() {
		System.out.println("lg tv의 destroy 메소드");
	}
	
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
		// System.out.println(name + "볼륨을 올린다.");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		// System.out.println(name + "볼륨을 내린다.");
		speaker.volumeDown();
	}
}
