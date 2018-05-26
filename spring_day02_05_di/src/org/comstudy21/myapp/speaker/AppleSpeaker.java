package org.comstudy21.myapp.speaker;

public class AppleSpeaker implements Speaker {

	private String maker = "Apple Speaker";
	
	public AppleSpeaker() {
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
