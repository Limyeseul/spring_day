package org.comstudy21.myapp.speaker;

public class SamsungSpeaker implements Speaker{

	private String maker = "Samsung Speaker";

	public SamsungSpeaker() {
		System.out.println(maker + " 객체생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println(maker + " 볼륨 업");
	}

	@Override
	public void volumeDown() {
		System.out.println(maker + " 볼륨 다운");
	}

}
