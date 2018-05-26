package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
	// MessagePrinter는 컴포넌트에 의해 자체 빈으로 만들어짐
	
	private final MessageService service;
	
	@Autowired
	public MessagePrinter(MessageService service) {
		// 생성자 자체를 @Autowired로 하여 객체 생성시 바로 final 변수에 받을 수 있도록 한다.
		this.service = service;
	}
	
	public void printMessage() {
		System.out.println(service.getMessage());
	}
}
